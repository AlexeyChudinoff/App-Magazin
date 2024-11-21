package org.skypro.skyshop;

public class App {

  public static void main(String[] args) {

    Product product = new Product("null", 0);
    Basket basket = new Basket();

    basket.greateBasket();
    basket.printBasket();
    basket.addProduct("Noski", 100);
    //   для проверки переполнения корзины
    //  basket.addProduct("Kepka", 100);
    basket.printBasket();
    basket.printBasketCost();
    System.out.println("Итого:" + basket.summCostBasket() + "\n ------------");
    basket.searchNameProduct("Хрень");
    basket.searchNameProduct("Noski");
    basket.deliteAllBasket();
    basket.printBasket();
    basket.searchNameProduct("Noski");

  }
}