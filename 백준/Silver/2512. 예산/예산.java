import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> money = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) money.add(Integer.valueOf(st.nextToken()));
        int total = Integer.parseInt(br.readLine());
        Collections.sort(money);

        int left = 0, right = money.get(N - 1);
        int mid = (left + right) / 2;
        while (left <= right) {
            int sum = 0;
            for (int m: money) {
                if (mid < m) sum += mid;
                else sum += m;
            }
            if (sum < total) left = mid + 1;
            else if (sum > total) right = mid - 1;
            else break;
            mid = (left + right) / 2;
        }
        int temp = total - mid * N;
        if (temp >= N) System.out.println(mid + 1);
        else System.out.println(mid);
    }

}