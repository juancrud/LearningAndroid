package com.juancrud.evaluacion2.activities;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.juancrud.evaluacion2.Datos;
import com.juancrud.evaluacion2.R;

public class MainActivity extends AppCompatActivity {

    private TextView tvLoading;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLoading = (TextView) findViewById(R.id.tvLoading);

        setupTimer();
        cargarDatos();
        timer.start();
    }

    private void cargarDatos() {
        Datos.initDatos();
    }

    private void iniciar() {
        Intent intent = new Intent(this, ListaActivity.class);
        startActivity(intent);
        finish();
    }

    private void setupTimer(){
        timer = new CountDownTimer(5000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                String mensaje = tvLoading.getText().toString();
                mensaje += ".";
                tvLoading.setText(mensaje);
            }

            @Override
            public void onFinish() {
                iniciar();
            }
        };
    }
}
