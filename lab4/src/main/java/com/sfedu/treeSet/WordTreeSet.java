package com.sfedu.treeSet;

import java.util.Objects;

public class WordTreeSet implements Comparable<WordTreeSet> {

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
            // Если длина слов одинакова, сравниваем сами слова
            diff = this.getWord().compareTo(o.getWord());
        }
        return diff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordTreeSet that = (WordTreeSet) o;
        return Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return word + '\'';
    }
}


