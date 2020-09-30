package com.university.LabWork4;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.Files;

public class WordCounterEasy {

    public static void main(String[] args) {
        String text = "The Dursleys had everything they wanted, but they also had a secret, and their greatest fear " +
                "was that somebody would discover it. They didn't think they could bear it if anyone " +
                "found out about the Potters. Mrs. Potter was Mrs. Dursley's sister, " +
                "but they hadn't met for several years; in fact, Mrs. Dursley pretended she didn't have a sister, " +
                "because her sister and her good-for-nothing husband were as unDursleyish as it was possible to be. " +
                "The Dursleys shuddered to think what the neighbors would say if the Potters arrived in the street. " +
                "The Dursleys knew that the Potters had a small son, too, but they had never even seen him. " +
                "This boy was another good reason for keeping the Potters away; " +
                "they didn't want Dudley mixing with a child like that. \n" +
                "When Mr. and Mrs. Dursley woke up on the dull, gray Tuesday our story starts, " +
                "there was nothing about the cloudy sky outside to suggest that strange and mysterious things " +
                "would soon be happening all over the country. Mr. Dursley hummed as he picked out his most boring " +
                "tie for work, and Mrs. Dursley gossiped away happily as she wrestled " +
                "a screaming Dudley into his high chair. \n" +
                "None of them noticed a large, tawny owl flutter past the window.";


        // Удаление знаков препинания, пробелов, абзацов и тд
        String marks = "\n.?!,;:\"";
        for (int i = 0; i < marks.length(); i++) {
            String m = String.valueOf(marks.charAt(i));
            if(text.contains(m)) {
                m = "[" + m + "]";
                text = text.replaceAll(m, "");
            }
        }
        text = text.replaceAll("--", "");
        text = text.toLowerCase();

        String[] words = text.split("\\s+");

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
        for (int i = (uniqueLength - 1); i >= 0; i--) {
            double freq = (double)wordFrequency[i] / (double)words.length * 100;
            System.out.printf("%-18s|%-7d|%5.2f", uniqueWords[i], wordFrequency[i] ,freq);
            System.out.println("%");
        }
    }
}


