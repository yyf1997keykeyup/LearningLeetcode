package StackQueue;

import java.util.*;

/**
 * From: https://leetcode.com/problems/top-k-frequent-words/
 * 692. Top K Frequent Words (Medium)
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> counter = new HashMap<>();
        for (String word : words) {
            counter.put(word, counter.getOrDefault(word,0) + 1);
        }
        PriorityQueue<String> maxHeap = new PriorityQueue<>((s1, s2) -> counter.get(s1).equals(counter.get(s2)) ? s2.compareTo(s1) : counter.get(s1) - counter.get(s2));
        for (Map.Entry counterEntry : counter.entrySet()) {
            maxHeap.offer((String) counterEntry.getKey());
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        List<String> output = new ArrayList<>();
        while (maxHeap.size() != 0) {
            output.add(maxHeap.poll());
        }
        Collections.reverse(output);
        return output;
    }
}
