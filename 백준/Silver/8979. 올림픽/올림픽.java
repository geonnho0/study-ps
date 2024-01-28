import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        ArrayList<Country> countries = new ArrayList<>();
        Country target = null;
        for (int i = 0; i < N; i++) {
            int countryNum = scanner.nextInt();
            int gold = scanner.nextInt();
            int silver = scanner.nextInt();
            int bronze = scanner.nextInt();

            countries.add(new Country(gold, silver, bronze));
            if (countryNum == K) target = countries.get(i);
        }
        Collections.sort(countries);
        for (int i = 0; i < N; i++) {
            if (target.equals(countries.get(i))) System.out.println(i + 1);
        }
    }
}

class Country implements Comparable<Country> {

    int gold;
    int silver;
    int bronze;

    @Override
    public int compareTo(Country o) {
        if (this.gold > o.gold) return -1;
        else if (this.gold == o.gold && this.silver > o.silver) return -1;
        else if (this.gold == o.gold && this.silver == o.silver && this.bronze > o.bronze) return -1;
        else if (this.gold == o.gold && this.silver == o.silver && this.bronze == o.bronze) return 0;
        return 1;
    }

    public Country(int gold, int silver, int bronze) {
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }
}