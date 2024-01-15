import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] gradesStrings = new int[count];
        for (int i = 0; i < count; i++) {
            gradesStrings[i] = scanner.nextInt();
        }
        double[] grades = new double[count];
        int max = 0;
        for (int grade: gradesStrings) {
            if (grade > max)
                max = grade;
        }
        for (int i = 0; i < count; i++) {
            int grade = gradesStrings[i];
            double newGrade = ((double) grade / max) * 100;
            grades[i] = newGrade;
        }
        double res = 0;
        for (int i = 0; i < count; i++) {
            res += grades[i];
        }
        System.out.println(res / count);
    }
}