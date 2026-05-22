package collection;

import java.util.LinkedList;
import java.util.Queue;
import model.Mobil;
import model.StatusMobil;

public class FleetManager {

    private Queue<Mobil> Mobil;
    private int nbelm;

    public FleetManager() {
        Mobil = new LinkedList<>();
        nbelm = 0;
    }

    public void enqueue(Mobil mobil) {
        Mobil.add(mobil);
        nbelm++;
    }


    /*FUNGSI :
    Mobil yang masuk duluan akan keluar duluan  */
    public Mobil dequeue() {

        if (Mobil.isEmpty()) {
            return null;
        }

        nbelm--;
        return Mobil.poll();
    }

    public Mobil getMobil() {

        if (Mobil.isEmpty()) {
            return null;
        }

        return Mobil.peek();
    }

    public Mobil getMobilById(String idMobil) {

        for (Mobil mobil : Mobil) {

            if (mobil.getIdMobil().equalsIgnoreCase(idMobil)) {
                return mobil;
            }
        }

        return null;
    }

    public boolean isMember(Mobil mobil) {
        return Mobil.contains(mobil);
    }

    public int countMobil() {
        return nbelm;
    }

    public void showMobil() {

        if (Mobil.isEmpty()) {
            System.out.println("Mobil kosong");
            return;
        }

        System.out.println("=== DAFTAR Mobil ===");

        for (Mobil mobil : Mobil) {
            System.out.println(mobil);
        }
    }


    /*Menampilkan Mobil yang tersedia dan STATUS RENTAL */
    public void showMobilTersedia() {
        
        boolean ada = false;

        System.out.println("=== MOBIL TERSEDIA ===");

        for (Mobil mobil : Mobil) {

            if (mobil.getStatus() == StatusMobil.TERSEDIA) {

                System.out.println(mobil);

                ada = true;
            }
        }

        if (!ada) {
            System.out.println("Tidak ada mobil tersedia");
        }
    }
}