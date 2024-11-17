package org.skypro.skyshop;

public class App {

  public static void main(String[] args) {

    Product product = new Product("null", 0);
    basket basket = new basket();

    basket.greateBasket();
    basket.addProduct("Noski", 100);
    //   для проверки переполнения корзины
    //  basket.addProduct("Kepka", 100);
    //  basket.addProduct("Ochki", 100);
    basket.printBasket();
    basket.printBasketCost();
    System.out.println("Итого:" + basket.summCostBasket());
    System.out.println("------------");
    basket.searchNameProduct("Rubashka");
    basket.searchNameProduct("Sorochka");
    basket.deliteAllBasket();
    basket.printBasket();
    basket.searchNameProduct("Rubashka");

  }
}