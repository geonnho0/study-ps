import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Name[] names = new Name[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            names[i] = new Name(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int power = Integer.parseInt(st.nextToken());

            int start = 0, end = N - 1, mid = 0;
            while (start <= end) {
                mid = (start + end) / 2;

                if (mid - 1 < 0) break;

                if (names[mid].power < power) start = mid + 1;
                else if (names[mid - 1].power >= power) end = mid;
                else break;
            }
            sb.append(names[mid].str + "\n");
        }
        System.out.print(sb);
    }

}

class Name {
    String str;
    int power;

    public Name(String str, int power) {
        this.str = str;
        this.power = power;
    }
}