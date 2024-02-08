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
        Stack<Tower> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            int temp = 0;
            while (!stack.empty()) {
                Tower left = stack.peek();
                if (left.height < height) {
                    stack.pop();
                    continue;
                }
                temp = stack.peek().number;
                break;
            }
            stack.add(new Tower(height, i + 1));
            sb.append(temp + " ");
        }
        System.out.print(sb);
    }

}

class Tower {
    int height, number;

    public Tower(int height, int number) {
        this.height = height;
        this.number = number;
    }
}