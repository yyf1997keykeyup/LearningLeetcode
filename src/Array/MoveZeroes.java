package Array;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int ia = 0, ib = 0;
        while (ia < nums.length) {
            if (nums[ia] != 0) {
                nums[ib] = nums[ia];
                ib++;
            }
            ia++;
        }
        while (ib < nums.length) {
            nums[ib] = 0;
            ib++;
        }
    }
}
