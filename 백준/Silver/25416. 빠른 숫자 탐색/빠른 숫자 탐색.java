import java.io.*;
import java.util.*;

public class Main {

    private static int solution(int r, int c, int[][] board) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c, 0});
        boolean[][] visited = new boolean[5][5];
        visited[r][c] = true;

        int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || visited[nx][ny] || board[nx][ny] == -1)
                    continue;

                if (board[nx][ny] == 1)
                    return curr[2] + 1;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, curr[2] + 1});
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[5][5];
        for (int i = 0; i < 5; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        String[] line = br.readLine().split(" ");
        int r = Integer.parseInt(line[0]);
        int c = Integer.parseInt(line[1]);

        System.out.println(solution(r, c, board));
    }
}