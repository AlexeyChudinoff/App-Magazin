package org.skypro.skyshop;


import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.Basket;
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

    basket.printBasketCost();
    basket.SpecialProduct();
    System.out.println("=============================");

    Article article = new Article(" ЗАГОЛОВОК "," СТАТЬЯ");
    SimpleProduct product = new SimpleProduct("Чайник", 800);
    SearchEngine searchEngine = new SearchEngine(null, null, null);

    article.getStringRepresentation();
    product.getStringRepresentation();
    searchEngine.GenerateSearchable(4);





  }//maim
}//App