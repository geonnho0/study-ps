import java.io.*;

public class Main {

    private static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    public static String solution(int n, int[] a, int[] count) {
        dfs(a[0], 1, a, count);
        return max + "\n" + min;
    }

    private static void dfs(int sum, int curr, int[] a, int[] count) {
        if (curr == a.length) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (count[i] == 0) continue;

            count[i]--;
          int newSum = sum;
            if (i == 0) newSum += a[curr];
            if (i == 1) newSum -= a[curr];
            if (i == 2) newSum *= a[curr];
            if (i == 3) newSum /= a[curr];
            dfs(newSum, curr + 1, a, count);
            count[i]++;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        String[] arr = br.readLine().split(" ");
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(arr[i]);
        int[] count = new int[4];
        arr = br.readLine().split(" ");
        for (int i = 0; i < 4; i++)
            count[i] = Integer.parseInt(arr[i]);
        System.out.println(solution(n, a, count));
    }
}