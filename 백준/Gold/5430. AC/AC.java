import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            String[] commands = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] num = line.substring(1, line.length() - 1).split(",");
            Deque<String> x = new ArrayDeque<>(n);
            for (int i = 0; i < n; i++) {
                x.offerLast(num[i]);
            }
            boolean left = true;
            boolean error = false;
            for (String p: commands) {
                if (p.equals("R")) {
                    left = !left;
                }
                else {
                    if (x.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (left) {
                        x.pollFirst();
                    }
                    else {
                        x.pollLast();
                    }
                }
            }
            if (error) {
                sb.append("error\n");
                continue;
            }
            sb.append("[");
            boolean flag = false;
            while (!x.isEmpty()) {
                sb.append(flag ? "," : "").append(left ? x.pollFirst() : x.pollLast());
                flag = true;
            }
            sb.append("]\n");
        }
        System.out.print(sb);
    }

}