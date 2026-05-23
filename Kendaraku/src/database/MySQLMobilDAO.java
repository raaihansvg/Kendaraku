package database;

import model.Mobil;
import model.StatusMobil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLMobilDAO implements MobilDAO {
    /* Atribut */
    private MySqlUtility db;
    /* Konstruktor */
    public MySQLMobilDAO(MySqlUtility db) {
        this.db = db;
    }
    
    @Override
    public void save(Mobil m) {
        try {
            Connection kon = db.getConnection();
            String query = "INSERT INTO mobil (id_mobil, merk, model, tahun_produksi, harga_per_hari, status) " +
                           "VALUES ('" + m.getIdMobil() + "','" + m.getMerk() + "','" + m.getModel() + "'," +
                           m.getTahunProduksi() + "," + m.getHargaPerHari() + ",'" + m.getStatus() + "') " +
                           "ON DUPLICATE KEY UPDATE status = '" + m.getStatus() + "'";
            Statement s = kon.createStatement();
            s.executeUpdate(query);
            System.out.println("Mobil " + m.getIdMobil() + " disimpan ke database");
        } catch (SQLException e) {
            System.out.println("Gagal simpan mobil: " + e.getMessage());
        }
    }

    @Override
    public Mobil findById(String idMobil) {
        try {
            Connection kon = db.getConnection();
            String query = "SELECT * FROM mobil WHERE id_mobil = '" + idMobil + "'";
            Statement s = kon.createStatement();
            ResultSet rs = s.executeQuery(query);
            if (rs.next()) return buatMobilDariRS(rs);
        } catch (SQLException e) {
            System.out.println("Gagal cari mobil: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Mobil> findAll() {
        List<Mobil> daftar = new ArrayList<>();
        try {
            Connection kon = db.getConnection();
            String query = "SELECT * FROM mobil";
            Statement s = kon.createStatement();
            ResultSet rs = s.executeQuery(query);
            while (rs.next()) daftar.add(buatMobilDariRS(rs));
        } catch (SQLException e) {
            System.out.println("Gagal ambil semua mobil: " + e.getMessage());
        }
        return daftar;
    }

    private Mobil buatMobilDariRS(ResultSet rs) throws SQLException {
        return new Mobil(
            rs.getString("id_mobil"),
            rs.getString("merk"),
            rs.getString("model"),
            rs.getInt("tahun_produksi"),
            rs.getDouble("harga_per_hari"),
            StatusMobil.valueOf(rs.getString("status"))
        );
    }
}