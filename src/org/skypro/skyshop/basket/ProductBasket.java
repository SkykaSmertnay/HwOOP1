package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.Arrays;
import java.util.Objects;

public class ProductBasket {
   private Product[] basketAll = new Product[5];

   public Product[] getBasketAll() {
      return basketAll;
   }

   public void setBasketAll(Product[] basketAll) {
      this.basketAll = basketAll;
   }
   public void setProductInBasket(int productNumber, Product product) {
      basketAll[productNumber] = product;
   }

   @Override
   public String toString() {
      return "ProductBasket{" +
              "basketAll=" + Arrays.toString(basketAll) +
              '}';
   }

   public  void addProduct(Product product) {
      if (basketAll[4] != null) {
         System.out.println("Невозможно добавить продукт");
      }
      for (int i=0; i < basketAll.length;i++) {

         if (basketAll[i] == null) {
            basketAll[i] = product;
            break;
         }
      }
   }

   public int basketPrice() {
      int basketPrice = 0;
      if (basketAll[0] != null) {
         for (Product product : basketAll) {
            basketPrice = basketPrice + product.getProductPrice();
         }
      }

      return basketPrice;
   }

   public void printBasket() {
      if (basketAll[0] == null) {
         System.out.println("в корзине пусто");
      } else {
         for (int i = 0; i < basketAll.length; i++) {
            System.out.println(basketAll[i]);
         }
         System.out.println("Итого: " + basketPrice());
      }
   }
   public boolean isProductInBasket(String name) {
      if (basketAll[0] == null){
         return false;
      }
      for (Product product : basketAll) {
         if (Objects.equals(product.getProductName(), name)) {
            return true;
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



