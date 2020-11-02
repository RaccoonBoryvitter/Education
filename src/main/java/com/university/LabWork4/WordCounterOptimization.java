package com.university.LabWork4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * Lessons.WordCounterOptimization
 *
 * @Autor: pavel
 * @DateTime: 15.10.2020|23:32
 * @Version WordCounterOptimization: 1.0
 */

public class WordCounterOptimization {
    public static String cleanText(String text) {
        text = text.replaceAll("[^a-zA-Z-'\\s+]|(\\s--\\s)", "");
        text = text.toLowerCase();
        return text;
    }

    public static void main(String[] args) {
        try {
            Path path = Paths.get("D:/Education/Harry Potter and the Sorcerer.txt");
            byte[] data = Files.readAllBytes(path);
            LocalDateTime start = LocalDateTime.now();
            String text = WordCounterOptimization.cleanText(new String(data, StandardCharsets.UTF_8));
            List<String> allWords = Arrays.stream(text.split("\\s+"))
                    .filter(w -> w.length() > 1)
                    .collect(Collectors.toList());

            Map<String, Long> dictionary = Arrays.stream(text.split("\\s+"))
                    .filter(w -> w.length() > 1)
                    .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
            LocalDateTime finish = LocalDateTime.now();

            System.out.printf("%-25s%-8s%-6s%n", "Word", "Amount", "Frequency (in %)");
            dictionary.entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .forEach(k -> System.out.printf("%-25s|%-7d|%5.6f%n",
                            k.getKey(),
                            k.getValue(),
                            k.getValue().doubleValue() / allWords.size() * 100));

            System.out.println("======================================================");
            System.out.println("Execution time: " + ChronoUnit.MILLIS.between(start, finish) + "ms");
        } catch (IOException ioe) {
            System.out.println("ERROR: invalid path!");
            ioe.printStackTrace();
        }
    }
}