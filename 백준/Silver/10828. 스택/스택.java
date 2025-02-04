import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] commands = new String[N];
    for (int i = 0; i < N; i++) {
      commands[i] = br.readLine();
    }
    List<Integer> ans = solution(N, commands);
    for (int a : ans)
      System.out.println(a);
  }

  static List<Integer> solution(int N, String[] commands) {
    List<Integer> ans = new ArrayList<>();
    Stack<Integer> s = new Stack<>();
    for (String command : commands) {
      String[] line = command.split(" ");
      if (line[0].equals("push")) {
        s.push(Integer.parseInt(line[1]));
      }
      else if (line[0].equals("pop")) {
        if (s.isEmpty()) {
          ans.add(-1);
          continue;
        }
        ans.add(s.pop());
      }
      else if (line[0].equals("size")) {
        ans.add(s.size());
      }
      else if (line[0].equals("empty")) {
        ans.add(s.isEmpty() ? 1 : 0);
      }
      else {
        if (s.isEmpty()) {
          ans.add(-1);
          continue;
        }
        ans.add(s.peek());
      }
    }
    return ans;
  }

}
