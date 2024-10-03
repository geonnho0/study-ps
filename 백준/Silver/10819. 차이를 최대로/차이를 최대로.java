import java.io.*;

public class Main {

    static int answer = 0;

    static int solution(int N, int[] A) {
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            visited[i] = true;
            backtrack(A, visited, 0, A[i], 1);
            visited[i] = false;
        }
        return answer;
    }

    static void backtrack(int[] A, boolean[] visited, int sum, int before, int count) {
        if (count == A.length) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            backtrack(A, visited, sum + Math.abs(before - A[i]), A[i], count + 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(line[i]);
        }
        System.out.println(solution(N, A));
    }
}