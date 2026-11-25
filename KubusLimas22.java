import java.util.Scanner;

public class KubusLimas22{

    static int luasPersegi(int s) {
        return s * s;
    }
    static int volumeKubus(int s) {
        return s * s * s;
    }
    static int luasPermukaanKubus(int s) {
        return 6 * luasPersegi(s);            
    }
    static double volumeLimasPersegi(int s, int t) {
        return luasPersegi(s) * t / 3.0;     
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println();
            System.out.println("===== MENU PERHITUNGAN =====");
            System.out.println("1. Luas persegi");
            System.out.println("2. Volume kubus");
            System.out.println("3. Luas permukaan kubus");
            System.out.println("4. Volume limas persegi");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            pilihan = sc.nextInt();

            if (pilihan >= 1 && pilihan <= 4) {
                System.out.print("Masukkan panjang sisi: ");
                int s = sc.nextInt();
                int t = 0;
                if (pilihan == 4) {
                    System.out.print("Masukkan tinggi limas: ");
                    t = sc.nextInt();
                }

                switch (pilihan) {
                    case 1:
                        System.out.println("Luas persegi = " + luasPersegi(s));
                        break;
                    case 2:
                        System.out.println("Volume kubus = " + volumeKubus(s));
                        break;
                    case 3:
                        System.out.println("Luas permukaan kubus = " + luasPermukaanKubus(s));
                        break;
                    case 4:
                        System.out.printf("Volume limas persegi = %.2f%n", volumeLimasPersegi(s, t));
                        break;
                }
            } else if (pilihan != 0) {
                System.out.println("Pilihan tidak valid");
            }
        } while (pilihan != 0);

        System.out.println("Program selesai.");
        sc.close();
    }
}