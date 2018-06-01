package com.juancrud.miscontactos.restApi.model;

import com.juancrud.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class ContactoResponse {

    private ArrayList<Contacto> contactos;

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

}
