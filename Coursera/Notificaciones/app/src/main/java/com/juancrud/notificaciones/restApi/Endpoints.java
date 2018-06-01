package com.juancrud.notificaciones.restApi;

import com.juancrud.notificaciones.restApi.model.UsuarioResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Endpoints {

    @FormUrlEncoded
    @POST(Constantes.KEY_POST_ID_TOKEN)
    Call<UsuarioResponse> registrarTokenId(@Field("token") String token);

}
