package String;

import java.util.Arrays;

/**
 * From: https://leetcode.com/problems/reorder-data-in-log-files/
 * 937. Reorder Data in Log Files (Easy)
 */
public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (log1, log2) -> {
            String[] splitLog1 = log1.split(" ", 2);
            boolean isDigit1 = Character.isDigit(splitLog1[1].charAt(0));
            String[] splitLog2 = log2.split(" ", 2);
            boolean isDigit2 = Character.isDigit(splitLog2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int comapreRes = splitLog1[1].compareTo(splitLog2[1]);
                if (comapreRes == 0) {
                    return splitLog1[0].compareTo(splitLog2[0]);
                }
                return comapreRes;
            }
            if (isDigit1 && !isDigit2) {
                return 1;
            }
            if (!isDigit1 && isDigit2) {
                return -1;
            }
            // isDigit1 && isDigit2
            return 0;
        });
        return logs;
    }

}
