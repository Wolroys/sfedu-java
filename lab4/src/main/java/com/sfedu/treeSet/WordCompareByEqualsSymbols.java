package com.sfedu.treeSet;

import java.util.Comparator;

public class WordCompareByEqualsSymbols implements Comparator<WordTreeSet> {

    @Override
    public int compare(WordTreeSet o1, WordTreeSet o2) {
        int count1 = countEqualSymbols(o1.getWord());
        int count2 = countEqualSymbols(o2.getWord());

        if (count1 == count2)
            return o1.getWord().compareTo(o2.getWord());

        return count1 - count2;
    }

    private int countEqualSymbols(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j < word.length(); j++) {
                if (word.charAt(i) == word.charAt(j)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

}
