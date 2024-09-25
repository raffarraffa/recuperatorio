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

public class CargarFragment extends Fragment {

    private CargarViewModel mViewModel;
    private FragmentCargarBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
                           CargarViewModel cargarViewModel=
                                   new ViewModelProvider(this)
                                           .get(CargarViewModel.class);
                           binding = FragmentCargarBinding.inflate(inflater, container,false);
                           View root = binding.getRoot();



            return root;
         }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}