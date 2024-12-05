package org.skypro.skyshop;


import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.Basket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.searchProduct.SearchEngine;
import org.skypro.skyshop.searchProduct.Searchable;
import org.skypro.skyshop.product.SimpleProduct;

public class App {

  public static void main(String[] args) {

    Basket basket = new Basket();

    basket.addProduct("Виски", 800, 50);
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

    SearchEngine searchEngine = new SearchEngine();
    Article article = new Article("Title", "Content");
    Product product = new SimpleProduct("product", 50);

    Searchable article1 = new Article("article1", "Инструкция к article1");
    Searchable article2 = new Article("article2", "Инструкция к article2");
    Searchable article3 = new Article("article3", "Инструкция к article3");
    Searchable article4 = new Article("article4", "Инструкция к article4");
    Searchable product1 = new FixPriceProduct("product1");
    Searchable product2 = new SimpleProduct("product2", 50);
    Product product4 = new SimpleProduct("product4", 50);
    Searchable product3 = new DiscountedProduct("product3", 1000, 50);
    Searchable article5 = new Article("article5", "Инструкция к article5");
    Searchable article6 = new Article("article6", "Инструкция к article6");
    Searchable article7 = new Article("article7", "Инструкция к article7");

    searchEngine.GenerateSearchable(10);
    System.out.println();
    //searchEngine.addBasket(copyBasket);
    System.out.println();
    searchEngine.printSearchEngine();
    System.out.println();
    searchEngine.add(article);
    searchEngine.add1(product4);
    searchEngine.add(article1);
    searchEngine.add(article2);
    searchEngine.add(article3);
    searchEngine.add(article4);
    searchEngine.add(article5);
    searchEngine.add(article6);
    searchEngine.add(article7);
    searchEngine.add(product1);
    searchEngine.add(product2);
    searchEngine.add(product3);
    System.out.println();
    searchEngine.printGetStringRepresentation();
    System.out.println();
    searchEngine.search("Инструкция");
    System.out.println();

    searchEngine.setCopyBasket();
    System.out.println();


  }//maim
}//App