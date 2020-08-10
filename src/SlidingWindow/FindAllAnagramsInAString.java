package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * From: https://leetcode.com/problems/find-all-anagrams-in-a-string/
 * 438. Find All Anagrams in a String (Medium)
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s2, String s1) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (char c : s1.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0, counter = 0;
        while (r < s2.length()) {
            char rc = s2.charAt(r);
            r++;
            if (needs.containsKey(rc)) {
                window.put(rc, window.getOrDefault(rc, 0) + 1);
                if (needs.get(rc).equals(window.get(rc))) {
                    counter++;
                }
            }
            while (r - l >= s1.length()) {
                if (counter == needs.size()) {
                    res.add(l);
                }
                char lc = s2.charAt(l);
                l++;
                if (needs.containsKey(lc)) {
                    if (window.get(lc).equals(needs.get(lc))) {
                        counter--;
                    }
                    window.put(lc, window.getOrDefault(lc, 0) - 1);
                }
            }
        }
        return res;
    }
}
