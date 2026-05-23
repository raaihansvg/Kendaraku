package generik;

@SuppressWarnings("unchecked")
public class Data<T> {
    /* Atribut */
    private static final int kapasitasAsli = 100;
    private Datum<T>[] daftarData;
    private int jumlahData;
    /* Konstruktor */
    public Data() {
        daftarData = (Datum<T>[]) new Datum[kapasitasAsli];
        jumlahData = 0;
    }
    /* Getter */
    public int getJumlahData() {
        return jumlahData;
    }

    public int getKapasitas() {
        return daftarData.length;
    }

    public boolean isKosong() {
        return jumlahData == 0;
    }

    public boolean isPenuh() {
        return jumlahData == daftarData.length;
    }

    /* method */
    public void tambah(T isi) {
        if (isPenuh()) {
            System.out.println("Data sudah penuh!");
            return;
        }

        daftarData[jumlahData] = new Datum<>(isi);
        jumlahData++;
    }

    public Datum<T> getDatum(int index) {
        if (!isIndexValid(index)) {
            return null;
        }

        return daftarData[index];
    }

    public T getIsi(int index) {
        Datum<T> datum = getDatum(index);

        if (datum == null) {
            return null;
        }

        return datum.getIsi();
    }

    public void setIsi(int index, T isi) {
        Datum<T> datum = getDatum(index);

        if (datum != null) {
            datum.setIsi(isi);
        }
    }

    public void tampilSemua() {
        if (isKosong()) {
            System.out.println("Data masih kosong");
            return;
        }

        for (int i = 0; i < jumlahData; i++) {
            System.out.println(daftarData[i]);
        }
    }

    private boolean isIndexValid(int index) {
        return index >= 0 && index < jumlahData;
    }
}
