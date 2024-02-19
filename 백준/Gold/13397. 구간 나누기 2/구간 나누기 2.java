import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        num = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        int max = 0;
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            max = Math.max(num[i], max);
        }

        int left = 0, right = max;
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(mid) <= M) right = mid;
            else left = mid + 1;
        }

        System.out.println(right);
    }

    static int check(int mid) {
        int count = 1;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            min = Math.min(min, num[i]);
            max = Math.max(max, num[i]);
            if (max - min > mid) {
                count++;
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
                i--;
            }
        }
        return count;
    }

}