import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] board = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        for (int i = 1; i < 101; i++) {
            board[i] = i;
        }
        for (int i = 0; i < N + M; i++) {
            line = br.readLine().split(" ");
            board[Integer.parseInt(line[0])] = Integer.parseInt(line[1]);
        }
        System.out.print(bfs());
    }

    static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        int[] distances = new int[101];
        queue.offer(1);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int i = 1; i < 7; i++) {
                int next = curr + i;
                if (next > 100) {
                    break;
                }
                if (distances[board[next]] == 0) {
                    distances[board[next]] = distances[curr] + 1;
                    queue.offer(board[next]);
                }
                if (board[next] == 100) {
                    return distances[100];
                }
            }
        }
        return -1;
    }

}