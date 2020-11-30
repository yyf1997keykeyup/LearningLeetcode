package StackQueue;

import java.util.Stack;

public class FindTheMostCompetitiveSubsequence {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] output = new int[k];
        int len = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<len; i++) {
            int num = nums[i];
            // compare and pop
            while (!stack.isEmpty() && stack.peek() > num && i<len-k+stack.size()) {
                stack.pop();
            }
            if (stack.size() < k) {
                stack.push(num);
            }
        }
        for (int kk=k-1; kk>=0; kk--) {
            output[kk] = stack.pop();
            if (stack.isEmpty()) {
                break;
            }
        }
        return output;
    }
}
