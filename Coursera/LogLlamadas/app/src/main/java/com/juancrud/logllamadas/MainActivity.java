package com.juancrud.logllamadas;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView tvLlamadas;
    private static final int CODIGO_SOLICITUD_PERMISO = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvLlamadas = (TextView) findViewById(R.id.tvLlamadas);
    }

    public void mostrarLlamadas(View view) {
        if (checkStatusPermiso()) {
            consularCPLlamadas();
        } else {
            solicitarPermiso();
        }
    }

    /* Consulta al content provider */
    public void consularCPLlamadas() {
        tvLlamadas.setText("");

        Uri direccionUriLlamadas = CallLog.Calls.CONTENT_URI;
        String[] campos = {
                CallLog.Calls.NUMBER, //Numero
                CallLog.Calls.DATE, //Fecha
                CallLog.Calls.TYPE, //Tipo de llamadas (perdida, espera, etc)
                CallLog.Calls.DURATION //Duracion
        };

        ContentResolver contentResolver = getContentResolver();
        Cursor registros = contentResolver.query(direccionUriLlamadas, campos, null, null, CallLog.Calls.DATE + " DESC");

        while(registros.moveToNext()){
            String numero = registros.getString(registros.getColumnIndex(campos[0]));
            long fecha = registros.getLong(registros.getColumnIndex(campos[1]));
            int tipo = registros.getInt(registros.getColumnIndex(campos[2]));
            String duracion = registros.getString(registros.getColumnIndex(campos[3]));
            String tipoLlamada;

            switch (tipo){
                case CallLog.Calls.INCOMING_TYPE:
                    tipoLlamada = getString(R.string.entrada);
                    break;
                case CallLog.Calls.MISSED_TYPE:
                    tipoLlamada = getString(R.string.perdida);
                    break;
                case CallLog.Calls.OUTGOING_TYPE:
                    tipoLlamada = getString(R.string.salida);
                    break;
                default:
                    tipoLlamada = getString(R.string.desconocida);
            }

            String detalle = getString(R.string.lblNumero) + numero + "\n" +
                    getString(R.string.lblFecha) + DateFormat.format("dd/MM/yy k:mm", fecha) + "\n" +
                    getString(R.string.lblTipo) + tipoLlamada + "\n" +
                    getString(R.string.lblDuracion) + duracion +" segs."+ "\n\n";
            tvLlamadas.append(detalle);
        }

    }

    /* Permisos */
    public void solicitarPermiso() {
        //ReadCallLog
        boolean solicitarPermisoRCL = ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CALL_LOG);
        //WriteCallLog
        boolean solicitarPermisoWCL = ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_CALL_LOG);

        if(solicitarPermisoRCL && solicitarPermisoWCL){
            Toast.makeText(this, "Los permisos fueron otorgados", Toast.LENGTH_SHORT).show();
        }
        else{
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CALL_LOG, Manifest.permission.WRITE_CALL_LOG}, CODIGO_SOLICITUD_PERMISO);
        }
    }

    public boolean checkStatusPermiso() {
        boolean permisoRCL = ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG) == PackageManager.PERMISSION_GRANTED;
        boolean permisoWCL = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_CALL_LOG) == PackageManager.PERMISSION_GRANTED;
        return permisoRCL && permisoWCL;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
            case CODIGO_SOLICITUD_PERMISO:
                if(checkStatusPermiso()){
                    Toast.makeText(this, "Ya esta activo el permiso", Toast.LENGTH_SHORT).show();
                    consularCPLlamadas();
                }
                else{
                    Toast.makeText(this, "No se activo el permiso", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
