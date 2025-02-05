import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] sticks = new int[N];
    for (int i = 0;i < N; i++)
      sticks[i] = Integer.parseInt(br.readLine());
    int ans = solution(N, sticks);
    System.out.println(ans);
  }

  static int solution(int N, int[] sticks) {
    int ans = 0;
    int curr = 0;
    for (int i = N - 1; i >= 0; i--) {
      int stick = sticks[i];
      if (curr < stick) {
        ans++;
        curr = stick;
      }
    }
    return ans;
  }

}
