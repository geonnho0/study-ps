import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int total = parseInt(br.readLine());
    int[][] dist = new int[total + 1][total + 1];
    for (int i = 1; i <= total; i++) {
      for (int j = 1; j <= total; j++) {
        dist[i][j] = 52;
      }
      dist[i][i] = 0;
    }
    while (true) {
      String[] line = br.readLine().split(" ");
      int N = parseInt(line[0]);
      int M = parseInt(line[1]);

      if (N == -1 && M == -1) break;

      dist[N][M] = 1;
      dist[M][N] = 1;
    }

    for (int k = 1; k <= total; k++)
      for (int i = 1; i <= total; i++)
        for (int j = 1; j <= total; j++)
          dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

    int[] score = new int[total + 1];
    for (int i = 1; i <= total; i++)
      for (int j = 1; j <= total; j++)
        score[i] = Math.max(score[i], dist[i][j]);

    int min = findMin(score);
    List<Integer> people = new ArrayList<>();
    for (int i = 1; i <= total; i++) {
      if (min == score[i]) {
        people.add(i);
      }
    }

    System.out.printf("%d %d\n", min, people.size());
    for (int p : people)
      System.out.printf("%d ", p);
  }

  static int findMin(int[] score) {
    int min = Integer.MAX_VALUE;
    for (int i = 1; i != score.length; i++)
      min = Math.min(min, score[i]);
    return min;
  }

  static int parseInt(String s) {
    return Integer.parseInt(s);
  }

}