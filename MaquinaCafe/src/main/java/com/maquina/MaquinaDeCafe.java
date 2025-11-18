package com.maquina;

public class MaquinaDeCafe {

    private Cafetera cafetera;
    private Vaso vasosPequeno;
    private Vaso vasosMediano;
    private Vaso vasosGrande;
    private Azucarero azucarero;

    // --- Getters y Setters (Se mantienen sin cambios) ---

    public Cafetera getCafetera() {
        return cafetera;
    }

    public void setCafetera(Cafetera cafetera) {
        this.cafetera = cafetera;
    }

    public Vaso getVasosPequeno() {
        return vasosPequeno;
    }

    public void setVasosPequeno(Vaso vasosPequeno) {
        this.vasosPequeno = vasosPequeno;
    }

    public Vaso getVasosMediano() {
        return vasosMediano;
    }

    public void setVasosMediano(Vaso vasosMediano) {
        this.vasosMediano = vasosMediano;
    }

    public Vaso getVasosGrande() {
        return vasosGrande;
    }

    public void setVasosGrande(Vaso vasosGrande) {
        this.vasosGrande = vasosGrande;
    }

    public Azucarero getAzucarero() {
        return azucarero;
    }

    public void setAzucarero(Azucarero azucarero) {
        this.azucarero = azucarero;
    }

    // --- Lógica Principal de la Máquina ---

    // Devuelve el objeto Vaso correspondiente al tipo solicitado.
    public Vaso getTipoDeVaso(String tipo) {

        // CORRECCIÓN: Maneja si el tipo de vaso es nulo
        if (tipo == null) {
            return null;
        }

        switch (tipo.toLowerCase()) {
            case "pequeno":
                return vasosPequeno;
            case "mediano":
                return vasosMediano;
            case "grande":
                return vasosGrande;
            default:
                return null;
        }
    }

    // Intenta servir un vaso de café y devuelve un mensaje de estado.
    public String getVasoDeCafe(Vaso vaso, int cantidadVasosRequeridos, int cantidadAzucarRequerida) {

        // 1. Validar Vasos
        if (!vaso.haySuficientesVasos(cantidadVasosRequeridos)) {
            return "No hay Vasos";
        }

        // La cantidad de café requerida es la capacidad del vaso
        int cantidadCafeRequerida = vaso.getContenido();

        // 2. Validar el Café
        if (!cafetera.hasCafe(cantidadCafeRequerida)) {
            return "No hay Cafe";
        }

        // 3. Validar el Azúcar
        if (cantidadAzucarRequerida > 0 && !azucarero.hasAzucar(cantidadAzucarRequerida)) {
            return "No hay Azucar";
        }

        // --- Dispensar (Consumir Recursos) ---

        // 4. Consumir Vasos
        vaso.consumirVasos(cantidadVasosRequeridos);

        // 5. Dispensar Café
        cafetera.giveCafe(cantidadCafeRequerida);

        // 6. Dispensar Azúcar
        if (cantidadAzucarRequerida > 0) {
            azucarero.giveAzucar(cantidadAzucarRequerida);
        }

        // 7. Éxito
        return "Felicitaciones";
    }
}