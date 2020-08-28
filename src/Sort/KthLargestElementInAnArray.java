package Sort;

import java.util.Random;

import java.util.Random;
class KthLargestElementInAnArray {
    int [] nums;

    public void swap(int a, int b) {
        int tmp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = tmp;
    }

    public int partition(int left, int right, int pivotIndex) {
        int pivot = this.nums[pivotIndex];
        // 1. move pivot to end
        swap(pivotIndex, right);
        int storeIndex = left;
        // 2. move all smaller elements to the left
        for (int i = left; i <= right; i++) {
            if (this.nums[i] < pivot) {
                swap(storeIndex, i);
                storeIndex++;
            }
        }
        // 3. move pivot to its final place
        swap(storeIndex, right);

        return storeIndex;
    }

    public int quickselect(int left, int right, int k_smallest) {
        if (left == right) {
            return this.nums[left];
        }
        // select a random pivot_index
        Random random = new Random();
        int pivot_index = left + random.nextInt(right - left);

        pivot_index = partition(left, right, pivot_index);

        // the pivot is on (N - k)th smallest position
        if (k_smallest == pivot_index)
            return this.nums[k_smallest];
            // go left side
        else if (k_smallest < pivot_index)
            return quickselect(left, pivot_index - 1, k_smallest);
        // go right side
        return quickselect(pivot_index + 1, right, k_smallest);
    }

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int size = nums.length;
        return quickselect(0, size - 1, size - k);
    }
}