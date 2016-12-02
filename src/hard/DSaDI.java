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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class DSaDI {    //  Data Stream as Disjoint Intervals

    private static List<Integer> streams = new ArrayList<>();
//    static int[] streams = new int[65536];
    private static int res = 0;
    private static List<Interval> orgInterval;

    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    /** Initialize your data structure here. */
    public DSaDI() {
    }

    public void addNum(int val) {
        streams.set(res++, val);
    }

    public List<Interval> getIntervals() {
        int cur = streams.get(res);
        boolean[] line = new boolean[res];
        Arrays.fill(line, false);
        int linePos = 0;
        for (Interval interval : orgInterval) {
            if (cur >= interval.start && cur <= interval.end);
            else if (1 == (interval.start - cur) || 1 == (cur - interval.end)) {
                if (cur < interval.start) {
                    interval.start = cur;
                } else {
                    interval.end = cur;
                }
                line[linePos] = true;
            } else {
                orgInterval.add(new Interval(cur, cur));
            }
            linePos++;
        }
        Interval itv = null;
        for (int k = 0; k < line.length; k++) {
            if (line[k]) {
                if (itv != null) {
                    Interval nxtItv = orgInterval.get(k);
                    if (nxtItv.start == itv.end) {
                        
                    }
                }
                itv = orgInterval.get(k);
            }
        }
    }

    public static void main(String[] args) {
        int val = 1;
        DSaDI obj = new DSaDI();
        int i = 0;
        while (streams.get(res) >= 0) {

        }
        obj.addNum(val);
        List<Interval> param_2 = obj.getIntervals();

    }
}

/**
 * Your DSaDI object will be instantiated and called as such:
 * DSaDI obj = new DSaDI();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */