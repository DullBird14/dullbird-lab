package com.dullbird.demo.chapter.five;

/**
 * @author cys
 * @date 2018-10-01 下午1:27
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 05-树7 堆中的路径 （25 分）
 * 将一系列给定数字插入一个初始为空的小顶堆H[]。
 * 随后对任意给定的下标i，打印从H[i]到根结点的路径。
 *
 * 输入格式:
 * 每组测试第1行包含2个正整数N和M(≤1000)，分别是插入元素的个数、以及需要打印的路径条数。
 * 下一行给出区间[-10000, 10000]内的N个要被插入一个初始为空的小顶堆的整数。最后一行给出M个下标。
 *
 * 输出格式:
 * 对输入中给出的每个下标i，在一行中输出从H[i]到根结点的路径上的数据。数字间以1个空格分隔，行末不得有多余空格。
 *
 * 输入样例:
 * 5 3
 * 46 23 26 24 10
 * 5 4 3
 * 输出样例:
 * 24 23 10
 * 46 23 10
 * 26 10
 */
//5 3
//46 23 26 24 10
//5 4 3
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String nAndMString = sc.nextLine();
        String[] nAndMStringArray = nAndMString.split(" ");
        int nValue = Integer.valueOf(nAndMStringArray[0]);
        int mValue = Integer.valueOf(nAndMStringArray[1]);
//        Node[] heap = new Node[nValue + 1];
        Heap minHeap = new Heap(nValue);
        String valueString = sc.nextLine();
        int[] data = minHeap.getData();
        String[] valueStringArray = valueString.split(" ");
        //初始化树。把数值形成一个二叉树
        for (int i = 0; i < valueStringArray.length; i++) {
            if (minHeap.isFull()) {
                System.out.println("超出限制");
                return;
            }
            insert(minHeap, Integer.valueOf(valueStringArray[i]));
//            data[i] = Integer.valueOf(valueStringArray[i-1]);
//            minHeap.increaseSize();
        }
//        System.out.println(Arrays.toString(data));
        //从末尾开始调节节点,形成一个最小堆
//        for (int i = data.length -1 ; i > 0; i--) {
//            int parentValue = data[i/2];
//            if (data[i] < parentValue) {
//                data[i/2] = data[i];
//                data[i] = parentValue;
//            }
//        }
//        System.out.println(Arrays.toString(data));
        //输出指定的节点
        String line = sc.nextLine();
        for (String index : line.split(" ")) {
            printTrace(minHeap, Integer.valueOf(index));
        }


    }


    public static void insert(Heap minHeap, int value){
        int[] data = minHeap.getData();
        int size ;
        for (size= minHeap.increaseSize(); data[size>>1] > value; size = size>>1) {
            data[size] = data[size>>1];
        }
        data[size] = value;
    }

    public static void printTrace(Heap minHeap, int index){
        if (index > minHeap.getSize()
                || index <= 0) {
            return;
        }
        int[] data = minHeap.getData();
        StringBuilder sb = new StringBuilder();
        int i ;
        for (i = index; i > 0; i = i >> 1) {
            sb.append(data[i]).append(" ");
        }
//        System.out.println(i>0);
//        System.out.println(i>>1 >0);
        System.out.println(sb.toString().trim());
    }

    public static class Heap{
        private int[] data;
        private int size;
        private int capacity;

        public Heap(int capacity) {
            this.capacity = capacity;
            init(capacity);
        }

        private void init(int capacity){
            data = new int[capacity + 1];
            data[0] = Integer.MIN_VALUE;
        }

        public int[] getData() {
            return data;
        }

        public void addNode(int value) {
            return;
        }

        public int increaseSize(){
            return ++size;
        }

        public int decreaseSize(){
            return ++size;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }


        public boolean isFull(){
            return size == capacity;
        }

        @Override
        public String toString() {
            return "Heap{" +
                    "data=" + Arrays.toString(data) +
                    ", size=" + size +
                    ", capacity=" + capacity +
                    '}';
        }

    }

//
//    public static class Node{
//        private int value;
//        private int parentNode;
//
//        public int getValue() {
//            return value;
//        }
//
//        public void setValue(int value) {
//            this.value = value;
//        }
//
//        public int getParentNode() {
//            return parentNode;
//        }
//
//        public void setParentNode(int parentNode) {
//            this.parentNode = parentNode;
//        }
//
//
//        @Override
//        public String toString() {
//            return "Node{" +
//                    "value=" + value +
//                    ", parentNode=" + parentNode +
//                    '}';
//        }
//    }

























}
