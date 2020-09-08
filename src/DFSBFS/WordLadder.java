package DFSBFS;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        Map<String, List<String>> genericMap = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < len; i++) {
                String genericWord = word.substring(0, i) + '*' + word.substring(i + 1, len);
                if (!genericMap.containsKey(genericWord)) {
                    genericMap.put(genericWord, new ArrayList<>());
                }
                genericMap.get(genericWord).add(word);
            }
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (int j = 0; j < len; j++) {
                    String genericWord = word.substring(0, j) + '*' + word.substring(j + 1, len);
                    if (!genericMap.containsKey(genericWord)) {
                        continue;
                    }
                    for (String adjWord : genericMap.get(genericWord)) {
                        if (adjWord.equals(endWord)) {
                            return level + 1;
                        }
                        if (!visited.contains(adjWord)) {
                            visited.add(adjWord);
                            queue.add(adjWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
