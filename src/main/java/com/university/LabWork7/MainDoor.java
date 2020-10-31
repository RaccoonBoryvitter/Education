package com.university.LabWork7;

/**
 * Created by IntelliJ IDEA.
 * Lessons.MainDoor
 *
 * @Autor: pavel
 * @DateTime: 02.10.2020|01:33
 * @Version MainDoor: 1.0
 */

public class MainDoor {
    public static void main(String[] args) {
        Door door1 = new Door(2.0f, 1.2f, "дерево", "красный", 4);
        Door door2 = new Door(1.95f, 1.1f, "стационарный", "цилиндровый");
        Door door3 = new Door(1.5f, "железо", "серый", "поворотная", "кодовый", 0, 1300.50f);


        System.out.println(door1);
        System.out.println(door2);
        System.out.println(door3);
        door1.favouriteTrack();
    }
}