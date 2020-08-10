package SlidingWindow;

import java.util.ArrayDeque;

/**
 * From: https://leetcode.com/problems/sliding-window-maximum/
 * 239. Sliding Window Maximum (Hard)
 */
public class SlidingWindowMaximum {
    ArrayDeque<Integer> deque = new ArrayDeque<>();
    int[] nums;

    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0 || k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        // init deque and output
        this.nums = nums;
        int maxIdx = 0;
        for (int i = 0; i < k; i++) {
            cleanDeque(i, k);
            deque.addLast(i);
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }
        int[] output = new int[len - k + 1];
        output[0] = nums[maxIdx];

        for (int i = k; i < len; i++) {
            cleanDeque(i, k);
            deque.addLast(i);
            output[i - k + 1] = nums[deque.getFirst()];
        }
        return output;
    }

    private void cleanDeque(int i, int k) {
        if (!deque.isEmpty() && deque.getFirst() == i - k) {
            deque.removeFirst();
        }
        while (!deque.isEmpty() && nums[i] > nums[deque.getLast()]) {
            deque.removeLast();
        }
    }
}
