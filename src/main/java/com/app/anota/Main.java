package com.app.anota;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        Variables
        GeneradorObjeto objeto = null;
        String eleccion;
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Carrito carrito = context.getBean("carrito", Carrito.class);

//Programa principal
        do {
//            Llama al método que devuelve cual es la elección del usuario y este mismo metodo llama inicialmenta al
//            método que le muestra al usuario cuales son las opciones posibles
            eleccion = eleccionUsuario();

//            En función de la acción elegida por el usuario se realiza una u otra
            switch (eleccion) {
                case "1": // Habría añadido ", "lapiz" ", pero por la versión de Java no puede hacerse
                    objeto = context.getBean("lapiz", Lapiz.class);
                    break;
                case "2":
                    objeto = context.getBean("goma", Goma.class);
                    break;
                case "3":
                    objeto = context.getBean("papel", Papel.class);
                    break;
                case "4":
                    System.out.println(carrito.getEmailInformacion());
                    break;
                case "5":
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    System.out.println("Elemento no encontrado.\nReiniciando");
            }

            if (!(eleccion.equals("4") || eleccion.equals("5"))) {
                carrito.agregarObjeto(objeto);
                carrito.mostrarObjetos();
            }
//            TODO: Añadir colores a los mensajes (Opcional)

//            Pequeña pausa para poder leer los mensajes
            Thread.sleep(1000);

        } while (!eleccion.equals("5"));

    }

    public static Scanner scanner = new Scanner(System.in);

    public static void printMenu() {
        System.out.println("¿Qué producto deseas añadir?");
        System.out.println("\t1. Lapiz");
        System.out.println("\t2. Goma");
        System.out.println("\t3. Papel");
        System.out.println("\t4. Notificar un incidente");
        System.out.println("\t5. Salir");
    }

    public static String eleccionUsuario() {
        boolean condicion;
        String eleccion;
        do {
            printMenu();
            eleccion = scanner.nextLine();
            condicion = !(eleccion.equals("1") || eleccion.equals("2") || eleccion.equals("3") || eleccion.equals("4") ||
                    eleccion.equals("5"));
            if (condicion) {
                System.out.println("Ha introducido un valor invalido.");
            }
        } while (condicion);

        return eleccion;
    }

}