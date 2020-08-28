package Graph;

import java.util.*;

public class AlienDictionary {
    /*
    * Refer to: https://leetcode.com/problems/alien-dictionary/solution/
    * DFS & Topological Sort
    */
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> adjacentList = new HashMap<>();
        Map<Character, Integer> count = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                adjacentList.put(c, new ArrayList<>());
                count.put(c, 0);
            }
        }

        for (int i = 0; i + 1 < words.length; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            for (int j = 0; j < word1.length() && j < word2.length(); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adjacentList.get(word1.charAt(j)).add(word2.charAt(j));
                    count.put(word2.charAt(j), count.get(word2.charAt(j)) + 1);
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (char c : count.keySet()) {
            if (count.get(c) == 0) {
                queue.add(c);
            }
        }
        while (!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for (char adjChar : adjacentList.get(c)) {
                count.put(adjChar, count.get(adjChar) - 1);
                if (count.get(adjChar) == 0) {
                    queue.add(adjChar);
                }
            }
        }
        if (sb.length() < count.size()) {
            return "";
        }
        return sb.toString();
    }
}
