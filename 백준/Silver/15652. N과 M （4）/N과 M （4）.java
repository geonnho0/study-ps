import java.io.*;
import java.util.*;

public class Main {

    private static int n, m;

    private static String solution(int N, int M) {
        StringBuilder sb = new StringBuilder();
        n = N;
        m = M;
        for (int i = 1; i <= n; i++)
            find(i, new ArrayList<>(Collections.singleton(String.valueOf(i))), sb);
        return sb.toString();
    }

    private static void find(int curr, ArrayList<String> str, StringBuilder sb) {
        if (str.size() == m) {
            StringBuilder temp = new StringBuilder();
            for (String s : str)
                temp.append(s).append(" ");
            sb.append(temp).append("\n");
            return;
        }

        for (int next = curr; next <= n; next++) {
            str.add(String.valueOf(next));
            find(next, str, sb);
            str.remove(str.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        System.out.println(solution(n, m));
    }
}