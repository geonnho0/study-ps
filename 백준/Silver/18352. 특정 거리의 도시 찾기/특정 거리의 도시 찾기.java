import java.util.*;

public class Main {

    static ArrayList<Integer>[] arr;
    static int[] distances;
    static ArrayList<Integer> res;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int K = scanner.nextInt();
        int X = scanner.nextInt();
        arr = new ArrayList[N + 1];
        distances = new int[N + 1];
        res = new ArrayList<>();
        for (int i = 1; i <= N; i++) arr[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            arr[start].add(end);
        }

        bfs(X, K);
        if (res.isEmpty()) System.out.println(-1);
        Collections.sort(res);
        for (int n: res) System.out.println(n);
    }

    static void bfs(int start, int max) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next: arr[curr]) {
                if (next == start || distances[next] != 0) continue;
                distances[next] = distances[curr] + 1;
                if (distances[next] == max) res.add(next);
                queue.add(next);
            }
        }
    }

}