package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question 41: Insert Interval (LeetCode 57)
 * 
 * Problem Statement:
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] 
 * represented in ascending order by starti. You are also given a new interval newInterval = [start, end] 
 * that represents the start and end of another interval.
 * 
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti 
 * and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 * 
 * Return intervals after the insertion.
 * 
 * Example:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * 
 * Logic:
 * 1. Add all intervals from the left side that end before the new interval starts.
 * 2. Merge all overlapping intervals with the new interval by updating its start and end.
 *    - newInterval[0] = min(newInterval[0], currentInterval[0])
 *    - newInterval[1] = max(newInterval[1], currentInterval[1])
 * 3. Add the merged newInterval.
 * 4. Add all intervals from the right side that start after the new interval ends.
 * 
 * Complexity:
 * - Time Complexity: O(n), where n is the number of intervals.
 * - Space Complexity: O(n) to store the result list.
 */
public class Question41 {

    /**
     * Inserts a new interval into a sorted list of non-overlapping intervals and merges if necessary.
     * @param intervals sorted non-overlapping intervals
     * @param newInterval interval to insert
     * @return merged intervals
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Step 1: Add all intervals that end before the new interval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Step 2: Merge overlapping intervals with the new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        // Add the merged new interval
        result.add(newInterval);

        // Step 3: Add the remaining intervals
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("           Insert Interval Solver          ");
        System.out.println("==========================================\n");

        // Test Case 1: Simple insertion with merge
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        runTest(intervals1, newInterval1, "Basic Merge Case");

        // Test Case 2: Merge multiple intervals
        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        runTest(intervals2, newInterval2, "Multiple Merge Case");

        // Test Case 3: No overlap, insert at beginning
        int[][] intervals3 = {{3, 5}, {6, 9}};
        int[] newInterval3 = {1, 2};
        runTest(intervals3, newInterval3, "Insert at Beginning");

        // Test Case 4: No overlap, insert at end
        int[][] intervals4 = {{1, 2}, {3, 5}};
        int[] newInterval4 = {6, 8};
        runTest(intervals4, newInterval4, "Insert at End");

        // Test Case 5: Empty intervals array
        int[][] intervals5 = {};
        int[] newInterval5 = {5, 7};
        runTest(intervals5, newInterval5, "Empty Input Case");

        // Test Case 6: Full coverage merge
        int[][] intervals6 = {{1, 5}};
        int[] newInterval6 = {0, 6};
        runTest(intervals6, newInterval6, "Full Coverage Case");
    }

    private static void runTest(int[][] intervals, int[] newInterval, String testName) {
        System.out.println("Test: " + testName);
        System.out.println("Intervals: " + formatIntervals(intervals));
        System.out.println("New Interval: " + Arrays.toString(newInterval));
        
        int[][] result = insert(intervals, newInterval);
        
        System.out.println("Result: " + formatIntervals(result));
        System.out.println("------------------------------------------\n");
    }

    private static String formatIntervals(int[][] intervals) {
        if (intervals.length == 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < intervals.length; i++) {
            sb.append(Arrays.toString(intervals[i]));
            if (i < intervals.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
