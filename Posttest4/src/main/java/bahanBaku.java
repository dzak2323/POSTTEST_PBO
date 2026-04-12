
public class bahanBaku {
    // Menggunakan protected agar bisa diakses langsung oleh subclass jika diperlukan
    protected String idbahan;
    protected String namaBahan;
    protected String kategoriBahan;
    protected double stok;
    protected String satuanStok;

    // Constructor
    public bahanBaku(String idbahan, String namaBahan, String kategoriBahan, double stok, String satuanStok) {
        this.idbahan = idbahan;
        this.namaBahan = namaBahan;
        this.kategoriBahan = kategoriBahan;
        this.stok = stok;
        this.satuanStok = satuanStok;
    }

    // Getter
    public String getIdbahan() { return idbahan; }
    public String getNamaBahan() { return namaBahan; }
    public String getKategoriBahan() { return kategoriBahan; }
    public double getStok() { return stok; }
    public String getSatuanStok() { return satuanStok; }

    // Setter
    public void setNamaBahan(String namaBahan) { this.namaBahan = namaBahan; }
    public void setKategoriBahan(String kategoriBahan) { this.kategoriBahan = kategoriBahan; }
    public void setStok(double stok) { this.stok = stok; }
    public void setSatuanStok(String satuanStok) { this.satuanStok = satuanStok; }


    public void setStok(double jumlah, boolean tambah) {
        if (tambah) {
            this.stok += jumlah;
        } else {
            this.stok -= jumlah;
        }
    }
    public void updateStok(double jumlahBaru) {
        this.stok = jumlahBaru;
    }


    public void updateStok(double jumlah, boolean isPenambahan) {
        if (isPenambahan) {
            this.stok += jumlah;
            System.out.println("Stok berhasil ditambah.");
        } else {
            this.stok -= jumlah;
            System.out.println("Stok berhasil dikurangi.");
        }
    }

    public void tampilkanBahan() {
        System.out.println("ID: " + idbahan + " | Nama: " + namaBahan + " | Kategori: " + kategoriBahan + " | Stok: " + stok + " " + satuanStok);
    }

    public String instruksiPenyimpanan() {
        return "Simpan di rak gudang suhu ruang standar.";
    }

    public String getInstruksiPenyimpanan() {
        return "Simpan di tempat yang bersih standar.";
    }
}


class BahanKering extends bahanBaku {
    private String tanggalKadaluarsa;

    public BahanKering(String idbahan, String namaBahan, String kategoriBahan, double stok, String satuanStok, String tanggalKadaluarsa) {
        super(idbahan, namaBahan, kategoriBahan, stok, satuanStok);
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }

    @Override
    public void tampilkanBahan() {
        super.tampilkanBahan();
        System.out.println("   └─ Tipe: Kering | Expired: " + tanggalKadaluarsa);
    }

    @Override
    public String instruksiPenyimpanan() {
        return "Simpan di tempat kering, hindari kelembapan agar tidak menggumpal.";
    }
}

class BahanBasah extends bahanBaku {
    private int suhuKulkas;

    public BahanBasah(String idbahan, String namaBahan, String kategoriBahan, double stok, String satuanStok, int suhuKulkas) {
        super(idbahan, namaBahan, kategoriBahan, stok, satuanStok);
        this.suhuKulkas = suhuKulkas;
    }

    @Override
    public void tampilkanBahan() {
        super.tampilkanBahan();
        System.out.println("   └─ Tipe: Basah | Suhu Kulkas: " + suhuKulkas + " derajat Celcius");
    }

    @Override
    public String instruksiPenyimpanan() {
        return "WAJIB disimpan di chiller/kulkas pada suhu " + suhuKulkas + " derajat Celcius.";
    }
}