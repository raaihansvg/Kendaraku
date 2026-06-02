-- 1. Buat database
CREATE DATABASE IF NOT EXISTS kendaraku;
USE kendaraku;

-- 2. Tabel mobil
CREATE TABLE mobil (
    id_mobil        VARCHAR(10)     PRIMARY KEY,
    merk            VARCHAR(50)     NOT NULL,
    model           VARCHAR(50)     NOT NULL,
    tahun_produksi  INT             NOT NULL,
    harga_per_hari  DOUBLE          NOT NULL,
    status          ENUM('TERSEDIA', 'DISEWA') DEFAULT 'TERSEDIA'
);

-- 3. Tabel pelanggan
CREATE TABLE pelanggan (
    id_pelanggan    VARCHAR(10)     PRIMARY KEY,
    nama            VARCHAR(100)    NOT NULL,
    no_telp         VARCHAR(15)     NOT NULL,
    email           VARCHAR(100)    NOT NULL
);

-- 4. Tabel transaksi (bergantung pada mobil & pelanggan)
CREATE TABLE transaksi (
    id_transaksi    VARCHAR(10)     PRIMARY KEY,
    id_pelanggan    VARCHAR(10)     NOT NULL,
    id_mobil        VARCHAR(10)     NOT NULL,
    tanggal_mulai   DATE            NOT NULL,
    tanggal_selesai DATE            NOT NULL,
    total_biaya     DOUBLE          NOT NULL,
    FOREIGN KEY (id_pelanggan) REFERENCES pelanggan(id_pelanggan),
    FOREIGN KEY (id_mobil)     REFERENCES mobil(id_mobil)
);
