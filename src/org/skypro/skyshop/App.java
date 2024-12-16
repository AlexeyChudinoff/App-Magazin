package org.skypro.skyshop;

import org.skypro.skyshop.product.Basket;
import org.skypro.skyshop.searchProduct.SearchEngine;

public class App {

  public static void main(String[] args) {

    Basket basket = new Basket();
    System.out.println();
    System.out.println();
    basket.addProduct("КЕПКО", 200, -5);//специально ошибочный
    basket.addProduct("ШАПКО", -100);//специально ошибочный
    basket.addProduct(" ");//специально ошибочный
    basket.addProduct("Вода");
    basket.addProduct("Еда");
    basket.addProduct("Штаны", 400);
    basket.addProduct("Штаны красивые Штаны удобные Штаны дорогие", 500);
    basket.addProduct("Рубаха", 300);
    basket.addProduct("Трусы", 200);
    basket.addProduct("Мыло", 900, 50);
    basket.addProduct("Сало", 900, 50);
    System.out.println();
    basket.printBasketCost();
    System.out.println();
    basket.SpecialProduct();
    System.out.println();
    basket.printBasket();
    System.out.println("=============================");
    System.out.println();
    System.out.println();

    SearchEngine searchEngine = new SearchEngine(10);

    System.out.println();
    searchEngine.addBasket();
    System.out.println();
    searchEngine.addArticle("article1", "Инструкция к article1");
    searchEngine.addArticle("article2", "Инструкция к article2");
    searchEngine.addArticle("article3", "Инструкция к article3");
    searchEngine.addArticle("article4", "Инструкция к article4");
    searchEngine.addArticle("article5", "Инструкция к article5");
    searchEngine.addArticle("article6", "Инструкция к article6");
    System.out.println();
    searchEngine.printGetStringRepresentation();
    System.out.println();
    searchEngine.search("Инструкция");
    System.out.println();
    searchEngine.searchForMostSuitable("Штаны");
    basket.getProductBasket();


  }//maim
}//App