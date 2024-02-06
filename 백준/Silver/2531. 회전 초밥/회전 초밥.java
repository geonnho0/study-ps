import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] eaten = new boolean[d + 5];
        int duplicated, coupon, ans = 0;
        for (int i = 0; i < N; i++) {
            duplicated = 0;
            coupon = 1;
            for (int j = i; j < i + k; j++) {
                if (eaten[arr[j % N]]) duplicated++;
                else eaten[arr[j % N]] = true;
                if (arr[j % N] == c) coupon = 0;
            }

            ans = Math.max(ans, k - duplicated + coupon);
            eaten = new boolean[d + 5];
        }
        System.out.println(ans);
    }

}