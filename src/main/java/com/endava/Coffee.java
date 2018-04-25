package com.endava;

public class Coffee {

    private final double coffee;
    private final double milk;
    private final int sugar;
    private final double water;
    private final double chocolate;
    private final double milkFoam;

    public static class Builder {
        private final double coffee;

        private double milk = 0.0;
        private int sugar = 0;
        private double water = 0.0;
        private double chocolate = 0.0;
        private double milkFoam = 0.0;

        public Builder(double coffee) {
            this.coffee = coffee;
        }

        public Builder addMilk(double val) {
            milk = val;
            return this;
        }

        public Builder addSugar(int val) {
            sugar = val;
            return this;
        }

        public Builder addWater(double val) {
            water = val;
            return this;
        }

        public Builder addChocolate(double val) {
            chocolate = val;
            return this;
        }

        public Builder addMilkFoam(double val) {
            milkFoam = val;
            return this;
        }

        public Coffee build() {
            return new Coffee(this);
        }
    }

    private Coffee(Builder builder) {
        coffee = builder.coffee;
        milk = builder.milk;
        sugar = builder.sugar;
        water = builder.water;
        chocolate = builder.chocolate;
        milkFoam = builder.milkFoam;
    }

}
