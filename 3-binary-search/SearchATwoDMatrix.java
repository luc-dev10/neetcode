/**
 * 
 * https://neetcode.io/problems/search-2d-matrix/question?list=neetcode150
 * 
 * You are given an m x n 2-D integer array matrix and an integer target.
 * Each row in matrix is sorted in non-decreasing order.
 * The first integer of every row is greater than the last integer of the previous row.
 * Return true if target exists within matrix or false otherwise.
 * Can you write a solution that runs in O(log(m * n)) time?
 * 
 * Constraints:
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -10000 <= matrix[i][j], target <= 10000
 * 
 */

public class SearchATwoDMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int t = 0;
        int b = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;
        int row = -1;

        while (t <= b) {
            int m = (b - t) / 2 + t;
            if (matrix[m][0] > target) {
                b = m - 1;
            } else if (matrix[m][r] < target) {
                t = m + 1;
            } else {
                row = m;
                break;
            }
        }

        if (row == -1) return false;

        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (matrix[row][m] == target) return true;
            else if (matrix[row][m] < target) l = m + 1;
            else r = m - 1;
        }

        return false;
    }
}