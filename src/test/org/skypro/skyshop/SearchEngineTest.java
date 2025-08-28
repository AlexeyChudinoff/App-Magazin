package test.org.skypro.skyshop;

import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.util.SimpleLogger;

public class SearchEngineTest {

  public void testSearchFunctionality() {
    SimpleLogger.test("Тест функциональности поиска");

    SearchEngine engine = new SearchEngine();
    ProductBasket basket = new ProductBasket();

    // Добавляем продукты в корзину
    basket.addProduct("Тест", new SimpleProduct("Apple iPhone", 100000));
    basket.addProduct("Тест", new SimpleProduct("Samsung Galaxy", 80000));

    // Добавляем статью
    engine.addArticle(new Article("Обзор смартфонов", "Лучшие смартфоны 2024 года"));

    // Добавляем корзину в поиск
    engine.addBasketInSearchList(basket);

    // Поиск точного совпадения
    var exactResults = engine.searchExactMatch("Apple iPhone");
    assert exactResults.size() == 1 : "Должно найтись одно точное совпадение";

    // Поиск по подстроке
    var containsResults = engine.searchContains("Phone");
    assert containsResults.size() == 1 : "Должно найтись одно совпадение по подстроке";

    SimpleLogger.test("✓ Тест функциональности поиска пройден");
  }

  public void testEmptySearch() {
    SimpleLogger.test("Тест пустого поиска");

    SearchEngine engine = new SearchEngine();
    var results = engine.searchExactMatch("Несуществующий");
    assert results.isEmpty() : "Поиск несуществующего должен вернуть пустой результат";

    SimpleLogger.test("✓ Тест пустого поиска пройден");
  }

  public void runAllTests() {
    SimpleLogger.test("\n=== ЗАПУСК ТЕСТОВ ПОИСКА ===");
    testSearchFunctionality();
    testEmptySearch();
    SimpleLogger.test("=== ТЕСТЫ ПОИСКА ЗАВЕРШЕНЫ ===\n");
  }
}