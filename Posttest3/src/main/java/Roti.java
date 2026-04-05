
// SUPERCLASS / PARENT CLASS
public class Roti { // Ini yang pakai 'public'
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
    public void setHarga(int harga) { this.harga = harga; }
    public void setStok(int stok) { this.stok = stok; }

    public void tampilkaninfo() {
        System.out.println("ID: " + idroti + " | Nama: " + namaRoti + " | Harga: " + harga + " | Stok: " + stok);
    }
}

// SUBCLASS / CHILD CLASS (INHERITANCE)
// 1. Roti Manis
class RotiManis extends Roti { // Tidak pakai 'public'
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

// 2. Roti Tawar
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

// 3. Kue Tart
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