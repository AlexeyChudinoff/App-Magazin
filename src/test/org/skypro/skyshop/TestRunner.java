package test.org.skypro.skyshop;


import org.skypro.skyshop.util.SimpleLogger;

public class TestRunner {

  public static void main(String[] args) {
    SimpleLogger.info("=== ЗАПУСК ТЕСТОВ SKYSHOP ===");
    SimpleLogger.info("Версия: 1.0");
    SimpleLogger.info("Дата: " + java.time.LocalDate.now());
    SimpleLogger.info("=" .repeat(50));

    // Запуск всех тестов
    new ProductTest().runAllTests();
    new ProductBasketTest().runAllTests();
    new SearchEngineTest().runAllTests();
    new ArticleTest().runAllTests();

    SimpleLogger.info("=" .repeat(50));
    SimpleLogger.info("=== ВСЕ ТЕСТЫ УСПЕШНО ЗАВЕРШЕНЫ ===");
    SimpleLogger.info("Проект готов к использованию!");
  }
}