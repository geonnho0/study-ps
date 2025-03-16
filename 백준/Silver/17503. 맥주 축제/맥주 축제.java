import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int N = parseInt(line[0]);
    int M = parseInt(line[1]);
    int K = parseInt(line[2]);
    int[][] vc = new int[K][2];
    for (int i = 0; i < K; i++) {
      line = br.readLine().split(" ");
      vc[i][0] = parseInt(line[0]);
      vc[i][1] = parseInt(line[1]);
    }

    Arrays.sort(vc, (a, b) -> {
      if (a[1] == b[1]) return b[0] - a[0];
      return a[1] - b[1];
    });


    int sum = 0;
    PriorityQueue<Integer> queue = new PriorityQueue<>();
    for (int[] beer : vc) {
      sum += beer[0];
      queue.offer(beer[0]);

      if (queue.size() > N) sum -= queue.poll();
      if (queue.size() == N && sum >= M) {
        System.out.println(beer[1]);
        return;
      }
    }
    System.out.println(-1);
  }

  static int parseInt(String s) {
    return Integer.parseInt(s);
  }

}