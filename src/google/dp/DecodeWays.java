package google.dp;

/**
 * Created by yingtan on 12/22/15.
 */
public class DecodeWays {

    public int numDecodings(String s) {
        if ((s == null) || (s.length() == 0)) return 0;

        if (s.charAt(0) == '0') return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= s.length(); i ++) {
            int curDigit = Integer.parseInt(s.substring(i-1, i));
            if (curDigit != 0) {
                dp[i] = dp[i-1];
            }
            if (s.charAt(i-2) != '0') {
                int curTwoDigit = Integer.parseInt(s.substring(i-2, i));
                if ((curTwoDigit > 0) && (curTwoDigit <= 26)) {
                    dp[i] = dp[i] + dp[i-2];
                }
            }
        }
        return dp[s.length()];
    }
}
