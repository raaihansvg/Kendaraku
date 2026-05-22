package service;
import java.util.ArrayList;
import model.Mobil;
import model.Pelanggan;
import model.Transaksi;
import model.StatusMobil;

public class RentalService{
    private ArrayList<Transaksi> daftarTransaksi = new ArrayList<>();

    // Penyewaan mobil
    public void sewaMobil(Pelanggan pelanggan,Mobil mobil,String tanggalMulai,String tanggalSelesai){
    if (mobil.getStatus() == StatusMobil.DISEWA) {
        System.out.println("Mobil sedang tidak tersedia");
        return;
    }
    Transaksi transaksi = new Transaksi(
            "TRX" + (daftarTransaksi.size() + 1),
            pelanggan,
            mobil,
            tanggalMulai,
            tanggalSelesai,
            0
    );
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

    // Mengembalikan mobil yang sudah selesai disewa
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