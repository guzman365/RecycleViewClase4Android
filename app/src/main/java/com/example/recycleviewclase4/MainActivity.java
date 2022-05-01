package com.example.recycleviewclase4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvLibros;
    private LibrosAdapter adapterLibros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Vincular la instancia de RecyclerView con RecyclerView de nuestro layout
        rcvLibros = findViewById(R.id.rcvListado);

        //Definir la forma de la lista vertical, similar a la de un listview
        rcvLibros.setLayoutManager(new LinearLayoutManager(this));

        //Asignar la informacion al Recycler de nuestro layout
        adapterLibros = new LibrosAdapter(obtenerLibros());
        rcvLibros.setAdapter(adapterLibros);
    }

    //Crear uina lista del tipo LibrosModelo con el contenido a mostrar en pantalla
    public List<LibrosModelo> obtenerLibros(){
        List<LibrosModelo> libros = new ArrayList<>();
        libros.add(new LibrosModelo(
                "Desarrollo de aplicaciones para android",
                "Edicion 2017. Incluye Android Studio 2.1 y wearable",
                R.drawable.primerimagen));
        libros.add(new LibrosModelo(
                "Professional ASP.NET MVC 5",
                "Manual completo para programación de páginas web activas con C#",
                R.drawable.segundaimagen));
        libros.add(new LibrosModelo(
                "Introducción a la programación Estructurada en C",
                "Libro sobre lenguaje C con ejemplos y disco de recursos",
                R.drawable.terceraimagen));
        return libros;
    }
}