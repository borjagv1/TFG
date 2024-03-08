package com.example.myapplication.ui.bd;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Clase que gestiona la sesión.
 * @version 1.0
 * @author Borja Guerra
 */
public class Session {
SharedPreferences sharedPreferences;
SharedPreferences.Editor editor;
Context context;
    /**
     * Constructor.
     * @param context The context.
     */
    public Session(Context context) {
        sharedPreferences = context.getSharedPreferences("mydb", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        this.context = context;
    }

    /**
     * Establece si el usuario está registrado.
     * @param loggedIn Si el usuario está registrado.
     */
    public void setLoggedIn(boolean loggedIn) {
        editor.putBoolean("loggedInmode", loggedIn);
        editor.commit();
    }

    /**
     * Comprueba si el usuario está registrado.
     * @return Si el usuario está registrado.
     */
    public boolean loggedIn() {
        return sharedPreferences.getBoolean("loggedInmode", false);
    }
}
