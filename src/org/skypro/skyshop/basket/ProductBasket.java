package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ProductBasket {

   private List<Product> basketAll = new LinkedList<>();



   public  void addProduct(Product product) {
      basketAll.add(product);

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

      if (basketAll.isEmpty()) {
         System.out.println("в корзине пусто");
      } else {
         for (int i = 0; i < basketAll.size(); i++) {
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

      if (!basketAll.isEmpty()){
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

   }

   public List<Product> deleteOneTypeOfProduct(Product product) {

      List<Product> deletedProducts = new LinkedList<>();
      if (basketAll.isEmpty()) {
         System.out.println("Список пуст");
         return deletedProducts;
      }else {
      for (int i = 0 ; i < basketAll.size() ; i++ ) {
         if (Objects.equals(basketAll.get(i),product)) {
            deletedProducts.add(basketAll.get(i));
            basketAll.remove(i);

         }
      }
      }
      if (deletedProducts.isEmpty()) {
         System.out.println("Список пуст");
      }

      return deletedProducts;
   }


}



