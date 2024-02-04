import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            int[] prices = new int[N];
            for (int i = 0; i < N; i++)
                prices[i] = Integer.parseInt(st.nextToken());

            long ans = 0;
            int max, start = N - 1;
            while (start > 0) {
                max = prices[start];
                start--;
                while (start >= 0 && prices[start] < max) {
                    ans += (max - prices[start]);
                    start--;
                }
            }
            sb.append(ans + "\n");
        }
        System.out.print(sb);
    }

}