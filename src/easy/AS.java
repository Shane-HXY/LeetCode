package easy;

/**
 * Created by huangxiangyu on 2016/11/30.
 */
/*
Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/
public class AS {   //  Add Strings
    public String addStrings(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        boolean carry = false;
        char[] res = new char[5100];
        int pos = 0;
        int cry = 0;
        boolean asb = false;	// a is shorter than b or not
        int left = 0;
        for (int i = n1.length, j = n2.length; i > 0 && j > 0; ) {
            if (carry == true) {
                cry = 1;
                carry = false;
            }
            int no1 = toInt(n1[--i]);
            int no2 = toInt(n2[--j]);
            if (no1 + no2 + cry >= 10) {
                carry = true;
            }
            res[pos++] = toChar((no1 + no2 + cry) % 10);
            cry = 0;
            if (i == 0 && j > 0) {
                asb = true;
                left = j;
            } else if (j == 0 && i > 0) {
                left = i;
            }
        }
        if (left != 0) {
            char[] n0;
            if (asb) {
                n0 = n2;
            } else {
                n0 = n1;
            }
            while (left > 0) {
                int cach;
                if (carry) {
                    cach = toInt(n0[--left]) + 1;
                } else {
                    cach = toInt(n0[--left]);
                }
                res[pos++] = toChar(cach % 10);
                if (cach >= 10) {
                    carry = true;
                } else {
                    carry = false;
                }
            }
            if (carry) {
                res[pos++] = toChar(1);
            }
        } else {
            if (carry) {
                res[pos++] = toChar(1);
            }
        }
        StringBuffer sb = new StringBuffer(new String(res).trim());
        return sb.reverse().toString();
    }
    private int toInt(char a) {
        return (int)(a - 48);
    }

    private char toChar(int a) {
        return (char)(a + 48);
    }

    public static void main(String[] args) {
        String num1 = "9";
        String num2 = "99";
        String a = new AS().addStrings(num1, num2);
        System.out.println(a);
    }
}
