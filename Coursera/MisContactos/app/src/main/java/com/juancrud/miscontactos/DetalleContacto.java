package com.juancrud.miscontactos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.juancrud.miscontactos.R;
import com.juancrud.miscontactos.pojo.Contacto;
import com.squareup.picasso.Picasso;

import static com.juancrud.miscontactos.R.id.tvNombre;

public class DetalleContacto extends AppCompatActivity {

    private ImageView imgFotoDetalle;
    private TextView tvLikesDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto_foto);

        Bundle extras = getIntent().getExtras();
        Contacto contacto = (Contacto) extras.getSerializable(getString(R.string.pContacto));

        imgFotoDetalle = (ImageView) findViewById(R.id.imgFotoDetalle);
        tvLikesDetalle = (TextView) findViewById(R.id.tvLikesDetalle);

        tvLikesDetalle.setText(""+contacto.getLikes());
        Picasso.with(this).load(contacto.getUrlFoto()).placeholder(R.drawable.mario).into(imgFotoDetalle);
    }

}
