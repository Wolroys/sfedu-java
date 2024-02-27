package com.sfedu;

import java.util.Collection;
import java.util.Iterator;

public class Letters implements Collection<Character> {
    private char[] letters;
    private int size = 0;

    public Letters(String str){
        this.letters = str.toCharArray();
        this.size = letters.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (!(o instanceof Character))
            return false;

        for (char c : letters){
            if (c == (Character) o)
                return true;
        }
        return false;
    }

    @Override
    public Iterator<Character> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Character character) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Character> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
