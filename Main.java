import java.lang.Math;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        double A = 0, B = 0, i, j, c, d, e, f, g, h, D, l, m, n, t;
        int k, x, y, o, N;

        double[] z = new double[1760];
        Arrays.fill(z, 0);
        String[] b = new String[1760];
        Arrays.fill(b, " ");

        while (true) {
            clearScreen();

            for (j = 0; j < 6.28; j += 0.07) {
                for (i = 0; i < 6.28; i += 0.02) {
                    c = Math.sin(i);
                    d = Math.cos(j);
                    e = Math.sin(A);
                    f = Math.sin(j);
                    g = Math.cos(A);
                    h = d + 2;
                    D = 1 / (c*h*e + f*g + 5);
                    l = Math.cos(i);
                    m = Math.cos(B);
                    n = Math.sin(B);
                    t = c*h*g - f*e;
                    x = (int)(40 + 30*D*(l*h*m-t*n));
                    y = (int)(12 + 15*D*(l*h*n+t*m));
                    o = x + 80*y;
                    N = (int)(8 * ((f*e-c*d*g)*m - c*d*e - f*g - l*d*n));

                    if (y >= 0 && y < 22 && x >= 0 && x < 80 && D > z[o]) {
                        z[o] = D;
                        b[o] = String.valueOf(".,-~:;=!*#$@".charAt(ensureIndex(N, ".,-~:;=!*#$@".length())));
                    }
                }
            }

            System.out.print("\033[H");
            for (k = 0; k < 1760; k++) {
                System.out.print(b[k]);
                b[k] = " ";
                z[k] = 0;
                if ((k+1)%80 == 0) {
                    System.out.print("\n");
                }
            }

            A += 0.07;
            B += 0.03;
            Thread.sleep(50);
        }
    }

    public static void clearScreen() {
        System.out.print("\033[2J\033[H");
    }

    public static int ensureIndex(int index, int length) {
        int res = 0;

        if (index >= 0 && index < length) {
            res = index;
        } else if (index == length) {
            res = length - 1;
        } else if (index <= 0) {
            res = 0;
        }

        return res;
    }
}
