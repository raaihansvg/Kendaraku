package program;

import model.*;
import service.*;
import java.util.Scanner;

public class Main {
    private static MobilService mobilService = new MobilService();
    private static PelangganService pelangganService = new PelangganService();
    private static RentalService rentalService = new RentalService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        isiDataContoh();
        tampilkanMenu();
    }

    private static void tampilkanMenu() {
        int pilihan = -1;

        while (pilihan != 0) {
            System.out.println("\n=============================");
            System.out.println("  SISTEM RENTAL KENDARAKU   ");
            System.out.println("=============================");
            System.out.println("--- MOBIL ---");
            System.out.println("[1] Lihat semua mobil");
            System.out.println("[2] Lihat mobil tersedia");
            System.out.println("[3] Tambah mobil baru");
            System.out.println("[4] Hapus mobil");
            System.out.println("--- PELANGGAN ---");
            System.out.println("[5] Lihat semua pelanggan");
            System.out.println("[6] Tambah pelanggan baru");
            System.out.println("[7] Hapus pelanggan");
            System.out.println("--- RENTAL ---");
            System.out.println("[8] Sewa mobil");
            System.out.println("[9] Kembalikan mobil");
            System.out.println("[10] Lihat semua transaksi");
            System.out.println("[11] Hitung total pendapatan");
            System.out.println("-----------------------------");
            System.out.println("[0] Keluar");
            System.out.print("Pilihan: ");

            try {
                pilihan = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, masukkan angka");
                continue;
            }

            prosesInput(pilihan);
        }

        System.out.println("Terima kasih telah menggunakan KENDARAKU!");
    }

    private static void prosesInput(int pilihan) {
        switch (pilihan) {
            case 1:
                mobilService.tampilMobil();
                break;
            case 2:
                mobilService.tampilMobilTersedia();
                break;
            case 3:
                menuTambahMobil();
                break;
            case 4:
                menuHapusMobil();
                break;
            case 5:
                pelangganService.tampilPelanggan();
                break;
            case 6:
                menuTambahPelanggan();
                break;
            case 7:
                menuHapusPelanggan();
                break;
            case 8:
                menuSewaMobil();
                break;
            case 9:
                menuKembalikanMobil();
                break;
            case 10:
                rentalService.showSemuaTransaksi();
                break;
            case 11:
                double total = rentalService.hitungPendapatan();
                System.out.printf("Total Pendapatan: Rp %.0f%n", total);
                break;
            case 0:
                break;
            default:
                System.out.println("Pilihan tidak dikenali");
        }
    }

    // == MENU MOBIL ==

    private static void menuTambahMobil() {
        System.out.println("\n=== TAMBAH MOBIL ===");
        System.out.print("ID Mobil        : ");
        String id = scanner.nextLine().trim();
        System.out.print("Merk            : ");
        String merk = scanner.nextLine().trim();
        System.out.print("Model           : ");
        String model = scanner.nextLine().trim();
        System.out.print("Tahun Produksi  : ");
        int tahun = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Harga Per Hari  : ");
        double harga = Double.parseDouble(scanner.nextLine().trim());

        Mobil mobil = new Mobil(id, merk, model, tahun, harga, StatusMobil.TERSEDIA);
        mobilService.tambahMobil(mobil);
        rentalService.tambahMobilKeArmada(mobil);
    }

    private static void menuHapusMobil() {
        System.out.println("\n=== HAPUS MOBIL ===");
        mobilService.tampilMobil();
        System.out.print("ID Mobil yang dihapus: ");
        String id = scanner.nextLine().trim();
        mobilService.hapusMobil(id);
    }

    // == MENU PELANGGAN ==

    private static void menuTambahPelanggan() {
        System.out.println("\n=== TAMBAH PELANGGAN ===");
        System.out.print("ID Pelanggan : ");
        String id = scanner.nextLine().trim();
        System.out.print("Nama         : ");
        String nama = scanner.nextLine().trim();
        System.out.print("No Telp      : ");
        String noTelp = scanner.nextLine().trim();
        System.out.print("Email        : ");
        String email = scanner.nextLine().trim();

        Pelanggan pelanggan = new Pelanggan(id, nama, noTelp, email);
        pelangganService.tambahPelanggan(pelanggan);
    }

    private static void menuHapusPelanggan() {
        System.out.println("\n=== HAPUS PELANGGAN ===");
        pelangganService.tampilPelanggan();
        System.out.print("ID Pelanggan yang dihapus: ");
        String id = scanner.nextLine().trim();
        pelangganService.hapusPelanggan(id);
    }

    // == MENU RENTAL ==

    private static void menuSewaMobil() {
        System.out.println("\n=== SEWA MOBIL ===");

        System.out.print("ID Pelanggan : ");
        String idPlg = scanner.nextLine().trim();
        Pelanggan pelanggan = pelangganService.cariPelanggan(idPlg);
        if (pelanggan == null) {
            System.out.println("Pelanggan tidak ditemukan");
            return;
        }

        mobilService.tampilMobilTersedia();
        System.out.print("ID Mobil     : ");
        String idMobil = scanner.nextLine().trim();

        System.out.print("Tanggal Mulai   (YYYY-MM-DD): ");
        String mulai = scanner.nextLine().trim();

        System.out.print("Tanggal Selesai (YYYY-MM-DD): ");
        String selesai = scanner.nextLine().trim();

        try {
            rentalService.sewaMobil(pelanggan, idMobil, mulai, selesai);
        } catch (MobilTidakTersedia e) {
            System.out.println("GAGAL: " + e.getMessage());
        }
    }

    private static void menuKembalikanMobil() {
        System.out.println("\n=== KEMBALIKAN MOBIL ===");
        System.out.print("ID Mobil: ");
        String idMobil = scanner.nextLine().trim();
        rentalService.kembalikanMobil(idMobil);
    }

    // == DATA CONTOH ==

    /* testing */
    private static void isiDataContoh() {
        Mobil m1 = new Mobil("M001", "Toyota", "Avanza", 2021, 350000, StatusMobil.TERSEDIA);
        Mobil m2 = new Mobil("M002", "Honda", "Brio", 2022, 300000, StatusMobil.TERSEDIA);
        Mobil m3 = new Mobil("M003", "Suzuki", "Ertiga", 2020, 400000, StatusMobil.TERSEDIA);

        mobilService.tambahMobil(m1);
        mobilService.tambahMobil(m2);
        mobilService.tambahMobil(m3);

        rentalService.tambahMobilKeArmada(m1);
        rentalService.tambahMobilKeArmada(m2);
        rentalService.tambahMobilKeArmada(m3);

        Pelanggan p1 = new Pelanggan("P001", "Budi Santoso", "081234567890", "budi@email.com");
        Pelanggan p2 = new Pelanggan("P002", "Siti Rahayu", "082345678901", "siti@email.com");

        pelangganService.tambahPelanggan(p1);
        pelangganService.tambahPelanggan(p2);

        System.out.println("Data contoh berhasil dimuat.");
    }
}