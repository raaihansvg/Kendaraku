package service;

import java.util.*;
import model.Pelanggan;

public class PelangganService {

    /* Atribut */
    private List<Pelanggan> daftarPelanggan;

    /* Konstruktor */
    public PelangganService(){
        daftarPelanggan = new ArrayList<>();
    }
    /* Getter */
    public List<Pelanggan> getDaftarPelanggan(){
        return daftarPelanggan;
    }

    /* Method */
    /* Menambahkan data pelangan baru */
    public void tambahPelanggan(Pelanggan pelanggan){
        daftarPelanggan.add(pelanggan);
        System.out.println("Pelanggan berhasil didaftarkan: " + pelanggan.getNama());
    }

    /* Menampilkan semua list(daftar) pelanggan yang sudah ada */
    public void tampilPelanggan(){
        if(daftarPelanggan.isEmpty()){
            System.out.println("Daftar pelanggan kosong");
            return;
        }else{
            System.out.println(" == Daftar Pelanggan == ");
            for(Pelanggan pelanggan : daftarPelanggan){
                System.out.println(pelanggan);
            }
        }
    }

    /* Mencari pelanggan berdasarkan idPelanggan */
    public Pelanggan cariPelanggan(String idPelanggan){
        for(Pelanggan pelanggan : daftarPelanggan){
            if(pelanggan.getIdPelanggan().equals(idPelanggan)){
                return pelanggan;
            }
        }
        return null;
    }

    /* Memperbarui data pelanggan berdasarkan IDPelanggan */
    public void updatePelanggan(Pelanggan pelangganBaru){
        for(int i = 0; i < daftarPelanggan.size(); i++){
            if(daftarPelanggan.get(i).getIdPelanggan().equalsIgnoreCase(pelangganBaru.getIdPelanggan())){
                daftarPelanggan.set(i, pelangganBaru);
                System.out.println("Data pelanggan " + pelangganBaru.getIdPelanggan() + " berhasil disimpan");
                return;
            }
        }
        System.out.println("Pelanggan dengan ID " + pelangganBaru.getIdPelanggan() + " tidak ditemukan");
    }

    /* menghapus pelanggan */
    public void hapusPelanggan(String idPelanggan){
        Pelanggan pelanggan = cariPelanggan(idPelanggan);
        if(pelanggan != null){
            daftarPelanggan.remove(pelanggan);
        }else{
            System.out.println("Pelanggan dengan ID " + idPelanggan + "tidak ditemukan");
        }
    }
}