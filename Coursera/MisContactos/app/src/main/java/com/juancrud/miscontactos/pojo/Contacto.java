package com.juancrud.miscontactos.pojo;

import java.io.Serializable;

public class Contacto implements Serializable {

    private String id;
    private String nombreCompleto;
    private String urlFoto;
    private int likes;

    public Contacto(){}

    public Contacto(String nombreCompleto, String urlFoto, int likes){
        setNombreCompleto(nombreCompleto);
        setUrlFoto(urlFoto);
        setLikes(likes);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
