package org.example;

import java.sql.Connection;
import java.util.List;

/**
 * Clase principal para probar las funcionalidades de la aplicación.
 */
public class Main {
    public static void main(String[] args) {
        // Obtener conexión a la base de datos
        Connection conexion = ConexionDB.getConexion();

        if (conexion != null) {
            PeliculaDAO peliculaDAO = new PeliculaDAOImpl(conexion);

            // Añadir una nueva película
            Pelicula nuevaPelicula = new Pelicula(0, "Matrix", "ciencia ficción", 1999);
            boolean resultadoAñadir = peliculaDAO.añadirPelicula(nuevaPelicula);
            System.out.println("Película añadida: " + resultadoAñadir);

            // Contar total de películas
            int totalPeliculas = peliculaDAO.contarPeliculas();
            System.out.println("Total de películas: " + totalPeliculas);

            // Filtrar películas por intervalo de años
            List<Pelicula> peliculasFiltradas = peliculaDAO.filtrarPorAño(1990, 2000);
            System.out.println("Películas entre 1990 y 2000:");
            peliculasFiltradas.forEach(System.out::println);

            // Cerrar la conexión
            ConexionDB.cerrarConexion(conexion);
        } else {
            System.out.println("Error al conectar con la base de datos.");
        }
    }
}
