package com.example.myapplication.ui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import com.example.myapplication.ui.bd.Session;
/**
 * Clase que gestiona la actividad principal.
 * @version 1.0
 * @see LoginActivity
 * @see MediaPlayer
 * @see Session
 * @see Nivel1Activity
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
        // Botón 1 - Nivel 1
        Button btnNivel1 = findViewById(R.id.button);
        btnNivel1.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Nivel1Activity.class)));
        // Botón 2 - Nivel 2
        Button btnNivel2 = findViewById(R.id.button2);
        btnNivel2.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Nivel2Activity.class)));
        // Botón 3 - Nivel 3
        Button btnNivel3 = findViewById(R.id.button3);
        btnNivel3.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, Nivel3Activity.class)));
        // Botón 4 - Foro
        Button btnForo = findViewById(R.id.button4);
        btnForo.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, ForoActivity.class)));
        // Botón 5 - Desarrollador
        Button btnDesarrollador = findViewById(R.id.button5);
        btnDesarrollador.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, DesarrolladorActivity.class)));
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
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release(); // Liberar recursos cuando la actividad termina
        }


    }
}
