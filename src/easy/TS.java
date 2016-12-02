package easy;

/**
 * Created by huangxiangyu on 2016/12/2.
 */
/*
Given an array of integers,
return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

UPDATE (2016/2/13):
The return format had been changed to zero-based indices.
Please read the above updated description carefully.

Subscribe to see which companies asked this question
*/
public class TS {   //  Two Sum
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        if (length < 2) {
            return null;
        }
        if (length == 2) {
            int[] res = {0,1};
            return ((target == (nums[0] + nums[1])) ? res: null);
        }
        int start = length / 2;
        int end = start - 1;
        while (end >= 0 && start < length) {
            if (nums[start] + nums[end] == target) {
                int[] res = {end, start};
                return res;
            } else {
                int end2 = end - 1;
                while (end2 >= 0) {
                    if (nums[start] + nums[end2] == target) {
                        int[] res = {end2, start};
                        return res;
                    }
                    end2--;
                }
            }
            start++;
            end = start - 1;
        }
        return null;
    }

    public int[] twoSum_1(int[] nums, int target) {
        int length = nums.length;
        int[] ret = new int[2];

        java.util.HashMap<Integer, Integer> map
                = new java.util.HashMap<Integer, Integer>();

        for(int i = 0; i < length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(target-nums[i], i);
            } else {
                ret[0] = map.get(nums[i]);
                ret[1] = i;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] nums = {230,863,916,585,981,404,316,785,88,12,70,435,384,778,887,755,740,337,86,92,325,422,815,650,920,
                125,277,336,221,847,168,23,677,61,400,136,874,363,394,199,863,997,794,587,124,321,212,957,764,173,314,
                422,927,783,930,282,306,506,44,926,691,568,68,730,933,737,531,180,414,751,28,546,60,371,493,370,527,
                387,43,541,13,457,328,227,652,365,430,803,59,858,538,427,583,368,375,173,809,896,370,789};
        int target = 542;
        int[] ret = new TS().twoSum_1(nums, target);
        System.out.println(ret[0] + " " + ret[1]);
    }
}