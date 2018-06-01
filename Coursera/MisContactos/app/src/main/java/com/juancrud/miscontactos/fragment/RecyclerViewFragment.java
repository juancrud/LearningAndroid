package com.juancrud.miscontactos.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juancrud.miscontactos.R;
import com.juancrud.miscontactos.adapter.ContactoAdaptador;
import com.juancrud.miscontactos.pojo.Contacto;
import com.juancrud.miscontactos.presentador.IRecyclerViewFragmentPresenter;
import com.juancrud.miscontactos.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {

    private ArrayList<Contacto> contactos;
    private RecyclerView rvContactos;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        rvContactos = (RecyclerView)view.findViewById(R.id.rvContactos);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        return view;
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 2);
        rvContactos.setLayoutManager(glm);
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvContactos.setLayoutManager(llm);
    }

    @Override
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos) {
        return new ContactoAdaptador(contactos, getActivity());
    }

    @Override
    public void inicializarAdaptador(ContactoAdaptador adaptador) {
        rvContactos.setAdapter(adaptador);
    }
}
