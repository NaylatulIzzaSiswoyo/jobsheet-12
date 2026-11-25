import java.util.Scanner;

public class RekapLaundry22 {

    static String[] namaLayanan = {"Cuci Kering", "Cuci Setrika", "Setrika Saja", "Express"};
    static int[] hargaPerKg = {6000, 8000, 5000, 12000};
    static String[] namaHari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};

    static int[][] data = new int[4][6];

   
    static void inputData(Scanner sc) {
        System.out.println("=== INPUT BERAT CUCIAN (kg) ===");
        for (int i = 0; i < namaLayanan.length; i++) {
            for (int j = 0; j < namaHari.length; j++) {
                System.out.print(namaLayanan[i] + " - " + namaHari[j] + " : ");
                data[i][j] = sc.nextInt();
            }
        }
    }

    static void tampilkanTabel() {
        System.out.println("\n=== REKAP BERAT CUCIAN (kg) ===");
        System.out.printf("%-15s %-10s", "Layanan", "Harga/kg");
        for (String h : namaHari) {
            System.out.printf("%8s", h);
        }
        System.out.println();
        System.out.println("-".repeat(25 + 8 * namaHari.length));

        for (int i = 0; i < namaLayanan.length; i++) {
            System.out.printf("%-15s Rp%-8d", namaLayanan[i], hargaPerKg[i]);
            for (int j = 0; j < namaHari.length; j++) {
                System.out.printf("%8d", data[i][j]);
            }
            System.out.println();
        }
    }

    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int j = 0; j < data[idxLayanan].length; j++) {
            total += data[idxLayanan][j];
        }
        return total;
    }

    static void tampilkanLayananTertinggi() {
        int idxMax = 0;
        for (int i = 1; i < data.length; i++) {
            if (totalPerLayanan(data, i) > totalPerLayanan(data, idxMax)) {
                idxMax = i;
            }
        }
        System.out.println("\nLayanan dengan total cucian tertinggi: "
                + namaLayanan[idxMax] + " (" + totalPerLayanan(data, idxMax) + " kg)");
    }

    static int hariTersibuk(int[][] data) {
        int idxMax = 0;
        int totalMax = -1;
        for (int j = 0; j < data[0].length; j++) {
            int total = 0;
            for (int i = 0; i < data.length; i++) {
                total += data[i][j];
            }
            if (total > totalMax) {
                totalMax = total;
                idxMax = j;
            }
        }
        return idxMax;
    }

    static void hitungPendapatan() {
        System.out.println("\n=== PENDAPATAN ===");
        long totalPendapatan = 0;
        for (int i = 0; i < namaLayanan.length; i++) {
            long pendapatan = (long) totalPerLayanan(data, i) * hargaPerKg[i];
            totalPendapatan += pendapatan;
            System.out.printf("%-15s : Rp%,d%n", namaLayanan[i], pendapatan);
        }
        System.out.printf("%-15s : Rp%,d%n", "TOTAL", totalPendapatan);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        inputData(sc);
        tampilkanTabel();

        System.out.println("\n=== TOTAL BERAT PER LAYANAN ===");
        for (int i = 0; i < namaLayanan.length; i++) {
            System.out.println(namaLayanan[i] + " : " + totalPerLayanan(data, i) + " kg");
        }

        tampilkanLayananTertinggi();

        int idxHari = hariTersibuk(data);
        System.out.println("Hari tersibuk: " + namaHari[idxHari] + " (indeks " + idxHari + ")");

        hitungPendapatan();

        sc.close();
    }
}