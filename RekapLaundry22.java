import java.util.Scanner;

public class RekapLaundry22 {

    static int[][] inputData(Scanner sc, String[] layanan, int jumlahHari) {
        int[][] data = new int[layanan.length][jumlahHari];
        for (int i = 0; i < layanan.length; i++) {
            System.out.println("Layanan: " + layanan[i]);
            for (int j = 0; j < jumlahHari; j++) {
                System.out.print("  Berat cucian Hari ke-" + (j + 1) + " (kg): ");
                data[i][j] = sc.nextInt();
            }
        }
        return data;
    }

    static void tampilTabel(int[][] data, String[] layanan, int[] harga) {
        System.out.printf("%-14s%10s", "Layanan", "Harga/kg");
        for (int j = 0; j < data[0].length; j++) {
            System.out.printf("%10s", "Hari ke-" + (j + 1));
        }
        System.out.println();
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%-14s%10d", layanan[i], harga[i]);
            for (int j = 0; j < data[i].length; j++) {
                System.out.printf("%10d", data[i][j]);
            }
            System.out.println();
        }
    }

    static int totalPerLayanan(int[][] data, int idxLayanan) {
        int total = 0;
        for (int berat : data[idxLayanan]) {
            total += berat;
        }
        return total;
    }

    static void tampilLayananTertinggi(int[][] data, String[] layanan) {
        int idxMax = 0;
        for (int i = 1; i < data.length; i++) {
            if (totalPerLayanan(data, i) > totalPerLayanan(data, idxMax)) {
                idxMax = i;
            }
        }
        System.out.println("Layanan dengan cucian tertinggi: " + layanan[idxMax]
                + " (" + totalPerLayanan(data, idxMax) + " kg)");
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

    static void tampilPendapatan(int[][] data, String[] layanan, int[] harga) {
        int totalSemua = 0;
        for (int i = 0; i < data.length; i++) {
            int pendapatan = totalPerLayanan(data, i) * harga[i];
            System.out.println(layanan[i] + ": Rp" + pendapatan);
            totalSemua += pendapatan;
        }
        System.out.println("Total pendapatan: Rp" + totalSemua);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Jumlah layanan: ");
        int jumlahLayanan = sc.nextInt();
        System.out.print("Jumlah hari: ");
        int jumlahHari = sc.nextInt();
        sc.nextLine(); // buang sisa enter

        String[] layanan = new String[jumlahLayanan];
        int[] harga = new int[jumlahLayanan];
        for (int i = 0; i < jumlahLayanan; i++) {
            System.out.print("Nama layanan ke-" + (i + 1) + ": ");
            layanan[i] = sc.nextLine();
            System.out.print("Harga per kg: ");
            harga[i] = sc.nextInt();
            sc.nextLine();
        }

        int[][] data = inputData(sc, layanan, jumlahHari);

        System.out.println();
        tampilTabel(data, layanan, harga);

        System.out.println();
        for (int i = 0; i < jumlahLayanan; i++) {
            System.out.println("Total " + layanan[i] + ": " + totalPerLayanan(data, i) + " kg");
        }

        System.out.println();
        tampilLayananTertinggi(data, layanan);
        System.out.println("Hari tersibuk: Hari ke-" + (hariTersibuk(data) + 1));

        System.out.println();
        tampilPendapatan(data, layanan, harga);

        sc.close();
    }
}