package com.rafalopez.recuperatorio.ui.borrar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rafalopez.recuperatorio.MainActivity;
import com.rafalopez.recuperatorio.entity.Inmueble;

public class BorrarViewModel extends AndroidViewModel {
    private Inmueble inmueble;
    private  MutableLiveData<String> mToastText;
    private  MutableLiveData<Inmueble> mExiste;

    public BorrarViewModel(@NonNull Application application) {
        super(application);
    }
    public MutableLiveData<String> getToastMessage() {
        if(mToastText==null){
            mToastText=new MutableLiveData<>();
        }
        return mToastText;
    }
    public MutableLiveData<Inmueble> getMutExiste() {
        if(mExiste==null){
            mExiste=new MutableLiveData<>();
        }
        return mExiste;
    }


    public  void buscarInmueble(String codigo){
        for(Inmueble in : MainActivity.inmuebles) {
            if (in.getCodigo().equalsIgnoreCase(codigo)){
                mExiste.setValue(in); // tengo que borrar
                return;
            }
        }
        mToastText.setValue("El Inmueble con ese codigo no existe");
    }
    public  void borrarInmueble(Inmueble inmueble){
        for(Inmueble in : MainActivity.inmuebles) {
            if (in.equals(inmueble)){
                MainActivity.inmuebles.remove(in);
                return;
            }
       }
        mToastText.setValue("El Inmueble se borro");
    }
 }