package com.juancrud.miscontactos.db;

import android.content.ContentValues;
import android.content.Context;

import com.juancrud.miscontactos.R;
import com.juancrud.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class ConstructorContactos {

    private Context context;

    public ConstructorContactos(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);

        insertarTodosLosContactos(db);
        return db.obtenerTodosLosContactos();
    }

    public void insertarTodosLosContactos(BaseDatos db) {
        ContentValues contentValues;

        contentValues = getContentValuesContacto("Juan Carlos Rudin", "88716316", "juancrud@gmail.com", R.drawable.mario);
        db.insertarContacto(contentValues);

        contentValues = getContentValuesContacto("Gabriela Sanchez", "87526036", "gabskatze@gmail.com", R.drawable.princess);
        db.insertarContacto(contentValues);

        contentValues = getContentValuesContacto("Maria Perez", "84627364", "mperez@gmail.com", R.drawable.luigi);
        db.insertarContacto(contentValues);

        contentValues = getContentValuesContacto("Ana Fernandez", "84726351", "afernandez@gmail.com", R.drawable.kong);
        db.insertarContacto(contentValues);

        contentValues = getContentValuesContacto("Fernando Alvarez", "86352431", "falvarez@gmail.com", R.drawable.toad);
        db.insertarContacto(contentValues);

        contentValues = getContentValuesContacto("Juan Sanchez", "87634512", "jsanchez@gmail.com", R.drawable.wario);
        db.insertarContacto(contentValues);
    }

    public void darLikeContacto(Contacto contacto) {
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = getContentValuesLikeContacto(contacto);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesContacto(Contacto contacto) {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikes(contacto);
    }

    private ContentValues getContentValuesLikeContacto(Contacto contacto) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO, contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES, 1);

        return contentValues;
    }

    private ContentValues getContentValuesContacto(String nombre, String telefono, String email, int foto){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE, nombre);
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO, telefono);
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL, email);
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO, foto);
        return contentValues;
    }
}
