package com.example.Utils;

import com.example.application.views.cuerda.CuerdaView;
import com.example.models.Producto;

import java.util.ArrayList;
import java.util.List;


import java.util.ArrayList;
import java.util.List;

public class Util {
    private static Producto productoEditable;
    public static List<Producto> listaProducto = new ArrayList<>(
            List.of(
            )
    );


    public static void setProductoEditable(Producto producto) {
        productoEditable = producto;
    }
    public static Producto getProductoEditable() {
        return productoEditable;
    }


}
