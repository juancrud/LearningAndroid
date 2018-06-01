package com.juancrud.memoria;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etCorreo;
    private TextView tvPreferenciaCompartida;
    private SharedPreferences miPreferenciaCompartida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etCorreo = (EditText) findViewById(R.id.etCorreo);
        tvPreferenciaCompartida = (TextView) findViewById(R.id.tvPreferenciaCompartida);

        miPreferenciaCompartida = getSharedPreferences("MisDatosPersonales", Context.MODE_PRIVATE);
    }

    /* File IO */
    public void generarArchivo(View view){
        try {
            String nombre = etNombre.getText().toString();

            FileOutputStream outputStream = openFileOutput("MiArchivo.txt", MODE_PRIVATE);
            outputStream.write(nombre.getBytes());
            outputStream.close();

            Toast.makeText(this, "El archivo se ha creado", Toast.LENGTH_SHORT).show();
            etNombre.setText("");
        }
        catch(Exception ex) {
            ex.printStackTrace();
            Toast.makeText(this, "Hubo un error en la ecritura del archivo", Toast.LENGTH_SHORT).show();
        }
    }

    /* Shared Preference */
    public void guardarPreferencia(View view) {
        SharedPreferences.Editor editor = miPreferenciaCompartida.edit();

        String nombre = etNombre.getText().toString();
        String correo = etCorreo.getText().toString();

        editor.putString("nombre", nombre);
        editor.putString("correo", correo);

        editor.commit();

        Toast.makeText(this, "Se ha creado la preferencia compartida", Toast.LENGTH_SHORT).show();
        etNombre.setText("");
        etCorreo.setText("");
    }

    public void mostrarPreferencia(View view) {
        String nombre = miPreferenciaCompartida.getString("nombre", "no existe esa variable");
        String correo = miPreferenciaCompartida.getString("correo", "no existe esa variable");

        String preferencia = "Nombre: " + nombre + "\nCorreo: " + correo;
        tvPreferenciaCompartida.setText(preferencia);
    }

}
