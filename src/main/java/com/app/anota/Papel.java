package com.app.anota;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Papel implements GeneradorObjeto{
    @Autowired
    private Identificador id;
    private static int cantidad = 1;

    @Override
    public void mostrarProducto() {
        System.out.println("Producto: Papel " + id.mostrarIdentificador() + ". Cantidad: " + cantidad);
    }

    @Override
    public void agregar() {
        cantidad ++;
    }

    public String toString(){
        return "Papel";
    }
}
