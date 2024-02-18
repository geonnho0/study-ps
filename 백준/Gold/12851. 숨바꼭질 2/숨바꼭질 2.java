import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K, min, count,MAX = 100005;
    static int[] time = new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (N >= K) System.out.print(N - K + "\n1");
        else {
            bfs();
            System.out.print(min + "\n" + count);
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        time[N] = 1;
        min = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int curr = queue.poll(), currTime = time[curr];

            if (min < currTime)
                return;

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) next = curr + 1;
                else if (i == 1) next = curr - 1;
                else next = curr * 2;

                if (next < 0 || next >= MAX) continue;

                if (next == K) {
                    min = currTime;
                    count++;
                }

                if (time[next] == 0 || time[next] == currTime + 1) {
                    queue.offer(next);
                    time[next] = currTime + 1;
                }
            }
        }
    }

}
