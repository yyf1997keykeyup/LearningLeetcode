package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> output = new ArrayList<>();
        backtrack(output, word, 0, "", 0);
        return output;
    }

    private void backtrack(List<String> output, String word, int idx, String cur, int count) {
        if (idx == word.length()) {
            if (count > 0) {
                cur += count;
            }
            output.add(cur);
            return;
        }
        backtrack(output, word, idx + 1, cur, count + 1);
        backtrack(output, word, idx + 1, cur + (count > 0 ? count : "") + word.charAt(idx), 0);
    }
}
