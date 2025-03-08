import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long T = parseLong(br.readLine());
    while (T-- > 0) {
      long n = parseLong(br.readLine());
      long left = 0, right = Integer.MAX_VALUE;

      long count = 0;
      while (left <= right) {
        long mid = (left + right) / 2;
        long sum = (mid * (mid + 1)) / 2;

        if (sum <= n) {
          count = Math.max(count, mid);
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
      System.out.println(count);
    }
  }

  static long parseLong(String s) {
    return Long.parseLong(s);
  }

}