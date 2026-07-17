import java.util.*;

class maxPoints{
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) return n;

        int result = 2;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int count = 2;

                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];

                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) continue;

                    int x3 = points[k][0];
                    int y3 = points[k][1];

                    // Cross Product
                    if ((y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1)) {
                        count++;
                    }
                }

                result = Math.max(result, count);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of points

        int[][] points = new int[n][2];

        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        maxPoints obj = new maxPoints();
        System.out.println(obj.maxPoints(points));

        sc.close();
    }
}