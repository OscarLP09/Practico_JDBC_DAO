package org.example;

import java.util.List;

public interface PeliculaDAO {
    List<Pelicula> filtrarPorAño(int añoInicio, int añoFin); // Historia 1
    int contarPeliculas(); // Historia 2
    boolean añadirPelicula(Pelicula pelicula); // Historia 3

    // Otros métodos del DAO, pero sin implementación
    default Pelicula obtenerPeliculaPorId(int id) {
        return null;
    }

    default List<Pelicula> listarPeliculas() {
        return null;
    }
}