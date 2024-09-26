package com.rafalopez.recuperatorio.ui.borrar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rafalopez.recuperatorio.R;
import com.rafalopez.recuperatorio.databinding.FragmentBorrarBinding;
import com.rafalopez.recuperatorio.databinding.FragmentGalleryBinding;
import com.rafalopez.recuperatorio.entity.Inmueble;

public class BorrarFragment extends Fragment {

    private BorrarViewModel mViewModel;
    private FragmentBorrarBinding binding;
    //private String codigo, descripcion,ambientes,direccion,precio;
    private String codigo, descripcion,ambientes,direccion,precio;


    public static BorrarFragment newInstance() {
        return new BorrarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentBorrarBinding.inflate(inflater,container,false);
        View root = binding.getRoot();
        mViewModel = new ViewModelProvider(this).get(BorrarViewModel.class);
        mViewModel.getToastMessage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            }
        });
        mViewModel.getMutExiste().observe(getViewLifecycleOwner(), new Observer<Inmueble>() {
            @Override
            public void onChanged(Inmueble inmueble) {
                borrarDialog("Desea borrar el inmueble",inmueble);

            }
        });

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.buscarInmueble(binding.inputCodigo.getText().toString());
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BorrarViewModel.class);
        // TODO: Use the ViewModel
    }

    private void borrarDialog(String title, Inmueble inmueble ){
        new AlertDialog.Builder(getContext())
                .setTitle(title)
                .setMessage(inmueble.toString())
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mViewModel.borrarInmueble(inmueble);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();

    }

}