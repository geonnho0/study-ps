import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String[] button;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int M = Integer.parseInt(br.readLine());
        button = new String[M];
        if (M != 0) {
            String[] line = br.readLine().split(" ");
            for (int i = 0; i < M; i++) {
                button[i] = line[i];
            }
        }
        int count = Math.abs(Integer.parseInt(N) - 100);
        System.out.print(Math.min(count, getCount(Integer.parseInt(N))));
    }

    static int getCount(int N) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= 1000000; i++) {
            String num = String.valueOf(i);
            if (valid(num)) {
                ans = Math.min(ans, num.length() + Math.abs(N - i));
            }
        }
        return ans;
    }

    static boolean valid(String num) {
        String[] arr = num.split("");
        for (String a : arr) {
            for (String b : button) {
                if (a.equals(b)) {
                    return false;
                }
            }
        }
        return true;
    }

}