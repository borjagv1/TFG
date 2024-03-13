package com.example.myapplication.ui.guia_mail;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

/**
 * Clase que gestiona la actividad de enviar correo.
 * @version 1.0
 * author Borja Guerra
 * Se encarga de mostrar la interfaz gráfica de enviar correo y de gestionar las interacciones del usuario con la misma.
 * @see Intent
 * @see Intent#ACTION_SEND
 * @see Intent#EXTRA_EMAIL
 * @see Intent#EXTRA_SUBJECT
 * @see Intent#EXTRA_TEXT
 * @see Intent#createChooser
 * @see Intent#setType
 * @see Intent#ACTION_SEND
 *
 */
public class EnviarCorreoActivity extends AppCompatActivity {
    EditText etSender;
    EditText etSubject;
    EditText etMessage;
    Button btnSend;
/**
 * Método que se ejecuta al crear la actividad.
 * @param savedInstanceState Si la actividad se reanuda, se recibe el último estado aquí.
 * Se encarga de inicializar los elementos de la actividad.
 */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_correo);
        etSender = findViewById(R.id.editText);
        etSubject = findViewById(R.id.editText2);
        etMessage = findViewById(R.id.editText3);
        btnSend = findViewById(R.id.button);
        btnSend.setOnClickListener(v -> {
            String sender = etSender.getText().toString();
            String subject = etSubject.getText().toString();
            String message = etMessage.getText().toString();
            sendEmail(sender, subject, message);
        });
    }

    /**
     * Método que envía un correo.
     * @param sender String con el correo del remitente.
     * @param subject String con el asunto del correo.
     * @param message String con el mensaje del correo.
     * @see Intent
     * message/rfc822 es el tipo MIME para los mensajes de correo electrónico.
     * Configuro el Intent para que abra una aplicación de correo electrónico.
     * @see Intent#ACTION_SEND
     * @see Intent#EXTRA_EMAIL
     * @see Intent#EXTRA_SUBJECT
     * @see Intent#EXTRA_TEXT
     */
    private void sendEmail(String sender, String subject, String message)
    {
        // Aquí se enviaría el correo
        Intent intentEmail = new Intent(Intent.ACTION_SEND);
        intentEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{sender});

        intentEmail.putExtra(Intent.EXTRA_SUBJECT, subject);
        intentEmail.putExtra(Intent.EXTRA_TEXT, message);
        intentEmail.setType("message/rfc822");
        startActivity(Intent.createChooser(intentEmail, "Elige un cliente de correo:"));
    }

}
