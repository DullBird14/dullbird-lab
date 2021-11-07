package com.dullbird.demo.leetCode;

/**
 * @author : cys
 * date: 2021-09-23 13:03
 */
public class Test287 {
    public static void main(String[] args) {

        Test287 test287 = new Test287();
        System.out.println(test287.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(test287.findDuplicate(new int[]{3,1,3,4,2}));
    }
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        //求出快慢指针相交时刻
        do {
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        } while (nums[slow] != nums[fast]);
        //求出环的叫点
        slow = 0;
        while (nums[slow] != nums[fast]){
            slow = nums[slow];
            fast = nums[fast];
        }
        return nums[slow];
    }
}
