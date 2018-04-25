package com.endava;

import javafx.util.Pair;

import java.util.HashMap;

public class CoffeeMaker {


    public static Pair<Coffee, Integer> make(HashMap<Enum, Integer> values, int balance, int sugar, int choice) {

        Coffee cup = null;

        switch (choice) {
            case 1:
                balance -= 10;
                if (balance >= 0) {
                    values.put(Ingredients.COFFEE, values.get(Ingredients.COFFEE) - 50);
                    values.put(Ingredients.WATER, values.get(Ingredients.WATER) - 50);
                    values.put(Ingredients.SUGAR, values.get(Ingredients.SUGAR) - sugar);
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
                    values.put(Ingredients.COFFEE, values.get(Ingredients.COFFEE) - 50);
                    values.put(Ingredients.MILK, values.get(Ingredients.MILK) - 16);
                    values.put(Ingredients.CHOCOLATE, values.get(Ingredients.CHOCOLATE) - 16);
                    values.put(Ingredients.MILKFOAM, values.get(Ingredients.MILKFOAM) - 16);
                    values.put(Ingredients.SUGAR, values.get(Ingredients.SUGAR) - sugar);
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
                    values.put(Ingredients.COFFEE, values.get(Ingredients.COFFEE) - 80);
                    values.put(Ingredients.MILKFOAM, values.get(Ingredients.MILKFOAM) - 20);
                    values.put(Ingredients.SUGAR, values.get(Ingredients.SUGAR) - sugar);
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
                    values.put(Ingredients.COFFEE, values.get(Ingredients.COFFEE) - 60);
                    values.put(Ingredients.SUGAR, values.get(Ingredients.SUGAR) - sugar);
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
