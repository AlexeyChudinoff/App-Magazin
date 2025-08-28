package test.org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.util.SimpleLogger;

public class ProductTest {

  public void testProductCreation() {
    SimpleLogger.test("Тест создания продуктов");

    try {
      Product product1 = new SimpleProduct("Телефон", 10000);
      Product product2 = new FixPriceProduct("Книга");
      Product product3 = new DiscountedProduct("Ноутбук", 50000, 10);

      SimpleLogger.test("✓ Все продукты созданы успешно");

      // Проверка цен
      assert product1.getCostProduct() == 10000 : "Цена простого продукта неверна";
      assert product2.getCostProduct() == 500 : "Цена фиксированного продукта неверна";
      assert product3.getCostProduct() == 45000 : "Цена со скидкой неверна"; // 50000 - 10%

      SimpleLogger.test("✓ Цены продуктов верны");

    } catch (Exception e) {
      SimpleLogger.test("✗ Ошибка при создании продуктов: " + e.getMessage());
    }
  }

  public void testProductEquality() {
    SimpleLogger.test("Тест равенства продуктов");

    Product product1 = new SimpleProduct("Тест", 100);
    Product product2 = new SimpleProduct("Тест", 200);
    Product product3 = new SimpleProduct("Другой", 100);

    assert product1.equals(product2) : "Продукты с одинаковыми именами должны быть равны";
    assert !product1.equals(product3) : "Продукты с разными именами не должны быть равны";

    SimpleLogger.test("✓ Тест равенства пройден");
  }

  public void testInvalidProduct() {
    SimpleLogger.test("Тест обработки невалидных продуктов");

    try {
      new SimpleProduct("", 100);
      SimpleLogger.test("✗ Должна быть ошибка при пустом имени");
    } catch (IllegalArgumentException e) {
      SimpleLogger.test("✓ Корректно обработана ошибка пустого имени");
    }

    try {
      new SimpleProduct("Тест", -100);
      SimpleLogger.test("✗ Должна быть ошибка при отрицательной цене");
    } catch (IllegalArgumentException e) {
      SimpleLogger.test("✓ Корректно обработана ошибка отрицательной цены");
    }
  }

  public void runAllTests() {
    SimpleLogger.test("\n=== ЗАПУСК ТЕСТОВ ПРОДУКТОВ ===");
    testProductCreation();
    testProductEquality();
    testInvalidProduct();
    SimpleLogger.test("=== ТЕСТЫ ПРОДУКТОВ ЗАВЕРШЕНЫ ===\n");
  }
}