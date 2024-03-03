package com.sfedu.treeSet;

public class WordTreeSet implements Comparable<WordTreeSet>{

    private String word;

    public WordTreeSet(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public int compareTo(WordTreeSet o) {
        int diff = this.getWord().length() - o.getWord().length();
        if (diff == 0) {
            diff = this.getWord().compareTo(o.getWord());
        }
        return diff;
    }

    @Override
    public String toString() {
        return word + '\'';
    }

}
