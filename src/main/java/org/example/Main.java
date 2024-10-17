package org.example;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection conexion = ConexionDB.getConexion();
        if (conexion != null) {
            PeliculaDAO peliculaDAO = new PeliculaDAOImpl(conexion);

            // Añadir una nueva película (Historia de usuario 3)
            Pelicula nuevaPelicula = new Pelicula(0, "Matrix", 1999, "ciencia ficción");
            boolean resultadoAñadir = peliculaDAO.añadirPelicula(nuevaPelicula);
            System.out.println("Película añadida: " + resultadoAñadir);

            // Contar total de películas (Historia de usuario 2)
            int totalPeliculas = peliculaDAO.contarPeliculas();
            System.out.println("Total de películas: " + totalPeliculas);

            // Filtrar películas por intervalo de años (Historia de usuario 1)
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
