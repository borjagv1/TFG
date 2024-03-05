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
     * @param context The context.
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
    public static final int MARKS = 0;
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + C_EMAIL + " TEXT, " + C_PASSWORD + " TEXT);";

    /**
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    /**
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
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

        //This class is used to store a set of values
        ContentValues values = new ContentValues();

        values.put(C_EMAIL, email);
        values.put(C_PASSWORD, password);

        //'insert' the row ID of the newly inserted row, or -1 if an error occurred
        long id = db.insert(TABLE_NAME, null, values);
        db.close();

        //'d' Send a DEBUG log message.
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
        // A Cursor object, which is positioned before the first entry.
        android.database.Cursor cursor = db.rawQuery(selectQuery, null);
        // Move the cursor to the first row.
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            return true;
        }
        cursor.close();
        db.close();
        return false;
    }
}
