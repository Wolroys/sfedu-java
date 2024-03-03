package com.sfedu.treeSet;

import java.util.Comparator;

public class WordCompareByFirstThreeSymbols implements Comparator<WordTreeSet> {

    @Override
    public int compare(WordTreeSet o1, WordTreeSet o2) {
        return o1.getWord().substring(0, Math.min(o1.getWord().length(), 3)).
                compareTo(o2.getWord().substring(0, Math.min(o2.getWord().length(), 3)));
    }
}
