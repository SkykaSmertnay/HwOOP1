package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

   private Map<String , List<Product>> basketAll = new HashMap<>();

   public  void addProduct(Product product) {
      basketAll.computeIfPresent(product.getName(), (key, list) -> {
         list.add(product);
         return list;
      });
      basketAll.computeIfAbsent(product.getName(), p -> new LinkedList<Product>()).add(product);

   }

   public int basketPrice() {
      int basketPrice = 0;
      for (Map.Entry<String, List<Product>> entry : basketAll.entrySet()) {
         for (Product product : entry.getValue()){
            if (product != null) {
               basketPrice = basketPrice + product.getPrice();
            }
         }
      }
      return basketPrice;
   }

   public void p() {
      System.out.println(basketAll);
   }



   public void printBasket() {

      int specialCounter = 0;

      if (basketAll.isEmpty()) {
         System.out.println("в корзине пусто");
      } else {
         for (Map.Entry<String, List<Product>> entry : basketAll.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {
               System.out.println(entry.getValue().get(i));
               if (entry.getValue().get(i).isSpecial()) {
                  specialCounter++;
               }
            }
         }

      }
      System.out.println("Итого: " + basketPrice());
      System.out.println("Специальных товаров: " + specialCounter);

   }
   public boolean isProductInBasket(String name) {

      if (basketAll.containsKey(name)){
         System.out.println(basketAll.get(name));
         return true;
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
         if (basketAll.containsKey(product.getName())) {
            deletedProducts = basketAll.get(product.getName());
            basketAll.remove(product.getName());
         }
      }
      if (deletedProducts.isEmpty()) {
         System.out.println("Список пуст");
      }

      return deletedProducts;
   }


}



