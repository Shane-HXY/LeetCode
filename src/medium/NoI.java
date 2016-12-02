package medium;

/**
 * Created by huangxiangyu on 2016/12/2.
 */
/*
Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note:
You may assume the interval's end point is always bigger than its start point.
Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
Example 1:
Input: [ [1,2], [2,3], [3,4], [1,3] ]

Output: 1

Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
Example 2:
Input: [ [1,2], [1,2], [1,2] ]

Output: 2

Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
Example 3:
Input: [ [1,2], [2,3] ]

Output: 0

Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class NoI { //  Non-overlapping Intervals
    static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0;}
        Interval(int s, int e) { start = s; end = e;}
    }
    // public int eraseOverlapIntervals(Interval[] intervals) {
    //     Interval in;
    //     for (int i = 1; i < intervals.length; i++) {
    //         in = intervals[i];
    //         int j = i - 1;
    //         while (j >= 0 && (in.end > intervals[j].end ||
    //             (in.end == intervals[j].end && in.start < intervals[j].start))) {
    //             intervals[j+1] = intervals[j];
    //             --j;
    //         }
    //         intervals[j+1] = in;
    //     }
    //     for (int i = 0; i < intervals.length; i++) {
    //         System.out.println(intervals[i].start + " " + intervals[i].end);
    //     }
    //     boolean[] remove = new boolean[intervals.length];
    //     int res = 0;
    //     java.util.Arrays.fill(remove, false);
    //     for (int i = 1; i < intervals.length; i++) {
    //         for (int j = 0; j < i; j++) {
    //             if (Integer.compare(intervals[j].end, intervals[i].start) > 0 && remove[j] ==false) {
    //                 remove[i] = true;
    //                 ++res;
    //             }
    //         }
    //     }
    //     return res;
    // }
    class IntvComp implements java.util.Comparator<Interval> {

        @Override
        public int compare(Interval in1, Interval in2) {
            if (in1.end != in2.end) {
                return in1.end - in2.end;
            } else {
                return in1.start - in2.start;
            }
        }
    }
    public int eraseOverlapIntervals_new(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        java.util.Arrays.sort(intervals, new IntvComp());

        int res = 0;
        int comp = intervals[0].end;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= comp) {
                comp = intervals[i].end;
                continue;
            }
            if (intervals[i].end >= comp) {
                res++;
            } else {
                res++;
                comp = intervals[i].end;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        // Interval[] itv = {new Interval(600, 830),
        //                 new Interval(800, 900),
        //                 new Interval(900, 1100),
        //                 new Interval(900, 1130),
        //                 new Interval(1030, 1400),
        //                 new Interval(1230, 1400)};
        // Interval[] itv = {new Interval(1,2), new Interval(1, 2), new Interval(1, 2)};
        Interval[] itv = {new Interval(1, 100), new Interval(2, 12), new Interval(1, 11), new Interval(11, 22)};
        // int i = new NoI().eraseOverlapIntervals(itv);
        int i = new NoI().eraseOverlapIntervals_new(itv);
        System.out.println(i);
    }
}
