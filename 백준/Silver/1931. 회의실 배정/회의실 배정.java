import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Meet[] info = new Meet[N];

        for (int i = 0; i < N; i++)
            info[i] = new Meet(scanner.nextInt(), scanner.nextInt());

        Arrays.sort(info);

        int count = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            if (info[i].start < end) continue;
            end = info[i].end;
            count++;
        }

        System.out.println(count);
    }

}

class Meet implements Comparable<Meet> {
    int start;
    int end;

    public Meet(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meet o) {
        if (this.end == o.end) return this.start - o.end;
        return this.end - o.end;
    }
}