package google.sort;

import java.util.Arrays;

/**
 * Created by yingtan on 11/5/15.
 */
public class WiggleSort {

    public void wiggleSort(int[] nums) {
        if ((nums == null) || (nums.length <= 1))
            return;
        Arrays.sort(nums);

        int len = nums.length;
        if (len == 2) return;
        int low = 1 ;
        int high = 2;
        while (high < len) {
            int tmp = nums[low];
            nums[low] = nums[high];
            nums[high] = tmp;

            low = low + 2;
            high = low + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,5,2,1,6,4};
        WiggleSort ob = new WiggleSort();
        ob.wiggleSort(nums);
        System.out.println();
    }
}
