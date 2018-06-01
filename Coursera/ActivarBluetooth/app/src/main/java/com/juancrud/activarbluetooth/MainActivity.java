package com.juancrud.activarbluetooth;

import android.Manifest;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int CODIGO_SOLICITUD_PERMISO = 1;
    private static final int CODIGO_SOLICITUD_HABILITAR_BLUETOOTH = 2;
    private Context context;
    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();
        activity = this;
    }

    public void habilitarBluetooth(View view) {
        solicitarPermission();

        BluetoothAdapter myBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if(myBluetoothAdapter == null){
            Toast.makeText(this, "Tu dispositivo no tiene Bluetooth", Toast.LENGTH_SHORT).show();
        }
        else if(!myBluetoothAdapter.isEnabled()){
            Intent habilitarBluetoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(habilitarBluetoothIntent, CODIGO_SOLICITUD_HABILITAR_BLUETOOTH);
        }
    }

    public boolean checkPermissionStatus() {
        int resultado = ContextCompat.checkSelfPermission(context, Manifest.permission.BLUETOOTH);
        return resultado == PackageManager.PERMISSION_GRANTED;
    }

    public void solicitarPermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.BLUETOOTH)){
            Toast.makeText(this, "El permiso ya fue otorgado, si deseas desactivarlo puedes ir a los ajustes de la aplicacion", Toast.LENGTH_SHORT).show();
        }
        else{
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.BLUETOOTH}, CODIGO_SOLICITUD_PERMISO);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case CODIGO_SOLICITUD_PERMISO:
                if(checkPermissionStatus()){
                    Toast.makeText(this, "Ya esta activo el permiso para Bluetooth", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(this, "No esta activo el permiso para Bluetooth", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
