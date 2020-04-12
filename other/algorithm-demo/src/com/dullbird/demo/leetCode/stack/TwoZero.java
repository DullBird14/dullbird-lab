package com.dullbird.demo.leetCode.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author cys
 * @date 2019-11-10 10:11 PM
 */

public class TwoZero {
	public static void main(String[] args) {
		TwoZero twoZero = new TwoZero();
		System.out.println(twoZero.isValid("()"));
	}
	public boolean isValid(String s) {
		Deque<Character> stack = new LinkedList<>();
		if (s==null || "".equals(s)){
			return true;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Objects.equals(c, '(')
					||Objects.equals(c, '[')
					||Objects.equals(c, '{')){
				stack.addLast(c);
			} else if (Objects.equals(c, ')')
					&& !Objects.equals(stack.pollLast(), '(')){
				return false;
			} else if (Objects.equals(c, ']')
					&& !Objects.equals(stack.pollLast(), '[')){
				return false;
			} else if (Objects.equals(c, '}')
					&& !Objects.equals(stack.pollLast(), '{')){
				return false;
			}
		}
		return stack.size() == 0;
	}
}
