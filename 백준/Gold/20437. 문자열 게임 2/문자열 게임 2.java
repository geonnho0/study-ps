import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            String[] strings = st.nextToken().split("");
            char[] chars = new char[strings.length];
            for (int i = 0; i < strings.length; i++)
                chars[i] = strings[i].charAt(0);
            ArrayList<Integer>[] counts = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                counts[i] = new ArrayList<>();
            }
            int length = chars.length;
            for (int i = 0; i < length; i++) {
                int index = (int) chars[i] - 'a';
                counts[index].add(i);
            }

            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int i = 0; i < 26; i++) {
                int size = counts[i].size();
                if (size < K)
                    continue;

                for (int j = 0; j <= size - K; j++) {
                    int tempLength = counts[i].get(j + K - 1) - counts[i].get(j) + 1;
                    min = Math.min(tempLength, min);
                    max = Math.max(tempLength, max);
                }
            }
            if (min == Integer.MAX_VALUE)
                System.out.println(-1);
            else
                System.out.println(min + " " + max);
        }
    }

}