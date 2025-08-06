package org.skypro.skyshop.product;

public class DiscountedProduct extends Product{
   private int basePrice;
   private int discount;


    public DiscountedProduct(String name, int basePrice, int discount) {
        super(name);
        try {
            if (basePrice > 0) {
                this.basePrice = basePrice;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("Цена должна быть строго больше 0!");
        }
        try {
            if (0 <= discount && discount <= 100) {
                this.discount = discount;
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("Скидка должна быть в диапозоне от 0 до 100 включительно!");
        }

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
