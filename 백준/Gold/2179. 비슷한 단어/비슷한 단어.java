import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (!words.contains(str))
                words.add(str);
        }

        String left = null, right = null;
        int max = 0;
        for (int i = 0; i < N; i++) {
            String curr = words.get(i);
            for (int j = i + 1; j < N; j++) {
                String next = words.get(j);
                int count = 0;
                int length = Math.min(curr.length(), next.length());
                for (int k = 0; k < length; k++) {
                    if (curr.charAt(k) != next.charAt(k)) break;
                    count++;
                }
                if (count <= max) continue;
                max = count;
                left = curr;
                right = next;
            }
        }

        System.out.println(left);
        System.out.println(right);
    }

}