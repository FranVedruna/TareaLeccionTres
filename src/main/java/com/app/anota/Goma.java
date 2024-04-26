package com.app.anota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Goma implements GeneradorObjeto{
    @Autowired
    private Identificador id;
    private static int cantidad = 1;

    public void agregar(){
        cantidad ++;
    }

    @Override
    public void mostrarProducto() {
        System.out.println("Producto: Goma " + id.mostrarIdentificador() + ". Cantidad: " + cantidad);
    }

    public String toString(){
        return "Goma";
    }
}
