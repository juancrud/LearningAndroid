package com.juancrud.evaluacion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFecha;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvNombre = (TextView) findViewById(R.id.tvDatoNombre);
        tvFecha = (TextView) findViewById(R.id.tvDatoFecha);
        tvTelefono = (TextView) findViewById(R.id.tvDatoTelefono);
        tvEmail = (TextView) findViewById(R.id.tvDatoEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDatoDescripcion);

        Data data = (Data)getIntent().getSerializableExtra(getString(R.string.data));
        tvNombre.setText(data.getNombre());
        tvFecha.setText(data.getFecha());
        tvTelefono.setText(data.getTelefono());
        tvEmail.setText(data.getEmail());
        tvDescripcion.setText(data.getDescripcion());
    }

    public void editar(View view) {
        finish();
    }
}
