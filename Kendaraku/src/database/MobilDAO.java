package database;

import model.Mobil;
import java.util.*;

public interface MobilDAO {
    void save(Mobil mobil);
    Mobil findById(String idMobil);
    List<Mobil> findAll();
}