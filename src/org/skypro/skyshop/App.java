package org.skypro.skyshop;

import org.skypro.skyshop.product.ProductBasket;
import org.skypro.skyshop.searchProduct.SearchEngine;

public class App {

  public static void main(String[] args) {

    ProductBasket productBasket = new ProductBasket();
    System.out.println();
    System.out.println();
   // productBasket.addProduct("КЕПКО", 200, -5);//специально ошибочный
   // productBasket.addProduct("ШАПКО", -100);//специально ошибочный
   // productBasket.addProduct(" ");//специально ошибочный
    productBasket.addProduct("Вода",0,0);
  //  productBasket.addProduct("Еда");
    productBasket.addProduct("Штаны", 400,0);
   // productBasket.addProduct("Штаны красивые Штаны удобные Штаны дорогие", 500);
   // productBasket.addProduct("Рубаха", 300);
   // productBasket.addProduct("Трусы", 200);
   // productBasket.addProduct("Мыло", 900, 50);
    productBasket.addProduct("Сало", 900, 50);

    System.out.println();
    productBasket.printBasketCost();
    System.out.println();
    productBasket.specialProduct();
    System.out.println();
    productBasket.printBasket();
    System.out.println("=============================");
    System.out.println();
    System.out.println();

    SearchEngine searchEngine = new SearchEngine(5);
    System.out.println();
    searchEngine.addBasketInSearchList(productBasket);// указываем объект для вытягивания
    System.out.println();
    searchEngine.addArticle("article1", "Инструкция к article1");
    searchEngine.addArticle("article2", "Инструкция к article2");
    searchEngine.addArticle("article3", "Инструкция к article3");
    searchEngine.addArticle("article4", "Инструкция к article4");
    searchEngine.addArticle("article5", "Инструкция к article5");
    searchEngine.addArticle("article6", "Инструкция к article6");
    System.out.println();
    searchEngine.printSerchList();
    System.out.println();
    searchEngine.printGetStringRepresentation();
    System.out.println();
    searchEngine.searchProduct("Инструкция");
    System.out.println();
    searchEngine.searchForMostSuitable("Штаны");
    System.out.println();
    productBasket.dellProductByName("Штаны");
    System.out.println();


  }//maim
}//App