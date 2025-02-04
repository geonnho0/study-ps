import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int N = Integer.parseInt(line[0]);
    int M = Integer.parseInt(line[1]);
    char[][] board = new char[N][M];
    for (int i = 0; i < N; i++) {
      line = br.readLine().split("");
      for (int j = 0; j < M; j++)
        board[i][j] = line[j].charAt(0);
    }
    int ans = solution(N, M, board);
    System.out.println(ans);
  }

  static int solution(int N, int M, char[][] board) {
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < N - 7; i++) {
      for (int j = 0; j < M - 7; j++) {
        ans = Math.min(ans, fillColor(i, j, board));
      }
    }
    return ans;
  }

  static int fillColor(int X, int Y, char[][] board) {
    int count = 0;
    char color = board[X][Y];

    for (int i = X; i < X + 8; i++) {
      for (int j = Y; j < Y + 8; j++) {
        if (board[i][j] != color) count++;

        color = color == 'W' ? 'B' : 'W';
      }
      color = color == 'W' ? 'B' : 'W';
    }

    return Math.min(count, 64 - count);
  }

}
