package com.university.LabWork1;

public class PersonalInfo {
    public static void main(String[] args) throws InterruptedException {

        // Примитивы (Primitives)
        byte myAge = 18;
        short myBirthYear = 2002;
        int daysPassed = 6636;
        long minutesPassed = 9_550_840L;
        float myWeight = 74.2f;
        double myHeight = 178.0;
        char myGender = 'M';
        boolean isStudent = true;

        // Ссылочные (Reference)
        String myName = "Pavel Shcherbatyi";
        String myHairColor = "black";
        String myEyeColor = "hazel";

        // Вывод информации
        System.out.println("\t[CLASSIFIED]");
        System.out.print(" > Full name: █████ ███████████");
        Thread.sleep(750);
        System.out.println("\r > Full name: " + myName);
        System.out.print(" > Age: ██ (borned in ████)");
        Thread.sleep(750);
        System.out.println("\r > Age: " + myAge + " (borned in " + myBirthYear + ")");
        System.out.print(" > Passed days since birth: ████ (███████ minutes)");
        Thread.sleep(750);
        System.out.println("\r > Passed days since birth: " + daysPassed +
                " (" + minutesPassed + " minutes)");
        System.out.print(" > Weight: ██.█ kg");
        Thread.sleep(750);
        System.out.println("\r > Weight: " + myWeight + " kg");
        System.out.print(" > Height: ███.█ cm");
        Thread.sleep(750);
        System.out.println("\r > Height: " + myHeight + " cm");
        System.out.print(" > Hair color: █████");
        Thread.sleep(750);
        System.out.println("\r > Hair color: " + myHairColor);
        System.out.print(" > Eye color: █████");
        Thread.sleep(750);
        System.out.println("\r > Eye color: " + myEyeColor);
        System.out.print(" > Gender: ████");
        Thread.sleep(750);
        if (myGender == 'M') {
            System.out.println("\r > Gender: " + myGender + "(ale)");
        } else {
            System.out.println("\r > Gender: " + myGender + "(emale)");
        }
        System.out.print(" > Studentship: ████████");
        Thread.sleep(750);
        if (isStudent)
            System.out.println("\r > Studentship: confirmed");
        else
            System.out.println("\r > Studentship: not confirmed");
    }
}
