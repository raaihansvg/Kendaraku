/*  Kelas Transaksi (POJO)
    Merepresentasikan transaksi sewa mobil pelanggan */

package model;

public class Transaksi{
    /* Atribut */
    private String idTransaksi;
    private Pelanggan pelanggan;
    private Mobil mobil;
    private String tanggalMulai;
    private String tanggalSelesai;
    private double totalBiaya;

    /* Konstruktor */
    public Transaksi(String idTransaksi,Pelanggan pelanggan,Mobil mobil,String tanggalMulai,String tanggalSelesai,double totalBiaya){
        this.idTransaksi  = idTransaksi;
        this.pelanggan = pelanggan;
        this.mobil = mobil;
        this.tanggalMulai = tanggalMulai;
        this.tanggalSelesai = tanggalSelesai;
        this.totalBiaya = totalBiaya;
    }

    /* Getter */
    public String getIdTransaksi(){
        return idTransaksi;
    }

    public Pelanggan getPelanggan(){
        return pelanggan;
    }

    public Mobil getMobil(){
        return mobil;
    }

    public String getTanggalMulai(){
        return tanggalMulai;
    }

    public String getTanggalSelesai(){
        return tanggalSelesai;
    }

    public double getTotalBiaya(){
        return totalBiaya;
    }

    /* Setter */
    public void setIdTransaksi(String idTransaksi){
        this.idTransaksi = idTransaksi;
    }

    public void setPelanggan(Pelanggan pelanggan){
        this.pelanggan = pelanggan;
    }

    public void setMobil(Mobil mobil){
        this.mobil = mobil;
    }

    public void setTanggalMulai(String tanggalMulai){
        this.tanggalMulai = tanggalMulai;
    }

    public void setTanggalSelesai(String tanggalSelesai){
        this.tanggalSelesai = tanggalSelesai;
    }

    public void setTotalBiaya(double totalBiaya){
        this.totalBiaya = totalBiaya;
    }

    /* Method Tambahan */
    /* Menghitung total biaya sewa mobil berdasarkan jumlah hari pemakaian */
    /* Format tanggal yang bisa adalah: "YYYY-MM-DD"*/
    /* Jika parsing gagal akan mengembalikan totalBiaya = 0 */
    public double hitungBiaya(){
        try{
            java.time.LocalDate mulai = java.time.LocalDate.parse(tanggalMulai);
            java.time.LocalDate selesai = java.time.LocalDate.parse(tanggalSelesai);
            long jumlahHari = java.time.temporal.ChronoUnit.DAYS.between(mulai, selesai);

            if(jumlahHari <= 0){
                return 0;
            }else{
                return jumlahHari * mobil.getHargaPerHari();
            }
        }catch (Exception e){
            return 0;
        }
    }

    /* Output */
    @Override
    public String toString() {
    return """
            == Data Transaksi ==
            Id Transaksi    : %s
            Pelanggan       : %s
            Mobil           : %s
            Tanggal Mulai   : %s
            Tanggal Selesai : %s
            Total Biaya     : Rp %.0f
            """.formatted(
                idTransaksi,
                pelanggan.getNama(),
                mobil.getMerk() + " " + mobil.getModel(),
                tanggalMulai,
                tanggalSelesai,
                hitungBiaya()
            );
    }
}