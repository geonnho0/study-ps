import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int N = Integer.parseInt(line[0]);
    int M = Integer.parseInt(line[1]);
    List<int[]> edges = new ArrayList<>();
    for (int i = 0; i < M; i++) {
      line = br.readLine().split(" ");
      edges.add(new int[]{
          Integer.parseInt(line[0]),
          Integer.parseInt(line[1]),
          Integer.parseInt(line[2])
      });
    }
    long[] ans = solution(N, M, edges);
    for (long a : ans) {
      System.out.println(a);
    }
  }

  public static long[] solution(int N, int M, List<int[]> edges) {
    long[] dist = new long[N + 1];
    Arrays.fill(dist, Long.MAX_VALUE);
    dist[1] = 0;

    for (int i = 1; i <= N; i++) {
      for (int[] edge : edges) {
        if (dist[edge[0]] == Long.MAX_VALUE) continue;

        if (dist[edge[1]] > dist[edge[0]] + edge[2]) {
          dist[edge[1]] = dist[edge[0]] + edge[2];

          if (i == N) {
            return new long[]{ -1 };
          }
        }
      }
    }
    
    long[] ans = new long[N - 1];
    for (int i = 2; i <= N; i++) {
      ans[i - 2] = dist[i];
      if (dist[i] == Long.MAX_VALUE) ans[i - 2] = -1;
    }
    return ans;
  }
}