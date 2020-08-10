package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * From: https://leetcode.com/problems/permutation-in-string/
 * 567. Permutation in String (Medium)
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
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
                    return true;
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
        return false;
    }
}
