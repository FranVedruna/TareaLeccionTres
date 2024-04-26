package com.app.anota;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class Carrito implements GeneradorCarrito {
    private List<GeneradorObjeto> listaObjetos = new LinkedList<>();

    @Value("${email}")
    private String emailInformacion;


    public String getEmailInformacion() {
        return "Mandenos un correo a: " + emailInformacion;
    }


    @Override
    public void agregarObjeto(GeneradorObjeto obj) {
        //Compruebo si ya estaba añadido el objeto
        if (listaObjetos.contains(obj)) {
            listaObjetos.get(listaObjetos.indexOf(obj)).agregar();
        } else {
            listaObjetos.add(obj);

            //Compruebo si he añadido el objeto
            if (listaObjetos.contains(obj)) {
                System.out.println("El objeto " + obj + " ha sido añadido");
            } else {
                System.out.println("El objeto " + obj + " no ha sido añadido");
            }
        }
    }

    @Override
    public void eliminarObjeto(GeneradorObjeto obj) {
//        Compruebo si existe el objeto en la lista
        if (listaObjetos.contains(obj)) {
            listaObjetos.remove(obj);

            // Compruebo si se ha eliminado el objeto
            if (!listaObjetos.contains(obj)) {
                System.out.println("El objeto " + obj + " ha sido eliminado");
            } else {
                System.out.println("El objeto " + obj + " no ha podido ser eliminado");
            }
        } else {
            System.out.println("Objeto no encontrado");
        }
    }

    @Override
    public void mostrarObjetos() {
        System.out.println("\n--- Productos añadidos ---");
        for (GeneradorObjeto obj : listaObjetos){
            obj.mostrarProducto();
        }
    }
}
