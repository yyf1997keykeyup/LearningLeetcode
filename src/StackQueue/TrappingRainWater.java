package StackQueue;

import java.util.Stack;

public class TrappingRainWater {
    /* Monotone Stack Version */
    public int trap(int[] height) {
        int waterSum = 0;
        int i=0;
        Stack<Integer> stack = new Stack<>();
        while (i < height.length) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int right = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = i - stack.peek() - 1;
                int minHeight = Math.min(height[i], height[stack.peek()]) - height[right];
                waterSum += distance * minHeight;
            }
            stack.push(i++);
        }
        return waterSum;
    }
}
