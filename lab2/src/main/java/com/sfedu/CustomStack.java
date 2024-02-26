package com.sfedu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CustomStack<T> {

    private List<T> stack;

    public CustomStack(){
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
