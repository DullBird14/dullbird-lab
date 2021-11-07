package com.dullbird.demo.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author : cys
 * date: 2021-08-16 12:43
 */
public class Test20 {
    public static void main(String[] args) {
        Test20 test20 = new Test20();
        System.out.println(test20.isValid("()[]{}"));
        System.out.println(test20.isValid("({"));
    }
    public boolean isValid(String s) {
        List<Character> leftList = new ArrayList<>();
        leftList.add('[');
        leftList.add('(');
        leftList.add('{');
        char[] chars = s.toCharArray();
        LinkedList<Character> queue = new LinkedList();
        for (char aChar : chars) {
            if (leftList.contains(aChar)) {
                queue.addLast(aChar);
                continue;
            }
            Character character = queue.peekLast();
            if (character ==null) {
                return false;
            }
            if (aChar==']' && character!='['){
                return false;
            }
            if (aChar==')' && character!='('){
                return false;
            }
            if (aChar=='}' && character!='{'){
                return false;
            }
            queue.removeLast();
        }
        return queue.size()==0;
    }
}
