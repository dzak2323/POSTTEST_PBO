public class Roti {
    private String idroti;
    private String namaRoti;
    private int harga;
    private int stok;
    protected String kodeProduksi;


//Constructor
public Roti(String idroti, String namaRoti, int harga, int stok) {
    this.idroti = idroti;
    this.namaRoti = namaRoti;
    this.harga = harga;
    this.stok = stok;
    this.kodeProduksi = "Batch-" + idroti;
    }
    //getter
    public String getNamaRoti() {return namaRoti;}
    public String getIdroti() {return idroti;}
    public int getHarga() {return harga;}
    public int getStok() {return stok;}

    //Setter
    public void setHarga(int harga) {this.harga = harga;}
    public void setNamaRoti(String namaRoti) {this.namaRoti = namaRoti;}
    public void setStok(int stok) {this.stok = stok;}

    String cekStatusStok(){
    if (this.stok > 0){
        return "Tersedia";
    }else {
        return "stok habis";
    }
    }

    //Print out
    public void tampilkaninfo() {
        System.out.println("ID : " + idroti + "| Roti: " + namaRoti + "Harga : Rp" + harga + "sisa stok: " + stok);
    }
}