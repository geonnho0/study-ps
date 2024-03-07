import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            ans = 0;
            n = Integer.parseInt(br.readLine());
            find(0);
            System.out.println(ans);
        }
    }

    static void find(int sum) {
        if (sum > n) {
            return;
        }
        if (sum == n) {
            ans++;
            return;
        }
        for (int i = 1; i <= 3; i++) {
            find(sum + i);
        }
    }

}