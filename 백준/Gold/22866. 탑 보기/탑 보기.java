import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        Building[] buildings = new Building[N + 1];
        int[][] distances = new int[N + 1][2];
        int[] count = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            buildings[i] = new Building(i, Integer.parseInt(st.nextToken()));
            Arrays.fill(distances[i], 100001);
        }

        Stack<Building> stack = new Stack<>();
        for (int i = 1; i <= N; i++) {
            while (!stack.empty() && stack.peek().height <= buildings[i].height) {
                stack.pop();
            }
            int size = stack.size();
            count[i] += size;
            if (size > 0) {
                int distance = Math.abs(stack.peek().index - i);
                if (distance < distances[i][1]) {
                    distances[i][0] = stack.peek().index;
                    distances[i][1] = distance;
                }
                else if (distance == distances[i][1] && stack.peek().index < distances[i][0]) {
                    distances[i][0] = stack.peek().index;
                }
            }
            stack.push(buildings[i]);
        }

        stack = new Stack<>();
        for (int i = N; i >= 1; i--) {
            while (!stack.empty() && stack.peek().height <= buildings[i].height) {
                stack.pop();
            }
            int size = stack.size();
            count[i] += size;
            if (size > 0) {
                int distance = Math.abs(stack.peek().index - i);
                if (distance < distances[i][1]) {
                    distances[i][0] = stack.peek().index;
                    distances[i][1] = distance;
                }
                else if (distance == distances[i][1] && stack.peek().index < distances[i][0]) {
                    distances[i][0] = stack.peek().index;
                }
            }
            stack.push(buildings[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (count[i] == 0)
                sb.append("0\n");
            else
                sb.append(count[i] + " " + distances[i][0] + "\n");
        }
        System.out.print(sb);
    }

}

class Building {
    int index, height;

    public Building(int index, int height) {
        this.index = index;
        this.height = height;
    }
}