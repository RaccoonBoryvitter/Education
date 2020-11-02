package com.university.ModuleHomework;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Lessons.BeerMain
 *
 * @Autor: Pavel Shcherbatyi
 * @DateTime: 02.11.2020|02:45
 * @Version BeerMain: 1.0
 */

public class BeerMain {
    public static void main(String[] args) {

        BeerBottled beer1 = new BeerBottled("Львовское Светлое 4,7% 2,3л", 37.00f);
        BeerBottled beer2 = new BeerBottled("Bud Светлое 5% 0,75л", 28.80f);
        BeerBottled beer3 = new BeerBottled("Черниговское Белая Ночь  5% 0,5л", 17.50f);
        BeerBottled beer4 = new BeerBottled("Staropramen тёмное 3,8% 0,5л", 18.90f);

        BeerDraught beer5 = new BeerDraught("Балтика Разливное", 2.0f, 20.50f);
        BeerDraught beer6 = new BeerDraught("Оболонь", 3.0f, 18.20f);
        BeerDraught beer7 = new BeerDraught("Жигулёвское", 1.5f, 23.70f);

        List<IPrice> beerList = Arrays.asList(beer1, beer2, beer3, beer4, beer5, beer6, beer7);

        float sum1 = (float) beerList.stream()
                .filter(b -> b instanceof BeerBottled)
                .mapToDouble(IPrice::getCost)
                .sum();
        System.out.println("Стоимость всех бутылок пива вместе взятых: " + sum1);
        float min1 = (float) beerList.stream()
                .filter(b -> b instanceof BeerBottled)
                .mapToDouble(IPrice::getCost)
                .min().orElse(0.0);
        System.out.println("Самая дешёвая цена за бутылку пива: " + min1);
        float max1 = (float) beerList.stream()
                .filter(b -> b instanceof BeerBottled)
                .mapToDouble(IPrice::getCost)
                .max().orElse(0.0);
        System.out.println("Самая дорогая цена за бутылку пива: " + max1);
        float avg1 = (float) beerList.stream()
                .filter(b -> b instanceof BeerBottled)
                .mapToDouble(IPrice::getCost)
                .average().orElse(0.0);
        System.out.println("Средняя цена за бутылку пива: " + avg1);

        System.out.println("================================================================");

        float sum2 = (float) beerList.stream()
                .filter(b -> b instanceof BeerDraught)
                .mapToDouble(b -> b.getCost())
                .sum();
        System.out.println("Стоимость всех пинт разливного пива вместе взятых: " + sum2);
        float min2 = (float) beerList.stream()
                .filter(b -> b instanceof BeerDraught)
                .mapToDouble(IPrice::getCost)
                .min().orElse(0.0);
        System.out.println("Самая дешёвая цена за порцию пива: " + min2);
        float max2 = (float) beerList.stream()
                .filter(b -> b instanceof BeerDraught)
                .mapToDouble(IPrice::getCost)
                .max().orElse(0.0);
        System.out.println("Самая дорогая цена за порцию пива: " + max2);
        float avg2 = (float) beerList.stream()
                .filter(b -> b instanceof BeerDraught)
                .mapToDouble(IPrice::getCost)
                .average().orElse(0.0);
        System.out.println("Средняя цена за порцию пива: " + avg2);

        System.out.println("================================================================");

        System.out.println("Что же стоит дороже? Взять 4 бутылки пива или же 5.5 литров разливного?");

        String answer = "Всё же " + ((sum1 > sum2) ? "в бутылках." : "разливное.");
        System.out.println(answer);

    }
}