package com.sfedu.task1;

import java.util.Arrays;

public class Stack<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] stack;
    private int top;

    public Stack() {
        stack = new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    //Если пользователь хочет задать свой начальный размер стеку
    public Stack(int capacity) {
        stack = new Object[capacity];
        top = -1;
    }

    public void push(T value) {
        if (top == stack.length - 1)
            resize();

        stack[++top] = value;
    }


    @SuppressWarnings("unchecked") //Добавляем чтобы компилятор не подсвечивал ошибку приведения типа
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        T value = (T) stack[top];
        stack[top--] = null;

        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return (T) stack[top];
    }


    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    private void resize() {
        int newSize = stack.length * 2;

        stack = Arrays.copyOf(stack, newSize);
    }

}
