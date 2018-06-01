package com.juancrud.miscontactos.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.juancrud.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qryCrearTablaContacto =  "CREATE TABLE " + ConstantesBaseDatos.TABLE_CONTACTS + "(" +
                                        ConstantesBaseDatos.TABLE_CONTACTS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE + " TEXT, " +
                                        ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO + " TEXT, " +
                                        ConstantesBaseDatos.TABLE_CONTACTS_EMAIL + " TEXT, " +
                                        ConstantesBaseDatos.TABLE_CONTACTS_FOTO + " INTEGER" +
                                        ")";

        String qryCrearTablaLikesContacto =  "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_CONTACT + "(" +
                ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_CONTACT_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_CONTACTS + "(" + ConstantesBaseDatos.TABLE_CONTACTS_ID + ")" +
                ")";

        db.execSQL(qryCrearTablaContacto);
        db.execSQL(qryCrearTablaLikesContacto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_LIKES_CONTACT);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_CONTACTS);
        onCreate(db);
    }

    public ArrayList<Contacto> obtenerTodosLosContactos() {
        ArrayList<Contacto> contactos = new ArrayList<>();

        String qry = "SELECT * FROM " + ConstantesBaseDatos.TABLE_CONTACTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(qry, null);

        while(registros.moveToNext()) {
            Contacto contacto = new Contacto();
            /*
            contacto.setId(registros.getInt(0));
            contacto.setNombre(registros.getString(1));
            contacto.setTelefono(registros.getString(2));
            contacto.setEmail(registros.getString(3));
            contacto.setFoto(registros.getInt(4));

            String qryLikes =   "SELECT COUNT(*) FROM " + ConstantesBaseDatos.TABLE_LIKES_CONTACT +
                                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + " = " + contacto.getId();
            Cursor likes = db.rawQuery(qryLikes, null);
            if(likes.moveToNext()){
                contacto.setLikes(likes.getInt(0));
            }*/

            contactos.add(contacto);
        }

        db.close();

        return contactos;
    }

    public void insertarContacto(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_CONTACTS, null, contentValues);
        db.close();
    }

    public void insertarLikeContacto(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_CONTACT, null, contentValues);
        db.close();
    }

    public int obtenerLikes(Contacto contacto) {
        int likes = 0;

        String qry = "SELECT COUNT(*) FROM " + ConstantesBaseDatos.TABLE_LIKES_CONTACT +
                     " WHERE " + ConstantesBaseDatos.TABLE_LIKES_CONTACT_ID_CONTACTO + " = " + contacto.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(qry, null);
        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }
        db.close();

        return likes;
    }

}
