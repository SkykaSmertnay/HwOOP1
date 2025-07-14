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
         } else {
            k++;
         }
      }
      if (k == 5) {
         System.out.println("Невозможно добавить продукт");
      }
   }

   public int basketPrice() {
      int basketPrice = 0;
         for (Product product : basketAll) {
            if (product != null) {
               basketPrice = basketPrice + product.getProductPrice();
            }
         }


      return basketPrice;
   }

   public void printBasket() {
      int k = 0;
      for (Product product : basketAll){
      if (product == null) {
         k++;
      }
      }
      if (k == 5) {
         System.out.println("в корзине пусто");
      } else {
         for (int i = 0; i < basketAll.length; i++) {
            System.out.println(basketAll[i]);
         }
         System.out.println("Итого: " + basketPrice());
      }

   }
   public boolean isProductInBasket(String name) {
      int k = 0;
      for (Product product : basketAll){
         if (product == null) {
            k++;
         }
      }
      if (k != 5){
         for (Product product : basketAll) {
            if (Objects.equals(product.getProductName(), name)) {
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

}



