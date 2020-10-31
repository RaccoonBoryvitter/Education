package com.university.LabWork4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WordCounterHard {

    public static String[] cleaner (String t) {
        String marks = "\n\r.?!,;:\"";
        for(int i = 0; i < marks.length(); i++) {
            String ch = String.valueOf(marks.charAt(i));
            if(t.contains(ch)) {
                ch = "[" + ch + "]";
                t = t.replaceAll(ch, "");
            }
        }

        t = t.replaceAll("--", "");
        t = t.toLowerCase();

        return t.split("\\s+");
    }

    public static void main(String[] args) {
        try {
            Path path = Paths.get("D:/Education/Harry Potter and the Sorcerer.txt");
            byte[] data = Files.readAllBytes(path);
            String text = new String(data, StandardCharsets.UTF_8);
            String[] words = WordCounterHard.cleaner(text);

            // Создание массива уникальных слов
            int uniqueLength = 0;
            for (int i = 0; i < words.length; i++) {
                int j = 0;
                for (j = 0; j < i; j++) {
                    if (words[i].equals(words[j]))
                        break;

                }
                if (i == j)
                    uniqueLength++;
            }

            String[] uniqueWords = new String[uniqueLength];
            int index = 0;
            for (int i = 0; i < words.length; i++) {
                int j = 0;
                for (j = 0; j < i; j++) {
                    if (words[i].equals(words[j]))
                        break;
                }
                if (i == j) {
                    uniqueWords[index] = words[i];
                    index++;
                }
            }

            // Массив частоты слов
            int[] wordFrequency = new int[uniqueLength];
            for (int i = 0; i < uniqueLength; i++) {
                int freq = 0;
                for (int j = 0; j < words.length; j++) {
                    if(uniqueWords[i].equals(words[j]))
                        freq++;
                }
                wordFrequency[i] = freq;
            }

            // Сортировка относительно массива частоты
            for (int i = 0; i < uniqueLength - 1; i++) {
                int min = i;
                for (int j = i + 1; j < uniqueLength; j++) {
                    if (wordFrequency[j] < wordFrequency[min])
                        min = j;
                }

                int temp = wordFrequency[min];
                String tempWord = uniqueWords[min];
                wordFrequency[min] = wordFrequency[i];
                uniqueWords[min] = uniqueWords[i];
                wordFrequency[i] = temp;
                uniqueWords[i] = tempWord;
            }

            System.out.println("Words count: " + words.length);
            System.out.println("Unique Words Count: " + uniqueLength);
            System.out.println("----------------------------------------------");
            System.out.printf("%-18s%-8s%-6s%n", "Word", "Amount", "Frequency");
            for (int i = (uniqueLength - 1); i >= (uniqueLength - 20); i--) {
                double freq = (double)wordFrequency[i] / (double)words.length * 100;
                System.out.printf("%-18s|%-7d|%5.2f", uniqueWords[i], wordFrequency[i] ,freq);
                System.out.println("%");
            }

        } catch (IOException ex) {
            System.out.println("ERROR: invalid path!");
        }
    }
}
