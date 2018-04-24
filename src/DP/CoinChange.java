package DP;

/**
 * Created by yingtan on 1/13/18.
 *
 * 322. Coin Change
 DescriptionHintsSubmissionsDiscussSolution
 DiscussPick One
 You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

 Example 1:
 coins = [1, 2, 5], amount = 11
 return 3 (11 = 5 + 5 + 1)

 Example 2:
 coins = [2], amount = 3
 return -1.

 Note:
 You may assume that you have an infinite number of each kind of coin.

 Credits:
 Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */
import java.util.*;
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i ++) {
            for (int j = 0 ; j < coins.length; j ++) {
                if (i >= coins[j]) {
                    if (dp[i-coins[j]] != Integer.MAX_VALUE) { // if can form in previous
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
        }
        if (dp[amount] != Integer.MAX_VALUE) return dp[amount];
        else return -1;
    }
}