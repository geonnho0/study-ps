import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        line = br.readLine().split(" ");
        int[] arr = new int[N];
        int[] sum = new int[N - K + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(line[i]);
            if (i < K) {
                sum[0] += arr[i];
            }
            else {
                sum[i - K + 1] = sum[i - K] - arr[i - K] + arr[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int s : sum) {
            max = Math.max(max, s);
        }
        System.out.print(max);
    }

}