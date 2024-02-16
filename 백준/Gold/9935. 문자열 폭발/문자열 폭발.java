import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String target = st.nextToken();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            if (str.charAt(i) == target.charAt(target.length() - 1) && stack.size() >= target.length()) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < target.length(); j++) sb.append(stack.pop());

                String string = sb.reverse().toString();
                if (!string.equals(target)) {
                    for (int j = 0; j < string.length(); j++) {
                        stack.push(string.charAt(j));
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (stack.empty()) sb.append("FRULA");
        else {
            while (!stack.empty()) {
                sb.append(stack.pop());
            }
            sb.reverse();
        }
        System.out.print(sb);
    }

}