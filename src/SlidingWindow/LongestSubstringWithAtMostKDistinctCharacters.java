package SlidingWindow;

import java.util.Collections;
import java.util.HashMap;

/**
 * From: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * 340. Longest Substring with At Most K Distinct Characters (Hard)
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }
        int len = s.length();
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> windowsMap = new HashMap<>();
        // windowsMap stores char->the rightmost index
        int maxSubLen = 1;
        while (r < len) {
            windowsMap.put(s.charAt(r), r);
            if (windowsMap.size() > k) {
                int removedIdx = Collections.min(windowsMap.values());
                windowsMap.remove(s.charAt(removedIdx));
                l = removedIdx + 1;
            }
            maxSubLen = Math.max(maxSubLen, r - l + 1);
            r++;
        }
        return maxSubLen;
    }
}
