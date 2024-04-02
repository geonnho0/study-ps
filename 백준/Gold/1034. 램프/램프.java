import java.io.*;

public class Main {

    static int[][] lamps;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        lamps = new int[N][M];
        for (int i = 0; i < N; i++) {
            line = br.readLine().split("");
            for (int j = 0; j < M; j++)
                lamps[i][j] = Integer.parseInt(line[j]);
        }
        int K = Integer.parseInt(br.readLine());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int zero = 0;
            for (int j = 0; j < M; j++) {
                if (lamps[i][j] == 0)
                    zero++;
            }
            if (zero > K || zero % 2 != K % 2)
                continue;

            int pattern = 0;
            for (int j = 0; j < N; j++) {
                if (isSame(i, j))
                    pattern++;
            }
            answer = Math.max(answer, pattern);
        }
        System.out.print(answer);
    }

    static boolean isSame(int row1, int row2) {
        for (int i = 0; i < M; i++)
            if (lamps[row1][i] != lamps[row2][i])
                return false;
        return true;
    }

}