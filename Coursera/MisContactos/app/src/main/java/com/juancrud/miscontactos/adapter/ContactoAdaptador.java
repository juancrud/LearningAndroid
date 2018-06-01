package com.juancrud.miscontactos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.juancrud.miscontactos.db.ConstructorContactos;
import com.juancrud.miscontactos.pojo.Contacto;
import com.juancrud.miscontactos.DetalleContacto;
import com.juancrud.miscontactos.R;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    private ArrayList<Contacto> contactos;
    private Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity){
        this.contactos = contactos;
        this.activity = activity;
    }

    //Inflar el layout y lo pasa al viewholder para que obtenga los views
    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_contacto, parent, false);
        return new ContactoViewHolder(view);
    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final ContactoViewHolder holder, int position) {
        final Contacto contacto = contactos.get(position);
        Picasso.with(activity).load(contacto.getUrlFoto()).placeholder(R.drawable.mario).into(holder.imgFotoCV);
        //holder.imgFotoCV.setImageResource(contacto.getUrlFoto());
        holder.tvLikes.setText(contacto.getLikes() + "");

        holder.imgFotoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra(activity.getString(R.string.pContacto), contacto);
                activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }


    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoCV;
        private TextView tvLikes;

        public ContactoViewHolder(View itemView) {
            super(itemView);

            imgFotoCV = (ImageView)itemView.findViewById(R.id.imgFotoCV);
            tvLikes = (TextView)itemView.findViewById(R.id.tvLikes);
        }
    }
}
