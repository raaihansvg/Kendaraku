package collection;

import java.util.*;
import model.Mobil;
import model.StatusMobil;

public class FleetManager {

    /* Atribut */
    private Queue<Mobil> armada;
    private int nbelm;

    /* Konstruktor */
    public FleetManager() {
        armada = new LinkedList<>();
        nbelm  = 0;
    }

    /* Menambahkan mobil ke antrian armada */
    public void enqueue(Mobil mobil) {
        armada.add(mobil);
        nbelm++;
    }

    /* Mobil yang masuk duluan akan keluar duluan (FIFO) */
    public Mobil dequeue(){
            if(armada.isEmpty()){
                return null;
            }else{
                nbelm --;
                return armada.poll();
            }
    }

    /* Melihat mobil terdepan tanpa mengeluarkannya */
    public Mobil getMobilTerdepan() {
        if (armada.isEmpty()){
            return null;
        }else{
            return armada.peek();
        }
    }

    /* Mencari mobil berdasarkan ID */
    public Mobil getMobilById(String idMobil) {
        for (Mobil mobil : armada) {
            if (mobil.getIdMobil().equalsIgnoreCase(idMobil)) {
                return mobil;
            }
        }
        return null;
    }
    /* Mengecek apakah suatu mobil tersedia */
    public boolean isMember(Mobil mobil) {
        return armada.contains(mobil);
    }
    /* Menghitung jumlah unit mobil */
    public int countMobil() {
        return nbelm;
    }

    /* Menampilkan seluruh armada */
    public void showArmada() {
        if (armada.isEmpty()) {
            System.out.println("Armada kosong");
            return;
        }
        System.out.println("=== DAFTAR ARMADA ===");
        for (Mobil mobil : armada) {
            System.out.println(mobil);
        }
    }

    /* Menampilkan hanya mobil yang berstatus tersedia */
    public void showMobilTersedia() {
        boolean ada = false;
        System.out.println("=== MOBIL TERSEDIA ===");
        for (Mobil mobil : armada) {
            if (mobil.getStatus() == StatusMobil.TERSEDIA) {
                System.out.println(mobil);
                ada = true;
            }
        }
        if (!ada) System.out.println("Tidak ada mobil tersedia");
    }
}
