package com.endava;

public class Cappucino implements Brewable{

    @Override
    public Coffee brew(int sugar) {
        return new Coffee.Builder(0.5)
                .addMilk(0.16)
                .addChocolate(0.16)
                .addMilkFoam(0.16)
                .addSugar(sugar)
                .build();
    }

}
