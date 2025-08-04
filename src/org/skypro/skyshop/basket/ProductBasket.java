package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.Objects;

public class ProductBasket {
   private Product[] basketAll = new Product[5];

   public  void addProduct(Product product) {
      int k = 0;
      for (int i=0; i < basketAll.length;i++) {
         if (basketAll[i] == null) {
            basketAll[i] = product;
            break;
         }
         k = howManyItems();
      }
      if (k == 5) {
         System.out.println("Невозможно добавить продукт");
      }
   }
   public int basketPrice() {
      int basketPrice = 0;
      for (Product product : basketAll) {
         if (product != null) {
            basketPrice = basketPrice + product.getPrice();
         }
      }
      return basketPrice;
   }



   public void printBasket() {
      int k = 0;
      int specialCounter = 0;
      k = howManyItems();
      if (k == 0) {
         System.out.println("в корзине пусто");
      } else {
         for (int i = 0; i < basketAll.length; i++) {
            System.out.println(basketAll[i]);
            if (basketAll[i].isSpecial()) {
               specialCounter++;
            }
         }

      }
      System.out.println("Итого: " + basketPrice());
      System.out.println("Специальных товаров: " + specialCounter);

   }
   public boolean isProductInBasket(String name) {
      int k = 0;
      for (Product product : basketAll){
         if (product == null) {
            k++;
         }
      }
      if (k != basketAll.length){
         for (Product product : basketAll) {
            if (Objects.equals(product.getName(), name)) {
               return true;
            }
         }
      }
      return false;
   }

   public void deleteBasket() {
      for (int i = 0; i < basketAll.length; i++) {
         basketAll[i] = null;
      }

   }

   public int howManyItems() {
      int k = 0;
      for (Product product : basketAll) {
         if (product != null) {
            k++;
         }
      }
      return k;
   }
}



