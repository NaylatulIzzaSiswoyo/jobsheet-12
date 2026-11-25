package Jobsheet12;

public class PengunjungCafe22 {

    static void daftarPengunjung(int nomorMeja, String... namaPengunjung) {
        System.out.println("Meja nomor " + nomorMeja + ", pengunjung:");
        for (String nama : namaPengunjung) {
            System.out.println("- " + nama);
        }
    }

    static int hitungTotalBelanja(int... harga) {
        int total = 0;
        for (int h : harga) {
            total += h;
        }
        return total;
    }

    public static void main(String[] args) {
        daftarPengunjung(5, "Ali", "Budi", "Citra");

        // PERTANYAAN 4: uji dengan 1, 3, dan 5 argumen
        System.out.println("1 argumen : " + hitungTotalBelanja(15000));
        System.out.println("3 argumen : " + hitungTotalBelanja(15000, 20000, 22000));
        System.out.println("5 argumen : " + hitungTotalBelanja(15000, 20000, 22000, 12000, 10000));
    }
}