import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[2001][2001];
        long[][] arr2 = new long[2][2001];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr2[0][i] = Integer.parseInt(line[i]);
        }
        line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr2[1][i] = Integer.parseInt(line[i]);
        }

        long maxAns = 0, maxB = 0, maxE = 0;
        for (int B = 0; B < N; B++) {
            for (int E = 0; E < N; E++) {
                if (B + E >= N) {
                    break;
                }

                if (B == 0 && E == 0) {
                    for (int i = 0; i < N; i++) {
                        arr[0][0] += (arr2[0][i] * arr2[1][N - 1 - i]);
                    }
                    maxAns = arr[0][0];
                    maxB = B;
                    maxE = E;
                }
                else if (B > 0 && E > 0) {
                    arr[B][E] = arr[B - 1][E - 1] - (arr2[0][B - 1] * arr2[1][N - E] + arr2[0][N - E] * arr2[1][B - 1]);
                }
                else {
                    if (B == 0) {
                        for (int i = 0; i < N - E; i++) {
                            arr[B][E] += (arr2[0][i] * arr2[1][N - 1 - E - i]);
                        }
                    }
                    else {
                        for (int i = 0; i < N - B; i++) {
                            arr[B][E] += (arr2[0][i + B] * arr2[1][N - 1 - i]);
                        }
                    }
                }
                if (maxAns < arr[B][E]) {
                    maxAns = arr[B][E];
                    maxB = B;
                    maxE = E;
                }
            }
        }
        System.out.println(maxB + " " + maxE);
        System.out.println(maxAns);
    }
    
}