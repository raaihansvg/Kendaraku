package service;

import collection.FleetManager;
import collection.RiwayatRental;
import model.Mobil;
import model.MobilTidakTersedia;
import model.Pelanggan;
import model.StatusMobil;
import model.Transaksi;



public class RentalService{
    /* Atribut */
    private FleetManager fleetManager;
    private RiwayatRental riwayatRental;
    private int hitungTransaksi;

    /* Konstruktor Default */
    public RentalService(){
        this.fleetManager = new FleetManager();
        this.riwayatRental = new RiwayatRental();
        this.hitungTransaksi = 0;
    }

    /* getter */
    public FleetManager getFleetManager(){
        return fleetManager;
    }

    public RiwayatRental getRiwayatRental(){
        return riwayatRental;
    }

    /* Method */

    /* menambahkan mobil ke armada */
    public void tambahMobilKeArmada(Mobil mobil){
        fleetManager.enqueue(mobil);
        System.out.println("Mobil ditambahkan ke armada: " + mobil.getMerk() + " " + mobil.getModel());
    }

    /* penyewaan mobil */
    public void sewaMobil(Pelanggan pelanggan, String idMobil, String tanggalMulai, String tanggalSelesai)throws MobilTidakTersedia{
        Mobil mobil = fleetManager.getMobilById(idMobil);
        if(mobil == null){
            throw new MobilTidakTersedia("Mobil dengan ID " + idMobil + " tidak tersedia");
        }
        if(mobil.getStatus() == StatusMobil.DISEWA){
            throw new MobilTidakTersedia("Mobil " + mobil.getMerk() + " " + mobil.getModel() + " sedang disewa, tidak tersedia saat ini");
        }

        hitungTransaksi ++;
        String idTransaksi = String.format("TRX%03d", hitungTransaksi);

        Transaksi transaksi = new Transaksi(idTransaksi, pelanggan, mobil, tanggalMulai, tanggalSelesai);
        mobil.setStatus(StatusMobil.DISEWA);
        riwayatRental.tambah(transaksi);
        System.out.println("Sewa Berhasil!");
        System.out.println(transaksi);
    }

    /* pengembalian mobil yang sudah disewa */
    public void kembalikanMobil(String idMobil) {
        Mobil mobil = fleetManager.getMobilById(idMobil);
        if (mobil == null) {
            System.out.println("Mobil dengan ID '" + idMobil + "' tidak ditemukan");
            return;
        }
        if (mobil.getStatus() == StatusMobil.TERSEDIA) {
            System.out.println("Mobil " + idMobil + " tidak sedang dalam status disewa");
            return;
        }
        mobil.setStatus(StatusMobil.TERSEDIA);
        System.out.println("Mobil " + mobil.getMerk() + " " + mobil.getModel()
                + " berhasil dikembalikan dan kini tersedia");
    }

    /* mencari transaksi berdasarkan ID */
    public Transaksi getTransaksi(String idTransaksi) {
        Transaksi transaksi = riwayatRental.cari(idTransaksi);
        if (transaksi == null) {
            System.out.println("Transaksi dengan ID '" + idTransaksi + "' tidak ditemukan");
        }
        return transaksi;
    }

    /* Menampilkan seluruh transaksi */
    public void showSemuaTransaksi() {
        riwayatRental.showSemua();
    }
    /* menghitung total pendapatan dari seluruh transaksi */
    public double hitungPendapatan() {
        double total = 0;
        for (Transaksi transaksi : riwayatRental.getDaftarTransaksi()) {
            total += transaksi.getTotalBiaya();
        }
        return total;
    }
}