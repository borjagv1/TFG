package com.example.myapplication.ui.guia_mail;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
/**
 * Clase que gestiona la actividad del foro.
 * @version 1.0
 * author Borja Guerra
 * Qué hace la clase
 * Se encarga de mostrar la interfaz gráfica del foro y de gestionar las interacciones del usuario con la misma.
 */
public class GuiaMatesMailActivity extends AppCompatActivity {
FloatingActionButton fbEnviarCorreo;

    /**
     * Método que se ejecuta al crear la actividad.
     * @param savedInstanceState Si la actividad se reanuda, se recibe el último estado aquí.
     * Se encarga de inicializar los elementos de la actividad.
     * @see Snackbar
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guia_mates_mail);
        fbEnviarCorreo = findViewById(R.id.fabbotoncitomail);
        // Hacer que el boton de enviar correo inicie la actividad EnviarCorreoActivity
       fbEnviarCorreo.setOnClickListener(v -> {
            Snackbar.make(v, "Enviar correo", BaseTransientBottomBar.LENGTH_SHORT).show();
            startActivity(new Intent(GuiaMatesMailActivity.this, EnviarCorreoActivity.class));
        });
    }
}
