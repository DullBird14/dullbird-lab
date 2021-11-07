package com.dullbird.demo.offer;

/**
 * @author : cys
 * date: 2021-07-13 00:20
 */
public class Test39 {
    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        int voted = 0;
        int i = 0;
        for (int num : nums) {
            if (voted == 0) {
                i = num;
            }
            int addVoted = i == num ? 1 : -1;
            voted = voted + addVoted;
        }
        int count = 0;
        for(int num : nums) {
            if(num == i) {
                count++;
            }
        }
        return count > nums.length / 2 ? i : 0;
    }
}
