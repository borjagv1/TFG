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
     * Se hace uso de SharedPreferences, ya que
     * Permite almacenar y recuperar datos de manera
     * Persistente en forma de pares clave-valor. Se utiliza comúnmente para almacenar preferencias de la aplicación,
     * como configuraciones del usuario, estados de inicio de sesión, preferencias personalizadas, etc.
     */
    public Session(Context context) {
        sharedPreferences = context.getSharedPreferences("mydb", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        this.context = context;
    }

    /**
     * Establece si el usuario está registrado.
     * @param loggedIn Si el usuario está registrado.
     * Este método se utiliza para establecer el estado de inicio de sesión del usuario.
     * Toma un parámetro booleano loggedIn, que indica si el usuario está registrado o no.
     * Dentro del método, se utiliza un objeto editor para modificar el archivo SharedPreferences.
     * Se utiliza putBoolean("loggedInmode", loggedIn) para guardar el valor de loggedIn bajo la clave "loggedInmode".
     * Luego, se llama a editor.commit() para confirmar los cambios y guardarlos de manera persistente en el archivo
     * SharedPreferences.
     */
    public void setLoggedIn(boolean loggedIn) {
        editor.putBoolean("loggedInmode", loggedIn);
        editor.commit();
    }

    /**
     * Comprueba si el usuario está registrado.
     * @return Si el usuario está registrado.
     * Este método se utiliza para verificar si el usuario está registrado o no.
     * Utiliza el objeto sharedPreferences para acceder al archivo SharedPreferences y llama al método
     * getBoolean("loggedInmode", false) para obtener el valor booleano almacenado bajo la clave "loggedInmode".
     * Si no se encuentra ningún valor bajo esta clave, se devuelve false como valor predeterminado.
     * Devuelve el valor booleano recuperado, que indica si el usuario está registrado o no.
     */
    public boolean loggedIn() {
        return sharedPreferences.getBoolean("loggedInmode", false);
    }
}
