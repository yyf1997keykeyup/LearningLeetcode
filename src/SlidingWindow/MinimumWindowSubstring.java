package SlidingWindow;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * From: https://leetcode.com/problems/minimum-window-substring/
 * 76. Minimum Window Substring (Hard)
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> char2count = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char2count.put(t.charAt(i), char2count.getOrDefault(t.charAt(i), 0) + 1);
        }
        int countSize = char2count.size();
        List<Pair<Integer, Character>> sequences = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (char2count.containsKey(c)) {
                sequences.add(new Pair<>(i, c));
            }
        }
        int l = 0, r = 0, currSize = 0;
        Map<Character, Integer> windowCounter = new HashMap<>();
        
        int maxLength = -1;
        int startIdx = 0;
        int endIdx = 0;

        while (r < sequences.size()) {
            char rc = sequences.get(r).getValue();
            windowCounter.put(rc, windowCounter.getOrDefault(rc, 0) + 1);

            if (char2count.containsKey(rc) && windowCounter.get(rc).equals(char2count.get(rc))) {
                currSize++;
            }
            while (l <= r && currSize == countSize) {
                char lc = sequences.get(l).getValue();
                int rIdx = sequences.get(r).getKey();
                int lIdx = sequences.get(l).getKey();
                if (maxLength == -1 || rIdx - lIdx + 1 < maxLength) {
                    maxLength = rIdx - lIdx + 1;
                    startIdx = lIdx;
                    endIdx = rIdx;
                }
                windowCounter.put(lc, windowCounter.get(lc) - 1);
                if (char2count.containsKey(lc) && windowCounter.get(lc) < char2count.get(lc)) {
                    currSize--;
                }
                l++;
            }
            r++;
        }
        return maxLength == -1 ? "" : s.substring(startIdx, endIdx + 1);
    }
}
