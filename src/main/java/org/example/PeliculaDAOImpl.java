package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la interfaz PeliculaDAO usando JDBC para interactuar con
 * una base de datos MySQL.
 */
public class PeliculaDAOImpl implements PeliculaDAO {
    private Connection conexion;

    /**
     * Constructor que recibe la conexión a la base de datos.
     *
     * @param conexion la conexión JDBC.
     */
    public PeliculaDAOImpl(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Pelicula> filtrarPorAño(int añoInicio, int añoFin) {
        List<Pelicula> peliculas = new ArrayList<>();
        String sql = "SELECT * FROM pelicula WHERE año BETWEEN ? AND ?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, añoInicio);
            ps.setInt(2, añoFin);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pelicula pelicula = new Pelicula(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getString("genero"),
                        rs.getInt("año")
                );
                peliculas.add(pelicula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peliculas;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int contarPeliculas() {
        String sql = "SELECT COUNT(*) FROM pelicula";
        try (Statement stmt = conexion.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean añadirPelicula(Pelicula pelicula) {
        String sql = "INSERT INTO pelicula (titulo, genero, año) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getGenero());
            ps.setInt(3, pelicula.getAño());
            int filasInsertadas = ps.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
