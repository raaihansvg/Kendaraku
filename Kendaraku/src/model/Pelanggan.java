/*  Kelas Pelanggan (POJO)
    Merepresentasikan data pelanggan serta riwayat
    transaksi sewanya. */

package model;
import java.util.*;

public class Pelanggan{
    /* Atribut */
    private String idPelanggan;
    private String nama;
    private String noTelp;
    private String email;
    private List<Transaksi> riwayatTransaksi;

    /* Konstruktor */
    public Pelanggan(String idPelanggan,String nama,String noTelp,String email){
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.noTelp = noTelp;
        this.email = email;
        this.riwayatTransaksi = new ArrayList<>();
    }

    /* Getter */
    public String getIdPelanggan(){
        return idPelanggan;
    }

    public String getNama(){
        return nama;
    }

    public String getNoTelp(){
        return noTelp;
    }

    public String email(){
        return email;
    }

    public List<Transaksi> getRiwayatTransaksi(){
        return riwayatTransaksi;
    }

    /* Setter */
    public void setIdPelanggan(String idPelanggan){
        this.idPelanggan = idPelanggan;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setNoTelp(String noTelp){
        this.noTelp = noTelp;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setRiwayatTransaksi(List<Transaksi> riwayatTransaksi){
        this.riwayatTransaksi = riwayatTransaksi;
    }

    /* method tambahan */
    /* Menambahkan transaksi ke riwayat pelanggan */
    public void tambahRiwayat(Transaksi Transaksi){
        riwayatTransaksi.add(Transaksi);
    }

    /* Output */
    @Override
    public String toString(){
        return """
                == Data Pelanggan ==
                Id Pelanngan    : %s
                Nama Pelanggan  : %s
                No Telp         : %s
                Email           : %s
                Transaksi       : %s
                """.formatted(
                    idPelanggan,
                    nama,
                    noTelp,
                    email,
                    riwayatTransaksi
                );
    }
}