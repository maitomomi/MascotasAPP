package com.example.mascotasapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Mascota> mascotas;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuppal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.action_favoritos){
            //fatla poner lo que tiene que pasar
            Intent intent=new Intent(this,FavoritosActivity.class);
            startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.pet);


        inicializarListaMascotas();
        RecyclerView rvMascotas = findViewById(R.id.rvMascotas);
        rvMascotas.setAdapter(new MascotasAdapter(mascotas));

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);


    }




    public void inicializarListaMascotas(){
        mascotas =new ArrayList<Mascota>();
        mascotas.add(new Mascota("Patas", R.mipmap.gatito,5));
        mascotas.add(new Mascota("Tomy", R.mipmap.gatito,4));
        mascotas.add(new Mascota("Seis",R.mipmap.perrito,6));
        mascotas.add(new Mascota("Tupac", R.mipmap.perrito,4));
        mascotas.add(new Mascota("Chico", R.mipmap.perrito,3));
        mascotas.add(new Mascota("Nina",R.mipmap.perrito,6));

    }

}
