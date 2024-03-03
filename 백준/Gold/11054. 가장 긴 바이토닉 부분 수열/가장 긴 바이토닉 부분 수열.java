import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(line[i]);
        }

        int[] up = new int[N];
        for (int i = 0; i < N; i++) {
            up[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (A[j] < A[i] && up[i] < up[j] + 1) {
                    up[i] = up[j] + 1;
                }
            }
        }

        int[] down = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            down[i] = 1;
            for (int j = N - 1; j >= i; j--) {
                if (A[i] > A[j] && down[i] < down[j] + 1) {
                    down[i] = down[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, up[i] + down[i]);
        }
        System.out.print(max - 1);
    }

}