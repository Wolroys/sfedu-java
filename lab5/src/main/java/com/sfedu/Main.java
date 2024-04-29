package com.sfedu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();

        try(BufferedReader reader = new BufferedReader(
                new BufferedReader(new FileReader("file.txt")))) {

            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(" ");
                String command = parts[0];

                switch (command) {
                    case "ADD":
                        dictionary.addSynonym(parts[1], parts[2]);
                        break;
                    case "COUNT":
                        System.out.println(dictionary.getSynonymsCount(parts[1]));
                        break;
                    case "SYN":
                        System.out.println(dictionary.getSynonyms(parts[1]));
                        break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
