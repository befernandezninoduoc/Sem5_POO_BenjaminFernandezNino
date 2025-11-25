package com.salmontt.model;

import com.salmontt.model.CentroCultivo;
import com.salmontt.model.DatosInvalidosException;

/**
 * Representa a un trabajador de la empresa Salmontt.
 * Un trabajador está asignado obligatoriamente a un {@link CentroCultivo},
 * lo que implementa una relación de composición:
 * el trabajador no puede existir sin su centro de cultivo.
 *
 * @author [Benjamín Fernández-Niño]
 * @version 1.1
 */
public class Trabajador {

    private String rut;
    private String nombre;
    private String cargo;
    private CentroCultivo centroAsignado;  //

    /**
     * Constructor completo que obliga a asignar un centro de cultivo.
     *
     * @param rut            RUT del trabajador (con guión y dígito verificador)
     * @param nombre         nombre completo del trabajador
     * @param cargo          cargo dentro de la empresa
     * @param centroAsignado centro de cultivo al que pertenece (no puede ser nulo)
     * @throws DatosInvalidosException si algún dato es inválido
     */
    public Trabajador(String rut, String nombre, String cargo, CentroCultivo centroAsignado) {
        setRut(rut);
        setNombre(nombre);
        setCargo(cargo);
        setCentroAsignado(centroAsignado);  // obligatorio
    }

    public String getRut() { return rut; }

    /**
     * Valida y establece el RUT con formato chileno.
     * @param rut formato esperado: 12345678-9 o 1234567-K
     */
    public void setRut(String rut) {
        if (rut == null || rut.length() < 9 || !rut.contains("-"))
            throw new DatosInvalidosException("RUT inválido: debe tener guión y formato correcto");
        this.rut = rut.toUpperCase();
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty())
            throw new DatosInvalidosException("El nombre del trabajador no puede estar vacío");
        this.nombre = nombre.trim();
    }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) {
        if (cargo == null || cargo.trim().isEmpty())
            throw new DatosInvalidosException("El cargo no puede estar vacío");
        this.cargo = cargo.trim();
    }

    /**
     * Devuelve el centro de cultivo al que está asignado el trabajador.
     * @return centro de cultivo asignado (nunca null)
     */
    public CentroCultivo getCentroAsignado() {
        return centroAsignado;
    }

    /**
     * Asigna o cambia el centro de cultivo del trabajador.
     * @param centroAsignado no puede ser null (composición fuerte)
     * @throws DatosInvalidosException si se intenta asignar null
     */
    public void setCentroAsignado(CentroCultivo centroAsignado) {
        if (centroAsignado == null)
            throw new DatosInvalidosException("Un trabajador debe estar asignado a un centro de cultivo");
        this.centroAsignado = centroAsignado;
    }

    /**
     * Representación formateada del trabajador incluyendo su centro asignado.
     */
    @Override
    public String toString() {
        return String.format("%-12s | %-25s | %-20s | Centro: %-25s",
                rut, nombre, cargo, centroAsignado.getNombre());
    }
}