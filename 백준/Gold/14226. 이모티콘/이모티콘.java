import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        System.out.println(bfs(S));
    }

    static int bfs(int S) {
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(1, 0, 0));
        boolean[][] visited = new boolean[10000][10000];
        visited[1][0] = true;

        while (!queue.isEmpty()) {
            State curr = queue.poll();

            if (curr.screen == S)
                return curr.time;

            if (curr.screen != curr.clip && !visited[curr.screen][curr.screen]) {
                queue.offer(new State(curr.screen, curr.screen, curr.time + 1));
                visited[curr.screen][curr.screen] = true;
            }
            if (curr.clip > 0 && curr.clip <= S && !visited[curr.screen + curr.clip][curr.clip]) {
                queue.offer(new State(curr.screen + curr.clip, curr.clip, curr.time + 1));
                visited[curr.screen + curr.clip][curr.clip] = true;
            }
            if (curr.screen - 1 >= 0 && !visited[curr.screen - 1][curr.clip]) {
                queue.offer(new State(curr.screen - 1, curr.clip, curr.time + 1));
                visited[curr.screen - 1][curr.clip] = true;
            }
        }
        return 0;
    }

}

class State {
    int screen, clip, time;

    public State(int screen, int clip, int time) {
        this.screen = screen;
        this.clip = clip;
        this.time = time;
    }
}