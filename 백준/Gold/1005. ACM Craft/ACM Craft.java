import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int K = Integer.parseInt(line[1]);
            int[] time = new int[N + 1];
            line = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                time[i + 1] = Integer.parseInt(line[i]);
            }
            List<Integer>[] edges = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                edges[i] = new ArrayList<>();
            }
            int[] d = new int[N + 1];
            for (int i = 0; i < K; i++) {
                line = br.readLine().split(" ");
                edges[Integer.parseInt(line[0])].add(Integer.valueOf(line[1]));
                d[Integer.parseInt(line[1])]++;
            }
            int[] count = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                count[i] = time[i];
            }
            int W = Integer.parseInt(br.readLine());
            boolean[] visited = new boolean[N + 1];
            while (true) {
                int start;
                for (start = 1; start <= N; start++) {
                    if (d[start] == 0 && !visited[start]) {
                        visited[start] = true;
                        break;
                    }
                }
                if (start == W) {
                    break;
                }
                for (int next : edges[start]) {
                    d[next]--;
                    count[next] = Math.max(count[next], count[start] + time[next]);
                }
            }
            System.out.println(count[W]);
        }
    }

}