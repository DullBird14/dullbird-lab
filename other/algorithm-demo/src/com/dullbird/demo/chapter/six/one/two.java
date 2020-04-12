package com.dullbird.demo.chapter.six.one;

/**
 * @author cys
 * @date 2018-10-21 上午11:34
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

/**
 * 06-图1 列出连通集 （25 分）
 * 给定一个有N个顶点和E条边的无向图，请用DFS和BFS分别列出其所有的连通集。假设顶点从0到N−1编号。进行搜索时，假设我们总是从编号最小的顶点出发，按编号递增的顺序访问邻接点。
 *
 * 输入格式:
 * 输入第1行给出2个整数N(0<N≤10)和E，分别是图的顶点数和边数。随后E行，每行给出一条边的两个端点。每行中的数字之间用1空格分隔。
 *
 * 输出格式:
 * 按照"{ v1 v2 ... vk }"的格式，每行输出一个连通集。先输出DFS的结果，再输出BFS的结果。
 *
 * 输入样例:
 * 8 6
 * 0 7
 * 0 1
 * 2 0
 * 4 1
 * 2 4
 * 3 5
 * 输出样例:
 * { 0 1 4 2 7 }
 * { 3 5 }
 * { 6 }
 * { 0 1 2 7 4 }
 * { 3 5 }
 * { 6 }
 */
//8 6
//0 7
//0 1
//2 0
//4 1
//2 4
//3 5
public class two {
    private static LinkedList<Integer>[] globalData;
    private static boolean[] visited;
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //初始化一个邻接表
        LinkedList<Integer>[] table = new LinkedList[n];
        visited = new boolean[n];
        int e = in.nextInt();
        in.nextLine();
        for (int i = 0; i < e; i++) {
            String intLine = in.nextLine();
            String[] intArray = intLine.split(" ");
            LinkedList linkedList = table[Integer.valueOf(intArray[0])];
            if (Objects.isNull(linkedList)) {
                LinkedList<Integer> list = new LinkedList<>();
                list.addLast(Integer.valueOf(intArray[1]));
                table[Integer.valueOf(intArray[0])] = list;
            } else {
                linkedList.addLast(Integer.valueOf(intArray[1]));
            }
            //无向图所以还需要反向添加一条
            linkedList = table[Integer.valueOf(intArray[1])];
            if (Objects.isNull(linkedList)) {
                LinkedList<Integer> list = new LinkedList<>();
                list.addLast(Integer.valueOf(intArray[0]));
                table[Integer.valueOf(intArray[1])] = list;
            } else {
                linkedList.addLast(Integer.valueOf(intArray[0]));
            }
        }
        Arrays.stream(table).forEach(list -> {
            if (!Objects.isNull(list)) {
                Collections.sort(list);
            }
        });
        globalData = table;
        System.out.println(Arrays.toString(globalData));
        //进行DFS遍历
        for (int i = 0; i < visited.length; i++) {
            while (!visited[i]) {
                System.out.print("{ ");
                LDFS(i);
                System.out.print("}\n");
            }
        }
//        Arrays.stream(visited).forEach(x -> x = false);
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        //进行BFS
        for (int i = 0; i < n; i++) {
            while (visited[i] == false) {
                System.out.print("{ ");
                LBFS(i);
                System.out.print("}\n");
            }
        }
    }

    //BFS搜索
    private static void LBFS(int nodeIndex) {
        visited[nodeIndex] = true;
        System.out.print(nodeIndex + " ");
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offerFirst(nodeIndex);
        //如果队列里面有值，不断的推出
        while (!queue.isEmpty()) {
            int index = queue.pollFirst();
            LinkedList<Integer> globalDatum = globalData[index];
            if (!Objects.isNull(globalDatum)) {
                for (Integer integer : globalDatum) {
                    if (!visited[integer]) {
                        System.out.print(integer + " ");
                        visited[integer] = true;
                        queue.offerLast(integer);
                    }
                }
            }
        }
    }

    // 邻接表矩阵 ,DFS搜索
    private static void LDFS(int nodeIndex){
        System.out.print(nodeIndex + " ");
        visited[nodeIndex] = true;
        //获取当前点的邻接点，并且继续遍历
        LinkedList<Integer> globalDatum = globalData[nodeIndex];
        if (!Objects.isNull(globalDatum)) {
            for (Integer integer : globalDatum) {
                if (!visited[integer]) {
                    LDFS(integer);
                }
            }
        }
    }

}
