package com.sfedu;

import java.util.Iterator;

public class CustomIterator implements Iterator<Character> {
    private int index;

    @Override
    public boolean hasNext() {
        return ;
    }

    @Override
    public Character next() {
        return null;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}
