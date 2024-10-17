package org.example;

import java.util.List;

/**
 * Interfaz que define las operaciones para la gestión de la entidad Pelicula.
 */
public interface PeliculaDAO {

    /**
     * Filtra las películas cuyo año de lanzamiento se encuentra dentro de un intervalo.
     *
     * @param añoInicio el año inicial del intervalo.
     * @param añoFin    el año final del intervalo.
     * @return una lista de películas que cumplen con el criterio.
     */
    List<Pelicula> filtrarPorAño(int añoInicio, int añoFin);

    /**
     * Cuenta el número total de películas en la base de datos.
     *
     * @return el total de películas.
     */
    int contarPeliculas();

    /**
     * Añade una nueva película a la base de datos.
     *
     * @param pelicula la película que se añadirá.
     * @return true si la operación fue exitosa, false en caso contrario.
     */
    boolean añadirPelicula(Pelicula pelicula);

    /**
     * Obtiene una película a partir de su identificador.
     * Este método no está implementado y devuelve null.
     *
     * @param id el identificador de la película.
     * @return null.
     */
    default Pelicula obtenerPeliculaPorId(int id) {
        return null;
    }

    /**
     * Lista todas las películas en la base de datos.
     * Este método no está implementado y devuelve null.
     *
     * @return null.
     */
    default List<Pelicula> listarPeliculas() {
        return null;
    }
}
