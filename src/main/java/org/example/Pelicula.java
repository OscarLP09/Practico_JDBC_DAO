package org.example;

/**
 * La clase Pelicula representa una película con sus atributos principales:
 * id, título, género y año de lanzamiento.
 */
public class Pelicula {
    private int id;
    private String titulo;
    private String genero;
    private int año;

    /**
     * Constructor de la clase Pelicula.
     *
     * @param id     el identificador único de la película.
     * @param titulo el título de la película.
     * @param genero el género de la película.
     * @param año    el año de lanzamiento de la película.
     */
    public Pelicula(int id, String titulo, String genero, int año) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.año = año;
    }

    /**
     * Obtiene el identificador único de la película.
     *
     * @return el identificador de la película.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único de la película.
     *
     * @param id el nuevo identificador de la película.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el título de la película.
     *
     * @return el título de la película.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título de la película.
     *
     * @param titulo el nuevo título de la película.
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Obtiene el género de la película.
     *
     * @return el género de la película.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Establece el género de la película.
     *
     * @param genero el nuevo género de la película.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene el año de lanzamiento de la película.
     *
     * @return el año de la película.
     */
    public int getAño() {
        return año;
    }

    /**
     * Establece el año de lanzamiento de la película.
     *
     * @param año el nuevo año de la película.
     */
    public void setAño(int año) {
        this.año = año;
    }

    /**
     * Devuelve una representación en forma de cadena de la película.
     *
     * @return una cadena que contiene los detalles de la película.
     */
    @Override
    public String toString() {
        return "Pelicula [id=" + id + ", titulo=" + titulo + ", genero=" + genero + ", año=" + año + "]";
    }
}
