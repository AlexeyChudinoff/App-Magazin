package org.skypro.skyshop;


import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.Basket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SearchEngine;
import org.skypro.skyshop.product.Searchable;
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
    Product product = new SimpleProduct("product", 600);

    Searchable article1 = new Article("article1", "Инструкция к article1");
    Searchable article2 = new Article("article2", "Инструкция к article2");
    Searchable article3 = new Article("article3", "Инструкция к article3");
    Searchable article4 = new Article("article4", "Инструкция к article4");
    Searchable product1 = new FixPriceProduct("product1");
    Searchable product2 = new SimpleProduct("product2", 300);
    Searchable product3 = new DiscountedProduct("product3",1000,50);

    searchEngine.GenerateSearchable(7);
    System.out.println();
    searchEngine.add(article);
    searchEngine.add(product);
    searchEngine.add(article1);
    searchEngine.add(article2);
    searchEngine.add(article3);
    searchEngine.add(product1);
    searchEngine.add(product2);
    searchEngine.add(product3);
    System.out.println();
    searchEngine.printSearchEngine();
    System.out.println();
    searchEngine.printGetStringRepresentation();
    System.out.println();
    searchEngine.search("Инструкция");




  }//maim
}//App