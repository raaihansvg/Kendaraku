/*  Exception MobilTidakTersedia berfungsi
    untuk menyampaikan pesan ketika mobil yang 
    ingin disewa tidak tersedia */

package model;

public class MobilTidakTersedia extends Exception{
    /* Konstruktor */
    /* Berguna untuk menerima dan mengembalikan pesan error */
    public MobilTidakTersedia(String pesan){
        super(pesan);
    }
}