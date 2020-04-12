package com.dullbird.demo.chapter.six.one;

/**
 * @author cys
 * @date 2018-10-13 下午8:26
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
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
public class Main {
    private static Node[][] globalData;
    private static int[] visited;
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //初始化一个matrix
        AdjacencyMatrix matrix = initMatrix(n, in);
        globalData = matrix.getData();
        visited = matrix.getNodeData();
        //进行DFS遍历
        for (int i = 0; i < n; i++) {
            while (visited[i] == 0) {
                System.out.print("{ ");
                MDFS(i);
                System.out.print("}\n");
            }
        }
//        Arrays.stream(visited).forEach(x -> x = 0);
        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }
        //进行BFS
        for (int i = 0; i < n; i++) {
            while (visited[i] == 0) {
                System.out.print("{ ");
                MBFS(i);
                System.out.print("}\n");
            }
        }
    }

    //BFS搜索
    private static void MBFS(int nodeIndex) {
        visited[nodeIndex] = 1;
        System.out.print(nodeIndex + " ");
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offerFirst(nodeIndex);
        //如果队列里面有值，不断的推出
        while (!queue.isEmpty()) {
            int index = queue.pollFirst();
            for (int i = 0; i < globalData.length; i++) {
                if (globalData[index][i].getIfHaveEdge() == 1
                        && visited[i] == 0) {
                    System.out.print(i + " ");
                    visited[i] = 1;
                    queue.offerLast(i);
                }
            }
        }
    }

    // 邻阶矩阵 ,DFS搜索
    private static void MDFS(int nodeIndex){
        System.out.print(nodeIndex + " ");
        visited[nodeIndex] = 1;
        for (int i = 0; i < globalData.length; i++) {
            Node nearbyNode = globalData[nodeIndex][i];
            if (nearbyNode.getIfHaveEdge() == 1
                    && visited[i] == 0) {
                MDFS(i);
            }
        }
//        node.setIfIsVisited(true);

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
            matrix.insertNode(Integer.valueOf(intArray[0]), Integer.valueOf(intArray[1]));
        }
        return matrix;
    }

    static class AdjacencyMatrix {
        private int node;
        private int edge;
        private Node[][] data;
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
            data = new Node[node][node];
            for (int i = 0; i < node; i++) {
                for (int j = 0; j < node; j++) {
                    data[i][j] = new Node();
                }
            }
        }

        public void insertNode(int fromNode, int toNode) {
            //如果有权重那么
            Node node = data[fromNode][toNode];
            node.setIfHaveEdge(1);
            //无向图需要添加下面代码
            node = data[toNode][fromNode];
            node.setIfHaveEdge(1);
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

        public Node[][] getData() {
            return data;
        }

        public void setData(Node[][] data) {
            this.data = data;
        }

        public int[] getNodeData() {
            return nodeData;
        }

        public void setNodeData(int[] nodeData) {
            this.nodeData = nodeData;
        }
    }

    static class Node {
        private int ifHaveEdge;
        private int power;
        private boolean ifIsVisited;

        public Node() {
        }

        public Node(int ifHaveEdge, int power) {
            this.ifHaveEdge = ifHaveEdge;
            this.power = power;
        }

        public int getIfHaveEdge() {
            return ifHaveEdge;
        }

        public void setIfHaveEdge(int ifHaveEdge) {
            this.ifHaveEdge = ifHaveEdge;
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }

        public boolean isIfIsVisited() {
            return ifIsVisited;
        }

        public void setIfIsVisited(boolean ifIsVisited) {
            this.ifIsVisited = ifIsVisited;
        }
    }


}
