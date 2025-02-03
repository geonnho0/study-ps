import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] arr = br.readLine().split(" ");
    int N = Integer.parseInt(arr[0]);
    int K = Integer.parseInt(arr[1]);
    int ans = solution(N, K);
    System.out.println(ans);
  }

  static int[] dist;
  static int MAX = 100000;

  static int solution(int N, int K) {
    dist = new int[MAX + 1];
    return bfs(N, K);
  }

  static int bfs(int N, int K) {
    Queue<Integer> q = new LinkedList<>();
    q.offer(N);

    while (!q.isEmpty()) {
      int curr = q.poll();

      if (curr == K)
        return dist[curr];

      int minus = curr - 1;
      if (minus >= 0 && dist[minus] == 0) {
        dist[minus] = dist[curr] + 1;
        q.offer(minus);
      }

      int plus = curr + 1;
      if (plus <= MAX && dist[plus] == 0) {
        dist[plus] = dist[curr] + 1;
        q.offer(plus);
      }

      int multiple = curr * 2;
      if (multiple <= MAX && dist[multiple] == 0) {
        dist[multiple] = dist[curr] + 1;
        q.offer(multiple);
      }
    }
    return -1;
  }
}
