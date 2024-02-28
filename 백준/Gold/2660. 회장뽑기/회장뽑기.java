import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] distances = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                distances[i][j] = 55;
            }
            distances[i][i] = 0;
        }
        List<Integer>[] edges = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        while (true) {
            String[] line = br.readLine().split(" ");
            if (line[0].equals("-1")) {
                break;
            }
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            distances[a][b] = 1;
            distances[b][a] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum = Math.max(sum, distances[i][j]);
            }
            min = Math.min(min, sum);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum = Math.max(sum, distances[i][j]);
            }
            if (min == sum) {
                ans.add(i);
            }
        }
        System.out.println(min + " " + ans.size());
        for (int a : ans) {
            System.out.print(a + " ");
        }
    }

}