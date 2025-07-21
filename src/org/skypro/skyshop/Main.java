package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class Main {
    public static void main(String[] args) {
        SimpleProduct beer = new SimpleProduct("пиво",70);
        SimpleProduct chips = new SimpleProduct("чипсы",50);
        SimpleProduct water = new SimpleProduct("вода",20);
        SimpleProduct chicken = new SimpleProduct("курица",250);
        SimpleProduct cola = new SimpleProduct("кола",150);
        DiscountedProduct mead = new DiscountedProduct("медовуха",100,20);
        DiscountedProduct tea = new DiscountedProduct("чай",250,15);
        FixPriceProduct eggs = new FixPriceProduct("яйца");
        ProductBasket basket1 = new ProductBasket();
        System.out.println(basket1);
        basket1.addProduct(mead);
        basket1.addProduct(chips);
        basket1.addProduct(water);
        basket1.addProduct(eggs);
        basket1.addProduct(tea);
        System.out.println("Заполнили корзину");
        basket1.basketPrice();
        basket1.printBasket();
        System.out.println("Пытаемся добавить 6-й продукт");
        basket1.addProduct(beer);
        System.out.println("Стоимость корзины " + basket1.basketPrice());
        System.out.println("Есть ли в корзине искомый продукт: " +basket1.isProductInBasket("курица"));
        System.out.println("Есть ли в корзине искомый продукт: " +basket1.isProductInBasket("медовуха"));
        basket1.deleteBasket();
        System.out.println("Очистили корзину");
        basket1.printBasket();
        System.out.println("Стоимость корзины " + basket1.basketPrice());
        System.out.println("Есть ли в корзине искомый продукт: " + basket1.isProductInBasket("вода"));
    }
}