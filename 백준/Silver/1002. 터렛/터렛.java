import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] line = br.readLine().split(" ");
            int x1 = Integer.parseInt(line[0]), y1 = Integer.parseInt(line[1]), r1 = Integer.parseInt(line[2]);
            int x2 = Integer.parseInt(line[3]), y2 = Integer.parseInt(line[4]), r2 = Integer.parseInt(line[5]);
            double dist = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));

            if (x1 == x2 && y1 == y2 && r1 == r2)
                System.out.println(-1);
            else if (dist > r1 + r2)
                System.out.println(0);
            else if (r1 != r2 && dist < Math.abs(r1 - r2))
                System.out.println(0);
            else if (r1 != r2 && dist == Math.abs(r1 - r2))
                System.out.println(1);
            else if (dist == r1 + r2)
                System.out.println(1);
            else
                System.out.println(2);
        }
    }
}