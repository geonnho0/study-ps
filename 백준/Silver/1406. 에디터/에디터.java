import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String[] strings = st.nextToken().split("");
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        for (String s: strings) left.push(s.charAt(0));
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if (command.equals("P")) left.push(st.nextToken().charAt(0));
            else if (command.equals("L")) {
                if (left.empty()) continue;
                right.push(left.pop());
            }
            else if (command.equals("D")) {
                if (right.empty()) continue;
                left.push(right.pop());
            }
            else {
                if (left.empty()) continue;
                left.pop();
            }
        }
        while (!left.empty()) right.push(left.pop());
        StringBuilder sb = new StringBuilder();
        while (!right.empty()) sb.append(right.pop());
        System.out.print(sb);
    }

}