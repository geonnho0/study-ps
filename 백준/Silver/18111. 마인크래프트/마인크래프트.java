import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] graph;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        long B = Long.parseLong(line[2]);
        graph = new int[N][M];
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < M; j++)
                graph[i][j] = Integer.parseInt(line[j]);
        }

        int time = Integer.MAX_VALUE, height = 0;
        for (int i = 0; i <= 256; i++) {
            int cost = fill(i, B);
            if (cost == -1)
                continue;
            if (time > cost) {
                time = cost;
                height = i;
            }
            else if (time == cost) {
                height = Math.max(height, i);
            }
        }
        System.out.print(time + " " + height);
    }

    static int fill(int base, long I) {
        int time = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int temp = graph[i][j] - base;
                if (temp > 0)
                    time += 2 * temp;
                else
                    time -= temp;
                I += temp;
            }
        }
        return I >= 0 ? time : -1;
    }

}