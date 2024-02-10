import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        for (int i = 0; i <= N; i++) {
            int x, y;
            if (i == N) {
                y = 0;
            } else {
                st = new StringTokenizer(br.readLine(), " ");
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
            }

            if (y == 0) {
                int last = 0;
                while (!stack.empty()) {
                    int stackPeek = stack.pop();
                    if (last != stackPeek) {
                        count++;
                    }
                    last = stackPeek;
                }
                continue;
            }
            if (stack.empty() || y > stack.peek()) {
                stack.push(y);
                continue;
            }
            int last = 0;
            while (!stack.empty() && y < stack.peek()) {
                int stackPeek = stack.pop();
                if (last != stackPeek) {
                    count++;
                }
                last = stackPeek;
            }
            stack.push(y);
        }
        System.out.println(count);
    }
}