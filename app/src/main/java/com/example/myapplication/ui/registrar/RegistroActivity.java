package com.example.myapplication.ui.registrar;

import android.content.Intent;
import android.os.Bundle;
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
     * Método que se ejecuta al crear la actividad.
     * Se encarga de inicializar los elementos de la actividad.
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
     * Método que se ejecuta al pulsar un botón.
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
     * Si no, registra el usuario y muestra un mensaje de éxito.
     */
    private void registrar() {
        String email = editTextEmail.getText().toString();
        String pass = editTextPassword.getText().toString();
        if (email.isEmpty() || pass.isEmpty()) {
            displayToast("Email/Contraseña no pueden estar vacíos");
        } else {
            db.addUserDetails(email, pass);
            displayToast("Usuario registrado");
            // back to log activity after registering
            startActivity(new Intent(RegistroActivity.this, LoginActivity.class));
            finish();
        }
    }

    /**
     * @param message Mensaje a mostrar.
     * Método que muestra un mensaje en forma de Toast.
     */
    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}

