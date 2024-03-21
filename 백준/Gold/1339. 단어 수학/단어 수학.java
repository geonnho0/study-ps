import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        int[] count = new int[26];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            int len = words[i].length() - 1;
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                count[c - 'A'] += (int) Math.pow(10, len);
                len--;
            }
        }

        Arrays.sort(count);
        int ans = 0, num = 9;
        for (int i = count.length - 1; i >= 0; i--)
            ans += (count[i] * num--);

        System.out.print(ans);
    }

}