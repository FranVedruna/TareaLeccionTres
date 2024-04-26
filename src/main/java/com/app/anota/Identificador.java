package com.app.anota;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Identificador implements GeneradorIdentificador{
    private static int contadorIdentificador = 1;
    private int identificador;

    public Identificador(){
        generarIdentificador();
    }
    @Override
    public void generarIdentificador() {
        this.identificador = contadorIdentificador;
        contadorIdentificador++;
    }

    @Override
    public String mostrarIdentificador() {
        return "Identificador: " + this.identificador;
    }
}
