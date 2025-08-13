package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ProductBasket {

   private List<Product> basketAll = new LinkedList<>();
   private int count = 0 ;


   public  void addProduct(Product product) {
      basketAll.add(product);
      count++;
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


      int specialCounter = 0;

      if (count == 0) {
         System.out.println("в корзине пусто");
      } else {
         for (int i = 0; i < count; i++) {
            System.out.println(basketAll.get(i));
            if (basketAll.get(i).isSpecial()) {
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
      if (k != count){
         for (Product product : basketAll) {
            if (Objects.equals(product.getName(), name)) {
               return true;
            }
         }
      }
      return false;
   }

   public void deleteBasket() {
         basketAll.clear();
         count = 0;
   }

   public List deleteOneTypeOfProduct(Product product) {
      int howManyDeleted = 0;
      List<Product> deletedProducts = new LinkedList<>();
      if (count == 0) {
         System.out.println("Список пуст");
         return deletedProducts;
      }else {
      for (int i = 0 ; i < count ; i++ ) {
         if (Objects.equals(basketAll.get(i),product)) {
            deletedProducts.add(basketAll.get(i));
            basketAll.remove(i);
            howManyDeleted++;
            count--;
         }
      }
      }
      if (howManyDeleted == 0) {
         System.out.println("Список пуст");
      }

      return deletedProducts;
   }


}



