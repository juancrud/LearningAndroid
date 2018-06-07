package com.juancrud.evaluacion3;

import com.juancrud.evaluacion3.pojo.Foto;
import com.juancrud.evaluacion3.pojo.Mascota;

import java.util.ArrayList;

public class Datos {

    public static ArrayList<Mascota> Mascotas;

    public static ArrayList<Mascota> Top5Mascotas;

    public static ArrayList<Foto> Fotos;

    public static void initDatos(){
        Mascotas = new ArrayList<>();
        Mascotas.add(new Mascota("Ximun", R.drawable.ximun, 9));
        Mascotas.add(new Mascota("Beto", R.drawable.beto, 10));
        Mascotas.add(new Mascota("Chanchito", R.drawable.chanchito, 7));
        Mascotas.add(new Mascota("Silvestre", R.drawable.silvestre, 9));
        Mascotas.add(new Mascota("Ronny", R.drawable.ronny, 6));
        Mascotas.add(new Mascota("Catty", R.drawable.catty, 7));
        Mascotas.add(new Mascota("Birdy", R.drawable.birdy, 1));
        Mascotas.add(new Mascota("Fishy", R.drawable.fishy, 4));
        Mascotas.add(new Mascota("Doggy", R.drawable.doggy, 8));
        Mascotas.add(new Mascota("Test", R.drawable.test, 3));

        Top5Mascotas = new ArrayList<>();
        Top5Mascotas.add(new Mascota("Beto", R.drawable.beto, 10));
        Top5Mascotas.add(new Mascota("Ximun", R.drawable.ximun, 9));
        Top5Mascotas.add(new Mascota("Silvestre", R.drawable.silvestre, 9));
        Top5Mascotas.add(new Mascota("Doggy", R.drawable.doggy, 8));
        Top5Mascotas.add(new Mascota("Chanchito", R.drawable.chanchito, 7));

        Fotos = new ArrayList<>();
        Fotos.add(new Foto(R.drawable.beto, 3));
        Fotos.add(new Foto(R.drawable.beto, 2));
        Fotos.add(new Foto(R.drawable.beto, 6));
        Fotos.add(new Foto(R.drawable.beto, 4));
        Fotos.add(new Foto(R.drawable.beto, 9));
        Fotos.add(new Foto(R.drawable.beto, 7));
        Fotos.add(new Foto(R.drawable.beto, 1));
        Fotos.add(new Foto(R.drawable.beto, 7));
        Fotos.add(new Foto(R.drawable.beto, 8));
        Fotos.add(new Foto(R.drawable.beto, 7));
        Fotos.add(new Foto(R.drawable.beto, 9));
        Fotos.add(new Foto(R.drawable.beto, 5));
    }
    
}
