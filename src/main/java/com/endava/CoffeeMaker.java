package com.endava;

import javafx.util.Pair;

import java.util.HashMap;

import static com.endava.Ingredients.*;

public class CoffeeMaker {


    public static Pair<Coffee, Integer> make(HashMap<Enum, Integer> values, int balance, int sugar, int choice) {

        Coffee cup = null;

        switch (choice) {
            case 1:
                balance -= 10;
                if (balance >= 0) {
                    values.put(COFFEE, values.get(COFFEE) - 50);
                    values.put(WATER, values.get(WATER) - 50);
                    values.put(SUGAR, values.get(SUGAR) - sugar);
                    cup = new Americano().brew(sugar);
                } else {
                    balance += 10;
                }
                break;
            case 2:
                balance -= 10;
                if (balance >= 0) {
                    values.put(COFFEE, values.get(COFFEE) - 50);
                    values.put(MILK, values.get(MILK) - 16);
                    values.put(CHOCOLATE, values.get(CHOCOLATE) - 16);
                    values.put(MILKFOAM, values.get(MILKFOAM) - 16);
                    values.put(SUGAR, values.get(SUGAR) - sugar);
                    cup = new Cappucino().brew(sugar);
                } else {
                    balance += 10;
                }
                break;
            case 3:
                balance -= 10;
                if (balance >= 0) {
                    values.put(COFFEE, values.get(COFFEE) - 80);
                    values.put(MILKFOAM, values.get(MILKFOAM) - 20);
                    values.put(SUGAR, values.get(SUGAR) - sugar);
                    cup = new Macchiato().brew(sugar);
                } else {
                    balance += 10;
                }
                break;
            case 4:
                balance -= 5;
                if (balance >= 0) {
                    values.put(COFFEE, values.get(COFFEE) - 60);
                    values.put(SUGAR, values.get(SUGAR) - sugar);
                    cup = new Espresso().brew(sugar);
                } else {
                    balance += 5;
                }
                break;
        }

        return new Pair<>(cup, balance);
    }

}
