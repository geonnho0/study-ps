import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] cards;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        cards = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++)
            cards[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(cards);
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(upper(target) - lower(target) + " ");
        }
        System.out.print(sb);
    }

    static int lower(int target) {
        int left = 0, right = N;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target <= cards[mid]) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    static int upper(int target) {
        int left = 0, right = N;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target < cards[mid]) right = mid;
            else left = mid + 1;
        }
        return left;
    }

}