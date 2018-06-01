package com.juancrud.miscontactos.fragment;

import com.juancrud.miscontactos.adapter.ContactoAdaptador;
import com.juancrud.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    void generarLinearLayoutVertical();
    ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);
    void inicializarAdaptador(ContactoAdaptador adaptador);

}
