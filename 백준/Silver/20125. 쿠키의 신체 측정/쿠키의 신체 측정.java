import java.util.Scanner;

public class Main {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        char[][] cookie = new char[N + 1][N + 1];
        scanner.nextLine();
        for (int i = 1; i <= N; i++) {
            String[] line = scanner.nextLine().split("");
            for (int j = 0; j < N; j++)
                cookie[i][j + 1] = line[j].charAt(0);
        }

        int headRow = 1, headCol = 1;
        boolean find = false;
        for (int i = 1; i <= N && !find; i++)
            for (int j = 1; j <= N && !find; j++)
                if (cookie[i][j] == '*') {
                    headRow = i;
                    headCol = j;
                    find = true;
                }

        int heartRow = headRow + 1, heartCol = headCol;
        System.out.println(heartRow + " " + heartCol);

        int leftArm = 0;
        for (int j = heartCol - 1; j > 0 && cookie[heartRow][j] == '*'; j--)
            leftArm++;
        int rightArm = 0;
        for (int j = heartCol + 1; j <= N && cookie[heartRow][j] == '*'; j++)
            rightArm++;

        int mid = 0;
        for (int i = heartRow + 1; i <= N && cookie[i][heartCol] == '*'; i++)
            mid++;

        int leftLeg = 0;
        for (int i = heartRow + mid + 1; i <= N && cookie[i][heartCol - 1] == '*'; i++)
            leftLeg++;
        int rightLeg = 0;
        for (int i = heartRow + mid + 1; i <= N && cookie[i][heartCol + 1] == '*'; i++)
            rightLeg++;

        System.out.print(leftArm + " " + rightArm + " " + mid + " " + leftLeg + " " + rightLeg);
    }

}