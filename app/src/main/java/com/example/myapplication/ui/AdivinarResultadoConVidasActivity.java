package com.example.myapplication.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

public class AdivinarResultadoConVidasActivity extends AppCompatActivity {

    private int vidas;
    private int num1;
    private int num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adivinar_resultado_vidas);

        vidas = 3;
        num1 = generarNumeroAleatorio();
        num2 = generarNumeroAleatorio();

        // Mostrar la imagen de las dos sandías
        // Mostrar las cuatro opciones con el resultado de la suma
        // ...

        // Controlar la selección del usuario
        // ...

        // Si el usuario elige la opción correcta, aumentar el puntaje
        // Si el usuario elige la opción incorrecta, disminuir las vidas
        // ...

        // Si se agotan las vidas, mostrar la pantalla de fin de juego
        // ...
    }

    private int generarNumeroAleatorio() {
        // Generar un número aleatorio entre 1 y 10
        // ...
        return 0;
    }
}
