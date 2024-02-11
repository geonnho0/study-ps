import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static int N;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            dfs("1",2);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(String line, int curr) {
        if (curr == N + 1) {
            String temp = line.replaceAll(" ", "");
            Iterator<Integer> it = Arrays.stream(temp.split("[+,-]"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList())
                    .iterator();
            int res = it.next(), length = line.length();
            for (int i = 0; i < length; i++) {
                if (line.charAt(i) == '+')
                    res += it.next();
                else if (line.charAt(i) == '-')
                    res -= it.next();
            }
            if (res == 0)
                sb.append(line + "\n");
            return;
        }
        dfs(line + " " + curr, curr + 1);
        dfs(line + "+" + curr, curr + 1);
        dfs(line + "-" + curr, curr + 1);
    }
}