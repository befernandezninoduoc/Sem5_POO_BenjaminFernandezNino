package com.salmontt.model;

/**
 * Excepción personalizada lanzada cuando los datos ingresados
 * no cumplen con las reglas de validación del sistema Salmontt.
 *
 * Se utiliza en todas las entidades: CentroCultivo, PlantaProcesamiento, Trabajador, etc.
 *
 * @author [Benjamín Fernández-Niño]
 * @version 1.1
 * @since 2025
 */
public class DatosInvalidosException extends IllegalArgumentException {

    public DatosInvalidosException(String mensaje) {
        super(mensaje);
    }

    public DatosInvalidosException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}