import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<Roti> daftarRoti = new ArrayList<>();
        ArrayList<bahanBaku> daftarBahan = new ArrayList<>();
        ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        boolean isRunning = true;


        while (isRunning) {
            System.out.println("\n=== MANAJEMEN TOKO ROTI ===");
            System.out.println("1. Kelola Data Roti");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            int pilihanUtama = input.nextInt();
            input.nextLine();

            if (pilihanUtama == 1) {

                System.out.println("\n--- MENU ROTI ---");
                System.out.println("1. Tambah data Roti ");
                System.out.println("2. Lihat Roti  ");
                System.out.println("3 Ubah data roti ");
                System.out.println("4 Hapus data roti ");
                System.out.print( "Pilih aksi:      ");

                int menuRoti = input.nextInt();
                input.nextLine();

                if (menuRoti == 1) {

                    System.out.println("\n-- Tambah Data Roti --");
                    System.out.print("Masukkan ID Roti gabungan huruf dan angka: ");
                    String id = input.nextLine();

                    System.out.print("Masukkan Nama Roti: ");
                    String nama = input.nextLine();

                    System.out.print("Masukkan Harga: ");
                    int harga = input.nextInt();

                    System.out.print("Masukkan Stok: ");
                    int stok = input.nextInt();
                    input.nextLine();


                    Roti rotiBaru = new Roti(id, nama, harga, stok);
                    daftarRoti.add(rotiBaru);
                    System.out.println("data roti telah tertambahkan");

                } else if (menuRoti == 2) {

                    System.out.println("\n-- Daftar Roti --");
                    if (daftarRoti.isEmpty()) {
                        System.out.println("kosong wok masukan dulu data rotinya.");
                    } else {
                        for (int i = 0; i < daftarRoti.size(); i++) {
                            Roti rotiYangDipilih = daftarRoti.get(i);
                            rotiYangDipilih.tampilkaninfo();
                        }
                    }
                }else if (menuRoti == 3) {
                        // == FITUR UPDATE (U) ==
                        System.out.println("\n-- Ubah Data Roti --");
                        if (daftarRoti.isEmpty()) {
                            System.out.println("Kosong wok, belum ada data yang bisa diubah.");
                        } else {
                            for (int i = 0; i < daftarRoti.size(); i++) {
                                System.out.print((i + 1) + ". ");
                                daftarRoti.get(i).tampilkaninfo();
                            }

                            System.out.print("Pilih nomor roti yang ingin diubah: ");
                            int index = input.nextInt() - 1;
                            input.nextLine();

                            if (index >= 0 && index < daftarRoti.size()) {
                                System.out.print("Nama Roti Baru: ");
                                String namaBaru = input.nextLine();
                                System.out.print("Harga Baru: ");
                                int hargaBaru = input.nextInt();
                                System.out.print("Stok Baru: ");
                                int stokBaru = input.nextInt();
                                input.nextLine();

                                Roti rotiEdit = daftarRoti.get(index);
                                rotiEdit.setNamaRoti(namaBaru);
                                rotiEdit.setHarga(hargaBaru);
                                rotiEdit.setStok(stokBaru);

                                System.out.println("Data Roti berhasil diubah!");
                            } else {
                                System.out.println("Nomor pilihan tidak ada.");
                            }
                        }

                    } else if (menuRoti == 4) {

                        System.out.println("\n-- Hapus Data Roti --");
                        if (daftarRoti.isEmpty()) {
                            System.out.println("Kosong wok, tidak ada data yang bisa dihapus.");
                        } else {

                            for (int i = 0; i < daftarRoti.size(); i++) {
                                System.out.print((i + 1) + ". ");
                                daftarRoti.get(i).tampilkaninfo();
                            }


                            System.out.print("Pilih nomor roti yang ingin dihapus: ");
                            int index = input.nextInt() - 1;
                            input.nextLine();


                            if (index >= 0 && index < daftarRoti.size()) {
                                daftarRoti.remove(index); // Ini perintah ampuh untuk Delete!
                                System.out.println("Data Roti berhasil dihapus!");
                            } else {
                                System.out.println("Nomor pilihan tidak ada.");
                            }
                        }
                } else {
                    System.out.println("pilih yang ada aja ya");
                }

            } else if (pilihanUtama == 0) {
                System.out.println("Aku pergu");
                isRunning = false;
            } else {
                System.out.println("dibilangin pilih yang ada");
            }
        }

        input.close();
    }
}