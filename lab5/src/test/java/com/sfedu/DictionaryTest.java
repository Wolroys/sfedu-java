package com.sfedu;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {

    @Test
    public void testAdd() {
        Dictionary dictionary = new Dictionary();
        dictionary.add("hello", "hi");
        assertEquals(1, dictionary.countSynonyms("hello"));
        assertEquals(1, dictionary.countSynonyms("hi"));

        dictionary.add("hi", "hey");
        assertEquals(2, dictionary.countSynonyms("hi"));
        assertEquals(1, dictionary.countSynonyms("hey"));

        dictionary.add("goodbye", "bye");
        assertEquals(1, dictionary.countSynonyms("goodbye"));
        assertEquals(1, dictionary.countSynonyms("bye"));
    }

    @Test
    public void testCountSynonyms() {
        Dictionary dictionary = new Dictionary();
        dictionary.add("hello", "hi");
        dictionary.add("hi", "hey");
        dictionary.add("goodbye", "bye");

        assertEquals(2, dictionary.countSynonyms("hi"));
        assertEquals(1, dictionary.countSynonyms("hello"));
        assertEquals(0, dictionary.countSynonyms("nonexistent"));
    }

    @Test
    public void testGetSynonyms() {
        Dictionary dictionary = new Dictionary();
        dictionary.add("hello", "hi");
        dictionary.add("hi", "hey");
        dictionary.add("goodbye", "bye");

        List<String> hiSynonyms = dictionary.getSynonyms("hi");
        assertTrue(hiSynonyms.contains("hello"));
        assertTrue(hiSynonyms.contains("hey"));

        List<String> helloSynonyms = dictionary.getSynonyms("hello");
        assertTrue(helloSynonyms.contains("hi"));
        assertFalse(helloSynonyms.contains("hey"));

        List<String> nonexistentSynonyms = dictionary.getSynonyms("nonexistent");
        assertTrue(nonexistentSynonyms.isEmpty());
    }


}