package com.juancrud.evaluacion2;

import com.juancrud.evaluacion2.pojo.Mascota;

import java.util.ArrayList;
import java.util.List;

public class Datos {

    public static ArrayList<Mascota> Mascotas;

    public static ArrayList<Mascota> Top5Mascotas;

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
    }

}
