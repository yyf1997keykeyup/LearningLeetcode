package Design;


import java.util.*;

public class InsertDeleteGetRandomO1 {
    Map<Integer, Integer> num2idx;
    List<Integer> nums;
    Random rand;

    /**
     * Initialize your data structure here.
     */
    public InsertDeleteGetRandomO1() {
        num2idx = new HashMap<>();
        nums = new ArrayList<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (num2idx.containsKey(val)) {
            return false;
        }
        num2idx.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!num2idx.containsKey(val)) {
            return false;
        }
        int lastElement = nums.get(nums.size() - 1);
        int idx = num2idx.get(val);

        nums.set(idx, lastElement);
        num2idx.put(lastElement, idx);

        nums.remove(nums.size() - 1);
        num2idx.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
