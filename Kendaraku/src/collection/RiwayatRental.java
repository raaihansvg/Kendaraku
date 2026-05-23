package collection;

import java.util.*;
import model.Transaksi;

public class RiwayatRental {
    /* Atribut */
    private List<Transaksi> daftarTransaksi;
    private int nbelm;

    /* Konstruktor */
    public RiwayatRental() {
        daftarTransaksi = new ArrayList<>();
        nbelm = 0;
    }

    /* Getter */
    public List<Transaksi> getDaftarTransaksi(){
        return daftarTransaksi;
    }

    /* Method */
    /* menambahkan transaksi */
    public void tambah(Transaksi transaksi) {
        daftarTransaksi.add(transaksi);
        nbelm++;
    }
    /* menghapus transaksi */
    public void hapus(Transaksi transaksi) {
        if (daftarTransaksi.remove(transaksi)) {
            nbelm--;
        }
    }
    /* mencari transaksi berdasarkan idTransaksi */
    public Transaksi cari(String idTransaksi) {
        for (Transaksi transaksi : daftarTransaksi) {
            if (transaksi.getIdTransaksi().equalsIgnoreCase(idTransaksi)) {
                return transaksi;
            }
        }
        return null;
    }
    /* mengecek apakah suatu transaksi tersedia*/
    public boolean isMember(Transaksi transaksi) {
        return daftarTransaksi.contains(transaksi);
    }
    /* menghitung banyaknya transaksi */
    public int countTransaksi() {
        return nbelm;
    }
    /* menampilkan seluruh transaksi */
    public void showSemua() {
        if (daftarTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi");
            return;
        }
        System.out.println("=== RIWAYAT RENTAL ===");
        for (Transaksi transaksi : daftarTransaksi) {
            System.out.println(transaksi);
        }
    }
}