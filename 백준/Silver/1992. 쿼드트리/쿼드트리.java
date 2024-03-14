import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] video;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        video = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                video[i][j] = Integer.parseInt(line[j]);
            }
        }
        compress(0, 0, N);
        System.out.print(sb);
    }

    static void compress(int x, int y, int n) {
        if (possible(x, y, n)) {
            sb.append(video[x][y]);
            return;
        }

        int smallN = n / 2;
        sb.append("(");
        compress(x, y, smallN);
        compress(x, y + smallN, smallN);
        compress(x + smallN, y, smallN);
        compress(x + smallN, y + smallN, smallN);
        sb.append(")");
    }

    static boolean possible(int x, int y, int n) {
        int v = video[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (video[i][j] != v) {
                    return false;
                }
            }
        }
        return true;
    }

}