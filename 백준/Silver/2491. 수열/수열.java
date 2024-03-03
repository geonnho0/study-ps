import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(line[i]);
        }
        int asc = 1, dsc = 1, maxAsc = 1, maxDsc = 1;
        for (int i = 1; i < N; i++) {
            if (num[i - 1] <= num[i]) {
                asc++;
            }
            else {
                maxAsc = Math.max(maxAsc, asc);
                asc = 1;
            }
            if (num[i - 1] >= num[i]) {
                dsc++;
            }
            else {
                maxDsc = Math.max(maxDsc, dsc);
                dsc = 1;
            }
        }
        maxAsc = Math.max(maxAsc, asc);
        maxDsc = Math.max(maxDsc, dsc);
        System.out.print(Math.max(maxAsc, maxDsc));
    }

}