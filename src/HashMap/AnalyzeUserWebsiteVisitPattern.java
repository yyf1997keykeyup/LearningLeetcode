package HashMap;

import java.util.*;

/**
 * From: https://leetcode.com/problems/analyze-user-website-visit-pattern/
 * 1152. Analyze User Website Visit Pattern (Medium)
 */
public class AnalyzeUserWebsiteVisitPattern {
    class Record {
        String username;
        int timestamp;
        String website;
        Record(String username, int timestamp, String website) {
            this.username = username;
            this.timestamp = timestamp;
            this.website = website;
        }
    }
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int len = username.length;
        Record[] records = new Record[len];
        for (int i=0; i<len; i++) {
            records[i] = new Record(username[i], timestamp[i], website[i]);
        }
        Arrays.sort(records, (r1, r2) -> {
            if (r1.timestamp == r2.timestamp) {
                return r1.website.compareTo(r2.website);
            }
            return r1.timestamp - r2.timestamp;
        });
        Map<String, List<Integer>> name2tokens = new HashMap<>();
        Map<String, Set<String>> tokensStr2usernameSet = new HashMap<>();
        Map<String, Integer> website2token = new HashMap<>();
        Map<Integer, String> token2website = new HashMap<>();

        int nextToken = 0;
        for (Record record : records) {
            if (!name2tokens.containsKey(record.username)) {
                name2tokens.put(record.username, new ArrayList<>());
            }
            if (!website2token.containsKey(record.website)) {
                website2token.put(record.website, nextToken);
                token2website.put(nextToken, record.website);
                nextToken++;
            }
            name2tokens.get(record.username).add(website2token.get(record.website));
            int size = name2tokens.get(record.username).size();
            if (size >= 3) {
                for (int i=0; i<size-2; i++) {
                    for (int j=i+1; j<size-1; j++) {
                        String tokensStr = name2tokens.get(record.username).get(i) + " " +
                                name2tokens.get(record.username).get(j) + " " +
                                name2tokens.get(record.username).get(size - 1);
                        if (!tokensStr2usernameSet.containsKey(tokensStr)) {
                            tokensStr2usernameSet.put(tokensStr, new HashSet<>());
                        }
                        tokensStr2usernameSet.get(tokensStr).add(record.username);
                    }
                }
            }
        }
        String[] maxSequence = new String[3];
        int maxSum = 0;
        for (Map.Entry<String, Set<String>> entry : tokensStr2usernameSet.entrySet()) {
            int sum = entry.getValue().size();
            if (sum > maxSum) {
                maxSum = sum;
                String tokensStr = entry.getKey();
                String[] tokens = tokensStr.split(" ");
                for (int i=0; i<3; i++) {
                    maxSequence[i] = token2website.get(Integer.parseInt(tokens[i]));
                }
            } else if (sum == maxSum) {
                String[] currSequence = new String[3];
                String tokensStr = entry.getKey();
                String[] tokens = tokensStr.split(" ");
                for (int i=0; i<3; i++) {
                    currSequence[i] = token2website.get(Integer.parseInt(tokens[i]));
                }
                if (!compareSequences(maxSequence, currSequence)) {
                    maxSequence = currSequence;
                }
            }
        }
        return Arrays. asList(maxSequence);
    }
    private boolean compareSequences(String[] s1, String[] s2) {
        /* return false when s1 < s2*/
        for (int i=0; i<3; i++) {
            if (s1[i].compareTo(s2[i]) < 0) {
                return true;
            } else if (s1[i].compareTo(s2[i]) > 0) {
                return false;
            }
        }
        return true;
    }
}
