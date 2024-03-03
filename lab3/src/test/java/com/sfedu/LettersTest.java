package com.sfedu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LettersTest {

    @Test
    void lettersShouldContainsS(){
        Letters letters = new Letters("snake");

        assertTrue(letters.contains('s'));
    }

    @Test
    void lettersShouldRemoveLetters(){
        Letters letters = new Letters("snake");

        letters.remove('e');

        assertEquals(4, letters.size());

        assertEquals("snak", letters.toString());

        letters.remove('a');

        assertEquals(3, letters.size());
        assertEquals("snk", letters.toString());

        letters.remove('s');

        assertEquals(2, letters.size());
        assertEquals("nk", letters.toString());

        letters.addAll(new Letters("abc"));

        letters.removeAll(new Letters("nk"));

        assertEquals(letters, new Letters("abc"));
    }

    @Test
    void lettersCollectionShouldAddAllLetters(){
        Letters letters = new Letters("abc");

        letters.add('d');

        assertEquals(4, letters.size());
        assertTrue(letters.contains('d'));

        letters.addAll(new Letters("zxc"));

        assertEquals(7, letters.size());
        assertTrue(letters.contains('z'));
        assertEquals("abcdzxc", letters.toString());
    }

    @Test
    void collectionHaveToBeEmpty(){
        Letters letters = new Letters("dsakjdaskljdasjkd");

        letters.clear();

        assertEquals("", letters.toString());
        assertTrue(letters.isEmpty());
    }

    @Test
    void collectionShouldRetainAllElements(){
        Letters letters = new Letters("hedgehog");

        letters.retainAll(new Letters("had"));

        assertEquals(3, letters.size());
        assertEquals(new Letters("hdh"), letters);
    }
}