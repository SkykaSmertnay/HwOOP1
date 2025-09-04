package org.skypro.skyshop.product;

import org.skypro.skyshop.article.Article;

public class FixPriceProduct extends Product{
    private final static int FIX_PRICE = 100;
    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return name + ": " + "Фиксированная цена " + FIX_PRICE  ;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }


    @Override
    public int compareTo(Product o) {
        return Integer.compare(Integer.compare(this.getSearchedName().length(), o.getSearchedName().length()), 0);
    }
}
