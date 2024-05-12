package com.sfedu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] files = {"C:\\Users\\averg\\IdeaProjects\\sfedu-java\\lab8\\alice30.txt",
                "C:\\Users\\averg\\IdeaProjects\\sfedu-java\\lab8\\crsto10.txt"};
        for (String fileName : files) {
            System.out.println("======================== Word count =======================");
            System.out.println("Parallel way: ");
            countWords(fileName, true);
            System.out.println("Common way: ");
            countWords(fileName, false);

            System.out.println("============= Count words with odd length =================");
            System.out.println("Parallel way: ");
            countOddLengthWord(fileName, true);
            System.out.println("Common way: ");
            countOddLengthWord(fileName, false);

            System.out.println("======================= Sorted words ======================");
            System.out.println("Parallel way: ");
            sortWordsWithLengthGreaterThan10(fileName, true);
            System.out.println("Common way: ");
            sortWordsWithLengthGreaterThan10(fileName, false);
        }
    }

    public static void countWords(String fileName, boolean isParallel) {
        List<String> words = getWordsFromFile(fileName);

        long startTime = System.currentTimeMillis();

        long count = 0;

        if (isParallel) {
            count = words.parallelStream().count();
        } else {
            count = words.size();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Word count: " + count + "; Time taken - " + (endTime - startTime) + " ms");

    }

    public static void countOddLengthWord(String fileName, boolean isParallel) {
        List<String> words = getWordsFromFile(fileName);

        long startTime = System.currentTimeMillis();
        Map<Integer, Long> countWords;

        if (isParallel) {
            countWords = words.parallelStream()
                    .filter(word -> word.length() % 2 != 0)
                    .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        } else {
            countWords = words.parallelStream()
                    .filter(word -> word.length() % 2 != 0)
                    .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Count words with odd length: " + countWords + "; Time taken - " + (endTime - startTime) + " ms");
    }

    public static void sortWordsWithLengthGreaterThan10(String fileName, boolean isParallel) {
        List<String> words = getWordsFromFile(fileName);

        List<String> sorted = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        if (isParallel) {
            sorted = words.parallelStream()
                    .filter(word -> word.length() > 10)
                    .sorted()
                    .collect(Collectors.toList());
        } else {
            sorted = words.stream()
                    .filter(word -> word.length() > 10)
                    .sorted()
                    .collect(Collectors.toList());
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Time taken - " + (endTime - startTime) + " ms");
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
