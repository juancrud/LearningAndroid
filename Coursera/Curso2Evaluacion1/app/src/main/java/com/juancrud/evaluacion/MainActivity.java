package com.juancrud.evaluacion;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre;
    private EditText etFecha;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDescripcion;

    private Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etFecha = (EditText) findViewById(R.id.etFecha);
        etTelefono = (EditText) findViewById(R.id.etTelefono);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etDescripcion = (EditText) findViewById(R.id.etDescripcion);

        setUpDatepicker();
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        etFecha.setText(sdf.format(myCalendar.getTime()));
    }

    private void setUpDatepicker() {
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        etFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = myCalendar.get(Calendar.YEAR);
                int month = myCalendar.get(Calendar.MONTH);
                int day = myCalendar.get(Calendar.DAY_OF_MONTH);
                new DatePickerDialog(MainActivity.this, date, year, month, day).show();
            }
        });
    }

    public void siguiente(View view) {
        String nombre = etNombre.getText().toString();
        String fecha = etFecha.getText().toString();
        String telefono = etTelefono.getText().toString();
        String email = etEmail.getText().toString();
        String descripcion = etDescripcion.getText().toString();
        Data data = new Data(nombre, fecha, telefono, email, descripcion);

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(getString(R.string.data), data);
        startActivity(intent);
    }

}
