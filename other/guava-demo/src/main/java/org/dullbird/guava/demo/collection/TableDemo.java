package org.dullbird.guava.demo.collection;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import sun.security.provider.certpath.Vertex;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月05日 21:39:00
 */
public class TableDemo {
    public static void main(String[] args) {
        String v1 = "v1";
        String v2 = "v2";
        String v3 = "v3";
        Table<String, String, Integer> weightedGraph = HashBasedTable.create();
        weightedGraph.put(v1, v2, 4);
        weightedGraph.put(v1, v3, 20);
        weightedGraph.put(v2, v3, 5);

        System.out.println(weightedGraph.rowMap());
        System.out.println(weightedGraph.row(v1));
        System.out.println(weightedGraph.column(v3));
    }
}
