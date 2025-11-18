package com.maquina;

public class Azucarero {

    private int cantidadAzucar;

     // Constructor que inicializa el azucarero con una cantidad específica de azúcar.

    public Azucarero(int cantidad) {
        this.cantidadAzucar = cantidad;
    }


     // Devuelve la cantidad actual de azúcar.

    public int getCantidadAzucar() {
        return cantidadAzucar;
    }


     // Verifica si existe suficiente azúcar para la cantidad requerida.

    public boolean hasAzucar(int cantidadRequerida) {
        return this.cantidadAzucar >= cantidadRequerida;
    }


     // Resta la cantidad de azúcar servida del azucarero.

    public void giveAzucar(int cantidadServida) {
        // Solo restamos si la verificación de cantidad ya fue exitosa (asumiendo
        // que la lógica de la máquina de café manejará la verificación primero).
        this.cantidadAzucar -= cantidadServida;
    }
}