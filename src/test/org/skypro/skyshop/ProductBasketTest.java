package test.org.skypro.skyshop;

import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.util.SimpleLogger;

public class ProductBasketTest {

  public void testBasketOperations() {
    SimpleLogger.test("Тест операций с корзиной");

    ProductBasket basket = new ProductBasket();
    Product product1 = new SimpleProduct("Телефон", 10000);
    Product product2 = new FixPriceProduct("Книга");

    // Добавление продуктов
    basket.addProduct("Электроника", product1);
    basket.addProduct("Книги", product2);

    assert basket.getTotalProductsCount() == 2 : "Неверное количество продуктов в корзине";
    SimpleLogger.test("✓ Продукты добавлены в корзину");

    // Проверка стоимости
    basket.printBasketCost(); // Должно быть 10000 + 500 = 10500

    // Удаление продукта
    basket.dellProductByName("Книга");
    assert basket.getTotalProductsCount() == 1 : "Продукт не был удален";
    SimpleLogger.test("✓ Продукт удален из корзины");

    SimpleLogger.test("✓ Тест операций с корзиной пройден");
  }

  public void testEmptyBasket() {
    SimpleLogger.test("Тест пустой корзины");

    ProductBasket basket = new ProductBasket();
    assert basket.isEmpty() : "Новая корзина должна быть пустой";
    assert basket.getTotalProductsCount() == 0 : "Количество продуктов должно быть 0";

    SimpleLogger.test("✓ Тест пустой корзины пройден");
  }

  public void runAllTests() {
    SimpleLogger.test("\n=== ЗАПУСК ТЕСТОВ КОРЗИНЫ ===");
    testBasketOperations();
    testEmptyBasket();
    SimpleLogger.test("=== ТЕСТЫ КОРЗИНЫ ЗАВЕРШЕНЫ ===\n");
  }
}