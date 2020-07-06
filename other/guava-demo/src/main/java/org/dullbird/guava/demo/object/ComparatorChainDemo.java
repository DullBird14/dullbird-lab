package org.dullbird.guava.demo.object;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月05日 16:38:00
 */
public class ComparatorChainDemo {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("a", 10));
        personList.add(new Person("b", 11));
        personList.add(new Person("b", 9));
        personList.add(new Person(null, 8));
        personList.add(new Person("d", null));
//        testComparisonChain(personList);
        testOrdering(personList);
        System.out.println(personList);
    }

    private static void testOrdering(List<Person> personList) {
        Ordering<Person> ordering = Ordering.natural().nullsLast().onResultOf(Person::getName)
                .compound(Ordering.natural().nullsLast().onResultOf(Person::getAge));
        personList.sort(ordering);
    }

    private static void testComparisonChain(List<Person> personList) {
        personList.sort((o1, o2) -> ComparisonChain.start()
                .compare(o1.getName(), o2.getName(), Ordering.natural().nullsLast())
                .compare(o1.getAge(), o2.getAge(), Ordering.natural().nullsLast())
                .result());
    }

    @Data
    @Accessors(chain = true)
    @AllArgsConstructor
    static class Person implements Comparable<Person> {
        private String name;
        private Integer age;

        @Override
        public int compareTo(Person o) {
            return ComparisonChain.start()
                    .compare(name, o.getName())
                    .compare(age, o.getAge())
                    .result();
        }
    }
}
