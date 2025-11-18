package com.maquina;

import java.lang.reflect.Constructor;

public class Cafetera {

    private int cantidadCafe;


     //Constructor que inicializa la cafetera con una cantidad específica de café.

    public Cafetera(int cantidad) {
        this.cantidadCafe = cantidad;
    }


     //Devuelve la cantidad actual de café.
    public int getCantidadCafe() {
        return cantidadCafe;
    }

    // Verifica si existe suficiente café para la cantidad requerida.

    public boolean hasCafe(int cantidadRequerida) {
        return this.cantidadCafe >= cantidadRequerida;
    }


     //Resta la cantidad de café servida de la cafetera.

    public void giveCafe(int cantidadServida) {
        this.cantidadCafe -= cantidadServida;
    }

    /* Método setter, no requerido explícitamente por los tests, pero útil si se necesita.*/
    public void setCantidadCafe(int cantidadCafe) {
        this.cantidadCafe = cantidadCafe;
    }
}