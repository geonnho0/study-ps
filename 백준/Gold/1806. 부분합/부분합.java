import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        long[] prefix = new long[N + 5];
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i - 1] + num;
        }
        System.out.print(getAns(N, S, prefix));
    }

    private static int getAns(int N, int S, long[] prefix) {
        int ans = Integer.MAX_VALUE;
        int first = 0, second = 1;
        while (first <= N && second <= N) {
            long sum = prefix[second] - prefix[first];
            if (sum < S) {
                if (second == N) break;
                second++;
                continue;
            }
            ans = Math.min(ans, second - first);
            first++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}