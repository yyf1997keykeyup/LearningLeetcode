package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> output = new ArrayList<>();
        backtrack(output, new String[]{"", "", "", ""}, 0, s, 0);
        return output;
    }
    private void backtrack(List<String> output, String[] ipArray, int idxIp, String s, int idxS) {
        if (idxS == s.length()) {
            if (idxIp == 4 & validateIP(ipArray)) {
                output.add(ipArrayToString(ipArray));
            }
            return;
        }
        if (idxIp >= 4) {
            return;
        }
        if (ipArray[idxIp].length() >= 3) {
            return;
        }
        ipArray[idxIp] += s.charAt(idxS);
        backtrack(output, ipArray, idxIp, s, idxS+1);
        backtrack(output, ipArray, idxIp+1, s, idxS+1);
        ipArray[idxIp] = ipArray[idxIp].substring(0, ipArray[idxIp].length()-1);
    }
    private boolean validateIP(String[] ipArray) {
        for (String s : ipArray) {
            if (s.length() > 1 && s.startsWith("0")) {
                return false;
            }
            if (s.length() == 3 && Integer.parseInt(s) > 255) {
                return false;
            }
        }
        return true;
    }
    private String ipArrayToString(String[] ipArray) {
        StringBuilder sb = new StringBuilder(ipArray[0]);
        for (int i=1; i<ipArray.length; i++) {
            sb.append(".").append(ipArray[i]);
        }
        return sb.toString();
    }
}
