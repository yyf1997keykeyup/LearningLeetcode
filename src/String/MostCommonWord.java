package String;

import java.util.*;

/**
 * From: https://leetcode.com/problems/most-common-word/
 * 819. Most Common Word (Easy)
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
        String[] words = paragraph.split("\\s+");
        for (String word : words) {
            System.out.println(word);
        }
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            if (!bannedSet.contains(word)) {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }
        String maxWord = "";
        int maxFreq = 0;
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxWord = entry.getKey();
                maxFreq = entry.getValue();
            }
        }
        return maxWord;
        //  return Collections.max(freqMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
