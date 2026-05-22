package model;

/**
 * Kelas Admin (Tambahan)
 * Merepresentasikan administrator sistem rental Kendaraku.
 *
 * Admin memiliki akses penuh ke sistem: mengelola armada mobil,
 * data pelanggan, dan transaksi.
 */
public class Admin {

    // ── Atribut ──────────────────────────────────────────────
    private String idAdmin;
    private String nama;
    private String username;
    private String password;
    private String email;
    private String noTelp;

    // ── Konstruktor ──────────────────────────────────────────
    public Admin(String idAdmin, String nama, String username,
                 String password, String email, String noTelp) {
        this.idAdmin  = idAdmin;
        this.nama     = nama;
        this.username = username;
        this.password = password;
        this.email    = email;
        this.noTelp   = noTelp;
    }

    // ── Getter & Setter ──────────────────────────────────────
    public String getIdAdmin()                  { return idAdmin; }
    public void   setIdAdmin(String idAdmin)    { this.idAdmin = idAdmin; }

    public String getNama()                     { return nama; }
    public void   setNama(String nama)          { this.nama = nama; }

    public String getUsername()                 { return username; }
    public void   setUsername(String username)  { this.username = username; }

    public String getPassword()                 { return password; }
    public void   setPassword(String password)  { this.password = password; }

    public String getEmail()                    { return email; }
    public void   setEmail(String email)        { this.email = email; }

    public String getNoTelp()                   { return noTelp; }
    public void   setNoTelp(String noTelp)      { this.noTelp = noTelp; }

    // ── Metode Bisnis ────────────────────────────────────────
    /**
     * Memvalidasi login admin berdasarkan username dan password.
     *
     * @param inputUsername username yang dimasukkan
     * @param inputPassword password yang dimasukkan
     * @return true jika cocok, false jika tidak
     */
    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    /**
     * Mengubah password admin.
     * Password lama harus benar sebelum password baru ditetapkan.
     *
     * @param passwordLama  password saat ini
     * @param passwordBaru  password baru yang diinginkan
     * @return true jika berhasil diubah, false jika password lama salah
     */
    public boolean gantiPassword(String passwordLama, String passwordBaru) {
        if (this.password.equals(passwordLama)) {
            this.password = passwordBaru;
            return true;
        }
        return false;
    }

    // ── toString ─────────────────────────────────────────────
    @Override
    public String toString() {
        return "Admin{" +
               "id='"        + idAdmin  + '\'' +
               ", nama='"    + nama     + '\'' +
               ", username='"+ username + '\'' +
               ", email='"   + email    + '\'' +
               ", telp='"    + noTelp   + '\'' +
               '}';
    }
}