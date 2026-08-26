import java.util.*;

public class StringGame{
   public static String t, p;
    public static int[] order;
   public  static boolean check(int k) {
        boolean[] removed = new boolean[t.length()];
        for (int i = 0; i < k; i++) {
            removed[order[i] - 1] = true;
        }
        int j = 0;
        for (int i = 0; i < t.length() && j < p.length(); i++) {
            if(removed[i]) continue;
            if (t.charAt(i) == p.charAt(j)) {
                j++;
            }
        }
        return j == p.length(); // j== nums.length()
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.next();
        p = sc.next();
        int n = t.length();
        order = new int[n];

        for (int i = 0; i < n; i++) {
            order[i] = sc.nextInt();
        }

        int lo = 0, hi = n - 1;
        int ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (check(mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        System.out.println(ans);
    }
}