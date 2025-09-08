package org.skypro.skyshop.product;

import org.skypro.skyshop.article.Article;

import java.util.Objects;

public class SimpleProduct extends Product {
   private int price;

    public SimpleProduct(String name, int price) {
        super (name);

            if (price > 0) {
                this.price = price;
            } else {
                throw new IllegalArgumentException();
            }

    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SimpleProduct that = (SimpleProduct) o;
        return price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price);
    }

    @Override
    public String toString() {
        return name + ": " + price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }



}
