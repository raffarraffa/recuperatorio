package com.rafalopez.recuperatorio.ui.cargar;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rafalopez.recuperatorio.R;
import com.rafalopez.recuperatorio.databinding.FragmentCargarBinding;

import com.rafalopez.recuperatorio.entity.Inmueble;

public class CargarFragment extends Fragment {

    private CargarViewModel cargarViewModel;
    private FragmentCargarBinding binding;
    private String codigo, descripcion,ambientes,direccion,precio;
    Inmueble inmueble = new Inmueble();
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
                cargarViewModel= new ViewModelProvider(this).get(CargarViewModel.class);
                binding = FragmentCargarBinding.inflate(inflater, container,false);
                View root = binding.getRoot();
                cargarViewModel.getToastMessage().observe(getViewLifecycleOwner(), new Observer<String>() {
                            @Override
                            public void onChanged(String msg) {
                                Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
                                binding.inputCodigo.setText("");
                                binding.inputDescripcion.setText("");
                                binding.inputCantidad.setText("");
                                binding.inputDireccion.setText("");
                                binding.inputPrecio.setText("");
                            }
                        });
                binding.btnCargar.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    codigo = binding.inputCodigo.getText().toString();
                    descripcion= binding.inputDescripcion.getText().toString();
                    ambientes= binding.inputCantidad.getText().toString();
                    direccion = binding.direccion.getText().toString();
                    precio = binding.inputPrecio.getText().toString();
                 //   Log.d("salida", "onClick: " + inmueble.toString());
                    cargarViewModel.cargarInmueble(codigo, descripcion,ambientes,direccion,precio);
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