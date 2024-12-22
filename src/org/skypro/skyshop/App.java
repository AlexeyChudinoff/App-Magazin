package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.ProductBasket;
import org.skypro.skyshop.searchProduct.SearchEngine;
import org.skypro.skyshop.searchProduct.Searchable;

public class App {

  public static void main(String[] args) {

    ProductBasket productBasket = new ProductBasket();
    System.out.println();

   productBasket.generateProduct("КЕПКО", 200, -5);//специально ошибочный
    productBasket.generateProduct("ШАПКО", -100, 0);//специально ошибочный
    productBasket.generateProduct(" ", 0, 0);//специально ошибочный
    productBasket.generateProduct("Вода", 0, 0);
    productBasket.generateProduct("Еда", 0, 0);
    productBasket.generateProduct("Штаны", 400, 0);
    productBasket.generateProduct("Штаны красивые Штаны удобные Штаны дорогие", 500, 0);
    productBasket.generateProduct("Рубаха", 300, 0);
    productBasket.generateProduct("Трусы", 200, 0);
    productBasket.generateProduct("Мыло", 900, 50);
    productBasket.generateProduct("Сало", 900, 50);
    System.out.println();
    Product product;
    productBasket.addProduct(product);
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
    searchEngine.generateArticle("article1", "Инструкция к article1");
    searchEngine.generateArticle("article2", "Инструкция к article2");
    searchEngine.generateArticle("article3", "Инструкция к article3");
    searchEngine.generateArticle("article4", "Инструкция к article4");
    searchEngine.generateArticle("article5", "Инструкция к article5");
    searchEngine.generateArticle("article6", "Инструкция к article6");
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