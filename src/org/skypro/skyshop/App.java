package org.skypro.skyshop;


import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.Basket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SearchEngine;
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
    System.out.println();

    Article article = new Article(" ЗАГОЛОВОК ", " СТАТЬЯ");
    Product product = new SimpleProduct("Кофейник", 900);
    SearchEngine searchable = new SearchEngine();

    Article article2 = new Article(" ЗАГОЛОВОК2 ", " СТАТЬЯ2");
    SimpleProduct simpleproduct = new SimpleProduct("Чайник", 800);
    FixPriceProduct fixproduct = new FixPriceProduct("Vaza");
    DiscountedProduct discproduct = new DiscountedProduct("Kartina", 800, 10);

    article.addArticle("Ода Вискарику", "Как пить и не напиваться ...");
    article.addArticle("Интструкция Рубаха", "Рубаха это ....");
    article.addArticle("Интструкция Трусы", "Трусы это ....");
    article.addArticle("Интструкция Штаны", "Штаны это ....");
    System.out.println();
    article.printArticles();
    System.out.println("oooooooooooo");
    System.out.println();
    System.out.println();

    searchable.GenerateSearchable(10);
    System.out.println();
searchable.printSearchEngine();
    System.out.println();
searchable.toString();
    System.out.println();

    System.out.println();
    /*SearchEngine.add("ложка",null,null);
    SearchEngine.add("вилка",null,null);
    SearchEngine.add("чашка",null,null);
    SearchEngine.add("тарелка",null,null);
    SearchEngine.add("нож",null,null);
    SearchEngine.add(null,"инструкция скатерть","скатерть это ...");
    SearchEngine.add(null,"инструкция нож","нож это ...");
    SearchEngine.add(null,"инструкция чашка","чашка это ...");
    SearchEngine.add(null,"инструкция вилка","вилка это ...");*/
    System.out.println();

    System.out.println();

    System.out.println();

    System.out.println();

    System.out.println();

    System.out.println();

    System.out.println();

    System.out.println();


  }//maim
}//App