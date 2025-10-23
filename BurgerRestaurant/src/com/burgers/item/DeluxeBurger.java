package com.burgers.item;

public class DeluxeBurger extends Burger {

    public DeluxeBurger(String name, double price) {
        super(name, price, 5);
    }

    // Override method to ensure price doesn't change
    @Override
    public double getAdjustedPrice() {
        return super.getBasePrice();
    }

    @Override
    public void printItem() {
        super.printItem();
        System.out.println("   (Price includes toppings, drink and side item)");
    }
}