package com.juancrud.evaluacion3;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.juancrud.evaluacion3.pojo.Foto;

import java.util.ArrayList;

public class FotosAdapter extends RecyclerView.Adapter<FotosAdapter.FotosViewHolder>{

    private ArrayList<Foto> fotos;

    public FotosAdapter(ArrayList<Foto> fotos){
        this.fotos = fotos;
    }

    @Override
    public FotosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_foto, parent, false);
        return new FotosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FotosViewHolder holder, int position) {
        Foto foto = fotos.get(position);
        holder.ivFoto.setImageResource(foto.getImagen());
        holder.tvRating.setText(""+foto.getRating());
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public static class FotosViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivFoto;
        private TextView tvRating;

        public FotosViewHolder(View itemView) {
            super(itemView);

            ivFoto = (ImageView) itemView.findViewById(R.id.ivFoto);
            tvRating = (TextView) itemView.findViewById(R.id.tvRating);
        }
    }
}
