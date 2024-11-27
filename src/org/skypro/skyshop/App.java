package org.skypro.skyshop;

public class App {

  public static void main(String[] args) {

    Basket basket = new Basket();

    basket.addProduct("Виски", 800, 50);
    basket.addProduct("Вода");
    basket.addProduct("Штаны", 400);
    basket.addProduct("Рубаха", 300);
    basket.addProduct("Трусы", 200);

    basket.printBasketCost();
    basket.SpecialProduct();

  }
}