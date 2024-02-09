import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static String[] start, dest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        start = st.nextToken().split("");
        st = new StringTokenizer(br.readLine());
        dest = st.nextToken().split("");

        int nonFirst = compare(false);
        int first = compare(true);
        if (nonFirst == -1) {
            if (first == -1) System.out.println(-1);
            else System.out.println(first);
        }
        else if (first == -1) System.out.println(nonFirst);
        else System.out.println(Math.min(first, nonFirst));
    }

    private static int compare(boolean first) {
        String[] temp = Arrays.copyOf(start, N);
        String[] temp1 = Arrays.copyOf(dest, N);
        int count = 0;
        if (first) {
            temp[0] = temp[0].equals("0") ? "1" : "0";
            temp[1] = temp[1].equals("1") ? "0" : "1";
            count++;
        }
        for (int i = 0; i < N; i++) {
            if (temp[i].equals(temp1[i])) continue;
            if (i + 1 < N) {
                temp[i + 1] = temp[i + 1].equals("0") ? "1" : "0";
                if (i + 2 < N)
                    temp[i + 2] = temp[i + 2].equals("0") ? "1" : "0";
                temp[i] = temp[i].equals("0") ? "1" : "0";
                count++;
            }
        }
        for (int i = 0; i < N; i++) {
            if (temp[i].equals(temp1[i])) continue;
            else return -1;
        }
        return count;
    }

}