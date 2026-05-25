package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlUtility {

    private static final String URL  = "jdbc:mysql://localhost:3306/kendaraku";
    private static final String USER = "root";
    private static final String PASS = "r27l14e09_";

    private Connection connection;

    public MySqlUtility() {
        connection = null;
    }

    /* Membuka koneksi ke database MySQL */
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, USER, PASS);
                System.out.println("Koneksi database berhasil");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver MySQL tidak ditemukan: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Gagal terhubung ke database: " + e.getMessage());
        }
        return connection;
    }

    /* Menutup koneksi database */
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Koneksi database ditutup");
            }
        } catch (SQLException e) {
            System.out.println("Gagal menutup koneksi: " + e.getMessage());
        }
    }
}
