package com.example.mascotasapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class FavoritosActivity extends AppCompatActivity {

    private List<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.fabfotos).setVisibility(View.INVISIBLE);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.pet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        inicializarListaMascotas();
        RecyclerView rvMascotas = findViewById(R.id.rvMascotas);
        rvMascotas.setAdapter(new MascotasAdapter(mascotas));

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }
    public void inicializarListaMascotas(){
        mascotas =new ArrayList<Mascota>();
        mascotas.add(new Mascota("Kyoshi",R.mipmap.perrito,6));
        mascotas.add(new Mascota("Arkady",R.mipmap.perrito,6));
        mascotas.add(new Mascota("Katia", R.mipmap.perrito,5));
        mascotas.add(new Mascota("Baba", R.mipmap.perrito,4));
        mascotas.add(new Mascota("Gretel", R.mipmap.perrito,4));


    }
}