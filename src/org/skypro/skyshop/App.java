package org.skypro.skyshop;

import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;

public class App {

  public static void main(String[] args) {
    System.out.println("🚀 Запуск приложения SkyShop!");
    System.out.println("=".repeat(50));

    // Создаем корзину продуктов
    ProductBasket productBasket = new ProductBasket();

    // Создаем различные продукты
    Product tovar1 = new FixPriceProduct("Шило");
    Product tovar2 = new DiscountedProduct("Мыло", 600, 50);  // 50% скидка = 300 руб.
    Product tovar3 = new SimpleProduct("Сало", 300);
    Product tovar4 = new SimpleProduct("Сало сало сало", 500);
    Product tovar5 = new DiscountedProduct("Хлеб", 100, 20);   // 20% скидка = 80 руб.
    Product tovar6 = new FixPriceProduct("Молоток");

    // Группируем продукты по категориям
    String prod = "Продовольственные товары";
    String hoz = "Хозяйственные товары";

    // Добавляем продукты в корзину
    productBasket.addProduct(prod, tovar1);
    productBasket.addProduct(hoz, tovar2);
    productBasket.addProduct(prod, tovar3);
    productBasket.addProduct(prod, tovar4);
    productBasket.addProduct(prod, tovar5);
    productBasket.addProduct(hoz, tovar6);

    System.out.println("\n📊 ИНФОРМАЦИЯ О КОРЗИНЕ:");
    System.out.println("=".repeat(30));

    // Выводим общую стоимость
    productBasket.printBasketCost();
    System.out.println();

    // Показываем специальные продукты
    productBasket.specialProduct();
    System.out.println();

    // Выводим содержимое корзины
    productBasket.printBasket();

    System.out.println("\n" + "=".repeat(50));
    System.out.println("🔍 ПОИСКОВАЯ СИСТЕМА:");
    System.out.println("=".repeat(30));

    // Создаем поисковый движок
    SearchEngine searchEngine = new SearchEngine();

    // Добавляем корзину в поисковый индекс
    searchEngine.addBasketInSearchList(productBasket);

    // Создаем и добавляем статьи
    Article article1 = new Article("article1", "Инструкция по использованию мыла");
    Article article2 = new Article("article2", "Как правильно хранить сало");
    Article article3 = new Article("article3", "Обзор хозяйственных товаров");
    Article article4 = new Article("Сало", "Рецепты приготовления сала"); // Статья с таким же названием как продукт

    searchEngine.addArticle(article1);
    searchEngine.addArticle(article2);
    searchEngine.addArticle(article3);
    searchEngine.addArticle(article4);

    System.out.println("\n📋 ВСЕ ОБЪЕКТЫ В ПОИСКЕ:");
    searchEngine.printSearchListSorted();

    System.out.println("\n🏷️ СТРОКОВЫЕ ПРЕДСТАВЛЕНИЯ:");
    searchEngine.printAllStringRepresentations();

    System.out.println("\n🔎 ПОИСК ТОЧНЫХ СОВПАДЕНИЙ:");
    searchEngine.searchExactMatch("Сало"); // Найдет и продукт и статью
    searchEngine.searchExactMatch("Мыло");
    searchEngine.searchExactMatch("Несуществующий"); // Не найдет

    System.out.println("\n🔍 ПОИСК ПО ПОДСТРОКЕ:");
    searchEngine.searchContains("сало"); // Найдет все упоминания
    searchEngine.searchContains("товар"); // Найдет в описании статьи

    System.out.println("\n🗑️ УДАЛЕНИЕ ПРОДУКТА ИЗ КОРЗИНЫ:");
    productBasket.dellProductByName("Сало"); // Удаляем один продукт "Сало"

    System.out.println("\n📊 КОРЗИНА ПОСЛЕ УДАЛЕНИЯ:");
    productBasket.printBasket();
    productBasket.printBasketCost();

    System.out.println("\n" + "=".repeat(50));
    System.out.println("✅ ПРИЛОЖЕНИЕ УСПЕШНО ЗАВЕРШЕНО!");
    System.out.println("=".repeat(50));
  }
}