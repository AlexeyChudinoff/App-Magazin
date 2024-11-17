package org.skypro.skyshop;

public class App {

  public static void main(String[] args) {

    Basket.greateBasket();
    Basket.addProduct("Noski", 100);
  //  Basket.addProduct("Kepka", 100);
  //  Basket.addProduct("Ochki", 100);
    Basket.printBasket();
    Basket.printBasketCost();
    System.out.println("Итого:" + Basket.summCostBasket());
    System.out.println("------------");

    Basket.searchNameProduct("Rubashka");
    Basket.searchNameProduct("Sorochka");
    Basket.deliteAllBasket();
    Basket.printBasket();
    Basket.searchNameProduct("Rubashka");

  }
}