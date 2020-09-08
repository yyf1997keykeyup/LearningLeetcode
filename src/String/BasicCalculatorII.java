package String;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int sum = 0;
        int tempSum = 0;
        int num = 0;
        char sign = '+';
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if ((!Character.isDigit(c) && c != ' ') || i == len - 1) {
                switch (sign) {
                    case '+':
                        sum += tempSum;
                        tempSum = num;
                        break;
                    case '-' :
                        sum += tempSum;
                        tempSum = -num;
                        break;
                    case '*' :
                        tempSum *= num;
                        break;
                    case '/' :
                        tempSum /= num;
                        break;
                }
                sign = c;
                num = 0;
            }
        }
        return sum + tempSum;
    }
}
