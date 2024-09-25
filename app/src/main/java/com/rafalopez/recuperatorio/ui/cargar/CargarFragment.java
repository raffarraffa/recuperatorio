package com.rafalopez.recuperatorio.ui.cargar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rafalopez.recuperatorio.R;
import com.rafalopez.recuperatorio.databinding.FragmentCargarBinding;
import com.rafalopez.recuperatorio.databinding.FragmentGalleryBinding;
import com.rafalopez.recuperatorio.entity.Inmueble;

public class CargarFragment extends Fragment {

    private CargarViewModel cargarViewModel;
    private FragmentCargarBinding binding;
    Inmueble inmueble = new Inmueble();
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
                           cargarViewModel= new ViewModelProvider(this).get(CargarViewModel.class);
                           binding = FragmentCargarBinding.inflate(inflater, container,false);
                           View root = binding.getRoot();
            binding.btnCargar.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    inmueble.setCodigo(binding.inputCodigo.getText().toString());
                    inmueble.setDescripcion(binding.inputDescripcion.getText().toString());
                    inmueble.setCantidadAmbientes(Integer.parseInt(binding.inputCantidad.getText().toString()));
                    inmueble.setDireccion(binding.direccion.getText().toString());
                    inmueble.setPrecio(Double.parseDouble(binding.inputPrecio.getText().toString()));
                  //  cargarViewModel.cargarInmueble(inmueble);
                }
            });



            return root;
         }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}