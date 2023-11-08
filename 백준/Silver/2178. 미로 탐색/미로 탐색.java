import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int[][] arr;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] str = sc.next().split("");
            for (int j = 0; j < str.length; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        bfs(0, 0);
        System.out.println(arr[N-1][M-1]);
    }

    static void bfs(int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();

            if (curr.x == N - 1 && curr.y == M - 1)
                return;

            for (int i = 0; i < 4; i++) {
                int nextX = curr.x + dx[i];
                int nextY = curr.y + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
                    continue;

                if (arr[nextX][nextY] == 1) {
                    arr[nextX][nextY] = arr[curr.x][curr.y] + 1;
                    queue.offer(new Pair(nextX, nextY));
                }
            }
        }
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