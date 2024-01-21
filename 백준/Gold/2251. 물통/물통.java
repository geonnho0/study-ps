import java.util.*;

public class Main {

    static int[] sender = {0, 0, 1, 1, 2, 2};
    static int[] receiver = {1, 2, 0, 2, 0, 1};
    static boolean[][] visited;
    static int[] max;
    static boolean[] answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        max = new int[3];
        max[0] = scanner.nextInt();
        max[1] = scanner.nextInt();
        max[2] = scanner.nextInt();
        visited = new boolean[201][201];
        answer = new boolean[201];

        bfs();
        for (int i = 0; i < answer.length; i++)
            if (answer[i]) System.out.print(i + " ");
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        visited[0][0] = true;
        answer[max[2]] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            int A = curr.A;
            int B = curr.B;
            int C = max[2] - A - B;

            for (int i = 0; i < 6; i++) {
                int[] next = {A, B, C};
                next[receiver[i]] += next[sender[i]];
                next[sender[i]] = 0;
                if (next[receiver[i]] > max[receiver[i]]) {
                    next[sender[i]] = next[receiver[i]] - max[receiver[i]];
                    next[receiver[i]] = max[receiver[i]];
                }
                if (visited[next[0]][next[1]]) continue;
                visited[next[0]][next[1]] = true;
                queue.add(new Node(next[0], next[1]));
                if (next[0] == 0) answer[next[2]] = true;
            }
        }
    }

}

class Node {
    int A;
    int B;

    public Node(int a, int b) {
        A = a;
        B = b;
    }
}