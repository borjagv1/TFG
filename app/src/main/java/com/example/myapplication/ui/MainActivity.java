package com.example.myapplication.ui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import com.example.myapplication.ui.bd.Session;
import com.example.myapplication.ui.guia_mail.GuiaMatesMailActivity;
import com.example.myapplication.ui.niveles.JuegoActivity;
import com.example.myapplication.ui.registrar.LoginActivity;

/**
 * Clase que gestiona la actividad principal.
 * @version 1.0
 * @see LoginActivity
 * @see MediaPlayer
 * @see Session
 * @see JuegoActivity
 * author Borja Guerra
 */
public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private boolean isMuted = false;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configurarMediaPlayer();
        funcionamientoBotonSilenciar();

        session = new Session(this);
        if (!session.loggedIn()) {
            logout();
        }

        configurarListenersBotones();
    }
    // javadoc
    /**
     * Método que configura los listeners de los botones.
     * @see JuegoActivity
     * @see GuiaMatesMailActivity
     * @see Session
     * @see MediaPlayer
     * @see LoginActivity
     */
    private void configurarListenersBotones() {
        // Botón 1 - Nivel 1
        Button btnNivel1 = findViewById(R.id.button);
        btnNivel1.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, JuegoActivity.class)));
       // Botón 2 - Guía y Mail
        Button btnForo = findViewById(R.id.button2);
        btnForo.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, GuiaMatesMailActivity.class)));
        // Botón de logout
        Button btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(v -> logout());
    }

    /**
     * Método que se ejecuta al pulsar el botón de logout.
     */
    private void logout() {
        session.setLoggedIn(false);
        finish();
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }

    /**
     * Método que inicializa el MediaPlayer y reproduce la música de fondo.
     * @see MediaPlayer
     */
    private void configurarMediaPlayer() {
        // Reproducir música de fondo
        // Inicializar MediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.autumn_sunset);
        mediaPlayer.setLooping(true); // Repetir la música en bucle
        mediaPlayer.start(); // Comenzar a reproducir la música
    }

    /**
     * Método que gestiona el funcionamiento del botón de silenciar.
     *
     */
    private void funcionamientoBotonSilenciar() {
        ImageButton btnMute;
        // Referenciar el botón de silenciar
        btnMute = findViewById(R.id.btnMute);
        btnMute.setOnClickListener(v -> {
            if (isMuted) {
                // Si está silenciado, volver a habilitar el sonido
                mediaPlayer.setVolume(1.0f, 1.0f);
                btnMute.setImageResource(R.drawable.ic_volume_on);
            } else {
                // Si no está silenciado, silenciar el sonido
                mediaPlayer.setVolume(0.0f, 0.0f);
                btnMute.setImageResource(R.drawable.ic_volume_off);
            }
            isMuted = !isMuted;
        });
    }

    // OnDestroy es un método que se llama cuando la actividad está a punto de ser destruida
    // El ejemplo claro es cuando pulsamos atrás en el móvil

    /**
     * Método que se ejecuta cuando la actividad está a punto de ser destruida.
     * Se encarga de liberar los recursos del MediaPlayer.
     * @see MediaPlayer
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release(); // Liberar recursos cuando la actividad termina
        }


    }
}
