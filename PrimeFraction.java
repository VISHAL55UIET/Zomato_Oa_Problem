import java.util.*;

public class PrimeFraction {
    public static class Solution {
        class Pair {
            int i, j;
            Pair(int i, int j) {
                this.i = i;
                this.j = j;  
            }
        }
        public int[] kthSmallestPrimeFraction(int[] arr, int k) {
            int n = arr.length;
            PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(
                    arr[a.i] * arr[b.j],
                    arr[b.i] * arr[a.j]
                )
            );
            // Start with 1/arr[j]
            for (int j = 1; j < n; j++) {
                pq.offer(new Pair(0, j));
            }
            // Find kth smallest fraction
            while (--k > 0) {
                Pair cur = pq.poll();
                if (cur.i + 1 < cur.j) {
                    pq.offer(new Pair(cur.i + 1, cur.j));
                }
            }

            Pair ans = pq.peek();

            return new int[] {
                arr[ans.i],
                arr[ans.j]
            };
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input n
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        // Input array
        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter k: ");
        int k = sc.nextInt();
        Solution sol = new Solution();
        int[] ans = sol.kthSmallestPrimeFraction(arr, k);
        System.out.println("Kth smallest prime fraction: "+ ans[0] + "/" + ans[1]);
    }
}