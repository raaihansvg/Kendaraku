package model;

/**
 * Exception MobilTidakTersedia
 * Dilempar ketika mobil yang ingin disewa tidak tersedia.
 */
public class MobilTidakTersedia extends Exception {

    public MobilTidakTersedia(String msg) {
        super(msg);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}