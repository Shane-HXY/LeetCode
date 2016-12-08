package medium;

import java.util.List;

/**
 * Created by huangxiangyu on 2016/12/8.
 */
/*
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/
public class DS {   //  394. Decode String
    public String decodeString(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer intApp = new StringBuffer();
        char[] chars = s.toCharArray();
        int cur = 0;
        while (cur < chars.length) {
            if (chars[cur] != '[' && chars[cur] != ']' && (chars[cur] < '0' || chars[cur] > '9')) {
                stringBuffer.append(chars[cur]);
            } else if (chars[cur] >= '0' && chars[cur] <= '9') {
                intApp.append(chars[cur]);
            }
        }
    }
    public String recursionDecode(String s, int num) {
        // recursive method to decode
        if ()
    }
    public int getNum(String s) {
        // get repeatTime of a String
    }
}
