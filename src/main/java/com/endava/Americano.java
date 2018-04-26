package com.endava;

public class Americano implements Brewable {

    @Override
    public Coffee brew(int sugar) {
        return new Coffee.Builder(0.5)
                .addWater(0.5)
                .addSugar(sugar)
                .build();
    }
}
