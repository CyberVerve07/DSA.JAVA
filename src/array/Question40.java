package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question 40: Merge Intervals (LeetCode 56)
 * 
 * Problem Statement:
 * Given an array of intervals where intervals[i] = [starti, endi], 
 * merge all overlapping intervals, and return an array of the 
 * non-overlapping intervals that cover all the intervals in the input.
 * 
 * Example:
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * 
 * Logic:
 * 1. Sort the intervals based on their start times.
 * 2. Initialize a list to hold the merged intervals.
 * 3. Iterate through the sorted intervals:
 *    - If the list is empty or the current interval's start time is greater than 
 *      the end time of the last interval in the list, add the current interval.
 *    - Otherwise, they overlap; update the end time of the last interval in the 
 *      list to be the maximum of its current end time and the current interval's end time.
 * 
 * Complexity:
 * - Time Complexity: O(n log n) due to sorting, where n is the number of intervals.
 * - Space Complexity: O(log n) or O(n) depending on the space used by the sorting algorithm.
 */
public class Question40 {

    /**
     * Merges overlapping intervals.
     * @param intervals 2D array of intervals
     * @return 2D array of merged intervals
     */
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Step 1: Sort the intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        
        // Start with the first interval
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int i = 1; i < intervals.length; i++) {
            int currentEnd = currentInterval[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if (nextStart <= currentEnd) {
                // Overlapping: update the end of the current interval
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // Non-overlapping: move to the next interval
                currentInterval = intervals[i];
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("           Merge Intervals Solver          ");
        System.out.println("==========================================\n");

        // Test Case 1: Overlapping intervals
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        runTest(intervals1, "Overlapping Case");

        // Test Case 2: Non-overlapping intervals
        int[][] intervals2 = {{1, 4}, {5, 6}};
        runTest(intervals2, "Non-overlapping Case");

        // Test Case 3: Fully contained intervals
        int[][] intervals3 = {{1, 10}, {2, 3}, {4, 5}, {6, 7}};
        runTest(intervals3, "Fully Contained Case");

        // Test Case 4: Identical intervals
        int[][] intervals4 = {{1, 4}, {1, 4}};
        runTest(intervals4, "Identical Case");

        // Test Case 5: Single element intervals
        int[][] intervals5 = {{1, 4}, {4, 5}};
        runTest(intervals5, "Touching Edge Case");

        // Test Case 6: Out of order intervals
        int[][] intervals6 = {{8, 10}, {1, 3}, {2, 6}};
        runTest(intervals6, "Unsorted Input Case");
    }

    private static void runTest(int[][] intervals, String testName) {
        System.out.println("Test: " + testName);
        System.out.print("Input: ");
        printIntervals(intervals);
        
        int[][] result = merge(intervals);
        
        System.out.print("Merged: ");
        printIntervals(result);
        System.out.println("------------------------------------------\n");
    }

    private static void printIntervals(int[][] intervals) {
        System.out.print("[");
        for (int i = 0; i < intervals.length; i++) {
            System.out.print(Arrays.toString(intervals[i]));
            if (i < intervals.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
