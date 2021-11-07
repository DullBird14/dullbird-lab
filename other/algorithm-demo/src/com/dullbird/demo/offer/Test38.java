package com.dullbird.demo.offer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : cys
 * date: 2021-07-31 14:19
 */
public class Test38 {
    public static void main(String[] args) {
        Test38 test38 = new Test38();
        String[] abcs = test38.permutation("abc");
        System.out.println(Arrays.toString(abcs));
    }

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        List<String> result = new ArrayList<>();
        innerPermutation(chars, 0, result);
        return result.toArray(new String[]{});
    }

    /**
     * 当前这层的遍历
     *
     * @param chars
     * @param index
     */
    public void innerPermutation(char[] chars, int index, List<String> result) {
        Set<Character> sets = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            if (sets.contains(chars[i])) {
                continue;
            }
            sets.add(chars[i]);
            swap(chars, index, i);
            if (index + 1 == chars.length) {
                result.add(new String(chars));
            } else {
                innerPermutation(chars, index + 1, result);
            }
            //交换回去
            swap(chars, i, index);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = temp;
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
