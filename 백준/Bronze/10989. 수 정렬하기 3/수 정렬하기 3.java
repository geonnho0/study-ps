import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        short[] a = new short[N];
        for (int i = 0; i < N; i++) {
            a[i] = Short.parseShort(br.readLine());
        }
        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();
        for (int i : a) {
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }

}