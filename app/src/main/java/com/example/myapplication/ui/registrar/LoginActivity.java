package com.example.myapplication.ui.registrar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import com.example.myapplication.ui.MainActivity;
import com.example.myapplication.ui.bd.MyDbHelper;
import com.example.myapplication.ui.bd.Session;
/**
 * Clase que gestiona la actividad de login.
 * @version 1.0
 * @see RegistroActivity
 * @see MyDbHelper
 * @see Session
 * @see MainActivity
 * author Borja Guerra
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextEmail;
    private EditText editTextPassword;
    private MyDbHelper db;
    private Session session;

    /**
     * @param savedInstanceState si la Activity se reanuda, se recibe el último estado aquí.
     * @see MainActivity
     * Metodo que se ejecuta al crear la actividad.
     * Se encarga de inicializar los elementos de la actividad.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db = new MyDbHelper(this);
        session = new Session(this);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnRegister = findViewById(R.id.btnRegistro);
        editTextEmail = findViewById(R.id.etEmail);
        editTextPassword = findViewById(R.id.etPassword);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        if (session.loggedIn()) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
    }


    /**
     * @param v The view that was clicked.
     * @see RegistroActivity
     */
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btnLogin) {
            login(v);
        } else if (id == R.id.btnRegistro) {
            register(v);
        }
    }

    public void register(View v) {
        startActivity(new Intent(LoginActivity.this, RegistroActivity.class));
        finish();
    }

    /**
     * Método que se ejecuta al pulsar el botón de login.
     * Comprueba si el usuario y contraseña son correctos.
     */
    public void login(View v) {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        if (db.getUserFromDataBase(email, password)) {
            session.setLoggedIn(true);
            displayToast("Login correcto");
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        } else {
            displayToast("Email/Contraseña incorrectos");
        }
    }
    /**
     * Método que muestra un mensaje en pantalla.
     * @param message Mensaje a mostrar.
     */
    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
