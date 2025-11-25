package com.salmontt.model;

/**
 * Representa un centro de cultivo de salmón de la empresa Salmontt.
 * uso de atributos privados, constructores, getters/setters, toString() y validación.
 *
 * @author [Benjamín Fernández-Niño]
 * @version 1.1
 * @since 2025
 */
public class CentroCultivo {

    private String nombre;
    private String comuna;
    private double toneladas;

    /**
     * Constructor completo con validación inmediata.
     *
     * @param nombre    nombre del centro
     * @param comuna    comuna de ubicación
     * @param toneladas producción en toneladas
     * @throws DatosInvalidosException validador de datos
     */
    public CentroCultivo(String nombre, String comuna, double toneladas) {
        setNombre(nombre);
        setComuna(comuna);
        setToneladas(toneladas);
    }

    public String getNombre() { return nombre; }

    /**
     * Establece el nombre del centro.
     * @param nombre no puede ser nulo ni vacío
     * @throws DatosInvalidosException si es inválido
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre del centro no puede estar vacío o ser nulo");
        }
        this.nombre = nombre.trim();
    }

    public String getComuna() { return comuna; }

    /**
     * Establece la comuna del centro.
     * @param comuna no puede ser nula ni vacía
     * @throws DatosInvalidosException si los datos son inválidos
     */
    public void setComuna(String comuna) {
        if (comuna == null || comuna.trim().isEmpty()) {
            throw new DatosInvalidosException("La comuna no puede estar vacía o ser nula");
        }
        this.comuna = comuna.trim();
    }

    public double getToneladas() { return toneladas; }

    /**
     * Establece las toneladas producidas.
     * @param toneladas debe ser mayor o igual a cero
     * @throws DatosInvalidosException si es negativo
     */
    public void setToneladas(double toneladas) {
        if (toneladas < 0) {
            throw new DatosInvalidosException(
                    "Las toneladas no pueden ser negativas: " + toneladas);
        }
        this.toneladas = toneladas;
    }

    @Override
    public String toString() {
        return String.format("%-30s | %-15s | %8.2f ton", nombre, comuna, toneladas);
    }
}