package com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import com.example.myapplication.ui.registrar.LoginActivity;

import java.util.Timer;
import java.util.TimerTask;
/**
 * Clase que gestiona la actividad de introducción.
 * Se encarga de mostrar una pantalla de introducción durante un tiempo determinado.
 * Después de ese tiempo, redirige a la pantalla de inicio de sesión.
 * @version 1.0
 * @see LoginActivity
 * author Borja Guerra
 */
public class IntroActivity extends AppCompatActivity {
    /**
     * Tiempo de espera en milisegundos de la pantalla de introducción.
     */
    private static final long SPLASH_TIME = 5000;
    /**
     * @param savedInstanceState si la Activity se reanuda, se recibe el último estado aquí.
     * Método que se ejecuta al crear la actividad.
     * Se encarga de inicializar los elementos de la actividad.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        TimerTask timerTask = new TimerTask() {
            /**
             * Método que se ejecuta al terminar el tiempo de espera.
             */
            @Override
            public void run() {
                startActivity(new Intent(IntroActivity.this, LoginActivity.class));
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask, SPLASH_TIME);
    }
}
