import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] scores = new int[N][2];
            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                scores[i][0] = Integer.parseInt(line[0]);
                scores[i][1] = Integer.parseInt(line[1]);
            }
            Arrays.sort(scores, (o1, o2) -> o1[0] - o2[0]);
            int count = 0, top = scores[0][1];
            for (int i = 1; i < N; i++) {
                if (top < scores[i][1]) {
                    count++;
                    continue;
                }
                top = scores[i][1];
            }
            System.out.println(N - count);
        }
    }

}