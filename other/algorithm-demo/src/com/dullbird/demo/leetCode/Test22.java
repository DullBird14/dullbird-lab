package com.dullbird.demo.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author : cys
 * date: 2021-08-31 13:18
 */
public class Test22 {
    public static void main(String[] args) {
        Test22 test22 = new Test22();
        List<String> strings = test22.generateParenthesis(1);
        System.out.println(strings);
    }

    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        int leftCount = n;
        int rightCount = n;
        LinkedList<String> queue = new LinkedList<>();
        innerGenerateParenthesis(leftCount, rightCount, "", queue);
        return result;
    }

    private void innerGenerateParenthesis(int leftCount, int rightCount,
                                          String string, LinkedList<String> queue) {
        if (leftCount + rightCount == 0) {
            if (queue.size() == 0) {
                result.add(string);
            }
            return;
        }
        //选择一个左括号
        if (leftCount > 0) {
            queue.addLast("(");
            String newString = string + "(";
            innerGenerateParenthesis(leftCount - 1, rightCount, newString, queue);
            queue.removeLast();
        }
        //选择一个右括号
        if (rightCount > 0) {
            String s = queue.peekLast();
            if (s == null) {
                return;
            }
            String newString = string;
            String removeMark = null;
            if (Objects.equals(s, "(")) {
                removeMark = queue.pollLast();
                newString = string + ")";
            }
            innerGenerateParenthesis(leftCount, rightCount - 1, newString, queue);
            if (Objects.nonNull(removeMark)) {
                queue.addLast(removeMark);
            }
        }

    }
}
