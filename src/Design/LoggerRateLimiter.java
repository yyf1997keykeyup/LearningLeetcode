package Design;

import java.util.HashMap;
import java.util.Map;

/**
 * From: https://leetcode.com/problems/logger-rate-limiter/
 * 359. Logger Rate Limiter (easy)
 */
public class LoggerRateLimiter {
    Map<String, Integer> map;
    /** Initialize your data structure here. */
    public LoggerRateLimiter() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (this.map.containsKey(message)) {
            if (timestamp - this.map.get(message) >= 10) {
                this.map.put(message, timestamp);
                return true;
            }
            return false;
        } else {
            this.map.put(message, timestamp);
            return true;
        }
    }
}
