import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

  static int[][] lab;
  static int n, m;
  static int answer = 0;
  static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};

  public static int solution(int N, int M, int[][] board) {
    lab = board;
    n = N;
    m = M;
    setWallAndSearch(0);
    return answer;
  }

  static void setWallAndSearch(int count) {
    if (count == 3) {
      search();
      return;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (lab[i][j] == 0) {
          lab[i][j] = 1;
          setWallAndSearch(count + 1);
          lab[i][j] = 0;
        }
      }
    }
  }

  static void search() {
    int wallCount = 0;
    int virusCount = 0;
    int[][] temp = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        temp[i][j] = lab[i][j];
      }
    }

    boolean[][] visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (temp[i][j] == 1)
          wallCount++;
        if (temp[i][j] == 2 && !visited[i][j]) {
          virusCount += spreadVirus(i, j, temp, visited);
        }
      }
    }

    answer = Math.max(answer, n * m - (wallCount + virusCount));
  }

  static int spreadVirus(int i, int j, int[][] temp, boolean[][] visited) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{i, j});
    visited[i][j] = true;

    int count = 1;
    while (!q.isEmpty()) {
      int[] curr = q.poll();

      for (int k = 0; k < 4; k++) {
        int nx = curr[0] + dx[k], ny = curr[1] + dy[k];

        if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || temp[nx][ny] != 0) continue;

        visited[nx][ny] = true;
        q.add(new int[]{nx, ny});
        temp[nx][ny] = 2;
        count++;
      }
    }

    return count;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int n = Integer.parseInt(line[0]);
    int m = Integer.parseInt(line[1]);
    int[][] board = new int[n][m];
    for (int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 0; j < m; j++) {
        board[i][j] = Integer.parseInt(input[j]);
      }
    }
    System.out.println(solution(n, m, board));
  }
}