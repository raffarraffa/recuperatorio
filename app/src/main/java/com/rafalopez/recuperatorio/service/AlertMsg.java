package com.rafalopez.recuperatorio.service;
import android.content.Context;
public class AlertMsg {
    private static Context context = null;
    public static void mostrar(Context context, String mensaje) {
        android.widget.Toast.makeText(context, mensaje, android.widget.Toast.LENGTH_SHORT).show();
    }
}
