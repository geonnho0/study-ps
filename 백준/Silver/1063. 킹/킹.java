import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static int N;
    static int[] kingLocation;
    static int[] rockLocation;

    public static void main(String[] args) {
        String[] str = sc.nextLine().split(" ");
        String[] king = str[0].split("");
        String[] rock = str[1].split("");
        N = Integer.parseInt(str[2]);

        kingLocation = new int[]{8 - Integer.parseInt(king[1]), getColumn(king[0])};
        rockLocation = new int[]{8 - Integer.parseInt(rock[1]), getColumn(rock[0])};

        run();

        printLocation();
    }

    static int getColumn(String alphabet) {
        switch (alphabet) {
            case "A": return 0;
            case "B": return 1;
            case "C": return 2;
            case "D": return 3;
            case "E": return 4;
            case "F": return 5;
            case "G": return 6;
            case "H": return 7;
            default: return -1;
        }
    }

    static void run() {
        for (int i = 0; i < N; i++) {
            String command = sc.next();
            switch (command) {
                case "R":
                    updateLocation(0, 1);
                    break;
                case "L":
                    updateLocation(0, -1);
                    break;
                case "B":
                    updateLocation(1, 0);
                    break;
                case "T":
                    updateLocation(-1, 0);
                    break;
                case "RT":
                    updateLocation(-1, 1);
                    break;
                case "LT":
                    updateLocation(-1, -1);
                    break;
                case "RB":
                    updateLocation(1, 1);
                    break;
                case "LB":
                    updateLocation(1, -1);
                    break;
            }
        }
    }

    static void updateRock(int x, int y) {
        rockLocation[0] = x;
        rockLocation[1] = y;
    }

    static void updateKing(int x, int y) {
        kingLocation[0] = x;
        kingLocation[1] = y;
    }

    static void updateLocation(int xChange, int yChange) {
        if (validateKingLocation(xChange, yChange))
            return;

        if (kingLocation[0] + xChange == rockLocation[0] && kingLocation[1] + yChange == rockLocation[1]) {
            if (!validateRockLocation(xChange, yChange)) {
                updateRock(rockLocation[0] + xChange, rockLocation[1] + yChange);
                updateKing(kingLocation[0] + xChange, kingLocation[1] + yChange);
            }
        } else {
            updateKing(kingLocation[0] + xChange, kingLocation[1] + yChange);
        }
    }

    static boolean validateKingLocation(int xChange, int yChange) {
        int[] nextKingLocation = new int[]{kingLocation[0] + xChange, kingLocation[1] + yChange};
        return nextKingLocation[0] < 0 || nextKingLocation[0] >= 8 || nextKingLocation[1] < 0 || nextKingLocation[1] >= 8;
    }

    static boolean validateRockLocation(int xChange, int yChange) {
        int[] nextRockLocation = new int[]{rockLocation[0] + xChange, rockLocation[1] + yChange};
        return nextRockLocation[0] < 0 || nextRockLocation[0] >= 8 || nextRockLocation[1] < 0 || nextRockLocation[1] >= 8;
    }

    static void printLocation() {
        String king = "";
        switch (kingLocation[1]) {
            case 0:
                king += "A";
                break;
            case 1:
                king += "B";
                break;
            case 2:
                king += "C";
                break;
            case 3:
                king += "D";
                break;
            case 4:
                king += "E";
                break;
            case 5:
                king += "F";
                break;
            case 6:
                king += "G";
                break;
            case 7:
                king += "H";
                break;
        }
        king += String.valueOf(8 - kingLocation[0]);
        System.out.println(king);

        king = "";
        switch (rockLocation[1]) {
            case 0:
                king += "A";
                break;
            case 1:
                king += "B";
                break;
            case 2:
                king += "C";
                break;
            case 3:
                king += "D";
                break;
            case 4:
                king += "E";
                break;
            case 5:
                king += "F";
                break;
            case 6:
                king += "G";
                break;
            case 7:
                king += "H";
                break;
        }
        king += String.valueOf(8 - rockLocation[0]);
        System.out.println(king);
    }

}
