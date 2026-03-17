import java.util.ArrayList;
import java.util.Scanner;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import static org.fusesource.jansi.Ansi.*;


public class Main {



    public static void main(String[] args) {
        System.setProperty("jansi.force", "true");
        AnsiConsole.systemInstall();

        ArrayList<Roti> daftarRoti = new ArrayList<>();
        ArrayList<bahanBaku> daftarBahan = new ArrayList<>();
        ArrayList<Pelanggan> daftarPelanggan = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        boolean isRunning = true;


        while (isRunning) {
            System.out.println(ansi().fg(Ansi.Color.GREEN).a("\n=== MANAJEMEN TOKO ROTI ===").reset());
            System.out.println(ansi().fg(Ansi.Color.CYAN).a("1. Kelola Data Roti").reset());
            System.out.println(ansi().fg(Ansi.Color.CYAN).a("0. Keluar").reset());
            System.out.print(ansi().fg(Ansi.Color.GREEN).a("Pilih menu: ").reset());

            int pilihanUtama = input.nextInt();
            input.nextLine();

            if (pilihanUtama == 1) {

                System.out.println(ansi().fg(Ansi.Color.GREEN).a("\n--- MENU ROTI ---").reset());
                System.out.println(ansi().fg(Ansi.Color.CYAN).a("1. Tambah data Roti ").reset());
                System.out.println(ansi().fg(Ansi.Color.CYAN).a("2. Lihat Roti  ").reset());
                System.out.println(ansi().fg(Ansi.Color.CYAN).a("3 Ubah data roti ").reset());
                System.out.println(ansi().fg(Ansi.Color.CYAN).a("4 Hapus data roti ").reset());
                System.out.print(ansi().fg(Ansi.Color.GREEN).a( "Pilih aksi: ").reset());

                int menuRoti = input.nextInt();
                input.nextLine();

                if (menuRoti == 1) {
                    System.out.println(ansi().fg(Ansi.Color.GREEN).a("\n-- Tambah Data Roti --").reset());
                    System.out.print(ansi().fg(Ansi.Color.GREEN).a("Masukkan ID Roti gabungan huruf dan angka: ").reset());
                    String id = input.nextLine();

                    System.out.print(ansi().fg(Ansi.Color.GREEN).a("Masukkan Nama Roti: ").reset());
                    String nama = input.nextLine();

                    System.out.print(ansi().fg(Ansi.Color.GREEN).a("Masukkan Harga: ").reset());
                    int harga = input.nextInt();

                    System.out.print(ansi().fg(Ansi.Color.GREEN).a("Masukkan Stok: ").reset());
                    int stok = input.nextInt();
                    input.nextLine();


                    Roti rotiBaru = new Roti(id, nama, harga, stok);
                    daftarRoti.add(rotiBaru);
                    System.out.println(ansi().fg(Ansi.Color.GREEN).a("data roti telah tertambahkan").reset());

                } else if (menuRoti == 2) {
                    System.out.println(ansi().fg(Ansi.Color.GREEN).a("\n-- Daftar Roti --").reset());
                    if (daftarRoti.isEmpty()) {
                        System.out.println(ansi().fg(Ansi.Color.RED).a("kosong wok masukan dulu data rotinya.").reset());
                    } else {
                        for (int i = 0; i < daftarRoti.size(); i++) {
                            Roti rotiYangDipilih = daftarRoti.get(i);
                            rotiYangDipilih.tampilkaninfo();
                        }
                    }
                }else if (menuRoti == 3) {
                        System.out.println(ansi().fg(Ansi.Color.GREEN).a("\n-- Ubah Data Roti --").reset());
                        if (daftarRoti.isEmpty()) {
                            System.out.println(ansi().fg(Ansi.Color.RED).a("Kosong wok, belum ada data yang bisa diubah.").reset());
                        } else {
                            for (int i = 0; i < daftarRoti.size(); i++) {
                                System.out.print((i + 1) + ". ");
                                daftarRoti.get(i).tampilkaninfo();
                            }

                            System.out.print(ansi().fg(Ansi.Color.GREEN).a("Pilih nomor roti yang ingin diubah: ").reset());
                            int index = input.nextInt() - 1;
                            input.nextLine();

                            if (index >= 0 && index < daftarRoti.size()) {
                                System.out.print(ansi().fg(Ansi.Color.GREEN).a("Nama Roti Baru: ").reset());
                                String namaBaru = input.nextLine();
                                System.out.print(ansi().fg(Ansi.Color.GREEN).a("Harga Baru: ").reset());
                                int hargaBaru = input.nextInt();
                                System.out.print(ansi().fg(Ansi.Color.GREEN).a("Stok Baru: ").reset());
                                int stokBaru = input.nextInt();
                                input.nextLine();

                                Roti rotiEdit = daftarRoti.get(index);
                                rotiEdit.setNamaRoti(namaBaru);
                                rotiEdit.setHarga(hargaBaru);
                                rotiEdit.setStok(stokBaru);

                                System.out.println(ansi().fg(Ansi.Color.GREEN).a("Data Roti berhasil diubah!").reset());
                            } else {
                                System.out.println(ansi().fg(Ansi.Color.RED).a("Nomor pilihan tidak ada.").reset());
                            }
                        }

                    } else if (menuRoti == 4) {

                        System.out.println(ansi().fg(Ansi.Color.GREEN).a("\n-- Hapus Data Roti --").reset());
                        if (daftarRoti.isEmpty()) {
                            System.out.println(ansi().fg(Ansi.Color.RED).a("Kosong wok, tidak ada data yang bisa dihapus.").reset());
                        } else {

                            for (int i = 0; i < daftarRoti.size(); i++) {
                                System.out.print((i + 1) + ". ");
                                daftarRoti.get(i).tampilkaninfo();
                            }


                            System.out.print(ansi().fg(Ansi.Color.GREEN).a("Pilih nomor roti yang ingin dihapus: ").reset());
                            int index = input.nextInt() - 1;
                            input.nextLine();


                            if (index >= 0 && index < daftarRoti.size()) {
                                daftarRoti.remove(index);
                                System.out.println(ansi().fg(Ansi.Color.GREEN).a("Data Roti berhasil dihapus!").reset());
                            } else {
                                System.out.println(ansi().fg(Ansi.Color.RED).a("Nomor pilihan tidak ada.").reset());
                            }
                        }
                } else {
                    System.out.println(ansi().fg(Ansi.Color.RED).a("pilih yang ada aja ya").reset());
                }

            } else if (pilihanUtama == 0) {
                System.out.println(ansi().fg(Ansi.Color.GREEN).a("Aku pergi").reset());
                isRunning = false;
            } else {
                System.out.println(ansi().fg(Ansi.Color.RED).a("dibilangin pilih yang ada").reset());
            }
        }

        input.close();
    }
}