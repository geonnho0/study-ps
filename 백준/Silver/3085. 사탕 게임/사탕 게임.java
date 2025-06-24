import java.io.*;

public class Main {

  static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};

    public static int solution(int n, char[][] candies) {
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret = Math.max(ret, swapAndCount(candies, i, j));
                if (ret == n) return ret;
            }
        }
        return ret;
    }

    private static int swapAndCount(char[][] candies, int x1, int y1) {
        int max = 0;
        for (int i = 0; i < 4; i++) {
            int x2 = x1 + dx[i], y2 = y1 + dy[i];
            if (x2 < 0 || x2 >= candies.length || y2 < 0 || y2 >= candies.length) continue;
            swap(candies, x1, y1, x2, y2);
            max = Math.max(max, findMax(candies, x1, y1));
            max = Math.max(max, findMax(candies, x2, y2));
            swap(candies, x1, y1, x2, y2);
        }
        return max;
    }

    private static void swap(char[][] candies, int x1, int y1, int x2, int y2) {
        char temp = candies[x1][y1];
        candies[x1][y1] = candies[x2][y2];
        candies[x2][y2] = temp;
    }

    private static int findMax(char[][] candies, int x, int y) {
        int count1 = 1;
        char color = candies[x][y];
        int h = x + 1;
        while (h < candies.length && candies[h][y] == color) {
            count1++;
            h++;
        }
        h = x - 1;
        while (h >= 0 && candies[h][y] == color) {
            count1++;
            h--;
        }

        int count2 = 1;
        int v = y + 1;
        while (v < candies.length && candies[x][v] == color) {
            count2++;
            v++;
        }
        v = y - 1;
        while (v >= 0 && candies[x][v] == color) {
            count2++;
            v--;
        }
        return Math.max(count1, count2);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] candies = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < n; j++)
                candies[i][j] = arr[j];
        }
        System.out.println(solution(n, candies));
    }
}