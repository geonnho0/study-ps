import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(arr);
        int left = 0, right = N - 1;
        int min = Integer.MAX_VALUE;
        int[] ans = new int[2];
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                ans[0] = arr[left];
                ans[1] = arr[right];
            }
            if (sum > 0) {
                right--;
            }
            else {
                left++;
            }
        }
        System.out.print(ans[0] + " " + ans[1]);
    }

}