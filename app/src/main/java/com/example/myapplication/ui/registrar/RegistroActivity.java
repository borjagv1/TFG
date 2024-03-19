package com.example.myapplication.ui.registrar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import com.example.myapplication.ui.bd.MyDbHelper;

/**
 * Clase que gestiona la actividad de registro.
 *
 * @version 1.0
 * @see LoginActivity
 * @see MyDbHelper
 * author Borja Guerra
 */
public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextEmail;
    private EditText editTextPassword;
    private MyDbHelper db;

    /**
     * @param savedInstanceState si la Activity se reanuda, se recibe el último estado aquí.
     *                           Método que se ejecuta al crear la actividad.
     *                           Se encarga de inicializar los elementos de la actividad.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new MyDbHelper(this);
        Button btnRegistro = findViewById(R.id.btnRegistro);
        TextView textViewLogin = findViewById(R.id.tvLogin);
        editTextEmail = findViewById(R.id.etEmail);
        editTextPassword = findViewById(R.id.etPass);
        btnRegistro.setOnClickListener(this);
        textViewLogin.setOnClickListener(this);
    }


    /**
     * @param v The view that was clicked.
     *          Método que se ejecuta al pulsar un botón.
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnRegistro) {
            registrar();
        } else if (id == R.id.tvLogin) {
            startActivity(new Intent(RegistroActivity.this, LoginActivity.class));
            finish();
        }
    }

    /**
     * Método que registra un usuario.
     * Si el email o la contraseña están vacíos, muestra un mensaje de error.
     * Si el email o teléfono se escriben mal se controla y se lanza mensaje de error.
     * Si no, registra el usuario y muestra un mensaje de éxito.
     */
    private void registrar() {
        String emailOTelefono = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        if (emailOTelefono.isEmpty() || password.isEmpty()) {
            displayToast("Email/Contraseña no pueden estar vacíos");
        } else {
            if (esEmailValido(emailOTelefono) || esTelefonoValido(emailOTelefono)) {
                db.addUserDetails(emailOTelefono, password);
                displayToast("Usuario registrado");
                // volver a la actividad de inicio de sesión después de registrarse
                startActivity(new Intent(RegistroActivity.this, LoginActivity.class));
                finish();
            } else {
                displayToast("Ingrese un email o número de teléfono válido");
            }
        }
    }

    /**
     * @param email String con el email a comprobar.
     * @return true si el email es válido, false si no.
     * Método que comprueba si un email es válido.
     */
    private boolean esEmailValido(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**
     * @param telefono String con el número de teléfono a comprobar.
     * @return true si el número de teléfono es válido, false si no.
     */
    private boolean esTelefonoValido(String telefono) {
        // asumiendo que un número válido tiene al menos 9 dígitos
        return telefono.length() >= 9 && TextUtils.isDigitsOnly(telefono);
    }

    /**
     * @param message Mensaje a mostrar.
     *                Método que muestra un mensaje en forma de Toast.
     */
    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}

