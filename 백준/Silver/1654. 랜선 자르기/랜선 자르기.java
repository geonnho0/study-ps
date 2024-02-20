import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        arr = new int[K];
        long right = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(arr[i], right);
        }

        long left = 0;
        right++;
        while (left < right) {
            long mid = (left + right) / 2;
            if (check(mid, N)) left = mid + 1;
            else right = mid;
        }
        System.out.println(left - 1);
    }

    static boolean check(long len, int N) {
        int ans = 0;
        for (int a : arr) ans += (a / len);
        return ans >= N;
    }

}