package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
   private int basePrice;
   private int discount;


    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        int totalPrice;
        totalPrice = basePrice - basePrice * discount / 100;
        return totalPrice;
    }

    @Override
    public String toString() {
        return name + ": " + getPrice() + " скидка " + discount + "%" ;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}
