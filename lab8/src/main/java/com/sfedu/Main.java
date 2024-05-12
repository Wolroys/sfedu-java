package com.sfedu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
    

    private static List<String> getWordsFromFile(String fileName) {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.addAll(List.of(line.split("\\s+")));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return words;
    }
}
