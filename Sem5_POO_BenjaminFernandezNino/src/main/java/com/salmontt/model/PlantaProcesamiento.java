package com.salmontt.model;

/**
 * Representa una planta de procesamiento de salmón de la empresa Salmontt.
 * Uso de atributos privados, constructores, getters/setters, toString() y validación.
 * @author [Benjamín Fernández-Niño]
 * @version 1.1
 */
public class PlantaProcesamiento {

    private String nombre;
    private String region;
    private int capacidadDiaria; // toneladas por día

    /**
     * Constructor con validación.
     */
    public PlantaProcesamiento(String nombre, String region, int capacidadDiaria) {
        setNombre(nombre);
        setRegion(region);
        setCapacidadDiaria(capacidadDiaria);
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new DatosInvalidosException ("El nombre de la planta no puede estar vacío");
        this.nombre = nombre.trim();
    }

    public String getRegion() { return region; }
    public void setRegion(String region) {
        if (region == null || region.trim().isEmpty())
            throw new DatosInvalidosException("La región no puede estar vacía");
        this.region = region.trim();
    }

    public int getCapacidadDiaria() { return capacidadDiaria; }
    public void setCapacidadDiaria(int capacidadDiaria) {
        if (capacidadDiaria <= 0)
            throw new DatosInvalidosException("La capacidad diaria debe ser mayor a 0");
        this.capacidadDiaria = capacidadDiaria;
    }

    @Override
    public String toString() {
        return String.format("%-25s | %-12s | %4d ton/día", nombre, region, capacidadDiaria);
    }
}