package service;

import java.util.ArrayList;
import model.Pelanggan;

public class PelangganService {

    private ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();

    /* =========================
       TAMBAH PELANGGAN
    ========================= */
    public void tambahPelanggan(Pelanggan pelanggan) {
        daftarPelanggan.add(pelanggan);
        System.out.println("Pelanggan berhasil ditambahkan!");
    }

    /* =========================
       TAMPILKAN SEMUA PELANGGAN
    ========================= */
    public void tampilPelanggan() {

        if (daftarPelanggan.isEmpty()) {
            System.out.println("Data pelanggan kosong");
            return;
        }

        for (Pelanggan pelanggan : daftarPelanggan) {
            System.out.println(pelanggan);
        }
    }

    /* =========================
       CARI PELANGGAN BERDASARKAN ID
    ========================= */
    public Pelanggan cariPelanggan(String idPelanggan) {

        for (Pelanggan pelanggan : daftarPelanggan) {

            if (pelanggan.getIdPelanggan().equals(idPelanggan)) {
                return pelanggan;
            }
        }

        return null;
    }

    /* =========================
       HAPUS PELANGGAN
    ========================= */
    public void hapusPelanggan(String idPelanggan) {

        Pelanggan pelanggan = cariPelanggan(idPelanggan);

        if (pelanggan != null) {
            daftarPelanggan.remove(pelanggan);
            System.out.println("Pelanggan berhasil dihapus");
        } else {
            System.out.println("Pelanggan tidak ditemukan");
        }
    }
}