package com.juancrud.miscontactos.presentador;

import android.content.Context;

import com.juancrud.miscontactos.adapter.ContactoAdaptador;
import com.juancrud.miscontactos.db.ConstructorContactos;
import com.juancrud.miscontactos.fragment.IRecyclerViewFragmentView;
import com.juancrud.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;

        obtenerContactos();
    }

    @Override
    public void obtenerContactos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        ContactoAdaptador adaptador = iRecyclerViewFragmentView.crearAdaptador(contactos);
        iRecyclerViewFragmentView.inicializarAdaptador(adaptador);
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
