//Question 8
//        Given an array of meeting time intervals where intervals[i] = [starti, endi],
//        determine if a person could attend all meetings.
//
//        Example 1:
//        Input: intervals = [[0,30],[5,10],[15,20]]
//        Output: false


package ppt_assignment3;

import java.util.Arrays;

public class MeetingTimeIntervals {
    public static boolean canAttendMeetings(int[][] intervals) {
        // Sort the intervals based on the start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Check if there is any overlap between adjacent intervals
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false; // Overlap found, person cannot attend all meetings
            }
        }

        return true; // No overlap found, person can attend all meetings
    }

    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        boolean canAttendAllMeetings = canAttendMeetings(intervals);
        System.out.println("Can attend all meetings? " + canAttendAllMeetings);
    }
}
