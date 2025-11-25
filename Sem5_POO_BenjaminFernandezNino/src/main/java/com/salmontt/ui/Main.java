package com.salmontt.ui;

import com.salmontt.data.GestorDatos;
import com.salmontt.model.*;

import java.util.ArrayList;

/**
 * Clase principal del sistema SalmonttApp
 * Evaluación Sumativa Semana 5 - POO
 * <p>
 * @author [Benjamín Fernández-Niño]
 * @version 1.1
 */
public class Main {

    /**
     * Método principal que ejecuta el flujo completo de la actividad:
     * 1. Carga los datos desde archivo
     * 2. Muestra todos los centros
     * 3. Filtra los de mayor producción (> 1000 toneladas)
     * 4. Identifica e imprime el centro con mayor producción
     * 5. Demuestra uso de composición y excepción personalizada
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        System.out.println("==".repeat(25));
        System.out.println("       SISTEMA SALMONTT ");
        System.out.println("==".repeat(25));
        System.out.println();

        // 1. CARGAR DATOS DESDE ARCHIVO
        GestorDatos gestor = new GestorDatos();
        ArrayList<CentroCultivo> centros = gestor.cargarCentros();

        // 2. MOSTRAR TODOS LOS CENTROS
        System.out.println("=== TODOS LOS CENTROS DE CULTIVO ===");
        for (CentroCultivo c : centros) {
            System.out.println(c);
        }
        System.out.println();

        // 3. FILTRAR CENTROS > 1000 TONELADAS
        System.out.println("=== CENTROS CON PRODUCCIÓN > 1000 TONELADAS ===");
        boolean hayMayores = false;
        for (CentroCultivo c : centros) {
            if (c.getToneladas() > 1000) {
                System.out.println(c);
                hayMayores = true;
            }
        }
        if (!hayMayores) {
            System.out.println("No existen centros con producción superior a 1000 toneladas.");
        }
        System.out.println();

        // 4. BUSCAR EL CENTRO CON MAYOR PRODUCCIÓN
        if (!centros.isEmpty()) {
            CentroCultivo mayor = centros.get(0);
            for (CentroCultivo c : centros) {
                if (c.getToneladas() > mayor.getToneladas()) {
                    mayor = c;
                }
            }
            System.out.println("CENTRO CON MAYOR PRODUCCIÓN:");
            System.out.println(mayor);
            System.out.printf("(Total: %.2f toneladas en %s)%n", mayor.getToneladas(), mayor.getComuna());
        }
        System.out.println();

        // =================================================================
        // 5. DEMOSTRACIÓN DE LAS 3 CLASES + COMPOSICIÓN + EXCEPCIÓN
        // =================================================================
        System.out.println("=== DEMOSTRACIÓN DE COMPOSICIÓN Y VALIDACIÓN ===");

        // Tomamos el primer centro como ejemplo para asignar trabajadores
        CentroCultivo centroParaTrabajadores = centros.get(0);

        // Crear trabajadores asignados al centro (COMPOSICIÓN)
        try {
            Trabajador t1 = new Trabajador("11.222.333-4", "María González", "Jefa de Centro", centroParaTrabajadores);
            Trabajador t2 = new Trabajador("22.333.444-5", "Pedro Gonzá lez", "Operario", centroParaTrabajadores);

            System.out.println("Trabajadores creados correctamente (con composición):");
            System.out.println(t1);
            System.out.println(t2);
        } catch (DatosInvalidosException e) {
            System.out.println("Error al crear trabajador: " + e.getMessage());
        }

        // Crear planta de procesamiento
        try {
            PlantaProcesamiento planta = new PlantaProcesamiento("Planta Central", "Los Lagos", 1500);
            System.out.println("\nPlanta creada correctamente:");
            System.out.println(planta);
        } catch (DatosInvalidosException e) {
            System.out.println("Error al crear planta: " + e.getMessage());
        }

        // Pruebas de validación fallidas (para mostrar la excepción)
        System.out.println("\n--- Pruebas de validación (para mostrar la excepción) ---");
        try { new Trabajador("", "Juan", "Operario", centroParaTrabajadores); }
        catch (DatosInvalidosException e) { System.out.println("Capturado: " + e.getMessage()); }

        try { new Trabajador("12345678-9", "Luis", "Técnico", null); } // falla por composición
        catch (DatosInvalidosException e) { System.out.println("Capturado: " + e.getMessage()); }

        try { new CentroCultivo("Test", "Castro", -100); }
        catch (DatosInvalidosException e) { System.out.println("Capturado: " + e.getMessage()); }

        System.out.println("\n=== FIN DEL PROGRAMA ===");
    }
}