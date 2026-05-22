package collection;

import java.util.ArrayList;
import java.util.List;
import model.Transaksi;

public class RiwayatRental {

    private List<Transaksi> daftarTransaksi;
    private int nbelm;

    public RiwayatRental() {

        daftarTransaksi = new ArrayList<>();
        nbelm = 0;
    }

    public void tambah(Transaksi transaksi) {

        daftarTransaksi.add(transaksi);
        nbelm++;
    }

    public void hapus(Transaksi transaksi) {

        if (daftarTransaksi.remove(transaksi)) {
            nbelm--;
        }
    }

    public Transaksi cari(String idTransaksi) {
        for (Transaksi transaksi : daftarTransaksi) {
            if (transaksi.getIdTransaksi().equalsIgnoreCase(idTransaksi)) {
                return transaksi;
            }
        }
        return null;
    }

    public boolean isMember(Transaksi transaksi) {
        return daftarTransaksi.contains(transaksi);
    }

    public int countTransaksi() {
        return nbelm;
    }

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

    public List<Transaksi> getDaftarTransaksi() {
        return daftarTransaksi;
    }
}