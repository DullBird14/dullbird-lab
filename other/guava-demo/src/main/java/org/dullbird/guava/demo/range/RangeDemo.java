package org.dullbird.guava.demo.range;

import com.google.common.collect.Range;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月12日 17:25:00
 */
public class RangeDemo {
    public static void main(String[] args) {
        Range<Integer> closedRange = Range.closed(1, 100);
        // true
        System.out.println(closedRange.contains(66));
        // false
        System.out.println(closedRange.contains(101));
        // [1,100] 包含 [2,3]
        System.out.println(closedRange.encloses(Range.closed(2, 3)));
        // [1,100] 不包含 [-1,5]
        System.out.println(closedRange.encloses(Range.closed(-1, 5)));
        //[1,100] 和 [100,102] 相连
        System.out.println(closedRange.isConnected(Range.closed(100, 102)));
        //[1,100] 和 [101,103] 不相连
        System.out.println(closedRange.isConnected(Range.closed(102, 103)));
        //[1,100] 和 [102,103] 不相交,会抛出异常
        try {
            System.out.println(closedRange.intersection(Range.closed(102, 103)));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        //[1,100] 和 [95,103] 相交
        System.out.println(closedRange.intersection(Range.closed(95, 103)));
        // 返回包含两个区间的最小区间 [1,100] 和 [95,103] 最小为[1,103]
        System.out.println(closedRange.span(Range.closed(102, 103)));

    }
}
