package StackQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(intervals.length, (t1, t2) -> {return t1 - t2;});
        Arrays.sort(intervals, (t1, t2) -> {return t1[0] - t2[0];});
        queue.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= queue.peek()) {
                queue.poll();
            }
            queue.add(intervals[i][1]);
        }
        return queue.size();
    }
}
