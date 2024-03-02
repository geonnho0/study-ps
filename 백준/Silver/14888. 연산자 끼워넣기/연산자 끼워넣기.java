import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] arr, op;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        line = br.readLine().split(" ");
        op = new int[4];
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(line[i]);
        }
        dfs(arr[0], 1);
        System.out.println(max);
        System.out.print(min);
    }

    static void dfs(int res, int index) {
        if (index == N) {
            max = Math.max(max, res);
            min = Math.min(min, res);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] == 0) {
                continue;
            }
            op[i]--;
            if (i == 0) {
                dfs(res + arr[index], index + 1);
            }
            else if (i == 1) {
                dfs(res - arr[index], index + 1);
            }
            else if (i == 2) {
                dfs(res * arr[index], index + 1);
            }
            else {
                dfs(res / arr[index], index + 1);
            }
            op[i]++;
        }
    }

}