package generik;

public class Datum<T> {
    /* atribut */
    private T isi;
    /* Konstruktor */
    public Datum(T isi) {
        this.isi = isi;
    }
    /* Method */
    public T getIsi() {
        return isi;
    }

    public void setIsi(T isi) {
        this.isi = isi;
    }

    @Override
    public String toString() {
        return String.valueOf(isi);
    }
}
