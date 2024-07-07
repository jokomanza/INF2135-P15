package nexus.joko.inf2135.asn3.model;

public class Mobil {

    private String nama;
    private Mesin mesin;
    private String bahanBakar;
    private int jumlahKursi;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setMesin(Mesin mesin) {
        this.mesin = mesin;
    }

    public Mesin getMesin() {
        return mesin;
    }
    
    public void setBahanBakar(String bahanBakar) {
        this.bahanBakar = bahanBakar;
    }

    public String getBahanBakar() {
        return bahanBakar;
    }

    public int getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(int jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }
}
