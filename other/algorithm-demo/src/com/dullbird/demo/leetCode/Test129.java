package com.dullbird.demo.leetCode;

import com.dullbird.demo.leetCode.loop.TreeNode;
import jdk.nashorn.internal.objects.annotations.Function;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : cys
 * date: 2021-09-07 13:14
 */
public class Test129 {
//    List<Integer> total = new ArrayList<>();
    Integer sum = 0;
    public int sumNumbers(TreeNode root) {
        innerSumNumbers(root, 0);
//        return total.stream().mapToInt(it -> it).sum();
        return sum;
    }

    private void innerSumNumbers(TreeNode root, int i) {
        i = i * 10 + root.val;
        if (root.left == null
                && root.right == null) {
            //此处可以优化。不用外部变量。直接用一个sum累加
//            total.add(i);
            sum += i;
            return;
        }
        if (root.left!=null) {
            innerSumNumbers(root.left, i);
        }

        if (root.right!=null) {
            innerSumNumbers(root.right, i);
        }
    }
}
