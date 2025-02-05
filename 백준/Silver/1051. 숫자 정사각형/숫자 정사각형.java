import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int N = Integer.parseInt(line[0]);
    int M = Integer.parseInt(line[1]);
    int[][] rectangle = new int[N][M];
    for (int i = 0; i < N; i++) {
      line = br.readLine().split("");
      for (int j = 0; j < M; j++)
        rectangle[i][j] = Integer.parseInt(line[j]);
    }
    int ans = solution(N, M, rectangle);
    System.out.println(ans);
  }

  static int solution(int N, int M, int[][] rectangle) {
    int ans = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        for (int size = 0; size + i < N && size + j < M; size++) {
          if (rectangle[i][j] == rectangle[i][j + size] &&
              rectangle[i][j] == rectangle[i + size][j] &&
              rectangle[i][j] == rectangle[i + size][j + size]) {
            ans = Math.max(ans, size + 1);
          }
        }
      }
    }
    return ans * ans;
  }

}