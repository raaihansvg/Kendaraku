package service;
import java.util.ArrayList;
import model.Mobil;
import model.Pelanggan;
import model.Transaksi;
import enumtype.StatusMobil;

public class RentalService{
    private ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();

    // Penyewaan mobil
    public void sewaMobil(Pelanggan pelanggan, Mobil mobil, int lamaSewa) {
        if(mobil.getStatus() == StatusMobil.DISEWA){
            System.out.println("Mobil sedang tidak available");
            return;
        }

        double totalBiaya = mobil.hitungHarga() * lamaSewa;

        Transaksi transaksi = new Transaksi("TRX" + (daftarTransaksi.size() + 1), pelanggan, mobil, lamaSewa, totalBiaya);

        daftarTransaksi.add(transaksi);
        mobil.setStatus(StatusMobil.DISEWA);

        System.out.println("Mobil berhasil disewa");
        System.out.println(transaksi);
    }

    // Menampilkan transaksi rental 
    public void tampilTransaksi(){
        if(daftarTransaksi.isEmpty()){
            System.out.println("Belum ada transaksi");
            return;
        }
        for(Transaksi transaksi : daftarTransaksi){
            System.out.println(transaksi);
        }
    }

    public void selesaiRental(Mobil mobil){
        mobil.setStatus(StatusMobil.TERSEDIA);
        System.out.println("Mobil sudah dikembalikan");
    }

    // Hitung Total pendapatan
    public double hitungPendapatan(){
        double total = 0 ;
        for(Transaksi transaksi : daftarTransaksi){
            total += transaksi.getTotalBiaya();
        } return total;
    }

}