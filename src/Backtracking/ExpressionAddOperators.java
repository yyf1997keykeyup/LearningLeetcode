package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        /*
         * From: https://leetcode.com/problems/expression-add-operators/discuss/71895/Java-Standard-Backtrace-AC-Solutoin-short-and-clear
         */
        List<String> rst = new ArrayList<>();
        if (num == null || num.length() == 0) return rst;
        backtrack(rst, "", num, target, 0, 0, 0);
        return rst;
    }

    public void backtrack(List<String> rst, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (target == eval)
                rst.add(path);
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') {
                break;  // avoid number like 001123
            }
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                backtrack(rst, path + cur, num, target, i + 1, cur, cur);
            } else {
                backtrack(rst, path + "+" + cur, num, target, i + 1, eval + cur, cur);
                backtrack(rst, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                backtrack(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }
}
