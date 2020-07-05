package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    Map<Character, String> phone = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();
        if (digits.length() != 0) {
            backtrack(output, "", digits, 0);
        }
        return output;
    }

    private void backtrack(List<String> output, String curComb, String digits, int idx) {
        if (idx == digits.length()) {
            output.add(curComb);
            return;
        }
        char digit = digits.charAt(idx);
        String letters = phone.get(digit);
        for (int i=0; i<letters.length(); i++) {
            String letter = letters.substring(i, i+1);
            backtrack(output, curComb + letter, digits, idx+1);
        }
    }
}
