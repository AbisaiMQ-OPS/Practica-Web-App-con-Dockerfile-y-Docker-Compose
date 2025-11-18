package com.maquina;

public class Vaso {

    private int cantidadVasos;
    private int contenido; // Representa la cantidad de café que cabe en el vaso

    // Constructor que inicializa el tipo de vaso.
    public Vaso(int cantidadVasos, int contenido) {
        this.cantidadVasos = cantidadVasos;
        this.contenido = contenido;
    }

    // --- Getters ---

    // Devuelve la cantidad actual de vasos disponibles.
    public int getCantidadVasos() {
        return cantidadVasos;
    }

    // Devuelve la capacidad de café del vaso.
    public int getContenido() {
        return contenido;
    }

    // --- Nueva Lógica de Inventario ---

    // 1. Verifica si existe suficiente cantidad de vasos. (SIN consumir)
    public boolean haySuficientesVasos(int cantidadRequerida) {
        return this.cantidadVasos >= cantidadRequerida;
    }

    // 2. Consume la cantidad de vasos (asumiendo que la verificación ya se hizo).
    public void consumirVasos(int cantidad) {
        // Asumimos que la cantidad es positiva. Debería haber una verificación externa
        // para evitar que la cantidad sea negativa, pero por simplicidad:
        if (cantidad > 0) {
            this.cantidadVasos -= cantidad;
        }
    }

    // NOTA: Si necesitas reponer vasos para el rollback, deberías agregar un método:
    /*
    public void reponerVasos(int cantidad) {
        if (cantidad > 0) {
            this.cantidadVasos += cantidad;
        }
    }
    */
}