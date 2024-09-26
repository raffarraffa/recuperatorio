package com.rafalopez.recuperatorio.ui.salir;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.rafalopez.recuperatorio.databinding.FragmentSalirBinding;

public class SalirFragment extends Fragment {

    private FragmentSalirBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSalirBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        new AlertDialog.Builder(getContext())
                .setTitle("Salir")
                .setMessage("Dese salir de la aplicacion")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        requireActivity().finishAffinity();

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void exitDialog(String title, String mesage ){


    }
}