package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para gestionar la conexión con la base de datos usando JDBC.
 */
public class ConexionDB {
    private static final String URL = "jdbc:mysql://localhost:3306/pelicula";
    private static final String USUARIO = "root"; // Cambia al usuario correcto
    private static final String PASSWORD = System.getenv("DB_PASSWORD");   // Cambia a la contraseña correcta

    /**
     * Establece una conexión a la base de datos.
     *
     * @return la conexión a la base de datos o null si ocurre un error.
     */
    public static Connection getConexion() {
        try {
            return DriverManager.getConnection(URL, USUARIO, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Cierra la conexión con la base de datos.
     *
     * @param conexion la conexión a cerrar.
     */
    public static void cerrarConexion(Connection conexion) {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
