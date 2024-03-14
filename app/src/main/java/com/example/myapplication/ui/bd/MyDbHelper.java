package com.example.myapplication.ui.bd;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;
/**
 * Clase que gestiona la base de datos.
 * @version 1.0
 * @author Borja Guerra
 * @see SQLiteOpenHelper
 */
public class MyDbHelper extends SQLiteOpenHelper {

    /**
     * Constructor.
     * @param context Contexto.
     */
    public MyDbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static final String TAG = MyDbHelper.class.getSimpleName();
    public static final String DB_NAME = "mydb.db";
    public static final int DB_VERSION = 1;
    public static final String TABLE_NAME = "mytable";
    public static final String C_ID = "_id";
    public static final String C_EMAIL = "email";
    public static final String C_PASSWORD = "password";
    public static final int MARCADOR = 0;
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + C_EMAIL + " TEXT, " + C_PASSWORD + " TEXT);";

    /**
     * @param db Mi Base de Datos.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    /**
     * @param db         Mi base de datos.
     * @param oldVersion La antigua versión de la base de datos.
     * @param newVersion La nueva versión de la base de datos.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /**
     * Añadir registros de usuario en mi bbdd
     */
    public void addUserDetails(String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();

        //ContentValues se usa para almacenar un conjunto de valores.
        ContentValues values = new ContentValues();

        values.put(C_EMAIL, email);
        values.put(C_PASSWORD, password);

        //Inserta un registro en la base de datos. Devuelve -1 si no se ha podido insertar.
        long id = db.insert(TABLE_NAME, null, values);
        db.close();

        //'d' Envío un mensaje al log.
        Log.d(TAG, "Se ha insertado un usuario: " + id);
    }

    /**
     * Comprobar si el usuario existe en la bbdd
     * return true si el usuario existe
     * return false si el usuario no existe
     */
    public boolean getUserFromDataBase(String email, String password) {
        String selectQuery = "select * from " + TABLE_NAME + " where " + C_EMAIL + " = " + "'" + email + "'" + " and " + C_PASSWORD + " = " + "'" + password + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        // Objeto cursor que permite leer los resultados de una consulta. Situado antes del primer resultado.
        android.database.Cursor cursor = db.rawQuery(selectQuery, null);
        // Muevo el cursor al primer resultado.
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            return true;
        }
        cursor.close();
        db.close();
        return false;
    }
}
