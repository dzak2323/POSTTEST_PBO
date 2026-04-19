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
            System.out.println(ansi().fg(Ansi.Color.CYAN).a("2. Kelola Data Bahan Baku").reset());
            System.out.println(ansi().fg(Ansi.Color.CYAN).a("0. Keluar").reset());
            System.out.print(ansi().fg(Ansi.Color.GREEN).a("Pilih menu: ").reset());

            int pilihanUtama = input.nextInt();
            input.nextLine();

            if (pilihanUtama == 1) {
                System.out.println(ansi().fg(Ansi.Color.GREEN).a("\n--- MENU ROTI ---").reset());
                System.out.println(ansi().fg(Ansi.Color.CYAN).a("1. Tambah data Roti ").reset());
                System.out.println(ansi().fg(Ansi.Color.CYAN).a("2. Lihat Roti  ").reset());
                System.out.println(ansi().fg(Ansi.Color.CYAN).a("3. Ubah data Roti ").reset());
                System.out.println(ansi().fg(Ansi.Color.CYAN).a("4. Hapus data Roti ").reset());
                System.out.print(ansi().fg(Ansi.Color.GREEN).a("Pilih aksi: ").reset());

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

                    System.out.println(ansi().fg(Ansi.Color.YELLOW).a("\nPilih Kategori Roti:").reset());
                    System.out.println("1. Roti Manis (Isian)");
                    System.out.println("2. Roti Tawar (Irisan)");
                    System.out.println("3. Kue Tart (Ukuran)");
                    System.out.print(ansi().fg(Ansi.Color.GREEN).a("Pilih Kategori (1-3): ").reset());
                    int kategori = input.nextInt();
                    input.nextLine();

                    if (kategori == 1) {
                        System.out.print("Masukkan Rasa Isian: ");
                        String isian = input.nextLine();
                        daftarRoti.add(new RotiManis(id, nama, harga, stok, isian));
                    } else if (kategori == 2) {
                        System.out.print("Masukkan Jumlah Irisan (angka): ");
                        int irisan = input.nextInt();
                        input.nextLine();
                        daftarRoti.add(new RotiTawar(id, nama, harga, stok, irisan));
                    } else if (kategori == 3) {
                        System.out.print("Masukkan Ukuran Loyang (contoh: 20cm): ");
                        String ukuran = input.nextLine();
                        daftarRoti.add(new KueTart(id, nama, harga, stok, ukuran));
                    } else {
                        System.out.println(ansi().fg(Ansi.Color.RED).a("Kategori tidak valid! Disimpan sebagai Roti Tawar tanpa irisan.").reset());
                        daftarRoti.add(new RotiTawar(id, nama, harga, stok, 0));
                    }
                    System.out.println(ansi().fg(Ansi.Color.GREEN).a("data roti telah tertambahkan").reset());

                } else if (menuRoti == 2) {
                    System.out.println(ansi().fg(Ansi.Color.GREEN).a("\n-- Daftar Roti --").reset());
                    if (daftarRoti.isEmpty()) {
                        System.out.println(ansi().fg(Ansi.Color.RED).a("kosong wok masukan dulu data rotinya.").reset());
                    } else {
                        for (int i = 0; i < daftarRoti.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            daftarRoti.get(i).tampilkaninfo();
                        }
                    }
                } else if (menuRoti == 3) {
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
                            System.out.println("Pilih Metode Update Harga:");
                            System.out.println("1. Input Harga Baru (Normal)");
                            System.out.println("2. Kenaikan Harga (%)");
                            int metode = input.nextInt();

                            Roti r = daftarRoti.get(index);
                            if (metode == 1) {
                                System.out.print("Harga Baru: ");
                                r.setHarga(input.nextInt());
                            } else {
                                System.out.print("Persentase Naik (misal 0.1 untuk 10%): ");
                                r.setHarga(input.nextDouble(), true);
                            }
                            input.nextLine();
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

            } else if (pilihanUtama == 2) {
                System.out.println(ansi().fg(Ansi.Color.GREEN).a("\n--- MENU BAHAN BAKU ---").reset());
                System.out.println(ansi().fg(Ansi.Color.CYAN).a("1. Tambah Data Bahan").reset());
                System.out.println(ansi().fg(Ansi.Color.CYAN).a("2. Lihat Data Bahan").reset());
                System.out.println(ansi().fg(Ansi.Color.CYAN).a("3. Update Stok Bahan").reset());
                System.out.print(ansi().fg(Ansi.Color.GREEN).a("Pilih aksi: ").reset());

                int menuBahan = input.nextInt();
                input.nextLine();

                if (menuBahan == 1) {
                    System.out.print("ID Bahan: "); String id = input.nextLine();
                    System.out.print("Nama Bahan: "); String nama = input.nextLine();
                    System.out.print("Kategori: "); String kategoriStr = input.nextLine();
                    System.out.print("Stok: "); double stok = input.nextDouble();
                    input.nextLine();
                    System.out.print("Satuan (Kg/Liter/dll): "); String satuan = input.nextLine();

                    System.out.println(ansi().fg(Ansi.Color.YELLOW).a("\nPilih Tipe Bahan:").reset());
                    System.out.println("1. Bahan Kering");
                    System.out.println("2. Bahan Basah");
                    System.out.print("Pilih (1-2): ");
                    int tipeBahan = input.nextInt();
                    input.nextLine();

                    if (tipeBahan == 1) {
                        System.out.print("Tempat Simpan (Contoh: Rak A): ");
                        String tempat = input.nextLine();
                        daftarBahan.add(new BahanKering(id, nama, kategoriStr, stok, satuan, tempat));
                    } else if (tipeBahan == 2) {
                        System.out.print("Suhu Ideal Kulkas (Celcius): ");
                        int suhu = input.nextInt();
                        input.nextLine();
                        daftarBahan.add(new BahanBasah(id, nama, kategoriStr, stok, satuan, suhu));
                    } else {
                        daftarBahan.add(new bahanBaku(id, nama, kategoriStr, stok, satuan));
                    }
                    System.out.println(ansi().fg(Ansi.Color.GREEN).a("Bahan baku berhasil ditambahkan!").reset());

                } else if (menuBahan == 2) {
                    if (daftarBahan.isEmpty()) {
                        System.out.println(ansi().fg(Ansi.Color.RED).a("Data bahan kosong.").reset());
                    } else {
                        for (int i = 0; i < daftarBahan.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            daftarBahan.get(i).tampilkanBahan();
                            System.out.println("   └─ Instruksi: " + daftarBahan.get(i).getInstruksiPenyimpanan());
                        }
                    }
                } else if (menuBahan == 3) {
                    if (daftarBahan.isEmpty()) {
                        System.out.println(ansi().fg(Ansi.Color.RED).a("Data bahan kosong.").reset());
                    } else {
                        for (int i = 0; i < daftarBahan.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            daftarBahan.get(i).tampilkanBahan();
                        }
                        System.out.print(ansi().fg(Ansi.Color.GREEN).a("Pilih nomor bahan: ").reset());
                        int idx = input.nextInt() - 1;
                        input.nextLine();

                        if (idx >= 0 && idx < daftarBahan.size()) {
                            System.out.println("Pilih Metode Update Stok:");
                            System.out.println("1. Timpa Stok Baru (Audit)");
                            System.out.println("2. Tambah/Kurang Stok (Barang Keluar/Masuk)");
                            int metodeStok = input.nextInt();

                            bahanBaku b = daftarBahan.get(idx);
                            if (metodeStok == 1) {
                                System.out.print("Jumlah Stok Final: ");
                                b.setStok(input.nextDouble());
                            } else {
                                System.out.print("Jumlah Tambah/Kurang: ");
                                double jumlah = input.nextDouble();
                                System.out.print("Ketik 1 untuk Tambah, 2 untuk Kurang: ");
                                int jenis = input.nextInt();
                                b.setStok(jumlah, jenis == 1);
                            }
                            input.nextLine();
                            System.out.println(ansi().fg(Ansi.Color.GREEN).a("Stok berhasil diupdate!").reset());
                        } else {
                            System.out.println(ansi().fg(Ansi.Color.RED).a("Pilihan tidak valid.").reset());
                        }
                    }
                } else {
                    System.out.println(ansi().fg(Ansi.Color.RED).a("Pilihan tidak valid.").reset());
                }

            } else if (pilihanUtama == 0) {
                System.out.println(ansi().fg(Ansi.Color.GREEN).a("Aku pergi").reset());
                isRunning = false;
            } else {
                System.out.println(ansi().fg(Ansi.Color.RED).a("dibilangin pilih yang ada").reset());
            }
        }
        input.close();
        AnsiConsole.systemUninstall();
    }
}