import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int TC = parseInt(br.readLine());
    while (TC-- > 0) {
      String[] line = br.readLine().split(" ");
      int N = parseInt(line[0]);
      int M = parseInt(line[1]);
      int W = parseInt(line[2]);

      List<int[]> edges = new ArrayList<>();
      for (int i = 1; i <= M; i++) {
        line = br.readLine().split(" ");
        int S = parseInt(line[0]);
        int E = parseInt(line[1]);
        int T = parseInt(line[2]);
        edges.add(new int[]{E, S, T});
        edges.add(new int[]{S, E, T});
      }

      for (int i = 1; i <= W; i++) {
        line = br.readLine().split(" ");
        int S = parseInt(line[0]);
        int E = parseInt(line[1]);
        int T = parseInt(line[2]);
        edges.add(new int[]{S, E, T * (-1)});
      }

      System.out.println(solution(N, M, W, edges));
    }
  }

  static String solution(int N, int M, int W, List<int[]> edges) {
    int[] dist = new int[N + 1];
    Arrays.fill(dist, -1);
    dist[1] = 0;

    for (int i = 0; i < N; i++) {
      for (int[] edge : edges) {
        if (dist[edge[1]] <= dist[edge[0]] + edge[2]) continue;
        dist[edge[1]] = dist[edge[0]] + edge[2];
      }
    }

    for (int[] edge : edges) {
      if (dist[edge[1]] <= dist[edge[0]] + edge[2]) continue;
      return "YES";
    }

    return "NO";
  }

  static int parseInt(String s) {
    return Integer.parseInt(s);
  }

}
