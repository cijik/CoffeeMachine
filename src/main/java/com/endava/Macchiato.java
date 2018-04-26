package com.endava;

public class Macchiato implements Brewable {

    @Override
    public Coffee brew(int sugar) {
        return new Coffee.Builder(0.8)
                .addMilkFoam(0.2)
                .addSugar(sugar)
                .build();
    }

}
