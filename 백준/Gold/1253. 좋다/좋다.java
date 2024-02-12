import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        long[] num = new long[N];
        for (int i = 0; i < N; i++)
            num[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(num);
        System.out.print(getAns(N, num));
    }

    private static int getAns(int N, long[] num) {
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;

            while (left < right) {
                long sum = num[left] + num[right];
                if (sum == num[i]) {
                    if (left != i && right != i) {
                        ans++;
                        break;
                    }
                    else if (left == i) left++;
                    else right--;
                }
                else if (sum > num[i]) right--;
                else left++;
            }
        }
        return ans;
    }
}