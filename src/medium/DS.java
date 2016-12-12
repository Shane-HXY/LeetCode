package medium;

import java.util.Stack;

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
    public Stack<Integer> stack = new Stack<>();
    public StringBuffer mainBuffer = new StringBuffer();
    public Stack<Character> stackChar = new Stack<>();

    public String decodeString(String s) {
        int rptTm = 1;
        mainBuffer.append(subString(s, rptTm));
        return mainBuffer.toString();
    }
    public String subString(String s,int rptTime) {
        char[] arr = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        int i = 0;
        int cur = 0;
        while (i < arr.length) {
            boolean ifin = false;
            if (i < arr.length && arr[i] != '[' && arr[i] != ']' && (arr[i] < '0' || arr[i] > '9') && stackChar.isEmpty()) {
                sb.append(arr[i]);
                i++;
                ifin = true;
            }
            if (i < arr.length && arr[i] > '0' && arr[i] <= '9' && stackChar.isEmpty()) {
                int numBuf = 0;
                while (arr[i] >= '0' && arr[i] <= '9') {
                    int numBufi;
                    numBufi = Integer.parseInt(String.valueOf(arr[i]));
                    numBuf = (numBuf + numBufi) * 10;
                    i++;
                }
                numBuf = numBuf / 10;
                stack.push(numBuf);
                ifin = true;
            }
            if (i < arr.length && arr[i] == '[') {
                if (stackChar.isEmpty()) {
                    cur = i;
                }
                stackChar.push('[');
                i++;
                ifin = true;
            }
            if (i < arr.length && arr[i] == ']') {
                stackChar.pop();
                if (stackChar.isEmpty()) {
                    sb.append(subString(s.substring(cur + 1, i), stack.pop()));
                }
                i++;
                ifin = true;
            }
            if (!ifin) {
                i++;
            }
        }
        StringBuffer res = new StringBuffer();
        for (int j = 0; j < rptTime; j++) {
            res.append(sb.toString());
        }
        return res.toString();
    }
    public static void main(String[] args) {
        DS ds = new DS();
        String a = "ab3[a3[b]]";
        String b = "3[a2[c]]";
        System.out.println(ds.decodeString(b));
    }
}
