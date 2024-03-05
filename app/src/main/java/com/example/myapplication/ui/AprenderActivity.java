package com.example.myapplication.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.example.myapplication.R;
import com.google.android.material.navigation.NavigationView;

public class AprenderActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private ImageView imageViewSuma;
    private ImageView imageViewResta;
    private ImageView imageViewMultiplicacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprender);

        // Aquí muestro el menú de la actividad Aprender
        // Inicializo el DrawerLayout, el NavigationView y los ImageView
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        imageViewSuma = findViewById(R.id.image_view_explicativo_suma);
        imageViewResta = findViewById(R.id.image_view_explicativo_resta);
        imageViewMultiplicacion = findViewById(R.id.image_view_explicativo_multiplicacion);

        // Ocultar todas las imágenes explicativas
        ocultarImagenesExplicativas();

        // Configurar el ActionBarDrawerToggle para mostrar el icono del menú
        // Texto para abrir y cerrar el menú
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        // Esto permite escuchar eventos de cierre y apertura del menú
        // Se llama los métodos correctos para actualizar el toggle
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        // syncState nos asegura que el icono del menú se muestre correctamente p. ej. (al girar la pantalla que no se cierre)
        actionBarDrawerToggle.syncState();
        // Habilitar clics en elementos de menú lateral
        navigationView.setNavigationItemSelectedListener(this);

    }

    //Método que maneja la selección de elementos del menú
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Manejar la selección del elemento del menú
        int itemId = item.getItemId();
        if (itemId == R.id.menu_suma) {
            // Actualizar el contenido para mostrar la explicación de la suma
            mostrarImagenExplicativa(R.drawable.imagen_suma, imageViewSuma);
        } else if (itemId == R.id.menu_resta) {
            // Actualizar el contenido para mostrar la explicación de la resta
            mostrarImagenExplicativa(R.drawable.imagen_resta, imageViewResta);
        } else if (itemId == R.id.menu_multiplicacion) {
            // Actualizar el contenido para mostrar la explicación de la multiplicación
            mostrarImagenExplicativa(R.drawable.imagen_multiplicacion, imageViewMultiplicacion);
        }
        // Agregar más casos según sea necesario para otras opciones de menú
        // Cerrar el menú lateral después de seleccionar una opción
        drawerLayout.closeDrawer(GravityCompat.START);
        // El proceso ha salido bien (true)
        return true;
    }

    // Método para mostrar el contenido en el área principal de AprenderActivity
    private void mostrarImagenExplicativa(int idImagen, ImageView imageView) {
        // Aquí se muestra la imagen en el área principal de la actividad
        ocultarImagenesExplicativas();
        imageView.setVisibility(View.VISIBLE);
        imageView.setImageDrawable(getResources().getDrawable(idImagen));
    }
    private void ocultarImagenesExplicativas() {
        imageViewSuma.setVisibility(View.GONE);
        imageViewResta.setVisibility(View.GONE);
        imageViewMultiplicacion.setVisibility(View.GONE);
    }
}
