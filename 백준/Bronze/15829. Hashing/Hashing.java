import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int L = Integer.parseInt(br.readLine());
    String str = br.readLine();
    int ans = solution(L, str);
    System.out.println(ans);
  }

  static int solution(int L, String str) {
    char[] a = str.toCharArray();
    int H = 0, r = 1, M = 1234567891;
    for (int i = 0; i < a.length; i++) {
      if (i > 0)
        r = (r * 31) % M;
      H += ((a[i] - 'a' + 1) * r) % M;
    }
    return H;
  }
}