package com.dullbird.demo.offer;

import java.util.Stack;

public class Test09 {
    private Stack<Integer> input;
    private Stack<Integer> output;
    public Test09() {
        input =new Stack<>();
        output =new Stack<>();
    }
    
    public void appendTail(int value) {
        input.add(value);
    }

    public int deleteHead() {
        if(output.isEmpty()) {
            while(!input.isEmpty()){
                output.add(input.pop());
            }
        }
        if(output.isEmpty()) {
            return -1;    
        }
        return output.pop();
    }
    
}
