package com.sfedu;

import java.util.*;

public class Dictionary {
    private final Map<String, Set<String>> synonyms;

    public Dictionary() {
        synonyms = new HashMap<>();
    }

    public void add(String word1, String word2) {
        synonyms.putIfAbsent(word1, new HashSet<>());
        synonyms.putIfAbsent(word2, new HashSet<>());

        synonyms.get(word1).add(word2);
        synonyms.get(word2).add(word1);
    }

    @SuppressWarnings("unchecked")
    public int countSynonyms(String word) {
        return synonyms.getOrDefault(word, Collections.EMPTY_SET).size();
    }

    @SuppressWarnings("unchecked")
    public List<String> getSynonyms(String word) {
        return synonyms.getOrDefault(word, Collections.EMPTY_SET).stream().toList();
    }
}
