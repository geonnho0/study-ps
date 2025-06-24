import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] edges;
    static int[] greatCount, lessCount;

    public static int solution(int n, int[][] marbles) {
        greatCount = new int[n + 1];
        lessCount = new int[n + 1];
        edges = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            edges[i] = new ArrayList<>();

        for (int[] m : marbles)
            edges[m[0]].add(m[1]);

        for (int i = 1; i <= n; i++)
            count(i);

        int ret = 0, halfCount = (n - 1) / 2;
        for (int i = 1; i <= n; i++) {
            if (greatCount[i] > halfCount || lessCount[i] > halfCount)
                ret++;
        }
        return ret;
    }

    private static void count(int marble) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] v = new boolean[edges.length];
        q.offer(marble);
        v[marble] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int next : edges[curr]) {
                if (v[next]) continue;

                v[next] = true;
                lessCount[marble]++;
                greatCount[next]++;
                q.offer(next);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]), m = Integer.parseInt(arr[1]);
        int[][] marbles = new int[m][2];
        for (int i = 0; i < m; i++) {
            arr = br.readLine().split(" ");
            marbles[i][0] = Integer.parseInt(arr[0]);
            marbles[i][1] = Integer.parseInt(arr[1]);
        }
        System.out.println(solution(n, marbles));
    }
}