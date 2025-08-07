package org.skypro.skyshop.product;

import org.skypro.skyshop.article.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
   protected String name;

    public Product  (String name){

            if (name != null && !name.isBlank()) {
                this.name = name;
            } else {
                throw new IllegalArgumentException();
            }

    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return name;
    }

    public abstract boolean isSpecial();

    @Override
    public String searchTerm() {
        return name;
    }

    @Override
    public String searchedContent() {
        return "PRODUCT";
    }


    @Override
    public String getSearchedName() {
        return name;
    }
}


