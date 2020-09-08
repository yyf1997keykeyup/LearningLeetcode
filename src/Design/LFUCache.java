package Design;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
    HashMap<Integer, Integer> values;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> count2set;
    int cap;
    int min = -1;

    public LFUCache(int capacity) {
        cap = capacity;
        values = new HashMap<>();
        counts = new HashMap<>();
        count2set = new HashMap<>();
        count2set.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!values.containsKey(key)) {
            return -1;
        }
        int count = counts.get(key);
        counts.put(key, count + 1);
        count2set.get(count).remove(key);
        if (count == min && count2set.get(count).size() == 0) {
            min++;
        }
        if (!count2set.containsKey(count + 1)) {
            count2set.put(count + 1, new LinkedHashSet<>());
        }
        count2set.get(count + 1).add(key);
        return values.get(key);
    }

    public void put(int key, int value) {
        if (cap <= 0) {
            return;
        }
        if (values.containsKey(key)) {
            values.put(key, value);
            get(key);
            return;
        }
        // if not contain key
        if (values.size() >= cap) {
            int evict = count2set.get(min).iterator().next();
            count2set.get(min).remove(evict);
            values.remove(evict);
        }
        values.put(key, value);
        counts.put(key, 1);
        min = 1;
        count2set.get(1).add(key);
    }
}
