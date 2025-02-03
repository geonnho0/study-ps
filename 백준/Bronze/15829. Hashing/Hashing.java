import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int L = Integer.parseInt(br.readLine());
    String str = br.readLine();
    long ans = solution(L, str);
    System.out.println(ans);
  }

  static long solution(int L, String str) {
    char[] a = str.toCharArray();
    long H = 0L, r = 1L, M = 1234567891L;
    for (int i = 0; i < L; i++) {
      H = (H + (a[i] - 'a' + 1) * r) % M;
      r = (r * 31) % M;
    }
    return H;
  }
}
