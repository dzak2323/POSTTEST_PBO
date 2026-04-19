interface OperasionalToko {
    // Memiliki minimal 2 method (Sesuai Syarat)
    void cekStatusStok();
    void tampilkanPromo();
}


public abstract class Roti implements OperasionalToko {
    protected String idroti;
    protected String namaRoti;
    protected int harga;
    protected int stok;

    public Roti(String idroti, String namaRoti, int harga, int stok) {
        this.idroti = idroti;
        this.namaRoti = namaRoti;
        this.harga = harga;
        this.stok = stok;
    }


    public String getIdroti() { return idroti; }
    public String getNamaRoti() { return namaRoti; }
    public int getHarga() { return harga; }
    public int getStok() { return stok; }
    public void setNamaRoti(String namaRoti) { this.namaRoti = namaRoti; }
    public void setStok(int stok) { this.stok = stok; }


    public void setHarga(int hargaBaru) {
        this.harga = hargaBaru;
    }

    public void setHarga(double persentase, boolean naik) {
        if (naik) {
            this.harga += (int) (this.harga * persentase);
        } else {
            this.harga -= (int) (this.harga * persentase);
        }
    }

    public abstract void detailKhusus();

    // Method untuk menampilkan info (Polimorfisme Dinamis)
    public void tampilkaninfo() {
        System.out.println("ID: " + idroti + " | Nama: " + namaRoti + " | Harga: Rp" + harga + " | Stok: " + stok);
        detailKhusus();
        cekStatusStok();
        tampilkanPromo();
    }


    @Override
    public void cekStatusStok() {
        if (this.stok > 0) {
            System.out.println("   ├─ Status: Aman (" + this.stok + " ready)");
        } else {
            System.out.println("   ├─ Status: HABIS!");
        }
    }

    @Override
    public void tampilkanPromo() {
        System.out.println("   └─ Promo: Beli 5 Gratis 1 (Berlaku semua roti)");
    }
}


class RotiManis extends Roti {
    private String rasaIsian;

    public RotiManis(String idroti, String namaRoti, int harga, int stok, String rasaIsian) {
        super(idroti, namaRoti, harga, stok);
        this.rasaIsian = rasaIsian;
    }


    @Override
    public void detailKhusus() {
        System.out.println("   ├─ Kategori: Roti Manis | Isian: " + rasaIsian);
    }

    @Override
    public void tampilkanPromo() {
        System.out.println("   └─ Promo: Diskon 10% setiap hari Jumat!");
    }
}


class RotiTawar extends Roti {
    private int jumlahIrisan;

    public RotiTawar(String idroti, String namaRoti, int harga, int stok, int jumlahIrisan) {
        super(idroti, namaRoti, harga, stok);
        this.jumlahIrisan = jumlahIrisan;
    }

    @Override
    public void detailKhusus() {
        System.out.println("   ├─ Kategori: Roti Tawar | Jumlah Irisan: " + jumlahIrisan + " slice");
    }
}


class KueTart extends Roti {
    private String ukuranLoyang;
    public KueTart(String idroti, String namaRoti, int harga, int stok, String ukuranLoyang) {
        super(idroti, namaRoti, harga, stok);
        this.ukuranLoyang = ukuranLoyang;
    }


    @Override
    public void detailKhusus() {
        System.out.println("   ├─ Kategori: Kue Tart | Ukuran: " + ukuranLoyang);
    }


    @Override
    public void tampilkanPromo() {
        System.out.println("   └─ Promo: Gratis Lilin Angka dan Pisau Kue!");
    }
}