package com.juancrud.miscontactos.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.juancrud.miscontactos.restApi.ConstantesRestApi;
import com.juancrud.miscontactos.restApi.EndpointsApi;
import com.juancrud.miscontactos.restApi.deserializador.ContactoDeserializador;
import com.juancrud.miscontactos.restApi.model.ContactoResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(EndpointsApi.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ContactoResponse.class, new ContactoDeserializador());
        return gsonBuilder.create();
    }

}
