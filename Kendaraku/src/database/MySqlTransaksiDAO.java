package database;

import model.Mobil;
import model.Pelanggan;
import model.StatusMobil;
import model.Transaksi;

import java.sql.*;
import java.util.*;

public class MySqlTransaksiDAO implements TransaksiDAO {
    /* Atribut */
    private MySqlUtility db;
    /* Konstruktor */
    public MySqlTransaksiDAO(MySqlUtility db) {
        this.db = db;
    }
    
    /* Method */
    @Override
    public void save(Transaksi t) {
        try {
            Connection kon = db.getConnection();
            String query = "INSERT INTO transaksi (id_transaksi, id_pelanggan, id_mobil, tanggal_mulai, tanggal_selesai, total_biaya) " +
                           "VALUES ('" + t.getIdTransaksi() + "', '" +
                                        t.getPelanggan().getIdPelanggan() + "', '" +
                                        t.getMobil().getIdMobil() + "', '" +
                                        t.getTanggalMulai() + "', '" +
                                        t.getTanggalSelesai() + "', " +
                                        t.getTotalBiaya() + ")";
            Statement s = kon.createStatement();
            s.executeUpdate(query);
            System.out.println("Transaksi berhasil disimpan");
        } catch (SQLException e) {
            System.out.println("Gagal simpan transaksi: " + e.getMessage());
        }
    }

    @Override
    public Transaksi findById(String idTransaksi) {
        try {
            Connection kon = db.getConnection();
            String query = "SELECT t.*, p.nama, p.no_telp, p.email, " +
                           "m.merk, m.model, m.tahun_produksi, m.harga_per_hari, m.status " +
                           "FROM transaksi t " +
                           "JOIN pelanggan p ON t.id_pelanggan = p.id_pelanggan " +
                           "JOIN mobil m ON t.id_mobil = m.id_mobil " +
                           "WHERE t.id_transaksi = '" + idTransaksi + "'";

            Statement s = kon.createStatement();
            ResultSet rs = s.executeQuery(query);

            if (rs.next()) {
                return buatTransaksiDariRS(rs);
            }
        } catch (SQLException e) {
            System.out.println("Gagal cari transaksi: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Transaksi> findAll() {
        List<Transaksi> daftar = new ArrayList<>();
        try {
            Connection kon = db.getConnection();
            String query = "SELECT t.*, p.nama, p.no_telp, p.email, " +
                           "m.merk, m.model, m.tahun_produksi, m.harga_per_hari, m.status " +
                           "FROM transaksi t " +
                           "JOIN pelanggan p ON t.id_pelanggan = p.id_pelanggan " +
                           "JOIN mobil m ON t.id_mobil = m.id_mobil";

            Statement s = kon.createStatement();
            ResultSet rs = s.executeQuery(query);

            while (rs.next()) {
                daftar.add(buatTransaksiDariRS(rs));
            }
        } catch (SQLException e) {
            System.out.println("Gagal ambil semua transaksi: " + e.getMessage());
        }
        return daftar;
    }

    private Transaksi buatTransaksiDariRS(ResultSet rs) throws SQLException {
        Pelanggan p = new Pelanggan(
            rs.getString("id_pelanggan"),
            rs.getString("nama"),
            rs.getString("no_telp"),
            rs.getString("email")
        );

        Mobil m = new Mobil(
            rs.getString("id_mobil"),
            rs.getString("merk"),
            rs.getString("model"),
            rs.getInt("tahun_produksi"),
            rs.getDouble("harga_per_hari"),
            StatusMobil.valueOf(rs.getString("status"))
        );

        return new Transaksi(
            rs.getString("id_transaksi"),
            p, m,
            rs.getString("tanggal_mulai"),
            rs.getString("tanggal_selesai")
        );
    }
}