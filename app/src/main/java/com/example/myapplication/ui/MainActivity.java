package com.example.myapplication.ui;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private ImageButton btnMute;
    private boolean isMuted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reproducir música de fondo
        // Inicializar MediaPlayer
        //mediaPlayer = MediaPlayer.create(this, R.raw.autumn_sunset);
        mediaPlayer.setLooping(true); // Repetir la música en bucle
        mediaPlayer.start(); // Comenzar a reproducir la música

        // Referenciar el botón de silenciar
        btnMute = findViewById(R.id.btnMute);
        btnMute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isMuted) {
                    // Si está silenciado, volver a habilitar el sonido
                    mediaPlayer.setVolume(1.0f, 1.0f);
                    //btnMute.setImageResource(R.drawable.ic_volume_on);
                } else {
                    // Si no está silenciado, silenciar el sonido
                    mediaPlayer.setVolume(0.0f, 0.0f);
                    //btnMute.setImageResource(R.drawable.ic_volume_off);
                }
                isMuted = !isMuted;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release(); // Liberar recursos cuando la actividad se destruye
        }

        // Botones para navegar a las otras actividades
        Button btnAprender = findViewById(R.id.btnAprender);
        Button btnAdivinarConVidas = findViewById(R.id.btnAdivinarConVidas);
        Button btnAdivinarSinVidas = findViewById(R.id.btnNoLives);

        btnAprender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AprenderActivity.class);
                startActivity(intent);
            }
        });

        btnAdivinarConVidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdivinarResultadoConVidasActivity.class);
                startActivity(intent);
            }
        });

        btnAdivinarSinVidas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdivinarResultadoSinVidasActivity.class);
                startActivity(intent);
            }
        });
    }
}
