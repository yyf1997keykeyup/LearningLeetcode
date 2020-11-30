package Greedy;

public class JumpGameII {
    public int jump(int[] nums) {
        int minJumps = 0;
        int end = 0, farthest = 0;
        for (int i=0; i<nums.length-1; i++) {
            farthest = Math.max(nums[i]+i, farthest);
            if (end == i) {
                minJumps++;
                end = farthest;
            }
        }
        return minJumps;
    }
}
