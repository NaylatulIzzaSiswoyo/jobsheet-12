import java.util.Scanner;

public class HitungBalok22 {
    static int hitungLuas(int pjg, int lb) {
        return pjg * lb;
    }

    static int hitungVolume(int tinggi, int a, int b) {
        return hitungLuas(a, b) * tinggi;
    }

    static int hitungLuasPermukaanBalok(int p, int l, int t) {
        return 2 * (hitungLuas(p, l) + hitungLuas(p, t) + hitungLuas(l, t));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p, l, t;
        int[][] balok = { {4, 3, 5}, {2, 2, 2}, {10, 5, 2} };

        for (int[] b : balok) {
            int pp = b[0], ll = b[1], tt = b[2];
            System.out.println("Balok " + pp + "x" + ll + "x" + tt
                + " -> Luas permukaan: " + hitungLuasPermukaanBalok(pp, ll, tt)
                + ", Volume: " + hitungVolume(tt, pp, ll));
        }

        System.out.println("Masukkan panjang");
        p = sc.nextInt();

        System.out.println("Masukkan lebar");
        l = sc.nextInt();

        System.out.println("Masukkan tinggi");
        t = sc.nextInt();

        System.out.println("Luas persegi panjang adalah " + hitungLuas(p, l));
        System.out.println("Luas permukaan balok adalah " + hitungLuasPermukaanBalok(p, l, t));
        System.out.println("Volume balok adalah " + hitungVolume(t, p, l));

        sc.close();
    }
}