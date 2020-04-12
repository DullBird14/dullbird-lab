package com.dullbird.demo.leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 * @author cys
 * @date 2019-11-01 12:21 PM
 */

public class Thirteen {
	public static void main(String[] args) {
		String a = "IX";
//		System.out.println(a.substring(0, 6));
		Thirteen thirteen = new Thirteen();
		System.out.println(thirteen.romanToInt(a));
	}

	public int romanToInt(String s) {
		int result = 0;
		int i = 0;
		Map<String, Integer> map = init();
		while (i < s.length()-1) {
			String twoChar = s.substring(i, i+2);
			Integer integer = map.get(twoChar);
			if (Objects.nonNull(integer)) {
				result += integer;
				i = i +2;
				continue;
			}
			Integer one = map.get(twoChar.substring(0, 1));
			result += one;
			i++;
		}

		if (i != s.length()) {
			String one = s.substring(i, i + 1);
			result += map.get(one);
		}
		return result;
		//更简洁的写法
//		int ans = 0;
//		for(int i = 0;i < s.length();) {
//			if(i + 1 < s.length() && map.containsKey(s.substring(i, i+2))) {
//				ans += map.get(s.substring(i, i+2));
//				i += 2;
//			} else {
//				ans += map.get(s.substring(i, i+1));
//				i ++;
//			}
//		}
//		return ans;

	}

	public Map<String, Integer> init() {
		return new HashMap<String, Integer>(){{
			this.put("I", 1);
			this.put("V", 5);
			this.put("X", 10);
			this.put("L", 50);
			this.put("C", 100);
			this.put("D", 500);
			this.put("M", 1000);
			this.put("IV", 4);
			this.put("IX", 9);
			this.put("XL", 40);
			this.put("XC", 90);
			this.put("CD", 400);
			this.put("CM", 900);
		}};
	}
}
