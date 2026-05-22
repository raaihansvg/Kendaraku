package model;

/**
 * Kelas Transaksi (POJO)
 * Merepresentasikan satu transaksi sewa mobil antara pelanggan dan mobil tertentu.
 */
public class Transaksi {

    // ── Atribut ──────────────────────────────────────────────
    private String     idTransaksi;
    private Pelanggan  pelanggan;
    private Mobil      mobil;
    private String     tanggalMulai;
    private String     tanggalSelesai;
    private double     totalBiaya;

    // ── Konstruktor ──────────────────────────────────────────
    public Transaksi(String idTransaksi, Pelanggan pelanggan, Mobil mobil,
                     String tanggalMulai, String tanggalSelesai) {
        this.idTransaksi    = idTransaksi;
        this.pelanggan      = pelanggan;
        this.mobil          = mobil;
        this.tanggalMulai   = tanggalMulai;
        this.tanggalSelesai = tanggalSelesai;
        this.totalBiaya     = hitungBiaya();
    }

    // ── Getter & Setter ──────────────────────────────────────
    public String    getIdTransaksi()                    { return idTransaksi; }
    public void      setIdTransaksi(String id)           { this.idTransaksi = id; }

    public Pelanggan getPelanggan()                      { return pelanggan; }
    public void      setPelanggan(Pelanggan p)           { this.pelanggan = p; }

    public Mobil     getMobil()                          { return mobil; }
    public void      setMobil(Mobil m)                   { this.mobil = m; }

    public String    getTanggalMulai()                   { return tanggalMulai; }
    public void      setTanggalMulai(String tgl)         { this.tanggalMulai = tgl; }

    public String    getTanggalSelesai()                 { return tanggalSelesai; }
    public void      setTanggalSelesai(String tgl)       { this.tanggalSelesai = tgl; }

    public double    getTotalBiaya()                     { return totalBiaya; }
    public void      setTotalBiaya(double biaya)         { this.totalBiaya = biaya; }

    // ── Metode Bisnis ────────────────────────────────────────
    /**
     * Menghitung total biaya sewa berdasarkan jumlah hari dan harga per hari mobil.
     * Format tanggal yang didukung: "YYYY-MM-DD".
     * Jika parsing gagal, totalBiaya = 0.
     */
    public double hitungBiaya() {
        try {
            java.time.LocalDate mulai   = java.time.LocalDate.parse(tanggalMulai);
            java.time.LocalDate selesai = java.time.LocalDate.parse(tanggalSelesai);
            long jumlahHari = java.time.temporal.ChronoUnit.DAYS.between(mulai, selesai);
            if (jumlahHari <= 0) return 0;
            return jumlahHari * mobil.getHargaPerHari();
        } catch (Exception e) {
            return 0;
        }
    }

    // ── toString ─────────────────────────────────────────────
    @Override
    public String toString() {
        return "Transaksi{" +
               "id='"            + idTransaksi                        + '\'' +
               ", pelanggan='"   + (pelanggan != null ? pelanggan.getNama() : "null") + '\'' +
               ", mobil='"       + (mobil     != null ? mobil.getMerk() + " " + mobil.getModel() : "null") + '\'' +
               ", mulai='"       + tanggalMulai                       + '\'' +
               ", selesai='"     + tanggalSelesai                     + '\'' +
               ", totalBiaya="   + totalBiaya                         +
               '}';
    }
}