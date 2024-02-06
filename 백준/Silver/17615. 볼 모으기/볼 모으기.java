import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), "");
        char[] arr = new char[N];
        String str = st.nextToken();
        for (int i = 0; i < N; i++)
            arr[i] = str.charAt(i);
        int red = 0, blue = 0;
        boolean redFlag = false, blueFlag = false;
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] == 'R') {
                blueFlag = true;
                if (redFlag)
                    red++;
            }
            else {
                redFlag = true;
                if (blueFlag)
                    blue++;
            }
        }
        int min = Math.min(red, blue);
        red = 0;
        blue = 0;
        redFlag = false;
        blueFlag = false;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'R') {
                blueFlag = true;
                if (redFlag)
                    red++;
            }
            else {
                redFlag = true;
                if (blueFlag)
                    blue++;
            }
        }
        min = Math.min(min, Math.min(red, blue));
        System.out.println(min);
    }

}