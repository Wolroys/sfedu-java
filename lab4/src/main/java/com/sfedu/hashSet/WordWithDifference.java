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
        int vowelsCount = countVowels(word);
        return vowelsCount;
    }

    private int countVowels(String word) {
        int count = 0;
        for (char c : word.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "WordWithDifference{" +
                "word='" + word + '\'' +
                '}';
    }
}



