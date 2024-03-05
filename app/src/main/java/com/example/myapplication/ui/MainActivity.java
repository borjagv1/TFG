package com.example.myapplication.ui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private boolean isMuted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configurarMediaPlayer();
        funcionamientoBotonSilenciar();
    }

    private void configurarMediaPlayer() {
        // Reproducir música de fondo
        // Inicializar MediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.autumn_sunset);
        mediaPlayer.setLooping(true); // Repetir la música en bucle
        mediaPlayer.start(); // Comenzar a reproducir la música
    }

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
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release(); // Liberar recursos cuando la actividad termina
        }


    }
}
