package Greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * From: https://leetcode.com/problems/partition-labels/
 * 763. Partition Labels (Medium)
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        int[] lastIdx = new int[26];
        for (int i = 0; i < S.length(); ++i) {
            lastIdx[S.charAt(i) - 'a'] = i;
        }
        int right = 0;
        int left = 0;
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < S.length(); ++i) {
            right = Math.max(right, lastIdx[S.charAt(i) - 'a']);
            if (i == right) {
                output.add(right - left + 1);
                left = right + 1;
            }
        }
        return output;
    }
}
