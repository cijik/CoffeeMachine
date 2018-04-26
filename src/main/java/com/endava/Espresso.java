package com.endava;

public class Espresso implements Brewable {

    @Override
    public Coffee brew(int sugar) {
        return new Coffee.Builder(0.6)
                .addSugar(sugar)
                .build();
    }

}
