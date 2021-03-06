package DP;

/**
 * Created by max2 on 10/15/15.
 */
/*
* Leetcode: uniquePath
* A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?
*
*
* */
public class UniquePath {


    public int uniquePaths(int m, int n) {
        // How to achieve this in space O(n) ?
        /* Two dim array
        //dp[i][j] = dp[i-1][j] + dp[i][j-1]
        int[][] uniqueNums = new int[m][n];
        for (int i = 0 ; i < m; i ++) {
            uniqueNums[i][0] = 1;
        }
        for (int j = 0 ; j < n ; j ++) {
            uniqueNums[0][j] = 1;
        }
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                uniqueNums[i][j] = uniqueNums[i-1][j] + uniqueNums[i][j-1];
            }
        }
        return uniqueNums[m-1][n-1];
        */
        // Since dp[i][j] = dp[i-1][j] + dp[i][j-1], satisfy: dp[i][x] = dp[i-1][x] + dp[i][y] and y < x, we can simplify this to
        // dp[j] = dp[j] + dp[j-1]
        int[] dp = new int[n];
        for (int i = 0; i < m; i ++) {
            dp[0] = 1;
            for (int j = 1; j < n; j ++) {
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n-1];
    }

    // use only one row and one col
    public int uniquePaths_rollingRows(int m, int n) {
        int[] rowDp = new int[n];
        int[] colDp = new int[m];

        for (int i = 0 ; i < m ; i ++) {
            colDp[i] = 1;
        }
        for (int j = 0; j < n; j ++) {
            rowDp[j] = 1;
        }

        for (int i = 1; i < m ; i ++) {
            for (int j = 1; j < n; j ++) {
                rowDp[j] = rowDp[j] + colDp[i];
                colDp[i] = rowDp[j];
            }
        }
        return rowDp[n-1];
    }

    // simplified to only use one row
    public int uniquePaths_best(int m, int n) {
        int[] rowDp = new int[n];
        //int[] colDp = new int[m];

        /* Can be simplified
        for (int i = 0 ; i < m ; i ++) {
            colDp[i] = 1;
        }
        */

        for (int j = 0; j < n; j ++) {
            rowDp[j] = 1;
        }

        for (int i = 1; i < m ; i ++) {
            for (int j = 1; j < n; j ++) {
                //rowDp[j] = rowDp[j] + colDp[i];
                //colDp[i] = rowDp[j];
                // can be simplified to the following:
                rowDp[j] = rowDp[j] + rowDp[j-1];
            }
        }
        return rowDp[n-1];
    }
}
