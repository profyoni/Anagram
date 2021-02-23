package edu.touro.cs;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// TODO : Replace this file with your code

class AnagramTest {

    @org.junit.jupiter.api.Test
    void canonicalForm() {
        String actual = Anagram.canonicalForm("ASDFAGH");

        assertEquals("AADFGHS", actual);
    }
    @org.junit.jupiter.api.Test
    void FindAllAnagrams() {
        List<List<String>> actual = Anagram.FindAllAnagrams(Arrays.asList(new String [] {"MAD", "BOB", "DAM"}));

        assertEquals(1, actual.size());
        assertEquals("DAM", actual.get(0).get(0));
        assertEquals("MAD", actual.get(0).get(1));
    }

    @org.junit.jupiter.api.Test
    void FindAllAnagrams2() {
        List<List<String>> actual = Anagram.FindAllAnagrams(Arrays.asList(new String [] {"MAD","BBoa",  "BOaB", "AMd"}));

        assertEquals(2, actual.size());
        assertEquals("AMd", actual.get(0).get(0));
        assertEquals("MAD", actual.get(0).get(1));
        assertEquals("BBoa", actual.get(1).get(0));
        assertEquals("BOaB", actual.get(1).get(1));
    }
}