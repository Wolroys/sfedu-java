package com.sfedu;

import java.util.*;

public class Dictionary {
    private final Map<String, Set<String>> synonyms = new HashMap<>();

    public void addSynonym(String word1, String word2) {
        add(word1, word2);
        add(word2, word1);
    }

    public int getSynonymsCount(String word) {
        Set<String> set = synonyms.get(word);
        return set == null ? 0 : set.size();
    }

    public List<String> getSynonyms(String word) {
        Set<String> set = synonyms.get(word);
        return set == null ? Collections.emptyList() : new ArrayList<>(set);
    }

    private void add(String word1, String word2) {
        Set<String> set = synonyms.computeIfAbsent(word1, k -> new HashSet<>());
        set.add(word2);
    }
}
