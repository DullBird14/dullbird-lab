package com.dullbird.demo.chapter.seven.one;

/**
 * @author cys
 * @date 2018-10-21 下午4:21
 */


import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 输入格式:
 * 输入说明：输入第1行给出两个正整数N (≤100)和M，其中N是考试涉及的动物总数，M是用于直接变形的魔咒条数。
 * 为简单起见，我们将动物按1~N编号。随后M行，每行给出了3个正整数，
 * 分别是两种动物的编号、以及它们之间变形需要的魔咒的长度(≤100)，数字之间用空格分隔。
 *
 * 输出格式:
 * 输出哈利·波特应该带去考场的动物的编号、以及最长的变形魔咒的长度，中间以空格分隔。
 * 如果只带1只动物是不可能完成所有变形要求的，则输出0。如果有若干只动物都可以备选，则输出编号最小的那只。
 *
 * 输入样例:
 * 6 11
 * 3 4 70
 * 1 2 1
 * 5 4 50
 * 2 6 50
 * 5 6 60
 * 1 3 70
 * 4 6 60
 * 3 6 80
 * 5 1 100
 * 2 4 60
 * 5 2 80
 * 输出样例:
 * 4 70
 */
//6 11
//3 4 70
//1 2 1
//5 4 50
//2 6 50
//5 6 60
//1 3 70
//4 6 60
//3 6 80
//5 1 100
//2 4 60
//5 2 80
public class Main {
    public static void main(String args[]) {
        //生成邻接矩阵
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //初始化一个matrix
        AdjacencyMatrix matrix = initMatrix(n, in);
        int[][] data = matrix.getData();
//        Arrays.stream(data).forEach(array -> {
//            Arrays.stream(array).forEach(num -> {
//                System.out.print(num + " ");
//            });
//            System.out.println();
//        });
        //floyd算法获取最短距离矩阵
        floyed(data);
//        System.out.println("========================");
//        Arrays.stream(data).forEach(array -> {
//            Arrays.stream(array).forEach(num -> {
//                System.out.print(num + "\t\t\t\t");
//            });
//            System.out.println();
//        });
        //找到哪个动物的最大距离是所有中最小的
        int minIndex = -1;
        int minNum = Integer.MAX_VALUE;
        for (int i = 0; i < data.length; i++) {
//            int index = -1;
            int maxNum = -1;
            for (int j = 0; j < data[i].length; j++) {
                if (i == j) {
                    continue;
                }

                if (data[i][j] == Integer.MAX_VALUE) {
                    System.out.println("0");
                    return;
                }

                if (data[i][j] > maxNum) {
                    maxNum = data[i][j];
                }
            }

            if (maxNum < minNum) {
                minNum = maxNum;
                minIndex = i;
            }

            if (maxNum == minNum) {
                minIndex = i < minIndex? i : minIndex;
            }
        }
        System.out.println(++minIndex + " " + minNum);
    }

    private static void floyed(int[][] data) {
        for (int k = 0; k < data.length; k++) {
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data.length; j++) {
                    if (data[i][k] != Integer.MAX_VALUE
                            && data[k][j] != Integer.MAX_VALUE
                            && i != j
                            && data[i][k] + data[k][j] < data[i][j]) {
                        data[i][j] = data[i][k] + data[k][j];
                    }
                }
            }
        }
    }


    //创建邻阶矩阵
    private static AdjacencyMatrix initMatrix(int nodeNum, Scanner in) {
        AdjacencyMatrix matrix = new AdjacencyMatrix(nodeNum);
        int e = in.nextInt();
        matrix.setEdge(e);
        in.nextLine();
        for (int i = 0; i < e; i++) {
            String intLine = in.nextLine();
            String[] intArray = intLine.split(" ");
            matrix.insertNode(Integer.valueOf(intArray[0]) - 1,
                    Integer.valueOf(intArray[1]) - 1 , Integer.valueOf(intArray[2]));
        }
        return matrix;
    }


    static class AdjacencyMatrix {
        private int node;
        private int edge;
        private int[][] data;
        private int[] nodeData;

        public AdjacencyMatrix(int node, int edge) {
            this.node = node;
            this.edge = edge;
            initMatrix(node);
        }

        public AdjacencyMatrix(int node) {
            this.node = node;
            initMatrix(node);
        }

        private void initMatrix(int node) {
            nodeData = new int[node];
            data = new int[node][node];
            for (int i = 0; i < node; i++) {
                for (int j = 0; j < node; j++) {
                    data[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        public void insertNode(int fromNode, int toNode, int power) {
            //如果有权重那么
            data[fromNode][toNode] = power;
            //无向图需要添加下面代码
            data[toNode][fromNode] = power;
        }

        public int getNode() {
            return node;
        }

        public void setNode(int node) {
            this.node = node;
        }

        public int getEdge() {
            return edge;
        }

        public void setEdge(int edge) {
            this.edge = edge;
        }


        public int[] getNodeData() {
            return nodeData;
        }

        public int[][] getData() {
            return data;
        }

        public void setData(int[][] data) {
            this.data = data;
        }

        public void setNodeData(int[] nodeData) {

            this.nodeData = nodeData;
        }
    }

//    static class Node {
//        private int power;
//
//
//        public Node(int power) {
//            this.power = power;
//        }
//
//        public int getPower() {
//            return power;
//        }
//
//        public void setPower(int power) {
//            this.power = power;
//        }
//
//    }
}
