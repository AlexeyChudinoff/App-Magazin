package test.org.skypro.skyshop;

import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.util.SimpleLogger;

public class ArticleTest {

  public void testArticleCreation() {
    SimpleLogger.test("Тест создания статей");

    Article article1 = new Article("Тестовая статья", "Содержание статьи");
    Article article2 = new Article("Другая статья", null);

    assert article1.searchTerm().equals("Тестовая статья") : "Неверное имя статьи";
    assert article2.getTextArticle().equals("") : "Текст статьи должен быть пустым для null";

    SimpleLogger.test("✓ Тест создания статей пройден");
  }

  public void testInvalidArticle() {
    SimpleLogger.test("Тест невалидных статей");

    try {
      new Article("", "Содержание");
      SimpleLogger.test("✗ Должна быть ошибка при пустом имени статьи");
    } catch (IllegalArgumentException e) {
      SimpleLogger.test("✓ Корректно обработана ошибка пустого имени статьи");
    }

    try {
      new Article(null, "Содержание");
      SimpleLogger.test("✗ Должна быть ошибка при null имени статьи");
    } catch (IllegalArgumentException e) {
      SimpleLogger.test("✓ Корректно обработана ошибка null имени статьи");
    }
  }

  public void runAllTests() {
    SimpleLogger.test("\n=== ЗАПУСК ТЕСТОВ СТАТЕЙ ===");
    testArticleCreation();
    testInvalidArticle();
    SimpleLogger.test("=== ТЕСТЫ СТАТЕЙ ЗАВЕРШЕНЫ ===\n");
  }
}