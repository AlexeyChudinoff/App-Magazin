package org.skypro.skyshop.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class ProductBasket {

  private final Map<String, List<Product>> productBasket = new HashMap<>();

  public void addProduct(String category, Product product) {
    if (category == null || category.isBlank()) {
      throw new IllegalArgumentException("ВНИМАНИЕ ! Категория не может быть пустой !");
    }
    if (product == null) {
      throw new IllegalArgumentException("ВНИМАНИЕ ! Продукт не может быть null !");
    }
    List<Product> products = productBasket.get(category);
    if (products == null) {
      products = new ArrayList<>();
      productBasket.put(category, products);
    }
    products.add(product);
    System.out.println("Add in category: " + category + ", product: " + product);
  }

  public Map<String, List<Product>> getProductBasket() {
    return productBasket;
  }

  public void printBasket() {
    System.out.println("printBasket");
    if (productBasket.isEmpty()) {
      System.out.println("Корзина пуста");
    } else {
      System.out.println("Состав корзины:");
      productBasket.forEach((category, product) -> {
        System.out.println("Категория: " + category);
        System.out.println("Продукты: " + product);
      });
    }
  }//  а вот так без категорий только продукты
//      productBasket.values().stream()
//      .flatMap(List::stream)
//      .forEach(product -> System.out.println("Продукты = " + product));

  public void printBasketCost() {
    System.out.println("printBasketCost");
    if (productBasket.isEmpty()) {
      System.out.println("Корзина пуста.");
    } else {
      int summ = productBasket.values().stream()
          .flatMap(List::stream)
          .mapToInt(product -> {
            System.out.println(product.searchTerm() + " Цена " + product.getCostProduct());
            return product.getCostProduct();
          })
          .sum();
      System.out.println("________________________");
      System.out.println("Сумма корзины: " + summ);
    }
  }

  public void specialProduct() {
    System.out.println("Специальные товары : ");
    long size = productBasket.values().stream()
        .flatMap(List::stream)
        .filter(Product::isSpecial)
       // .peek(product -> System.out.println(product))
        .peek(System.out::println)
        .count();
    System.out.println("Всего: " + size + " продуктов");

  }

//        0;
//    for (List<Product> products : productBasket.values()) {
//      if (products != null) {
//        for (Product product : products) {
//          if (product != null && product.isSpecial()) {
//            namber++;
//            System.out.println(product);
//          }
//        }
//      }
//    }
//    System.out.println(" Всего спец. товаров: " + namber + " шт");
//  }

  public List<Product> dellProductByName(String name) {
    System.out.println("dellProductByName");
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("ВНИМАНИЕ ! Имя продукта не может быть пустым !");
    }
    List<Product> dellBasket = new ArrayList<>();
    boolean productFound = false;
    for (List<Product> products : productBasket.values()) {
      if (products != null) {
        // только через Iterator удалять элементы из списка
        // во время итерации, иначе ConcurrentModificationException
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
          Product product = iterator.next();
          if (product.getNameProduct().equals(name)) {
            dellBasket.add(product);
            iterator.remove();
            productFound = true;
          }
        }
      }
    }
    if (!productFound) {
      System.out.println("Не найден продукт: " + name);
      return dellBasket;
    }
    System.out.println("Удаленные продукты: " + dellBasket);
    return dellBasket;
  }

}// class