import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, ans = 0;
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        board = new int[N];
        check(0);
        System.out.print(ans);
    }

    static void check(int row) {
        if (row == N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[row] = i;
            if (isValid(row)) {
                check(row + 1);
            }
        }
    }

    static boolean isValid(int row) {
        for (int i = 0; i < row; i++) {
            if (board[row] == board[i] || row - i == Math.abs(board[row] - board[i])) {
                return false;
            }
        }
        return true;
    }

}