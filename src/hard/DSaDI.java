package hard;

/**
 * Created by huangxiangyu on 2016/12/1.
 */
/*
Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]
Follow up:
What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?

Credits:
Special thanks to @yunhong for adding this problem and creating most of the test cases.
*/

import java.util.*;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class DSaDI {    //  Data Stream as Disjoint Intervals

    private TreeSet<Interval> intervals;
    /** Initialize your data structure here. */
    public DSaDI() {
        intervals = new TreeSet<>(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
    }

    public void addNum(int val) {
        Interval interval = new Interval(val, val);
        Interval floor = intervals.floor(interval);
        if (floor != null) {
            if (floor.end >= val) return;
            else if (floor.end + 1 == val) {
                interval.start = floor.start;
                intervals.remove(floor);
            }
        }
        Interval higher = intervals.higher(interval);
        if (higher != null && (higher.start - 1 == val)) {
            interval.end = higher.end;
            intervals.remove(higher);
        }
        intervals.add(interval);
    }

    public List<Interval> getIntervals() {
        return (Arrays.asList(intervals.toArray(new Interval[0])));
    }

    public static void main(String[] args) {
        DSaDI di = new DSaDI();
        int[] intList = {1, 3, 7, 2, 6};
        for (int i = 0; i < intList.length; i++) {
            di.addNum(intList[i]);
            for (Interval itv:
                    di.getIntervals()) {
                System.out.print("[" + itv.start + ", " + itv.end + "] ");
            }
            System.out.print("\n");
        }
    }
}

/**
 * Your DSaDI object will be instantiated and called as such:
 * DSaDI obj = new DSaDI();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */