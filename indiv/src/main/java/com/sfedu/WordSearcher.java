package com.sfedu;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordSearcher {
    private static final int DEFAULT_THREAD_COUNT = 3;
    private final Path dir;
    private final String word;
    private final int threadCount;
    private final BlockingQueue<Path> queue = new LinkedBlockingQueue<>();
    private final AtomicBoolean done = new AtomicBoolean(false);

    public WordSearcher(String dir, String word, int threadCount) {
        this.dir = Paths.get(dir);
        this.word = word;
        this.threadCount = threadCount > 0 ? threadCount : DEFAULT_THREAD_COUNT;
    }

    public void start() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount + 1);
        executorService.submit(this::directoryWalker);

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(this::fileProcessor);
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }

    private void directoryWalker() {
        try {
            Files.walk(dir)
                    .filter(Files::isRegularFile)
                    .forEach(queue::offer);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            done.set(true);
        }
    }

    private void fileProcessor() {
        try {
            while (!done.get() || !queue.isEmpty()) {
                Path file = queue.poll(100, TimeUnit.MILLISECONDS);
                if (file != null) {
                    processFile(file);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void processFile(Path file) {
        try (BufferedReader reader = Files.newBufferedReader(file)) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = Pattern.compile("\\b" + word + "\\b").matcher(line);
                if (matcher.find()) {
                    System.out.println("File: " + file + " -> " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
