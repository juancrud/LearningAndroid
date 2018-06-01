package com.juancrud.mascotas;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SwipeRefreshLayout sfiMiIndicadorRefresh;
    private ListView lvMiLista;
    private FloatingActionButton fabMiFab;
    private Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sfiMiIndicadorRefresh = (SwipeRefreshLayout)findViewById(R.id.sfiMiIndicadorRefresh);
        lvMiLista = (ListView)findViewById(R.id.lvMiLista);
        fabMiFab = (FloatingActionButton)findViewById(R.id.fabMiFab);

        String[] planetas = getResources().getStringArray(R.array.planetas);
        lvMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));
        sfiMiIndicadorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refrecandoContenido();
            }
        });

        agregarFab();
    }

    public void refrecandoContenido(){
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lvMiLista.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, planetas));
        sfiMiIndicadorRefresh.setRefreshing(false);
    }

    public void agregarFab(){
        fabMiFab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Toast.makeText(getBaseContext(), getString(R.string.mensaje), Toast.LENGTH_SHORT).show();
                Snackbar.make(v, getString(R.string.mensaje), Snackbar.LENGTH_LONG)
                        .setAction(getString(R.string.text_accion), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i("SNACKBAR", "Click en Snackbar");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();


            }
        });
    }
}
