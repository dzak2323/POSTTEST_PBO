public class Pelanggan {
    private String idPelanggan ;
    private String namaPelanggan;
    private String noHp;
    private int poinMember;
    private String jenisMember;

    // Constructor
    public Pelanggan(String idPelanggan, String namaPelanggan, String noHp, int poinMember, String jenisMember){
        this.idPelanggan = idPelanggan;
        this.namaPelanggan = namaPelanggan;
        this.noHp = noHp;
        this.poinMember = poinMember;
        this.jenisMember = jenisMember;
    }

    // Getter
    public String getIdPelanggan() {return idPelanggan;}
    public String getNamaPelanggan() {return namaPelanggan;}
    public String getNoHp() {return noHp;}
    public int getPoinMember() {return poinMember;}
    public String getJenisMember() {return jenisMember;}

    // Setter

    public void setJenisMember(String jenisMember) {this.jenisMember = jenisMember;}
    public void setNamaPelanggan(String namaPelanggan) {this.namaPelanggan = namaPelanggan;}
    public void setNoHp(String noHp) {this.noHp = noHp;}
    public void setPoinMember(int poinMember) {this.poinMember = poinMember;}

    // Print out

    public void tampilkanPelanggan(){
        System.out.println(
        "ID :" + idPelanggan +
        "| Nama: " + namaPelanggan +
        "| No terdaftar: " + noHp +
        "| Poin saat ini: " + poinMember +
        "| Member adalah: "+ jenisMember);
    }

}

