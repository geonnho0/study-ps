import java.io.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
      long X = parseInt(line[0]);
      long Y = parseInt(line[1]);
      long Z = (Y * 100) / X;
      long left = 0, right = X;

      int answer = -1;
      while (left <= right) {
        long mid = (left + right) / 2;

        long newZ = ((Y + mid) * 100) / (X + mid);

        if (Z == newZ) {
          left = mid + 1;
        } else {
          answer = (int) mid;
          right = mid - 1;
        }
      }
      System.out.println(answer);
  }

  static int parseInt(String s) {
    return Integer.parseInt(s);
  }

}
