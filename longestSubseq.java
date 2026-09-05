import java.util.*;

class longestSubseq {
    public int longestSubseq(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(arr[i] - arr[j]) == 1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
    public static void main(String[] args) {

        longestSubseq sol = new longestSubseq();
        // Test Case 1
        int[] arr1 = {10, 9, 4, 5, 4, 8, 6};
        System.out.println("Test Case 1: " + sol.longestSubseq(arr1));

        // Test Case 2
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("Test Case 2: " + sol.longestSubseq(arr2));

        // Test Case 3
        int[] arr3 = {10, 20, 30, 40};
        System.out.println("Test Case 3: " + sol.longestSubseq(arr3));
    }
}