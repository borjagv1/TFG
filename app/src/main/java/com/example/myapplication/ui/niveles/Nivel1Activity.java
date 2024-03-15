package com.example.myapplication.ui.niveles;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Actividad nivel 1 de la aplicación.
 * Esta actividad contiene preguntas y respuestas interactivas para el usuario.
 * Al responder correctamente, el usuario puede acumular puntos y recibir premios.
 *
 * @author Borja Guerra
 * @version 1.0
 */
public class Nivel1Activity extends AppCompatActivity {
    /**
     * Conjunto que almacena el n.º de las respuestas correctas.
     * @see LinkedHashSet Mantiene el orden de inserción.
     * @see Set Interfaz que no permite elementos duplicados.
     */
    final Set<Integer> linkedHashSetCorrectas = new LinkedHashSet<>();
    /**
     * Array que almacena el número de veces que se ha pulsado EL BOTÓN de responder.
     */
    public int[] contadorDePulsado = new int[10000];
    /**
     * Array que almacena el estado de las respuestas según la pregunta en la que estoy
     * P. ej. controlPregunta[1] = 0 → No ha respondido a la pregunta 1 o ha respondido de forma correcta.
     * Si es 1 → Se ha respondido de forma incorrecta tres veces y ya no se puede responder.
     * Controla el estado de las preguntas y evita que el usuario responda más de tres veces incorrectamente.
     */
    public int[] controlPregunta = new int[10000];

    {
        reiniciarContadores();
    }

    /**
     * Método que se ejecuta al crear la actividad.
     * @param savedInstanceState Si la actividad se reanuda, se recibe el último estado aquí.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel1);

        linkedHashSetCorrectas.clear();


        // PARA PREGUNTA - 1
        final Button buttonPregunta1 = findViewById(R.id.button1);
        final EditText inputPregunta1 = findViewById(R.id.editPregunta1);

        buttonPregunta1.setOnClickListener(arg0 -> {
            // Si es correcto se deshabilita el campo de texto y el botón
            if (inputPregunta1.getText().toString().equals("2")) {
                inputPregunta1.setEnabled(false);
                buttonPregunta1.setBackgroundResource(R.drawable.correcto);
                buttonPregunta1.setEnabled(false);
                // Si no está en el conjunto de respuestas correctas, añade el n.º de la pregunta
                if (controlPregunta[1] == 0) {
                    linkedHashSetCorrectas.add(1);
                }
                mostrarCorrecto("cor");

            } else {
                // Si es incorrecto se suma 1 al contador de pulsado
                contadorDePulsado[1] += 1;
                // Si se ha pulsado 3 veces, se deshabilita el campo de texto y el botón
                if (contadorDePulsado[1] == 3) {
                    Toast.makeText(getApplicationContext(), "La Respuesta es: 2", Toast.LENGTH_LONG).show();
                    controlPregunta[1] = 1;
                    inputPregunta1.setEnabled(false);
                    buttonPregunta1.setBackgroundResource(R.drawable.incorrecto);
                    buttonPregunta1.setEnabled(false);
                }
                mostrarIncorrecto("inc");
            }
            // Si se ha pulsado 3 veces, se muestra un mensaje emergente con la respuesta correcta
            if (contadorDePulsado[1] == 3) {
                Toast.makeText(getApplicationContext(), "La Respuesta es: 2", Toast.LENGTH_LONG).show();
                contadorDePulsado[1] = 0;
                controlPregunta[1] = 1;
            }
        });

        // PARA LA PREGUNTA - 2
        final Button buttonPregunta2 = findViewById(R.id.button2);
        final EditText inputPregunta2 = findViewById(R.id.editPregunta2);

        buttonPregunta2.setOnClickListener(arg0 -> {
            // Si es correcto se deshabilita el campo de texto y el botón
            if (inputPregunta2.getText().toString().equals("70")) {
                inputPregunta2.setEnabled(false);
                buttonPregunta2.setBackgroundResource(R.drawable.correcto);
                buttonPregunta2.setEnabled(false);

                // Si no está en el conjunto de respuestas correctas, añade el n.º de la pregunta
                mostrarCorrecto("cor");
                if (controlPregunta[2] == 0) {
                    linkedHashSetCorrectas.add(2);
                }

            } else {
                // Si es incorrecto se suma 1 al contador de pulsado
                contadorDePulsado[2] = contadorDePulsado[2] + 1;
                // Si se ha pulsado 3 veces, se deshabilita el campo de texto y el botón
                if (contadorDePulsado[2] == 3) {
                    controlPregunta[2] = 1;
                    inputPregunta2.setEnabled(false);
                    buttonPregunta2.setBackgroundResource(R.drawable.incorrecto);
                    buttonPregunta2.setEnabled(false);
                }
                mostrarIncorrecto("inc");
            }
            // Si se ha pulsado 3 veces, se muestra un mensaje emergente con la respuesta correcta
            if (contadorDePulsado[2] == 3) {
                Toast.makeText(getApplicationContext(), "La Respuesta es: 70", Toast.LENGTH_LONG).show();
                contadorDePulsado[2] = 0;
                controlPregunta[2] = 1;
            }

        });

        //PARA LA PREGUNTA - 3
        final Button buttonPregunta3 = findViewById(R.id.button3);
        final EditText inputPregunta3 = findViewById(R.id.editPregunta3);

        buttonPregunta3.setOnClickListener(arg0 -> {
            // Si es correcto se deshabilita el campo de texto y el botón
            if (inputPregunta3.getText().toString().equals("1")) {
                inputPregunta3.setEnabled(false);
                buttonPregunta3.setBackgroundResource(R.drawable.correcto);
                buttonPregunta3.setEnabled(false);

                // Si no está en el conjunto de respuestas correctas, añade el n.º de la pregunta
                mostrarCorrecto("cor");
                if (controlPregunta[3] == 0) {
                    linkedHashSetCorrectas.add(3);
                }

            } else {
                // Si es incorrecto se suma 1 al contador de pulsado
                contadorDePulsado[3] = contadorDePulsado[3] + 1;
                // Si se ha pulsado 3 veces, se deshabilita el campo de texto y el botón
                if (contadorDePulsado[3] == 3) {
                    controlPregunta[3] = 1;
                    inputPregunta3.setEnabled(false);
                    buttonPregunta3.setBackgroundResource(R.drawable.incorrecto);
                    buttonPregunta3.setEnabled(false);
                }
                mostrarIncorrecto("inc");
            }
            // Si se ha pulsado 3 veces, se muestra un mensaje emergente con la respuesta correcta
            if (contadorDePulsado[3] == 3) {
                Toast.makeText(getApplicationContext(), "La Respuesta es: 1", Toast.LENGTH_LONG).show();
                contadorDePulsado[3] = 0;
                controlPregunta[3] = 1;
            }

        });
        //PARA LA PREGUNTA - 4
        final Button buttonPregunta4 = findViewById(R.id.button4);
        final EditText inputPregunta4 = findViewById(R.id.editPregunta4);

        buttonPregunta4.setOnClickListener(arg0 -> {
            // Si es correcto se deshabilita el campo de texto y el botón
            if (inputPregunta4.getText().toString().equals("3")) {
                inputPregunta4.setEnabled(false);
                buttonPregunta4.setBackgroundResource(R.drawable.correcto);
                buttonPregunta4.setEnabled(false);

                // Si no está en el conjunto de respuestas correctas, añade el n.º de la pregunta
                mostrarCorrecto("cor");
                if (controlPregunta[4] == 0) {
                    linkedHashSetCorrectas.add(4);
                }

            } else {
                // Si es incorrecto se suma 1 al contador de pulsado
                contadorDePulsado[4] = contadorDePulsado[4] + 1;
                // Si se ha pulsado 3 veces, se deshabilita el campo de texto y el botón
                if (contadorDePulsado[4] == 3) {
                    controlPregunta[4] = 1;
                    inputPregunta4.setEnabled(false);
                    buttonPregunta4.setBackgroundResource(R.drawable.incorrecto);
                    buttonPregunta4.setEnabled(false);
                }
                mostrarIncorrecto("inc");
            }
            // Si se ha pulsado 3 veces, se muestra un mensaje emergente con la respuesta correcta
            if (contadorDePulsado[4] == 4) {
                Toast.makeText(getApplicationContext(), "La Respuesta es: 3", Toast.LENGTH_LONG).show();
                contadorDePulsado[4] = 0;
                controlPregunta[4] = 1;
            }

        });
        // Marcador
        Button marcador = findViewById(R.id.marcador);
        marcador.setOnClickListener(view -> mostrarMarcadores());
        // Premiar
        Button premiar = findViewById(R.id.premiar);
        premiar.setOnClickListener(view -> listaPremios());

    }

    /**
     * Método que muestra el marcador de respuestas correctas.
     * Muestra un mensaje emergente con la puntuación total.
     * Recibe el conjunto de respuestas correctas y calcula la puntuación.
     *
     * @see Toast
     * @see LinkedHashSet
     */
    public void mostrarMarcadores() {
        int marcador;
        int respuestasCorr = linkedHashSetCorrectas.size();
        marcador = respuestasCorr * 10;

        Toast.makeText(getApplicationContext(), "Puntuación Total : " + marcador, Toast.LENGTH_SHORT).show();
    }

    /**
     * Método que muestra un mensaje emergente con la respuesta correcta.
     *
     * @param view Vista de la actividad.
     * @see AlertDialog
     */
    public void mostrarCorrecto(String view) {
        AlertDialog.Builder mensaje = new AlertDialog.Builder(this);
        mensaje.setMessage("¡Enhorabuena, respuesta correcta!")
                .setPositiveButton("Continuar...", (dialogInterface, i) -> dialogInterface.dismiss())
                .setTitle("¡BIEN!")
                .setIcon(R.drawable.checkok)
                .create();
        mensaje.show();

    }

    /**
     * Método que muestra un mensaje emergente con la respuesta incorrecta.
     *
     * @param view Vista de la actividad.
     * @see AlertDialog
     */
    public void mostrarIncorrecto(String view) {
        AlertDialog.Builder mensaje = new AlertDialog.Builder(this);
        mensaje.setMessage("¡Vaya! Respuesta Incorrecta")
                .setPositiveButton("Inténtalo de nuevo...", (dialogInterface, i) -> dialogInterface.dismiss())
                .setTitle("¡No! Incorrecto")
                .setIcon(R.drawable.checknotcorrect)
                .create();
        mensaje.show();

    }

    /**
     * Método que reinicia los contadores de pulsado y los flags.
     */
    public void reiniciarContadores() {
        for (int i = 0; i < contadorDePulsado.length; i++) {
            contadorDePulsado[i] = 0;
            controlPregunta[i] = 0;
        }
    }

    /**
     * Método que muestra un mensaje emergente con el premio obtenido.
     */
    public void listaPremios() {
        int size = linkedHashSetCorrectas.size();
        int marcador;
        marcador = size * 10;
        if (marcador >= 0 && marcador <= 10) {
            novato(marcador);
        } else if (marcador == 20) {
            aprendiz(marcador);
        } else if (marcador == 30) {
            especialista(marcador);
        } else if (marcador == 40) {
            experto(marcador);
        }
    }

    public void novato(int marcadores) {
        mostrarPremio("novato", marcadores, R.drawable.novato);
    }

    public void aprendiz(int marcadores) {
        mostrarPremio("aprendiz", marcadores, R.drawable.aprendiz);
    }

    public void especialista(int marcadores) {
        mostrarPremio("especialista", marcadores, R.drawable.especialista);
    }

    public void experto(int marcadores) {
        mostrarPremio("experto", marcadores, R.drawable.experto);
    }



    /**
     * Método genérico que muestra un mensaje emergente con el premio obtenido.
     *
     * @param premio     Nombre del premio.
     * @param marcadores Puntuación total.
     * @param icono      Icono del premio.
     * @see AlertDialog
     */
    private void mostrarPremio(String premio, int marcadores, int icono) {
        AlertDialog.Builder mensaje = new AlertDialog.Builder(this);
        mensaje.setMessage("Eres " + premio + " en el Nivel - 1" + " y puntúas : " + marcadores)
                .setPositiveButton("Salir", (dialogInterface, i) -> dialogInterface.dismiss())
                .setTitle(premio.toUpperCase())
                .setIcon(icono)
                .create();
        mensaje.show();
    }
} // Fin de la clase Nivel1Activity

