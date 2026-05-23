package service;

import java.util.*;

import database.MySQLMobilDAO;
import database.MySqlUtility;
import model.Mobil;
import model.StatusMobil;

public class MobilService{
    /* Atribut */
    private List<Mobil> daftarMobil;
    private MySQLMobilDAO dao = new MySQLMobilDAO(new MySqlUtility());
    /* Konstruktor */
    public MobilService(){
        daftarMobil = new ArrayList<>();
    }
    

    /* getter */
    public List<Mobil> getDaftarMobil(){
        return daftarMobil;
    }

    /* Method */

    /* menambahkan mobil baru */
    public void tambahMobil(Mobil mobil){
        daftarMobil.add(mobil);
        dao.save(mobil);
        System.out.println("Mobil berhasil ditambahkan: " + mobil.getMerk() + " " + mobil.getModel());
    }

    /* Menampilkan semua list(daftar) mobil yang sudah ada */
    public void tampilMobil(){
        if(daftarMobil.isEmpty()){
            System.out.println("Daftar mobil kosong");
            return;
        }else{
            System.out.println(" == DAFTAR SEMUA MOBIL == ");
            for(Mobil mobil : daftarMobil){
                System.out.println(mobil);
            }
        }
    }

    /* Mencari mobil berdasarkan IdMobil */
    public Mobil cariMobil(String idMobil){
        for(Mobil mobil : daftarMobil){
            if(mobil.getIdMobil().equals(idMobil)){
                return mobil;
            }
        }
        return null;
    }

    /* Menampikan mobil yang hanya tersedia */
    public void tampilMobilTersedia(){
        boolean adaMobil = false;
        System.out.println(" == DAFTAR MOBIL YANG TERSEDIA == ");
        
        for(Mobil mobil : daftarMobil){
            if(mobil.getStatus() == StatusMobil.TERSEDIA){
                System.out.println(mobil);
                adaMobil = true;
            }
        }
        if(! adaMobil){
            System.out.println("Tidak ada mobil yang tersedia saat ini");
        }
    }
    /* Memperbarui status mobil */
    public void updateStatus(String idMobil,StatusMobil status){
        Mobil mobil = cariMobil(idMobil);
        if(mobil != null){
            mobil.setStatus(status);
            System.out.println("Status mobil " + idMobil + " diperbarui menjadi " + status);
        }else{
            System.out.println("Mobil dengan ID " + idMobil + " Tidak ditemukan");
        }
    }

    /* Menghapus data mobil */
    public void hapusMobil(String idMobil){
        Mobil mobil = cariMobil(idMobil);
        if(mobil != null){
            if (mobil.getStatus() == StatusMobil.DISEWA){
                System.out.println("Mobil sedang disewa tidak bisa dihapus");
                return;
            }else{
                daftarMobil.remove(mobil);
                System.out.println("Mobil dengan idMobil " + idMobil + " berhasil dihapus");
            }
        }else{
            System.out.println("Mobil dengan idMobil " + idMobil + " tidak ditemukan");
        }
    }
}