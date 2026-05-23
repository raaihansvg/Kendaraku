package database;

import model.Pelanggan;

import java.sql.*;
import java.util.*;

public class MySQLPelangganDAO implements PelangganDAO {

    private MySqlUtility db;

    public MySQLPelangganDAO(MySqlUtility db) {
        this.db = db;
    }

    @Override
    public void save(Pelanggan p) {
        try {
            Connection kon = db.getConnection();
            String query = "INSERT INTO pelanggan (id_pelanggan, nama, no_telp, email) " +
                           "VALUES ('" + p.getIdPelanggan() + "','" + p.getNama() + "','" +
                           p.getNoTelp() + "','" + p.getEmail() + "') " +
                           "ON DUPLICATE KEY UPDATE nama = '" + p.getNama() + "'";
            Statement s = kon.createStatement();
            s.executeUpdate(query);
            System.out.println("Pelanggan " + p.getIdPelanggan() + " disimpan ke database");
        } catch (SQLException e) {
            System.out.println("Gagal simpan pelanggan: " + e.getMessage());
        }
    }

    @Override
    public Pelanggan findById(String idPelanggan) {
        try {
            Connection kon = db.getConnection();
            String query = "SELECT * FROM pelanggan WHERE id_pelanggan = '" + idPelanggan + "'";
            Statement s = kon.createStatement();
            ResultSet rs = s.executeQuery(query);
            if (rs.next()) return buatPelangganDariRS(rs);
        } catch (SQLException e) {
            System.out.println("Gagal cari pelanggan: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Pelanggan> findAll() {
        List<Pelanggan> daftar = new ArrayList<>();
        try {
            Connection kon = db.getConnection();
            String query = "SELECT * FROM pelanggan";
            Statement s = kon.createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) daftar.add(buatPelangganDariRS(rs));
        } catch (SQLException e) {
            System.out.println("Gagal ambil semua pelanggan: " + e.getMessage());
        }
        return daftar;
    }

    private Pelanggan buatPelangganDariRS(ResultSet rs) throws SQLException {
        return new Pelanggan(
            rs.getString("id_pelanggan"),
            rs.getString("nama"),
            rs.getString("no_telp"),
            rs.getString("email")
        );
    }
}