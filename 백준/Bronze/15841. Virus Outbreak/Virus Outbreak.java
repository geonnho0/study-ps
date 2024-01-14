import java.io.*;
import java.math.BigInteger;

public class Main {

    static BigInteger[] dp;

    public static void main(String[] args) throws IOException {
        initDP();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n;
        while ((n = Integer.parseInt(br.readLine())) != -1) {
            bw.write("Hour " + n + ": " + dp[n] + " cow(s) affected\n");
        }
        bw.close();
    }

    public static void initDP() {
        dp = new BigInteger[500];
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;
        for (int i = 2; i <= 490; i++) {
            dp[i] = dp[i - 2].add(dp[i - 1]);
        }
    }
}
