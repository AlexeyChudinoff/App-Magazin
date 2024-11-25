package org.skypro.skyshop;

public class App {

  public static void main(String[] args) {

    Basket basket = new Basket();

    basket.addDiscountedProduct("Виски", 800, 50);
    basket.addFixPriceProduct("Вода");
    basket.addSimpleProduct("Штаны", 400);
    basket.addSimpleProduct("Рубаха", 300);
    basket.addSimpleProduct("Трусы", 200);

    basket.printBasketCost();
    basket.SpecialProduct();

  }
}