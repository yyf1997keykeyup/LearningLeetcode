package StackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class BasicCalculatorIII {
    public int calculate(String s) {
        Queue<Character> tokens = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') tokens.offer(c);
        }
        tokens.offer('+');
        return calculate(tokens);
    }

    private int calculate(Queue<Character> tokens) {
        char preOp = '+';
        int num = 0, sum = 0, prev = 0;
        while (!tokens.isEmpty()) {
            char c = tokens.poll();

            if ('0' <= c && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '(') {
                num = calculate(tokens);
            } else {
                switch (preOp) {
                    case '+': {
                        sum += prev;
                        prev = num;
                    }
                    case '-': {
                        sum += prev;
                        prev = -num;
                    }
                    case '*': {
                        prev *= num;
                    }
                    case '/': {
                        prev /= num;
                    }
                }
                if (c == ')') {
                    break;
                }
                preOp = c;
                num = 0;
            }
        }
        return sum + prev;
    }
}
