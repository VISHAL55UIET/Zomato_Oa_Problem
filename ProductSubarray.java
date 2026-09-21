import java.util.*;

public class ProductSubarray {

    public static long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] res = new long[k];
        long[] prevCount = new long[k];
        for (int i = 0; i < n; i++) {
            long[] currCount = new long[k];
            int currElementRemainder = nums[i] % k;
            currCount[currElementRemainder]++;
            for (int oldRem = 0; oldRem < k; oldRem++) {
                int newRem = (int) ((long) oldRem * nums[i] % k);
                currCount[newRem] += prevCount[oldRem];
            }
            prevCount = currCount;
            for (int x = 0; x < k; x++) {
                res[x] += prevCount[x];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 3;
        long[] ans = resultArray(nums, k);
        System.out.println(Arrays.toString(ans));
    }
}