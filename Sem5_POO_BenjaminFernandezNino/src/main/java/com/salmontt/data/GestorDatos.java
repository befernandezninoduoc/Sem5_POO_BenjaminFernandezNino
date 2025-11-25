package com.salmontt.data;

import com.salmontt.model.CentroCultivo;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Clase encargada de cargar los centros de cultivo desde un archivo de texto.
 * El archivo está con formato:
 * nombre;comuna;toneladas
 *
 * @author [Benjamín Fernández-Niño]
 * @version 1.1
 * @since 2025
 */
public class GestorDatos {

    /**
     * Lee el archivo y construye una lista de objetos CentroCultivo.
     *
     * @return ArrayList con todos los centros cargados
     */
    public ArrayList<CentroCultivo> cargarCentros() {
        ArrayList<CentroCultivo> centros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                getClass().getClassLoader().getResourceAsStream("centros_cultivo.txt")))) {

            String linea;
            int numeroLinea = 0;

            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                if (linea.trim().isEmpty()) continue;

                String[] partes = linea.split(";");
                if (partes.length != 3) {
                    System.err.println("Formato incorrecto en línea " + numeroLinea + ": " + linea);
                    continue;
                }

                String nombre = partes[0].trim();
                String comuna = partes[1].trim();
                double toneladas = Double.parseDouble(partes[2].trim().replace(",", "."));

                centros.add(new CentroCultivo(nombre, comuna, toneladas));
            }

            System.out.println("Se cargaron exitosamente " + centros.size() + " centros de cultivo.\n");

        } catch (Exception e) {
            System.err.println("Error crítico al cargar el archivo:");
            e.printStackTrace();
        }

        return centros;
    }
}