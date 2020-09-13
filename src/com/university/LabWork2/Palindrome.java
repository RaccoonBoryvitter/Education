package com.university.LabWork2;

//import java.util.StringTokenizer;

public class Palindrome {
    public static void main(String[] args) {

        String word = "Води, Сахара, хасидов";
        System.out.println("> Is given string \"" + word + "\" a palindrome?");

        // Избавление от знаков препинания, пробелов и тд
        String delim = " -:;!?,.–«»";
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            String c = String.valueOf(word.charAt(i));
            if (!delim.contains(c))
                result += c;
        }
        result = result.toLowerCase();

        //Непосредственно сама проверка
        boolean isPalindrome = true;
        byte size = (byte)(result.length());
        for (int i = 0; i < (size / 2); i++) {
            if (result.charAt(i) != result.charAt(size - 1 - i)) {
                isPalindrome = false;
                break;
            }

        }

        System.out.println("> Answer: " + isPalindrome);
    }
}

/* Первый способ -- токенайзер
 *
 *     String delim = " -:;!?,.–«»";
       StringTokenizer tokenizer = new StringTokenizer(word, delim);
       String result = "";
       while(tokenizer.hasMoreTokens()) {
           result = result + tokenizer.nextToken();
       }

       boolean isPalindrome = true;
       byte size = (byte)(result.length());
       for (int i = 0; i < (size / 2); i++) {
           if (result.charAt(i) != result.charAt(size - 1 - i)) {
               isPalindrome = false;
               break;
           }
       }
 *
 *
 */

/* Второй способ -- без токенайзера (аналогичный)
 *
 *     String delim = " -:;!?,.–«»";
       String result = "";
       for (int i = 0; i < word.length(); i++) {
           String c = String.valueOf(word.charAt(i));
           if (!delim.contains(c))
               result = result + c;
       }

       boolean isPalindrome = true;
       byte size = (byte)(result.length());
       for (int i = 0; i < (size / 2); i++) {
           if (result.charAt(i) != result.charAt(size - 1 - i)) {
               isPalindrome = false;
               break;
           }

       }
 *
 */