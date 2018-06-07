package com.juancrud.evaluacion;

import java.io.Serializable;

public class Data implements Serializable{

    private String nombre;
    private String fecha;
    private String telefono;
    private String email;
    private String descripcion;

    public Data(String nombre, String fecha, String telefono, String email, String descripcion) {
        setNombre(nombre);
        setFecha(fecha);
        setTelefono(telefono);
        setEmail(email);
        setDescripcion(descripcion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
