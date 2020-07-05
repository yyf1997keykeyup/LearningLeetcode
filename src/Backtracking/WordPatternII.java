package Backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {
        /*
         * From: https://leetcode.com/problems/word-pattern-ii/discuss/73664/Share-my-Java-backtracking-solution
         */
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return isMatch(str, 0, pattern, 0, map, set);
    }

    boolean isMatch(String str, int i, String pat, int j, Map<Character, String> map, Set<String> set) {
        // base case
        if (i == str.length() && j == pat.length()) {
            return true;
        }
        if (i == str.length() || j == pat.length()) {
            return false;
        }
        char c = pat.charAt(j);
        if (map.containsKey(c)) {
            String s = map.get(c);
            if (str.startsWith(s, i)) {
                return isMatch(str, i + s.length(), pat, j + 1, map, set);
            }
            return false;
        }
        // if pattern character does not exist in the map,
        // try every possible matches
        for (int k = i; k < str.length(); k++) {
            String p = str.substring(i, k + 1);
            if (set.contains(p)) {
                continue;
            }
            map.put(c, p);
            set.add(p);
            if (isMatch(str, k + 1, pat, j + 1, map, set)) {
                return true;
            }
            map.remove(c);
            set.remove(p);
        }
        return false;
    }
}
