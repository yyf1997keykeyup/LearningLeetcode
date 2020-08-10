package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

/**
 * From: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 3. Longest Substring Without Repeating Characters (Medium)
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if (set.contains(s.charAt(j))){
                set.remove(s.charAt(i));
                i++;
            } else {
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j-i);
            }
        }
        return ans;
    }
}
