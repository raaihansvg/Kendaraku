package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Kelas Pelanggan (POJO)
 * Merepresentasikan data pelanggan beserta riwayat transaksi sewanya.
 */
public class Pelanggan {

    // ── Atribut ──────────────────────────────────────────────
    private String          idPelanggan;
    private String          nama;
    private String          noTelp;
    private String          email;
    private List<Transaksi> riwayatTransaksi;

    // ── Konstruktor ──────────────────────────────────────────
    public Pelanggan(String idPelanggan, String nama, String noTelp, String email) {
        this.idPelanggan      = idPelanggan;
        this.nama             = nama;
        this.noTelp           = noTelp;
        this.email            = email;
        this.riwayatTransaksi = new ArrayList<>();
    }

    // ── Getter & Setter ──────────────────────────────────────
    public String getIdPelanggan()                  { return idPelanggan; }
    public void   setIdPelanggan(String id)         { this.idPelanggan = id; }

    public String getNama()                         { return nama; }
    public void   setNama(String nama)              { this.nama = nama; }

    public String getNoTelp()                       { return noTelp; }
    public void   setNoTelp(String noTelp)          { this.noTelp = noTelp; }

    public String getEmail()                        { return email; }
    public void   setEmail(String email)            { this.email = email; }

    public List<Transaksi> getRiwayatTransaksi()    { return riwayatTransaksi; }
    public void            setRiwayatTransaksi(List<Transaksi> riwayat) {
        this.riwayatTransaksi = riwayat;
    }

    // ── Metode Bisnis ────────────────────────────────────────
    /**
     * Menambahkan satu transaksi ke riwayat pelanggan.
     */
    public void tambahRiwayat(Transaksi t) {
        riwayatTransaksi.add(t);
    }

    // ── toString ─────────────────────────────────────────────
    @Override
    public String toString() {
        return "Pelanggan{" +
               "id='"     + idPelanggan + '\'' +
               ", nama='" + nama        + '\'' +
               ", telp='" + noTelp      + '\'' +
               ", email='"+ email       + '\'' +
               ", jumlahTransaksi=" + riwayatTransaksi.size() +
               '}';
    }
}