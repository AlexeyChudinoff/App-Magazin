package org.skypro.skyshop;

import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchProduct.SearchEngine;

public class App {

  public static void main(String[] args) {
    System.out.println();
    ProductBasket productBasket = new ProductBasket();

    Product tovar_1 = new FixPriceProduct("Шило");
    Product tovar_2 = new FixPriceProduct("Водичка");
    Product tovar_3 = new DiscountedProduct("Еда", 800, 50);
    Product tovar_4 = new DiscountedProduct("Мыло", 600, 50);
    Product tovar_5 = new SimpleProduct("Сало", 300);
    Product tovar_6 = new SimpleProduct("Сало Сало Сало", 300);
    System.out.println("..Adding Products in Basket");
    productBasket.addProduct("Не съедобный", tovar_1);
    productBasket.addProduct("Съедобный", tovar_2);
    productBasket.addProduct("Съедобный", tovar_3);
    productBasket.addProduct("Не съедобный", tovar_4);
    productBasket.addProduct("Съедобный", tovar_5);
    productBasket.addProduct("Съедобный", tovar_6);
    System.out.println();
    productBasket.printBasket();

    System.out.println();
    productBasket.printBasketCost();
    System.out.println();
    productBasket.specialProduct();
    System.out.println();
    productBasket.printBasket();
    System.out.println();
    productBasket.dellProductByName("Мыло");
    System.out.println();
    productBasket.printBasket();
    System.out.println();
    System.out.println("=============================");
    System.out.println();
    System.out.println();

    SearchEngine searchEngine = new SearchEngine();

    System.out.println();
    searchEngine.addBasketInSearchList(productBasket);
    System.out.println();

    Article article1 = new Article("artic1", "Инструкция к article1");
    Article article2 = new Article("articl2", "Инструкция к article2");
    Article article3 = new Article("article3", "Инструкция к article3");
   // Article article4 = new Article("article4", "Инструкция к article4");
    System.out.println("..Adding Articles in SearchList");
    searchEngine.addArticle( article1);
    searchEngine.addArticle( article2);
    searchEngine.addArticle( article3);
    //searchEngine.addArticle("Инструкции", article4);
    System.out.println();

    searchEngine.printSerchList();
    System.out.println();
    searchEngine.printGetStringRepresentation();
    System.out.println();
    searchEngine.searchProduct("article3");
    searchEngine.searchProduct("Шило");
    System.out.println();
    searchEngine.searchForMostSuitable("Сало");
    System.out.println();


  }//maim
}//App