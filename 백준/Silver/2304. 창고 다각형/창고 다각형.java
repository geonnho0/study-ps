import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        Rect[] rects = new Rect[N];
        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            rects[i] = new Rect(l, h);
            maxHeight = Math.max(maxHeight, h);
        }
        Arrays.sort(rects);

        int index = 0, maxL;
        Rect curr = rects[index++];
        long ans = 0;
        while (true) {
            if (curr.h < maxHeight) {
                if (curr.h < rects[index].h) {
                    ans += (curr.h * (rects[index].l - curr.l));
                    curr = rects[index];
                }
                index++;
            }
            else {
                maxL = index - 1;
                index = N - 1;
                curr = rects[index--];
                while (index >= maxL) {
                    if (curr.h <= rects[index].h) {
                        ans += (curr.h * (curr.l - rects[index].l));
                        curr = rects[index];
                    }
                    index--;
                }
                break;
            }
        }
        ans += rects[maxL].h;
        System.out.print(ans);
    }

}

class Rect implements Comparable<Rect> {

    int l, h;

    public Rect(int l, int h) {
        this.l = l;
        this.h = h;
    }

    @Override
    public int compareTo(Rect o) {
        return l - o.l;
    }
}