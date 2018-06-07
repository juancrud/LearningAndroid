package com.juancrud.evaluacion2.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.juancrud.evaluacion2.Datos;
import com.juancrud.evaluacion2.MascotaAdapter;
import com.juancrud.evaluacion2.R;

public class ListaActivity extends AppCompatActivity {

    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        rvMascotas = (RecyclerView)findViewById(R.id.rvMascotas);

        initRecyclerView();
        initAdapter();
    }

    private void initRecyclerView() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
    }

    private void initAdapter() {
        MascotaAdapter adapter = new MascotaAdapter(Datos.Mascotas);
        rvMascotas.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mStar5:
                Intent intent = new Intent(this, FavoritosActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
