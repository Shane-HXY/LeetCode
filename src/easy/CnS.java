package easy;

/**
 * Created by huangxiangyu on 2016/12/2.
 */
/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.
*/
public class CnS {  // Count and Say
    public String countAndSay(int n) {
        if (n < 1) {
            return new String("");
        } else if (n == 1) {
            return new String("1");
        }
        String s = "1";
        int i = 1;
        while (i < n) {
            StringBuffer sb = new StringBuffer();
            int count = 1;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j-1)) {
                    count++;
                } else {
                    sb.append(count)
                            .append(s.charAt(j-1));
                    count = 1;
                }
            }
            sb.append(count)
                    .append(s.charAt(s.length() - 1));
            s = sb.toString();
            i++;
        }
        return s;
    }

    public static void main(String[] args) throws java.io.IOException {
        java.io.BufferedReader bf = new java.io.BufferedReader(
                new java.io.InputStreamReader(System.in));
        String s = bf.readLine();
        int q = Integer.parseInt(s);
        System.out.println(new CnS().countAndSay(q));
    }
}
