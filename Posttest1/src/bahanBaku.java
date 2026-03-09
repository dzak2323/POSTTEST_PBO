public class bahanBaku {
    private String idbahan;
    private String namaBahan;
    private String kategoriBahan;
    private double stok;
    private String satuanStok;

     //Constructor
    public bahanBaku(String idbahan, String namaBahan, String kategoriBahan
    , double stok, String satuanStok ){
       this.idbahan = idbahan;
       this.namaBahan = namaBahan;
       this.kategoriBahan = kategoriBahan;
       this.stok = stok;
       this.satuanStok = satuanStok;
    }

    //getter
    public String getIdbahan() {return idbahan;}
    public String getNamaBahan(){return namaBahan;}
    public String getKategoriBahan(){return kategoriBahan;}
    public double getStok(){return stok;}
    public String getSatuanStok(){return satuanStok;}

    //Setter
    public void setNamaBahan(String namaBahan){this.namaBahan = namaBahan;}
    public void setKategoriBahan(String kategoriBahan){this.kategoriBahan = kategoriBahan;}
    public void setStok(double stok){this.stok = stok;}
    public void setSatuanStok(String satuanStok){this.satuanStok = satuanStok;}

    //Print out
    public void tampilkanBahan(){
        System.out.println(
                "Id bahan: " + idbahan +
                "|Nama bahan: " + namaBahan +
                "| Kategori bahan" + kategoriBahan +
                "|Stok: " +stok+
                 "" + satuanStok
        );
    }
}


