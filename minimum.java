import java.util.*;

public class minimum{

    static long minimumCost(int[] packages) {

        int n = packages.length;
        long handling = 0;
        for (int x : packages)
            handling += x;

        // Travel cost if robot starts from LEFT
        long leftTravel = 0;
        long suffixMax = 0;

        for (int i = n - 1; i >= 0; i--) {
            suffixMax = Math.max(suffixMax, packages[i]);
            leftTravel += suffixMax;
        }

        // Travel cost if robot starts from RIGHT
        long rightTravel = 0;
        long prefixMax = 0;

        for (int i = 0; i < n; i++) {
            prefixMax = Math.max(prefixMax, packages[i]);
            rightTravel += prefixMax;
        }

        return handling + Math.min(leftTravel, rightTravel);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] packages = new int[n];

        for (int i = 0; i < n; i++)
            packages[i] = sc.nextInt();

        System.out.println(minimumCost(packages));
    }
}