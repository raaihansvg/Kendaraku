# Kendaraku

Sistem rental kendaraan berbasis Java dengan penyimpanan data menggunakan MySQL.

## Requirements & Library

- Java 17+
- MySQL 8.0+
- mysql-connector-j-9.3.0

## Struktur Project
```
src/
├── collection/
│   ├── FleetManager.java
│   └── RiwayatRental.java
├── database/
│   ├── MobilDAO.java
│   ├── MySQLMobilDAO.java
│   ├── PelangganDAO.java
│   ├── MySQLPelangganDAO.java
│   ├── TransaksiDAO.java
│   ├── MySQLTransaksiDAO.java
│   └── MysqlUtility.java
├── generik/
│   ├── Data.java
│   ├── Datum.java
│   └── OperatorGenerik.java
├── model/
│   ├── Mobil.java
│   ├── MobilTidakTersedia.java
│   ├── Pelanggan.java
│   ├── Priceable.java
│   ├── StatusMobil.java
│   └── Transaksi.java
├── service/
│   ├── MobilService.java
│   ├── PelangganService.java
│   └── RentalService.java
└── program/
└── Main.java
```
## MySQL Setup

```sql
CREATE DATABASE IF NOT EXISTS kendaraku;
USE kendaraku;

CREATE TABLE mobil (
    id_mobil        VARCHAR(10)  PRIMARY KEY,
    merk            VARCHAR(50)  NOT NULL,
    model           VARCHAR(50)  NOT NULL,
    tahun_produksi  INT          NOT NULL,
    harga_per_hari  DOUBLE       NOT NULL,
    status          ENUM('TERSEDIA', 'DISEWA') DEFAULT 'TERSEDIA'
);

CREATE TABLE pelanggan (
    id_pelanggan  VARCHAR(10)   PRIMARY KEY,
    nama          VARCHAR(100)  NOT NULL,
    no_telp       VARCHAR(15)   NOT NULL,
    email         VARCHAR(100)  NOT NULL
);

CREATE TABLE transaksi (
    id_transaksi    VARCHAR(10)  PRIMARY KEY,
    id_pelanggan    VARCHAR(10)  NOT NULL,
    id_mobil        VARCHAR(10)  NOT NULL,
    tanggal_mulai   DATE         NOT NULL,
    tanggal_selesai DATE         NOT NULL,
    total_biaya     DOUBLE       NOT NULL,
    FOREIGN KEY (id_pelanggan) REFERENCES pelanggan(id_pelanggan),
    FOREIGN KEY (id_mobil)     REFERENCES mobil(id_mobil)
);
```

## Konfigurasi Database

Sesuaikan password MySQL di `src/database/MysqlUtility.java`:

```java
private static final String URL  = "jdbc:mysql://localhost:3306/kendaraku";
private static final String USER = "root";
private static final String PASS = "password";
```

## How to Build

Makesure file `mysql-connector-j-9.3.0.jar` sudah ada di folder `lib/`.

Compile:
```bash
cd src
javac -cp .:../lib/mysql-connector-j-9.3.0.jar collection/*.java database/*.java generik/*.java model/*.java service/*.java program/*.java
```

Run:
```bash
java -cp .:../lib/mysql-connector-j-9.3.0.jar program.Main
```

## Fitur

- Lihat semua mobil & mobil tersedia
- Tambah dan hapus mobil
- Lihat semua pelanggan
- Tambah dan hapus pelanggan
- Sewa mobil (otomatis tersimpan ke database)
- Kembalikan mobil
- Lihat riwayat transaksi
- Hitung total pendapatan

## Contributors

- raaihansvg — Raihan
- yurawawawawa — Arga Yura Dane
- dhymarbun — Adhyaksa Marganda
- Narfa26 - Muhammad Farhan
