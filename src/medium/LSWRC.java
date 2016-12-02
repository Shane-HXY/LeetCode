package medium;

/**
 * Created by huangxiangyu on 2016/12/2.
 */
/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

Subscribe to see which companies asked this question
*/
public class LSWRC {   //  Longest Substring Without Repeating Characters
    public static int lengthOfLongestSubstring(String s) {
        boolean[] hash = new boolean[256];
        java.util.Arrays.fill(hash, false);
        int start = 0;
        int end = 0;
        int res = 0;
        int length = s.length();
        while (end < length && res - start < length) {
            if (hash[s.charAt(end)] == false) {
                hash[s.charAt(end++)] = true;
            } else {
                hash[s.charAt(start++)] = false;
            }
            res = Math.max(res, end - start);
        }
        return res;
    }

    public static void main(String[] args) throws java.io.IOException {
        System.out.print("Input String is: ");
        java.io.BufferedReader bf = new java.io.BufferedReader(
                new java.io.InputStreamReader(System.in));
        String s = bf.readLine();
        System.out.println(lengthOfLongestSubstring(s));
    }
}
//              pwwkew
// end=3
// start=1
// start+res=3
// res=2
// n=6
//  p   w   k   e
//  _   -   -   _
/*
hash[1] = false; hash[0] = false
res = 1; start = 0; end = 1
hash[2] = false; hash[0] = false
res = 2; start = 0; end = 2
hash[2] = false; hash[1] = false
res = 2; start = 1; end = 2
hash[2] = false; hash[2] = false
res = 2; start = 2; end = 2
hash[3] = false; hash[2] = false
res = 2; start = 2; end = 3
hash[4] = false; hash[2] = false
res = 2; start = 2; end = 4
hash[5] = false; hash[2] = false
res = 3; start = 2; end = 5
hash[5] = false; hash[3] = false
res = 3; start = 3; end = 5
3
*/