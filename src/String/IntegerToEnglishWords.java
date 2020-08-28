//package String;
//
//public class IntegerToEnglishWords {
//    public String numberToWords(int num) {
//        if (num == 0) {
//            return "Zero";
//        }
//        final int BILLION_NUM = 1000000000;
//        final int MILLION_NUM = 1000000;
//        final int THOUSAND_NUM = 1000;
//        int billion = num / BILLION_NUM;
//        int million = (num - billion * BILLION_NUM) / MILLION_NUM;
//        int thousand = (num - billion * BILLION_NUM - million * MILLION_NUM) / THOUSAND_NUM;
//        int others = num - billion * BILLION_NUM - million * MILLION_NUM - thousand * THOUSAND_NUM;
//
//        StringBuilder sb = new StringBuilder();
//        if (billion != 0) {
//            sb.append(parseThreeDigit(billion));
//            sb.append(" Billion");
//        }
//        if (million != 0) {
//            if (sb.length() != 0) {
//                sb.append(" ");
//            }
//            sb.append(parseThreeDigit(million));
//            sb.append(" Million");
//        }
//        if (thousand != 0) {
//            if (sb.length() != 0) {
//                sb.append(" ");
//            }
//            sb.append(parseThreeDigit(thousand));
//            sb.append(" Thousand");
//        }
//        if (others != 0) {
//            if (sb.length() != 0) {
//                sb.append(" ");
//            }
//            sb.append(parseThreeDigit(others));
//        }
//        return sb.toString();
//    }
//
//    private String parseThreeDigit(int num) {
//        int hundred = num / 100;
//        int others = num - hundred * 100;
//        String res = "";
//        if (hundred != 0 && others != 0) {
//            res = parseOneDigit(hundred) + " Hundred " + parseTwoDigit(others);
//        } else if (hundred == 0 && others != 0) {
//            res = parseTwoDigit(others);
//        } else if (hundred != 0 && others == 0) {
//            res = parseOneDigit(hundred) + " Hundred";
//        }
//        return res;
//    }
//
//    private String parseTwoDigit(int num) {
//        if (num == 0) {
//            return "";
//        } else if (num < 10) {
//            return parseOneDigit(num);
//        } else if (num < 20) {
//            return twoLessThan20(num);
//        } else {
//            int tenner = num / 10;
//            int rest = num - tenner * 10;
//            if (rest == 0) {
//                return ten(tenner);
//            } else {
//                return ten(tenner) + " " + parseOneDigit(rest);
//            }
//        }
//    }
//
//    private String parseOneDigit(int num) {
//        return switch (num) {
//            case 1 -> "One";
//            case 2 -> "Two";
//            case 3 -> "Three";
//            case 4 -> "Four";
//            case 5 -> "Five";
//            case 6 -> "Six";
//            case 7 -> "Seven";
//            case 8 -> "Eight";
//            case 9 -> "Nine";
//            default -> "";
//        };
//    }
//
//    private String twoLessThan20(int num) {
//        return switch (num) {
//            case 10 -> "Ten";
//            case 11 -> "Eleven";
//            case 12 -> "Twelve";
//            case 13 -> "Thirteen";
//            case 14 -> "Fourteen";
//            case 15 -> "Fifteen";
//            case 16 -> "Sixteen";
//            case 17 -> "Seventeen";
//            case 18 -> "Eighteen";
//            case 19 -> "Nineteen";
//            default -> "";
//        };
//    }
//
//    private String ten(int num) {
//        return switch (num) {
//            case 2 -> "Twenty";
//            case 3 -> "Thirty";
//            case 4 -> "Forty";
//            case 5 -> "Fifty";
//            case 6 -> "Sixty";
//            case 7 -> "Seventy";
//            case 8 -> "Eighty";
//            case 9 -> "Ninety";
//            default -> "";
//        };
//    }
//}
