import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int R, C, c = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        R = Integer.parseInt(line[1]);
        C = Integer.parseInt(line[2]);
        search(0, 0, N);
    }

    static void search(int x, int y, int n) {
        if (n == 1) {
            if (x == R && y == C) {
                System.out.print(c);
            }
            else if (x == R && y + 1 == C) {
                System.out.print(c + 1);
            }
            else if (x + 1 == R && y == C) {
                System.out.print(c + 2);
            }
            else if (x + 1 == R && y + 1 == C) {
                System.out.print(c + 3);
            }
            return;
        }
        int len = (int) Math.pow(2, n - 1), count = len * len;
        if (x + len > R && y + len > C) {
            search(x, y, n - 1);
        }
        else if (x + len > R && y + len <= C) {
            c += count;
            search(x, y + len, n - 1);
        }
        else if (x + len <= R && y + len > C) {
            c += 2 * count;
            search(x + len, y, n - 1);
        }
        else {
            c += 3 * count;
            search(x + len, y + len, n - 1);
        }
    }

}