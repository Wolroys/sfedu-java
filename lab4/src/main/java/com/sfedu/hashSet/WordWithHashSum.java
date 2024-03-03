package com.sfedu.hashSet;

import java.util.Objects;

public class WordWithHashSum {
    private String word;

    public WordWithHashSum(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordWithHashSum that = (WordWithHashSum) o;
        return Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        for (char c : word.toCharArray())
            hash += c;

        return hash;
    }

    @Override
    public String toString() {
        return "WordWithHashSum{" +
                "word='" + word + '\'' +
                '}';
    }
}
