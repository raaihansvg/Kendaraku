/*  Kelas Mobil (POJO) 
    Merepresentasikan data mobil dalam sistem rental KENDARAKU
    Menggunakan interface Priceable untuk melakukan perhitungan harga sewa mobil*/

package model;

public class Mobil implements Priceable{
    /* Atribut */
    private String idMobil;
    private String merk;
    private String model;
    private int tahunProduksi;
    private double hargaPerHari;
    private StatusMobil status;

    /* Konstruktor */
    public Mobil(String idMobil,String merk,String model,int tahunProduksi,double hargaPerHari,StatusMobil status){
        this.idMobil = idMobil;
        this.merk = merk;
        this.model = model;
        this.tahunProduksi = tahunProduksi;
        this.hargaPerHari = hargaPerHari;
        this.status = status;
    }

    /* Getter */
    public String getIdMobil(){
        return idMobil;
    }

    public String getMerk(){
        return merk;
    }

    public String getModel(){
        return model;
    }

    public int getTahunProduksi(){
        return tahunProduksi;
    }

    public double getHargaPerHari(){
        return hargaPerHari;
    }

    public StatusMobil getStatus(){
        return status;
    }

    /* Setter */
    public void setIdMobil(String idMobil){
        this.idMobil = idMobil;
    }

    public void setMerk(String merk){
        this.merk = merk;
    }

    public void setModel(String model){
        this.model  = model;
    }

    public void setTahunProduksi(int tahunProduksi){
        this.tahunProduksi = tahunProduksi;
    }

    public void setHargaPerHari(double hargaPerHari){
        this.hargaPerHari = hargaPerHari;
    }

    public void setStatus(StatusMobil status){
        this.status = status;
    }

    /* Implementasi Priceable yang akan mengembalikan harga sewa per hari */
    @Override
    public double hitungHarga(){
        return hargaPerHari;
    }

    /* Output */
    @Override
    public String toString(){
        return """
                == Data Mobil ==
                Id Mobil    : %s
                Merk Mobil  : %s
                Model Mobil : %s
                Tahun Mobil : %s
                Harga/Hari  : %.0f
                Status      : %s
                """.formatted(
                    idMobil,
                    merk,
                    model,
                    tahunProduksi,
                    hargaPerHari,
                    status
                );
    }
}