package StackQueue;

import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            int ii = i % nums.length;
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[ii]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                res[ii] = -1;
            } else {
                res[ii] = nums[stack.peek()];
            }
            stack.push(ii);
        }
        return res;
    }
}
