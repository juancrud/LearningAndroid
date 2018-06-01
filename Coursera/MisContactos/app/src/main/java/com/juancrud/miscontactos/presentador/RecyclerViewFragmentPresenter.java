package com.juancrud.miscontactos.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.juancrud.miscontactos.adapter.ContactoAdaptador;
import com.juancrud.miscontactos.db.ConstructorContactos;
import com.juancrud.miscontactos.fragment.IRecyclerViewFragmentView;
import com.juancrud.miscontactos.pojo.Contacto;
import com.juancrud.miscontactos.restApi.EndpointsApi;
import com.juancrud.miscontactos.restApi.adapter.RestApiAdapter;
import com.juancrud.miscontactos.restApi.model.ContactoResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorContactos constructorContactos;
    private ArrayList<Contacto> contactos;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;

        //obtenerContactos();
        obtenerMediosRecientes();
    }

    @Override
    public void obtenerContactos() {
        constructorContactos = new ConstructorContactos(context);
        contactos = constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        ContactoAdaptador adaptador = iRecyclerViewFragmentView.crearAdaptador(contactos);
        iRecyclerViewFragmentView.inicializarAdaptador(adaptador);
        iRecyclerViewFragmentView.generarGridLayout();
    }

    @Override
    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<ContactoResponse> contactoResponseCall =  endpointsApi.getRecentMedia();

        contactoResponseCall.enqueue(new Callback<ContactoResponse>() {
            @Override
            public void onResponse(Call<ContactoResponse> call, Response<ContactoResponse> response) {
                ContactoResponse contactoResponse = response.body();
                contactos = contactoResponse.getContactos();
                mostrarContactosRV();
            }

            @Override
            public void onFailure(Call<ContactoResponse> call, Throwable t) {
                Toast.makeText(context, "Error en la conexion", Toast.LENGTH_SHORT).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });
    }
}
