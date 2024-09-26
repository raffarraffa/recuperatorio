package com.rafalopez.recuperatorio.ui.borrar;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rafalopez.recuperatorio.R;
import com.rafalopez.recuperatorio.databinding.FragmentBorrarBinding;
import com.rafalopez.recuperatorio.databinding.FragmentGalleryBinding;

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
        mViewModel = new ViewModelProvider(this).get(BorrarViewModel.class);
        View root = binding.getRoot();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewModel.
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

}