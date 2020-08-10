package HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * From: https://leetcode.com/problems/subarray-sum-equals-k/
 * 560. Subarray Sum Equals K (Medium)
 */
public class SubarraySumEqualsK {
    /**
     * Time Complexity: O(N^2)
     */
    public int subarraySumPrefixSum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (sum[i] - sum[j] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    /**
     * Time Complexity: O(N)
     */
    int subarraySum(int[] nums, int k) {
        // prefixSum -> count
        Map<Integer, Integer> preSum = new HashMap<>();
        // base case
        preSum.put(0, 1);
        int ans = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            int sum0_j = sum - k;
            if (preSum.containsKey(sum0_j)) {
                ans += preSum.get(sum0_j);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
