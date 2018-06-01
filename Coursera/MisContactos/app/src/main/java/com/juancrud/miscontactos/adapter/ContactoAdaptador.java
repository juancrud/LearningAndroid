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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        return new ContactoViewHolder(view);
    }

    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(final ContactoViewHolder holder, int position) {
        final Contacto contacto = contactos.get(position);
        holder.imgFotoCV.setImageResource(contacto.getFoto());
        holder.tvNombreCV.setText(contacto.getNombre());
        holder.tvTelefonoCV.setText(contacto.getTelefono());
        holder.tvLikes.setText(contacto.getLikes() + " likes");

        holder.imgFotoCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra(activity.getString(R.string.pContacto), contacto);
                activity.startActivity(intent);
            }
        });

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste Like a: " + contacto.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorContactos constructorContactos = new ConstructorContactos(activity);
                constructorContactos.darLikeContacto(contacto);
                holder.tvLikes.setText(constructorContactos.obtenerLikesContacto(contacto) + " likes");
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }


    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoCV;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private TextView tvLikes;
        private ImageButton btnLike;

        public ContactoViewHolder(View itemView) {
            super(itemView);

            imgFotoCV = (ImageView)itemView.findViewById(R.id.imgFotoCV);
            tvNombreCV = (TextView)itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV = (TextView)itemView.findViewById(R.id.tvTelefonoCV);
            tvLikes = (TextView)itemView.findViewById(R.id.tvLikes);
            btnLike = (ImageButton)itemView.findViewById(R.id.btnLike);
        }
    }
}
