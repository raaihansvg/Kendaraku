package generik;
import model.Priceable;

public class OperatorGenerik<T extends Priceable> {
    public void tukar(Data<T> data, int indexPertama, int indexKedua) {
        T isiPertama = data.getIsi(indexPertama);
        T isiKedua = data.getIsi(indexKedua);

        if (isiPertama == null || isiKedua == null) {
            System.out.println("Index tidak valid");
            return;
        }

        data.setIsi(indexPertama, isiKedua);
        data.setIsi(indexKedua, isiPertama);
    }

    public int bandingkan(T dataPertama, T dataKedua) {
        return Double.compare(dataPertama.hitungHarga(), dataKedua.hitungHarga());
    }

    public double cariHarga(T data) {
        return data.hitungHarga();
    }

    public double cariHarga(Data<T> data, int index) {
        T isi = data.getIsi(index);

        if (isi == null) {
            return -1;
        }

        return cariHarga(isi);
    }
}
