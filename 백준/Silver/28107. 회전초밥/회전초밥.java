import java.io.*;
import java.util.PriorityQueue;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int N = Integer.parseInt(line[0]);
    int M = Integer.parseInt(line[1]);
    PriorityQueue<int[]> info = new PriorityQueue<>((a, b) -> {
       if (a[0] == b[0]) return a[1] - b[1];
       return a[0] - b[0];
     });
    for (int i = 0; i < N; i++) {
      line = br.readLine().split(" ");
      for (int j = 1; j < line.length; j++) info.offer(new int[]{Integer.parseInt(line[j]), i});
    }

    PriorityQueue<Integer> items = new PriorityQueue<>();
    line = br.readLine().split(" ");
    for (int i = 0; i < M; i++) items.offer(Integer.parseInt(line[i]));

    int[] answer = new int[N];
    while (!items.isEmpty()) {
      Integer item = items.poll();
      while (!info.isEmpty() && info.peek()[0] < item) {
        info.poll();
      }

      if (!info.isEmpty() && info.peek()[0] == item) {
        answer[info.poll()[1]]++;
      }
    }

    for (int a : answer) {
      System.out.printf("%d ", a);
    }
  }

}