package Backtracking;

import java.util.*;

public class WordBreakII {
    private Set<String> wordSet;
    private Map<String, List<List<String>>> memo;

    public List<String> wordBreak(String s, List<String> wordDict) {
        wordSet = new HashSet<>();
        wordSet.addAll(wordDict);
        memo = new HashMap<>();

        backtrack(s);

        List<String> output = new ArrayList<>();
        for (List<String> words : memo.get(s)) {
            StringBuilder sentence = new StringBuilder();
            for (int i = words.size() - 1; i >= 0; i--) {
                sentence.append(words.get(i)).append(" ");
            }
            output.add(sentence.toString().substring(0, sentence.length() - 1));
        }
        return output;
    }

    protected List<List<String>> backtrack(String s) {
        if (s.length() == 0) {
            List<List<String>> solutions = new ArrayList<>();
            solutions.add(new ArrayList<>());
            return solutions;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        memo.put(s, new ArrayList<>());

        for (int endIdx = 1; endIdx <= s.length(); endIdx++) {
            String word = s.substring(0, endIdx);
            if (wordSet.contains(word)) {
                // keep in mind that this is reverse order
                List<List<String>> subSentences = backtrack(s.substring(endIdx));
                for (List<String> subSentence : subSentences) {
                    List<String> newSentence = new ArrayList<>(subSentence);
                    newSentence.add(word);
                    memo.get(s).add(newSentence);
                }
            }
        }
        return memo.get(s);
    }
    public static void main(String[] args) {
        new WordBreakII().wordBreak("catsanddog", new ArrayList<String>() {{
            add("cat");add("cats");add("and");add("sand");add("dog");
        }});
    }
}
