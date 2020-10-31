package com.university.LabWork4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

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
        String marks = "\n\r.?!,;:\"";
        for(int i = 0; i < marks.length(); i++) {
            String ch = String.valueOf(marks.charAt(i));
            if(text.contains(ch)) {
                ch = "[" + ch + "]";
                text = text.replaceAll(ch, "");
            }
        }

        text = text.replaceAll("--", "");
        text = text.toLowerCase();
        return text;
    }

    public static void main(String[] args) {
        try {
            Path path = Paths.get("D:/Education/Harry Potter and the Sorcerer.txt");
            byte[] data = Files.readAllBytes(path);
            String text = new String(data, StandardCharsets.UTF_8);
            String processedText = WordCounterOptimization.cleanText(text);

            List<String> allWords = new ArrayList<String>();
            allWords = Arrays.asList(processedText.split("\\s+"));

            System.out.println("HELLO");
        } catch (IOException ioe) {
            System.out.println("ERROR: invalid path!");
            ioe.printStackTrace();
        }
    }
}