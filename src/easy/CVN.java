package easy;

/**
 * Created by huangxiangyu on 2016/12/2.
 */
/*
Compare two version numbers version1 and version2.
If version1 > version2 return 1,
if version1 < version2 return -1,
otherwise return 0.

You may assume that the version strings are non-empty
and contain only digits and the . character.
The . character does not represent a decimal point
and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three",
it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
*/
public class CVN {  // Compare Version Numbers
    public int compareVersion(String version1, String version2) {
        // Stage1: convert strings to chararrays and find the 'dots'
        char[] cv1 = version1.toCharArray();
        char[] cv2 = version2.toCharArray();
        int i = 0; int ori = 0;
        java.util.ArrayList<String> vs1 = new java.util.ArrayList<String>();
        java.util.ArrayList<String> vs2 = new java.util.ArrayList<String>();
        while (i <= cv1.length) {
            if (i != cv1.length && cv1[i] != '.');
            else {
                String sub = version1.substring(ori, i);
                vs1.add(sub);
                ori = ++i;
            }
            i++;
        }
        i = 0; ori = 0;
        while (i <= cv2.length) {
            if (i != cv2.length && cv2[i] != '.');
            else {
                String sub = version2.substring(ori, i);
                vs2.add(sub);
                ori = ++i;
            }
            i++;
        }

        // Stage2: convert each substring to integer and compare
        i = 0;
        while (i < vs1.size() && i < vs2.size()) {
            if (java.lang.Integer.parseInt(vs1.get(i)) > Integer.parseInt(vs2.get(i)))
                return 1;
            else if (Integer.parseInt(vs1.get(i)) < Integer.parseInt(vs2.get(i)))
                return -1;
            i++;
        }
        if (i < vs1.size() && i >= vs2.size()) {
            while (Integer.parseInt(vs1.get(i)) == 0) {
                i++;
                if (i >= vs1.size())
                    return 0;
            }
            return 1;
        } else if (i >= vs1.size() && i < vs2.size()) {
            while (Integer.parseInt(vs2.get(i)) == 0) {
                i++;
                if (i >= vs2.size()) {
                    return 0;
                }
            }
            return -1;
        }
        return 0;
    }


    public static void main(String[] args) {
        String v1 = "1.0.1";
        String v2 = "1";
        // System.out.println(Integer.parseInt(v1));
        System.out.println(new CVN().compareVersion(v1, v2));
    }
}