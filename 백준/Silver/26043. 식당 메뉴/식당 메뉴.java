import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Queue<int[]> q = new LinkedList<>();
    List<Integer>[] ans = new List[3];
    for (int i = 0; i < 3; i++) ans[i] = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      String[] line = br.readLine().split(" ");
      if (line[0].equals("1")) {
        q.offer(new int[]{
            Integer.parseInt(line[1]),
            Integer.parseInt(line[2])
        });
        continue;
      }
      int[] student = q.poll();
      if (student[1] == Integer.parseInt(line[1])) {
        ans[0].add(student[0]);
      } else {
        ans[1].add(student[0]);
      }
    }

    while (!q.isEmpty()) {
      ans[2].add(q.poll()[0]);
    }

    StringBuilder sb = new StringBuilder();
    if (!ans[0].isEmpty()) {
      Collections.sort(ans[0]);
      for (int a : ans[0]) sb.append(a).append(" ");
    } else {
      sb.append("None");
    }
    sb.append("\n");

    if (!ans[1].isEmpty()) {
      Collections.sort(ans[1]);
      for (int b : ans[1]) sb.append(b).append(" ");
    } else {
      sb.append("None");
    }
    sb.append("\n");

    if (!ans[2].isEmpty()) {
      Collections.sort(ans[2]);
      for (int c : ans[2]) sb.append(c).append(" ");
    } else {
      sb.append("None");
    }
    System.out.println(sb);
  }

}