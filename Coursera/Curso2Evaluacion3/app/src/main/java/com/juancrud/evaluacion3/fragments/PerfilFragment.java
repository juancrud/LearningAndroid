package com.juancrud.evaluacion3.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.juancrud.evaluacion3.Datos;
import com.juancrud.evaluacion3.FotosAdapter;
import com.juancrud.evaluacion3.MascotaAdapter;
import com.juancrud.evaluacion3.R;

import static com.juancrud.evaluacion3.R.id.rvMascotas;

public class PerfilFragment extends Fragment {

    private ImageView ivFoto;
    private TextView tvNombre;
    private RecyclerView rvFotos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        ivFoto = (ImageView)view.findViewById(R.id.ivFoto);
        tvNombre = (TextView)view.findViewById(R.id.tvNombre);
        rvFotos = (RecyclerView)view.findViewById(R.id.rvFotos);

        initRecyclerView();
        initAdapter();

        return view;
    }

    private void initRecyclerView() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        rvFotos.setLayoutManager(glm);
    }

    private void initAdapter() {
        FotosAdapter adapter = new FotosAdapter(Datos.Fotos);
        rvFotos.setAdapter(adapter);
    }

}
