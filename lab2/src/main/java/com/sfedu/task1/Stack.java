package com.sfedu.task1;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

    private List<T> stack;

    public Stack(){
        stack = new ArrayList<>();
    }

    public void push(T value){
        stack.add(value);
    }

    public T pop(){
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return stack.remove(stack.size() - 1);
    }

    public T peek(){
        if (stack.isEmpty()){
            throw new RuntimeException("Stack is empty");
        }

        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public int size(){
        return stack.size();
    }


}
