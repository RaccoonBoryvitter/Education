package com.university.LabWork2;

/**
 * Created by IntelliJ IDEA.
 * Lessons.PalindromeChecker
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 01.11.2020|02:52
 * @Version PalindromeChecker: 1.0
 */

public class PalindromeChecker {

    public static boolean isPalindrome(String inputWord) {

        // Избавление от знаков препинания, пробелов и тд
        String result = inputWord
                .toLowerCase()
                .replaceAll("[^0-9a-z\\u0430-\\u0451\\u0454\\u0456\\u0457]", "");

        //Непосредственно сама проверка
        boolean status = true;
        int size = result.length();
        int iterations = size / 2;
        for (int i = 0; i < iterations; i++) {
            if (result.charAt(i) != result.charAt(size - 1 - i)) {
                status = false;
                break;
            }
        }

        return status;
    }

}