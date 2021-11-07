package com.dullbird.demo.offer;

/**
 * @author : cys
 * date: 2021-07-24 16:41
 */
public class Test53_2 {
    public static void main(String[] args) {
        Test53_2 test532 = new Test53_2();
        int i = test532.missingNumber(new int[]{0});
        System.out.println(i);
    }
    public int missingNumber(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int mid = 0;
        while (i <= j) {
            mid = (j - i) / 2 + i;
            if (nums[mid] == mid) {
                i = mid + 1;
            }
//            else if (mid - 1 < 0
//                    || nums[mid - 1] == mid - 1) {
//                break;
//            }
            else {
                j = mid - 1;
            }
        }
        return i;
    }
}
