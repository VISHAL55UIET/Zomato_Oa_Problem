import java.util.*;

class SegmentTree {

    private static final int MAXK = 6;

    private int k;
    private int n;
    private int[][] tree;

    public SegmentTree(int[] nums, int k) {
        this.k = k;
        this.n = nums.length;
        int size = 2 << Integer.toBinaryString(n).length();
        tree = new int[size][MAXK];
        build(nums, 1, 0, n - 1);
    }
    private void makeLeaf(int o, int value) {
        Arrays.fill(tree[o], 0);
        int r = value % k;
        tree[o][r] = 1;
        tree[o][k] = r;
    }
    private void mergePre(int[] left, int[] right, int[] result) {
        int mulL = left[k];
        int mulR = right[k];
        result[k] = (mulL * mulR) % k;
        // Subarrays completely inside left
        for (int x = 0; x < k; x++) {
            result[x] = left[x];
        }
        // Subarrays starting from right
        for (int x = 0; x < k; x++) {
            result[(mulL * x) % k] += right[x];
        }
    }
    private void maintain(int o) {
        mergePre(tree[o * 2], tree[o * 2 + 1], tree[o]);
    }
    private void build(int[] nums, int o, int l, int r) {
        if (l == r) {
            makeLeaf(o, nums[l]);
            return;
        }
        int m = (l + r) / 2;
        build(nums, o * 2, l, m);
        build(nums, o * 2 + 1, m + 1, r);
        maintain(o);
    }
    public void update(int o, int l, int r, int index, int value) {
        if (l == r) {
            makeLeaf(o, value);
            return;
        }
        int m = (l + r) / 2;
        if (index <= m) {
            update(o * 2, l, m, index, value);
        } else {
            update(o * 2 + 1, m + 1, r, index, value);
        }
        maintain(o);
    }

    public int[] query(int o, int l, int r, int L, int R) {
        if (L <= l && r <= R) {
            return tree[o];
        }
        int m = (l + r) / 2;
        if (R <= m) {
            return query(o * 2, l, m, L, R);
        }
        if (L > m) {
            return query(o * 2 + 1, m + 1, r, L, R);
        }
        int[] left = query(o * 2, l, m, L, R);
        int[] right = query(o * 2 + 1, m + 1, r, L, R);
        int[] result = new int[MAXK];
        mergePre(left, right, result);
        return result;
    }
}

class Solution {
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        SegmentTree seg = new SegmentTree(nums, k);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];
            // Update nums[index]
            seg.update(1, 0, n - 1, index, value);
            // Query range [start, n - 1]
            int[] pre = seg.query(1, 0, n - 1, start, n - 1);
            ans[i] = pre[x];
        }
        return ans;
    }
}

public class SegmentTreeProductQueries {

    public static void main(String[] args) {

        Solution sol = new Solution();

        int[] nums1 = {6,7,8,9,10};

        int k1 = 3;

        int[][] queries1 = {
            {0, 6, 0, 0},
            {2, 5, 1, 2},
            {4, 3, 2, 1}
        };

        int[] result1 = sol.resultArray(nums1, k1, queries1);

        System.out.println("Test Case 1:");
        System.out.println(Arrays.toString(result1));
        int[] nums2 = {1,2,3,4};

        int k2 = 2;

        int[][] queries2 = {
            {1, 3, 0, 0},
            {3, 5, 1, 1}
        };

        int[] result2 = sol.resultArray(nums2, k2, queries2);

        System.out.println("\nTest Case 2:");
        System.out.println(Arrays.toString(result2));
        int[] nums3 = {1, 1, 1, 1};
        int k3 = 2;
        int[][] queries3 = {
            {0, 2, 0, 0},
            {2, 4, 1, 1},
            {3, 6, 0, 0}
        };
        int[] result3 = sol.resultArray(nums3, k3, queries3);
        System.out.println("\nTest Case 3:");
        System.out.println(Arrays.toString(result3));
        int[] nums4 = {3, 6, 9, 12};
        int k4 = 3;
        int[][] queries4 = {
            {0, 2, 0, 0},
            {1, 5, 1, 0},
            {2, 7, 0, 1}
        };

        int[] result4 = sol.resultArray(nums4, k4, queries4);
        System.out.println("\nTest Case 4:");
        System.out.println(Arrays.toString(result4));
    }
}