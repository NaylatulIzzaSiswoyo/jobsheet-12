import java.util.Scanner;

public class BankSampah22 {

    static Scanner sc = new Scanner(System.in);

    static double[] inputSetoran(int n) {
        double[] setoran = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Berat setoran nasabah " + (i + 1) + " (kg): ");
            setoran[i] = sc.nextDouble();
        }
        return setoran;
    }

    static void tampilSetoran(double[] setoran) {
        System.out.println("=== Data Setoran ===");
        for (int i = 0; i < setoran.length; i++) {
            System.out.println("Nasabah " + (i + 1) + ": " + setoran[i] + " kg");
        }
    }

    static double totalSetoran(double[] setoran) {
        double total = 0;
        for (double s : setoran) {
            total += s;
        }
        return total;
    }

    static double hitungSaldo(double berat, double hargaPerKg) {
        return berat * hargaPerKg;
    }

    static int nasabahTerbanyak(double[] setoran) {
        int idxMax = 0;
        for (int i = 1; i < setoran.length; i++) {
            if (setoran[i] > setoran[idxMax]) {
                idxMax = i;
            }
        }
        return idxMax;
    }

    public static void main(String[] args) {
        final double HARGA_PER_KG = 3000;

        System.out.print("Jumlah nasabah: ");
        int n = sc.nextInt();

        double[] setoran = inputSetoran(n);

        System.out.println();
        tampilSetoran(setoran);

        System.out.println();
        System.out.println("=== Saldo Nasabah (Rp3.000/kg) ===");
        for (int i = 0; i < setoran.length; i++) {
            double saldo = hitungSaldo(setoran[i], HARGA_PER_KG);
            System.out.printf("Nasabah %d: Rp%,.0f%n", i + 1, saldo);
        }

        double total = totalSetoran(setoran);
        System.out.println();
        System.out.println("Total berat setoran: " + total + " kg");

        int idx = nasabahTerbanyak(setoran);
        System.out.println("Setoran terbanyak: Nasabah " + (idx + 1)
                + " (" + setoran[idx] + " kg)");

        sc.close();
    }
}