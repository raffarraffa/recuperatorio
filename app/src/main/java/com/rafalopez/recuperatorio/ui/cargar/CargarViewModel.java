package com.rafalopez.recuperatorio.ui.cargar;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rafalopez.recuperatorio.MainActivity;
import com.rafalopez.recuperatorio.entity.Inmueble;
import com.rafalopez.recuperatorio.service.AlertMsg;

public class CargarViewModel extends AndroidViewModel {
    private  Inmueble inmueble;
    private  MutableLiveData<String> mToastText;
  //  private Context contexto;


    public CargarViewModel(@NonNull Application application) {
        super(application);
//        this.contexto = getApplication().getApplicationContext();

    }
    public MutableLiveData<String> getToastMessage() {

        if(mToastText==null){
            mToastText=new MutableLiveData<>();
        }
        return mToastText;
    }
    public void cargarInmueble(String codigo,String descripcion,String ambiente, String direccion, String precio){
        if(codigo.isEmpty() || descripcion.isEmpty() || ambiente.isEmpty()|| direccion.isEmpty() || precio.isEmpty() ) {
            Log.d("salida", "cargarInmueble: SADFF" );

            mToastText.setValue("Tiene campo incompletos");
            return;
        }
        inmueble =new Inmueble(codigo,descripcion,Integer.parseInt(ambiente),direccion,
                Double.parseDouble(precio));
       for(Inmueble in : MainActivity.inmuebles) {
           Log.d("salida", "cargarInmueble: " + in.toString());
           if (in.equals(inmueble)) {
               mToastText.setValue("El codigo ya existe");
               return;
           }
       }
         MainActivity.inmuebles.add(inmueble);
        mToastText.setValue("Inmueble coigo " + inmueble.getCodigo() +  " Fue crado con exito  " );
       return;
   }


    private  void addInmueble(Inmueble inmueble) {
        for(Inmueble in :MainActivity.inmuebles) {
            if (inmueble.equals(in)) {
              //  AlertMsg.mostrar(contexto, "El inmueble ya existe ");
                return;
            }
        }
        MainActivity.inmuebles.add(inmueble);
//        AlertMsg.mostrar(contexto, "El inmueble agregado con exito ");
        }

}