package database;

import model.Pelanggan;
import java.util.List;

public interface PelangganDAO {
    void save(Pelanggan pelanggan);
    Pelanggan findById(String idPelanggan);
    List<Pelanggan> findAll();
}