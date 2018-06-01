package com.juancrud.notificaciones.restApi.adapter;

import com.juancrud.notificaciones.restApi.Constantes;
import com.juancrud.notificaciones.restApi.Endpoints;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {

    public Endpoints establecerConexionRestApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constantes.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(Endpoints.class);
    }
}
