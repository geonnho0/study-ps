import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long length = 1, count = 9;
        while (K > count * length) {
            K -= (length * count);
            length++;
            count *= 10;
        }
        K--;
        long num = (long) Math.pow(10, (length - 1)) + (K / length);
        if (num > N) System.out.println(-1);
        else System.out.println(String.valueOf(num).charAt((int) (K % length)));
    }

}