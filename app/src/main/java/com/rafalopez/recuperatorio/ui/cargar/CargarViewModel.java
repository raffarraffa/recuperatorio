package com.rafalopez.recuperatorio.ui.cargar;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rafalopez.recuperatorio.MainActivity;
import com.rafalopez.recuperatorio.entity.Inmueble;
import com.rafalopez.recuperatorio.service.AlertMsg;

public class CargarViewModel extends AndroidViewModel {
    private  Inmueble inmueble;
    private  MutableLiveData<String> mText;
    private Context contexto;

    public CargarViewModel(@NonNull Application application, Context contexto) {
        super(application);
        this.contexto = contexto.getApplicationContext();
    }

    public MutableLiveData<String> getmText() {
        return mText;
    }

    public void cargarInmueble(Inmueble inmueble){
        switch (inmueble.isValid()){
            case 0:
                addInmueble(inmueble);
            break;
            case 1:
                AlertMsg.mostrar(contexto,"El inmueble no tiene codigo");
            break;
            case 2:
                AlertMsg.mostrar(contexto,"El inmueble no tiene descripcion");
            break;
            case 3:
                AlertMsg.mostrar(contexto,"El inmueble no tiene cant. ambientes");
            break;
            case 4:
                AlertMsg.mostrar(contexto,"El inmueble no tiene direccion");
            break;
            case 5:
                AlertMsg.mostrar(contexto,"El inmueble no tiene precio");
            break;
            default:
                AlertMsg.mostrar(contexto,"El inmueble no tiene codigo");

        }
    }


    private  void addInmueble(Inmueble inmueble) {
        for(Inmueble in :MainActivity.inmuebles) {
            if (inmueble.equals(in)) {
                AlertMsg.mostrar(contexto, "El inmueble ya existe ");
                return;
            }
        }
        MainActivity.inmuebles.add(inmueble);
        AlertMsg.mostrar(contexto, "El inmueble agregado con exito ");
        }
}