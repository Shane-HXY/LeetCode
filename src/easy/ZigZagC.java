package easy;

/**
 * Created by huangxiangyu on 2016/12/2.
 */

/*
The string "PAYPALISHIRING" is written in a zigzag pattern
on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string
and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
public class ZigZagC {  //  ZigZag Conversion
    public String convert(String s, int numRows) {
        int length = s.length();
        if (numRows <= 1 || length <= 1) {
            return s;
        }
        java.lang.StringBuffer sb = new java.lang.StringBuffer();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < length; j += 2 * numRows - 2) {
                sb.append(s.charAt(j+i));
                if (i == 0 || i == numRows - 1)
                    continue;
                if (j + 2 * numRows - 2 - i < length)
                    sb.append(s.charAt(j + 2 * numRows - 2 - i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(new ZigZagC().convert("PAYPALISHIRING", 3));
        System.out.println(new ZigZagC().convert("PAYPALISHIRING", 4));
    }
}

// P   I   N
// A  LS  IG
// Y A H R
// P   I