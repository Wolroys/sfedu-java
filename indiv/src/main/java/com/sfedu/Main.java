package com.sfedu;


public class Main {
    public static void main(String[] args) {

        String directory = "C:\\Users\\averg\\IdeaProjects\\sfedu-java\\indiv\\dir";
        String keyword = "and";
        int threadCount = 4;

        try {
            new WordSearcher(directory, keyword, threadCount).start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
