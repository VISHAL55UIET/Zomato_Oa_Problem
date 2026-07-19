import java.util.*;
public class Direction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int maxNorth = sc.nextInt();
        int maxEast = sc.nextInt();
        int xp = sc.nextInt();
        int yp = sc.nextInt();
        int k = sc.nextInt();
        int distN = maxNorth - yp;
        int distS = yp - 1;
        int distE = maxEast - xp;
        int distW = xp - 1;
        for (int i = 0; i < k; i++) {
            int bx = sc.nextInt(),by = sc.nextInt();
            if (bx == xp) { 
                if (by > yp) {
                    distN = Math.min(distN, by - yp - 1);
                } else if (by < yp) { 
                    distS = Math.min(distS, yp - by - 1);
                }
            } else if (by == yp) { 
                if (bx > xp) { 
                    distE = Math.min(distE, bx - xp - 1);
                } else if (bx < xp) { 
                    distW = Math.min(distW, xp - bx - 1);
                }
            }
        }
        int totalVicinity = Math.max(0, distN) 
                          + Math.max(0, distS) 
                          + Math.max(0, distE) 
                          + Math.max(0, distW);
                          
        System.out.println(totalVicinity);
        
        sc.close();
    }

}
