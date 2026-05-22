package service;

import java.util.ArrayList;
import model.Pelanggan;

public class PelangganService{
    private ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();

    // Menambahkan Pelanggan
    public void tambahPelanggan(Pelanggan pelanggan){
        daftarPelanggan.add(pelanggan);
        System.out.println("Pelanggan ditambahkan");
    }

    // Menampilkan seluruh pelanggan
    public void tampilPelanggan(){
        if(daftarPelanggan.isEmpty()){
            System.out.println("Tidak ada data pelanggan");
            return;
        }
        for(Pelanggan pelanggan : daftarPelanggan){
            System.out.println(pelanggan);
        }
    }

    // Mencari pelanggan berdasarkan idnya
    public Pelanggan cariPelanggan(String idPelanggan){
        for(Pelanggan pelanggan : daftarPelanggan){
            if(pelanggan.getIdPelanggan().equals(idPelanggan)){
                return pelanggan;
            }
        } return null;
    }

    // Menghapus pelanggan
    public void hapusPelanggan(String idPelanggan){
        Pelanggan pelanggan = cariPelanggan(idPelanggan);
        if(pelanggan != null){
            daftarPelanggan.remove(pelanggan);
            System.out.println("Pelanggan dihapus");
        }else{
            System.out.println("Pelanggan tidak ada");
        }
    }
}