package com.sfedu.treeSet;

import java.util.Comparator;

public class WordCompareByEqualsSymbols implements Comparator<WordTreeSet> {

    @Override
    public int compare(WordTreeSet o1, WordTreeSet o2) {
        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < o1.getWord().length(); i++){
            for (int j = 0; j < o1.getWord().length(); j++){
                if (i != j)
                    count1++;
            }
        }
        for (int i = 0; i < o2.getWord().length(); i++){
            for (int j = 0; j < o2.getWord().length(); j++){
                if (i != j)
                    count2++;
            }
        }

        if (count1 == count2)
            return o1.getWord().compareTo(o2.getWord());

        return count1 - count2;
    }
}
