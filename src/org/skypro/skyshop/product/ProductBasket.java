package org.skypro.skyshop.product;

import org.skypro.skyshop.util.SimpleLogger;

import java.util.*;

public class ProductBasket {


  private final Map<String, List<Product>> productBasket = new HashMap<>();


  public void addProduct(String category, Product product) {
    if (category == null || category.isBlank()) {
      SimpleLogger.warn("Категория не может быть пустой! Продукт не добавлен.");
      return;
    }

    if (product == null) {
      SimpleLogger.warn("Продукт не может быть null! Не добавлен в категорию: " + category);
      return;
    }

    productBasket.computeIfAbsent(category, k -> new ArrayList<>()).add(product);
    SimpleLogger.info("Добавлен продукт: " + product.getNameProduct() + " в категорию: " + category);
  }

  public void dellProductByName(String productName) {
    if (productName == null || productName.isBlank()) {
      SimpleLogger.warn("Имя продукта для удаления не может быть пустым!");
      return;
    }

    boolean removed = false;
    for (List<Product> products : productBasket.values()) {
      removed |= products.removeIf(product ->
          product != null && productName.equalsIgnoreCase(product.getNameProduct()));
    }

    if (removed) {
      SimpleLogger.info("Удален продукт: " + productName);
    } else {
      SimpleLogger.warn("Продукт не найден для удаления: " + productName);
    }
  }

  public void printBasket() {
    SimpleLogger.info("=== СОДЕРЖИМОЕ КОРЗИНЫ ===");

    if (productBasket.isEmpty()) {
      SimpleLogger.info("Корзина пуста!");
      return;
    }

    for (Map.Entry<String, List<Product>> entry : productBasket.entrySet()) {
      SimpleLogger.info("Категория: " + entry.getKey());
      for (Product product : entry.getValue()) {
        SimpleLogger.info("  - " + product.toString());
      }
    }
  }

  public void printBasketCost() {
    int totalCost = 0;
    for (List<Product> products : productBasket.values()) {
      for (Product product : products) {
        totalCost += product.getCostProduct();
      }
    }
    SimpleLogger.info("Общая стоимость корзины: " + totalCost + " руб.");
  }

  public void specialProduct() {
    SimpleLogger.info("=== СПЕЦИАЛЬНЫЕ ПРОДУКТЫ ===");
    boolean hasSpecial = false;

    for (List<Product> products : productBasket.values()) {
      for (Product product : products) {
        if (product.isSpecial()) {
          SimpleLogger.info("Специальный: " + product.toString());
          hasSpecial = true;
        }
      }
    }

    if (!hasSpecial) {
      SimpleLogger.info("Специальные продукты отсутствуют");
    }
  }

  public Map<String, List<Product>> getProductBasket() {
    // Возвращаем копию для защиты от внешних изменений
    Map<String, List<Product>> copy = new HashMap<>();
    for (Map.Entry<String, List<Product>> entry : productBasket.entrySet()) {
      copy.put(entry.getKey(), new ArrayList<>(entry.getValue()));
    }
    return copy;
  }

  public boolean isEmpty() {
    return productBasket.isEmpty();
  }

  public int getTotalProductsCount() {
    int count = 0;
    for (List<Product> products : productBasket.values()) {
      count += products.size();
    }
    return count;
  }
}