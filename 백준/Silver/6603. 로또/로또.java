import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] visited;
    static int k;
    static int[] S;
    static int[] lotto;
    static ArrayList<Lotto> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String[] line = br.readLine().split(" ");
            k = Integer.parseInt(line[0]);
            if (k == 0) {
                break;
            }
            S = new int[k];
            visited = new boolean[k];
            lotto = new int[6];
            ans = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(line[i + 1]);
            }
            dfs(0);
            Collections.sort(ans);
            for (Lotto a : ans) {
                sb.append(a).append("\n");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void dfs(int length) {
        if (length == 6) {
            Lotto l = new Lotto();
            for (int i = 0; i < 6; i++) {
                l.n[i] = lotto[i];
            }
            ans.add(l);
            return;
        }
        for (int i = 0; i < k; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            lotto[length] = S[i];
            if (isSorted(length + 1)) {
                dfs(length + 1);
            }
            visited[i] = false;
        }
    }

    private static boolean isSorted(int length) {
        int curr = lotto[0];
        for (int i = 1; i < length; i++) {
            if (curr > lotto[i]) {
                return false;
            }
            curr = lotto[i];
        }
        return true;
    }

}

class Lotto implements Comparable<Lotto> {
    int[] n = new int[6];

    @Override
    public int compareTo(Lotto o) {
        for (int i = 0; i < 6; i++) {
            if (n[i] < o.n[i]) {
                return -1;
            }
            else if (n[i] > o.n[i]) {
                return 1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        String str = "";
        for (int num : n) {
            str += num + " ";
        }
        return str;
    }
}