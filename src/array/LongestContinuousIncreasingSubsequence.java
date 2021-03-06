package array;

/**
 * Created by yingtan on 1/22/18.
 *
 * 674. Longest Continuous Increasing Subsequence
 DescriptionHintsSubmissionsDiscussSolution
 DiscussPick One
 Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).

 Example 1:
 Input: [1,3,5,4,7]
 Output: 3
 Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 Example 2:
 Input: [2,2,2,2,2]
 Output: 1
 Explanation: The longest continuous increasing subsequence is [2], its length is 1.

 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 1;
        int start = 0;
        int end = 1;
        for (; end < nums.length ; end ++) {
            if (nums[end] <= nums[end - 1]) {
                max = Math.max(max, end - start);
                start = end;
            }
        }
        max = Math.max(max, end - start);
        return max;
    }
}
