package database;

import model.Transaksi;
import java.util.*;

public interface TransaksiDAO {

    /* Method */

    /* menyimpan satu transaksi ke database */
    void save(Transaksi transaksi);
    /* mencari transaksi berdasarkan ID */
    Transaksi findById(String idTransaksi);
    /* Mengambil seluruh transaksi dari database */
    List<Transaksi> findAll();
}
