package com.dullbird.demo.leetCode;

import java.util.LinkedList;
import java.util.Optional;

/**
 * @author : cys
 * date: 2021-08-25 23:22
 */
public class Test32 {
    public static void main(String[] args) {
        Test32 test32 = new Test32();
        System.out.println(test32.longestValidParentheses("()(())"));
        System.out.println(test32.longestValidParentheses("(((((("));
        System.out.println(test32.longestValidParentheses("))))))"));
        System.out.println(test32.longestValidParentheses("()()(((((()))))"));
    }

    public int longestValidParentheses(String s) {
        //通过栈的方法完成
        char[] chars = s.toCharArray();
        int max = 0;
        int tempNum = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(-1);
        for (int i = 0; i < chars.length; i++) {
            Integer preIndex = queue.peekLast();
            if (preIndex == null
                    || preIndex < 0
                    || chars[preIndex] == ')'
                    || chars[i] == '(') {
                queue.addLast(i);
                continue;
            }

            if (chars[preIndex] == '('
                    && chars[i] == ')') {
                queue.pollLast();
                Integer prePreIndex = queue.peekLast() == null ? 0 : queue.peekLast();
                tempNum = i - prePreIndex;
                if (tempNum > max) {
                    max = tempNum;
                }
            }
        }
        return max;
    }

}
