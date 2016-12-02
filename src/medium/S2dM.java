package medium;

/**
 * Created by huangxiangyu on 2016/12/2.
 */
/*
Write an efficient algorithm that searches for a value in an m x n matrix.
This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
Given target = 5, return true.

Given target = 20, return false.
*/
public class S2dM { //  Search a 2D Matrix II
    public boolean searchMatrix(int[][] matrix, int target) {
        if (null == matrix || matrix.length == 0) {
            return false;
        }
        int width = matrix.length;
        int i = 0; int j = matrix[i].length - 1;
        while (i < width && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // int[][] matrix = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24},
        //     {18,21,23,26,30}};
        int[][] matrix = {{1,1,2},{1}};
        int target = 2;
        // System.out.println(new S2dM().searchMatrix(matrix, target));
        System.out.println(matrix.length);
        // System.out.println(matrix[3].length);
        // System.out.println(matrix[0][2]);
    }
}
