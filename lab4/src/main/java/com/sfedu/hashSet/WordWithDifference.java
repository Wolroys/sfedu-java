package com.sfedu.hashSet;

import java.util.Objects;

public class WordWithDifference {
    private String word;

    public WordWithDifference(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordWithDifference that = (WordWithDifference) o;
        return Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        if (word.length() < 2)
            return 0;

        return word.charAt(0) - word.charAt(word.length() - 1);
    }

    @Override
    public String toString() {
        return "WordWithDifference{" +
                "word='" + word + '\'' +
                '}';
    }
}
