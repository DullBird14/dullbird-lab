package com.dullbird.demo.leetCode.greedy;

import jdk.nashorn.internal.ir.IfNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * @author cys
 * @date 2019-12-07 00:17
 */

public class FourZeroTwo {
	public static void main(String[] args) {
		FourZeroTwo fourZeroTwo = new FourZeroTwo();
//		String s = fourZeroTwo.removeKdigits("1432219", 3);
		String s = fourZeroTwo.removeKdigits("1234567890", 9);
		System.out.println(s);
	}
	public String removeKdigits(String num, int k) {
		char[] array = num.toCharArray();
		LinkedList<Character> objects = new LinkedList<>();

		int i = 0;
		while (i < array.length) {
			char current = array[i];
			Character last = objects.peekLast();
			if(last != null && k>0 && current < last) {
				objects.pollLast();
				k--;
				continue;
			}
			objects.addLast(current);
			i++;
		}
		while (k>0) {
			objects.pollLast();
			k--;
		}
		do {
			Character first = objects.peekFirst();
			if (first == null
					|| first !='0') {
				break;
			}
			objects.pollFirst();
		} while (objects.size()>0);
		StringBuilder builder = new StringBuilder();
		if (objects.size() >0){
			objects.forEach(builder::append);
		} else {
			builder.append('0');
		}
		return builder.toString();
	}
//	public String removeKdigits(String num, int k) {
//		LinkedList<Character> objects = new LinkedList<>();
//		for (int i = 0; i < num.length(); i++) {
//			char c = num.charAt(i);
//			if (i+1 < num.length()
//					&& num.charAt(i+1) =='0'
//					&& k>0) {
//				i++;
//				k--;
//				continue;
//			}
//			Character maxChar = objects.peekLast();
//			if (maxChar != null
//					&& maxChar > c
//					&& k>0) {
//				objects.pollLast();
//				k--;
//			}
//			objects.addLast(c);
//		}
//		while (k>0){
//			objects.pollLast();
//			k--;
//		}
//		StringBuilder builder = new StringBuilder();
//		for (Character object : objects) {
//			builder.append(object);
//		}
//		return builder.toString().length() == 0 ? "0" : builder.toString();
//	}
//
//	public String removeKdigits(String num, int k) {
//		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
//		int temp = k < num.length()? k : num.length();
//		for (int i = 0; i < k; i++) {
//			char c = num.charAt(i);
//			if (i + 1 < num.length() && num.charAt(i+1) =='0') {
//				continue;
//			}
//			if (c == '0') {
//				k++;
//				continue;
//			}
//			priorityQueue.add(Integer.parseInt(String.valueOf(c)));
//		}
//		num = num.substring(k +1);
//		Integer poll = priorityQueue.poll();
//		num = poll ==null? num : poll + num;
//		return num;
//	}
}
