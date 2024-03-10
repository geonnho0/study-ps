import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] scores = new int[N][3];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                scores[i][j] = Integer.parseInt(line[j]);
            }
        }

        int[][] max = new int[N][3], min = new int[N][3];
        for (int i = 0; i < 3; i++) {
            max[0][i] = scores[0][i];
            min[0][i] = scores[0][i];
        }

        for (int i = 1; i < N; i++) {
            max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]) + scores[i][0];
            min[i][0] = Math.min(min[i - 1][0], min[i - 1][1]) + scores[i][0];
            max[i][1] = Math.max(max[i - 1][0], Math.max(max[i - 1][1], max[i - 1][2])) + scores[i][1];
            min[i][1] = Math.min(min[i - 1][0], Math.min(min[i - 1][1], min[i - 1][2])) + scores[i][1];
            max[i][2] = Math.max(max[i - 1][1], max[i - 1][2]) + scores[i][2];
            min[i][2] = Math.min(min[i - 1][1], min[i - 1][2]) + scores[i][2];
        }

        int[] answer = new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE};
        for (int i = 0; i < 3; i++) {
            answer[0] = Math.max(answer[0], max[N - 1][i]);
            answer[1] = Math.min(answer[1], min[N - 1][i]);
        }
        System.out.print(answer[0] + " " + answer[1]);
    }

}