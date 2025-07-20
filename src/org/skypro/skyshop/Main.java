package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class Main {
    public static void main(String[] args) {
        Product beer = new Product("пиво",70);
        Product chips = new Product("чипсы",50);
        Product water = new Product("вода",20);
        Product chicken = new Product("курица",250);
        Product cola = new Product("кола",150);
        ProductBasket basket1 = new ProductBasket();
        System.out.println(basket1);
        basket1.addProduct(beer);
        basket1.addProduct(chips);
        basket1.addProduct(water);
        basket1.addProduct(chicken);
        basket1.addProduct(chips);
        System.out.println("Заполнили корзину");
        basket1.basketPrice();
        basket1.printBasket();
        System.out.println("Пытаемся добавить 6-й продукт");
        basket1.addProduct(beer);
        System.out.println("Стоимость корзины " + basket1.basketPrice());
        System.out.println(basket1.isProductInBasket("вода"));
        System.out.println(basket1.isProductInBasket("кола"));
        basket1.deleteBasket();
        System.out.println("Очистили корзину");
        basket1.printBasket();
        System.out.println("Стоимость корзины " + basket1.basketPrice());
        System.out.println(basket1.isProductInBasket("вода"));
    }
}