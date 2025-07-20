package org.skypro.skyshop.product;

import java.util.Objects;

public class Product {
   private String name;
    private int price;

    public Product (String productName,int productPrice){
        this.name = productName;
        this.price = productPrice;
    }

    public String getProductName() {
        return name;
    }

    public int getProductPrice() {
        return price;
    }

    /*public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }*/

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public String toString() {
        return name + " : " + price;
    }
}


