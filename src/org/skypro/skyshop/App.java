package org.skypro.skyshop;

import org.skypro.skyshop.product.Basket;
import org.skypro.skyshop.searchProduct.SearchEngine;

public class App {

  public static void main(String[] args) {

    Basket basket = new Basket();

    basket.addProduct("Виски", 800, 50);
    basket.addProduct("   ", -200, 120);
    basket.addProduct("Вода");
    basket.addProduct("Штаны", 400);
    basket.addProduct("Рубаха", 300);
    basket.addProduct("Трусы", 200);
    System.out.println();
    basket.printBasketCost();
    System.out.println();
    basket.SpecialProduct();
    System.out.println("=============================");
    System.out.println();
    System.out.println();

    SearchEngine searchEngine = new SearchEngine(4);

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


  }//maim
}//App