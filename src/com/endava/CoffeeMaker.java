package com.endava;

import javafx.util.Pair;

import java.util.HashMap;

public class CoffeeMaker {


    public static Pair<Coffee, Integer> make(HashMap<String, Integer> values, int balance, int sugar, int choice) {

        Coffee cup = null;

        switch (choice) {
            case 1:
                balance -= 10;
                if (balance >= 0) {
                    values.put("COFFEE", values.get("COFFEE") - 50);
                    values.put("WATER", values.get("WATER") - 50);
                    values.put("SUGAR", values.get("SUGAR") - sugar);
                    cup = new Coffee.Builder(0.5)
                            .addWater(0.5)
                            .addSugar(sugar)
                            .build();
                } else {
                    balance += 10;
                }
                break;
            case 2:
                balance -= 10;
                if (balance >= 0) {
                    values.put("COFFEE", values.get("COFFEE") - 50);
                    values.put("MILK", values.get("MILK") - 16);
                    values.put("CHOCOLATE", values.get("CHOCOLATE") - 16);
                    values.put("MILKFOAM", values.get("MILKFOAM") - 16);
                    values.put("SUGAR", values.get("SUGAR") - sugar);
                    cup = new Coffee.Builder(0.5)
                            .addMilk(0.16)
                            .addChocolate(0.16)
                            .addMilkFoam(0.16)
                            .addSugar(sugar)
                            .build();
                } else {
                    balance += 10;
                }
                break;
            case 3:
                balance -= 10;
                if (balance >= 0) {
                    values.put("COFFEE", values.get("COFFEE") - 80);
                    values.put("MILKFOAM", values.get("MILKFOAM") - 20);
                    values.put("SUGAR", values.get("SUGAR") - sugar);
                    cup = new Coffee.Builder(0.8)
                            .addMilkFoam(0.2)
                            .addSugar(sugar)
                            .build();
                } else {
                    balance += 10;
                }
                break;
            case 4:
                balance -= 5;
                if (balance >= 0) {
                    values.put("COFFEE", values.get("COFFEE") - 60);
                    values.put("SUGAR", values.get("SUGAR") - sugar);
                    cup = new Coffee.Builder(0.6)
                            .addSugar(sugar)
                            .build();
                } else {
                    balance += 5;
                }
                break;
        }

        return new Pair<>(cup, balance);
    }

}
