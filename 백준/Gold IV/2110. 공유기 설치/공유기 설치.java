import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] home;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        home = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            home[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(home);

        int lower = 1, upper = home[N - 1] - home[0] + 1;
        while (lower < upper) {
            int mid = (lower + upper) / 2;
            if (installable(mid) < C) upper = mid;
            else lower = mid + 1;
        }
        System.out.println(lower - 1);
    }

    static int installable(int distance) {
        int count = 1;
        int lastInstallLocation = home[0];
        for (int i = 1; i < N; i++) {
            int curr = home[i];
            if (curr - lastInstallLocation >= distance) {
                count++;
                lastInstallLocation = curr;
            }
        }
        return count;
    }

}