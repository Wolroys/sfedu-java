package com.sfedu;


import java.util.*;

public class Letters implements Collection<Character> {
    private char[] letters;
    private int size = 0;

    public Letters() {
    }

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
        return new LettersIterator();
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
        grow(size + 1);
        letters[size++] = character;
        return true;
    }

    private void grow(int capacity){
        if (capacity > letters.length){
            char[] newArr = new char[capacity];
            System.arraycopy(letters, 0, newArr, 0, size);
            letters = newArr;
        }
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof Character))
            return false;

        int index = -1;
        for (int i = 0; i < size; i++){
            if (letters[i] == (char) o){
                index = i;
                break;
            }
        }

        if (index == -1)
            return false;

        char[] newArr = new char[--size];

        System.arraycopy(letters, 0, newArr, 0, index);

        if (size - 1 - index >= 0)
            System.arraycopy(letters, index + 1, newArr, index, size - index);

        letters = newArr;

        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Character> c) {
        boolean isModified = false;

        for (Character el : c){
            add(el);
            isModified = true;
        }
        return isModified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isModified = false;

        for (Object o : c){
            if (!(o instanceof Character))
                return false;

            if (remove(o))
                isModified = true;
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isModified = false;

        for (Character el : letters){
            if (!c.contains(el) && this.remove(el))
                isModified = true;
        }

        return isModified;
    }

    @Override
    public void clear() {
        letters = new char[0];
        size = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letters other = (Letters) o;
        return size == other.size && Arrays.equals(letters, other.letters);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(letters);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Character c : letters)
            sb.append(c);
        return sb.toString();
    }

    private class LettersIterator implements Iterator<Character> {
        private int index;
        private int lastRemovedIndex = -1;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Character next() {
            if (!hasNext())
                throw new NoSuchElementException();
            lastRemovedIndex = index;

            return letters[index++];
        }

        @Override
        public void remove() {
            if (lastRemovedIndex == -1){
                throw new IllegalStateException();
            }

            if (lastRemovedIndex == index - 1){
                index--;
            }

            Letters.this.remove(lastRemovedIndex);
            lastRemovedIndex = -1;
        }
    }
}
