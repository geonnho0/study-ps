import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < M; j++)
                board[i][j] = Integer.parseInt(line[j]);
        }
        int[] answer = solution(N, M, board);
        System.out.println(answer[0] + "\n" + answer[1]);
    }

    private static int[][] board;
    private static int N, M;
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    private static int[] solution(int n, int m, int[][] boards) {
        N = n;
        M = m;
        board = boards;

        int totalCheeseCount = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (board[i][j] == 1)
                    totalCheeseCount++;

        int time = 0;
        while (true) {
            int cheeseCount = countCheeseForMelting();

            if (totalCheeseCount == cheeseCount)
                break;

            totalCheeseCount -= cheeseCount;
            time++;
        }
        return new int[]{time + 1, totalCheeseCount};
    }

    private static int countCheeseForMelting() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        int count = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny])
                    continue;

                visited[nx][ny] = true;
                if (board[nx][ny] == 0) {
                    q.offer(new int[]{nx, ny});
                    continue;
                }
                board[nx][ny] = 0;
                count++;
            }
        }
        return count;
    }
}