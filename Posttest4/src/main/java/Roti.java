
public class Roti {
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

    public void tampilkaninfo() {
        System.out.println("ID: " + idroti + " | Nama: " + namaRoti + " | Harga: " + harga + " | Stok: " + stok);
    }
}


class RotiManis extends Roti {
    private String rasaIsian;

    public RotiManis(String idroti, String namaRoti, int harga, int stok, String rasaIsian) {
        super(idroti, namaRoti, harga, stok);
        this.rasaIsian = rasaIsian;
    }

    @Override
    public void tampilkaninfo() {
        super.tampilkaninfo();
        System.out.println("   └─ Kategori: Roti Manis | Isian: " + rasaIsian);
    }
}


class RotiTawar extends Roti {
    private int jumlahIrisan;

    public RotiTawar(String idroti, String namaRoti, int harga, int stok, int jumlahIrisan) {
        super(idroti, namaRoti, harga, stok);
        this.jumlahIrisan = jumlahIrisan;
    }

    @Override
    public void tampilkaninfo() {
        super.tampilkaninfo();
        System.out.println("   └─ Kategori: Roti Tawar | Jumlah Irisan: " + jumlahIrisan + " slice");
    }
}


class KueTart extends Roti {
    private String ukuranLoyang;

    public KueTart(String idroti, String namaRoti, int harga, int stok, String ukuranLoyang) {
        super(idroti, namaRoti, harga, stok);
        this.ukuranLoyang = ukuranLoyang;
    }

    @Override
    public void tampilkaninfo() {
        super.tampilkaninfo();
        System.out.println("   └─ Kategori: Kue Tart | Ukuran: " + ukuranLoyang);
    }

}