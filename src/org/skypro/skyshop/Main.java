package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.article.SearchEngine;
import org.skypro.skyshop.article.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        SearchEngine searchEngine = new SearchEngine(5);
        Article article1 = new Article("Article1","Text");

        SimpleProduct beer = new SimpleProduct("пиво",70);
        SimpleProduct chips = new SimpleProduct("чипсы",50);
        SimpleProduct water = new SimpleProduct("вода",20);
        SimpleProduct chicken = new SimpleProduct("курица",250);
        SimpleProduct cola = new SimpleProduct("кола",150);
        DiscountedProduct mead = new DiscountedProduct("медовуха",100,20);
        DiscountedProduct tea = new DiscountedProduct("чай",250,15);
        FixPriceProduct eggs = new FixPriceProduct("яйца");
        Searchable[] basket2 = new Searchable[5];
        basket2[0] = beer;
        basket2[1] = water;
        basket2[2] = chicken;
        basket2[3] = article1;
        basket2[4] = tea;


        ProductBasket basket1 = new ProductBasket();
        searchEngine.add(beer);
        searchEngine.add(water);
        searchEngine.add(chicken);
        searchEngine.add(article1);
        searchEngine.add(cola);
        searchEngine.add(tea);
        searchEngine.add(eggs);


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
        System.out.println(water.searchTerm());
        System.out.println(Arrays.toString(searchEngine.search(basket2)));

    }
}