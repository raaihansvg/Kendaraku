package service;

import java.util.ArrayList;
import model.Mobil;
import model.StatusMobil;

public class MobilService {
    private ArrayList<Mobil> daftarMobil = new ArrayList<>();

    // Method Tambah Mobil
    public void tambahMobil(Mobil mobil) {
        daftarMobil.add(mobil);
        System.out.println("Mobil Berhasil di Tambahkan!");
    }

    // Menampilkan Daftar Semua Mobil
    public void tampilMobil(){
        if(daftarMobil.isEmpty()){
            System.out.println("Mobil Kosong");
            return;
        }
        for(Mobil mobil : daftarMobil){
            System.out.println(mobil);
        }
    }

    // cari mobil berdasarkan id
    public Mobil cariMobil(String idMobil){
        for (Mobil mobil : daftarMobil) {
            if (mobil.getIdMobil().equals(idMobil)){
                return mobil;
            }

        } return null;
    }

    // Menampilkan mobil yang hanya berstatus tersedia (siap untuk disewa)
    public void tampilMobilTersedia(){
        for(Mobil mobil : daftarMobil) {
            if(mobil.getStatus() == StatusMobil.TERSEDIA){
                System.out.println(mobil);
            }
        }
    }

    // Memperbarui status mobil
    public void updateStatus(String idMobil, StatusMobil statusBaru) {
        Mobil mobil = cariMobil(idMobil);
        if(mobil != null){
            mobil.setStatus(statusBaru);
            System.out.println("Status mobil berhasil diupdate");
        }else{
            System.out.println("Mobil tidak ditemukan");
        }
    }

    // menghapus data mobil
    public void hapusMobil(String idMobil){
        Mobil mobil = cariMobil(idMobil);
        if(mobil != null){
            daftarMobil.remove(mobil);
            System.out.println("Mobil dihapus");
        }else{
            System.out.println("Mobil tidak ada");
        }
    }
}

