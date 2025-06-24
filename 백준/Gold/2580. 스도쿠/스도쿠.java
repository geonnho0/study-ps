import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    static int[][] graph = new int[9][9];
    static ArrayList<int[]> blanks = new ArrayList<>();
    static boolean done = false;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
                if (graph[i][j] == 0) {
                    blanks.add(new int[]{i, j});
                    count++;
                }
            }
        }
        dfs(0);
    }

    static void dfs(int depth) {
        if (done) {
            return;
        }
        if (depth == count) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(graph[i][j] + " ");
                }
                System.out.println();
            }
            done = true;
            return;
        }
        int[] next = blanks.get(depth);
        for (int i = 1; i <= 9; i++) {
            if (check(next[0], next[1], i)) {
                graph[next[0]][next[1]] = i;
                dfs(depth + 1);
                graph[next[0]][next[1]] = 0;
            }
        }
    }

    static boolean check(int x, int y, int value) {
        for (int i = 0; i < 9; i++) {
            if (graph[i][y] == value || graph[x][i] == value) {
                return false;
            }
        }
        return squareValid(x, y, value);
    }

    static boolean squareValid(int x, int y, int value) {
        int[] bound = {x, y};
        while (bound[0] % 3 != 0) {
            bound[0]--;
        }
        while (bound[1] % 3 != 0) {
            bound[1]--;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (graph[bound[0] + i][bound[1] + j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

}