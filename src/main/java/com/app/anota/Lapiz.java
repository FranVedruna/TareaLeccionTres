package com.app.anota;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Lapiz implements GeneradorObjeto{
    @Autowired
    private Identificador id;
    private static int cantidad = 1;


    @Override
    public void mostrarProducto() {
        System.out.println("Producto: Lapiz " + id.mostrarIdentificador() + ". Cantidad: " +cantidad);
    }

    @Override
    public void agregar() {
        cantidad ++;
    }

    public String toString(){
        return "Lapiz";
    }
}
