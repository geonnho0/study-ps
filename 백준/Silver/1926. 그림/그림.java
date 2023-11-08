import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static boolean[][] arr;
    static int max = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int curr = sc.nextInt();
                arr[i][j] = (curr == 1);
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j]) {
                    count = count + 1;
                    bfs(i, j);
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    static void bfs(int x, int y) {
        int size = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));
        arr[x][y] = false;

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = curr.x + dx[i];
                int nextY = curr.y + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
                    continue;

                if (arr[nextX][nextY]) {
                    arr[nextX][nextY] = false;
                    size = size + 1;
                    queue.offer(new Pair(nextX, nextY));
                }
            }
        }

        max = Math.max(max, size);
    }

}

class Pair {
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}