import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Line> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            list.add(new Line(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
        }
        Collections.sort(list);

        int[] dp = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            Line curr = list.get(i);
            for (int j = 0; j <= i; j++) {
                Line temp = list.get(j);
                if (temp.b < curr.b && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.print(N - max);
    }

}

class Line implements Comparable<Line> {
    int a, b;

    public Line(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Line o) {
        return a - o.a;
    }
}