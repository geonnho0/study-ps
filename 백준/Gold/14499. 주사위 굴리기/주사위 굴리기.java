import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};
    static int[][] dice = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        map = new int[N][M];
        int x = Integer.parseInt(line[2]), y = Integer.parseInt(line[3]);
        int K = Integer.parseInt(line[4]);
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
        line = br.readLine().split(" ");
        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(line[i]) - 1;
            int nextX = x + dx[dir], nextY = y + dy[dir];
            if (!valid(nextX, nextY)) {
                continue;
            }
            roll(dir);
            if (map[nextX][nextY] == 0) {
                map[nextX][nextY] = dice[3][1];
            }
            else {
                dice[3][1] = map[nextX][nextY];
                map[nextX][nextY] = 0;
            }
            System.out.println(dice[1][1]);
            x = nextX;
            y = nextY;
        }
    }

    static private void roll(int dir) {
        if (dir == 0) {
            int temp = dice[1][2];
            dice[1][2] = dice[1][1];
            dice[1][1] = dice[1][0];
            dice[1][0] = dice[3][1];
            dice[3][1] = temp;
        }
        else if (dir == 1) {
            int temp = dice[1][0];
            dice[1][0] = dice[1][1];
            dice[1][1] = dice[1][2];
            dice[1][2] = dice[3][1];
            dice[3][1] = temp;
        }
        else if (dir == 2) {
            int temp = dice[3][1];
            dice[3][1] = dice[2][1];
            dice[2][1] = dice[1][1];
            dice[1][1] = dice[0][1];
            dice[0][1] = temp;
        }
        else {
            int temp = dice[0][1];
            dice[0][1] = dice[1][1];
            dice[1][1] = dice[2][1];
            dice[2][1] = dice[3][1];
            dice[3][1] = temp;
        }
    }

    static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

}