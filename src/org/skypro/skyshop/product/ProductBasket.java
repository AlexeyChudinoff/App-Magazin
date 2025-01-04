package org.skypro.skyshop.product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ProductBasket {

  private final Map<String,Product > productBasket = new HashMap<>();

  public void addProduct(String name, Product product) {
    productBasket.put(name, product);
    System.out.println("Add: " + name + ": "+ product);
  }

  public void printBasketCost() {
    System.out.println("printBasketCost");
    if (productBasket.isEmpty()) {
      System.out.println("Корзина пуста.");
    } else {
      int summ = 0;
      for (Product product : productBasket.values()) {
        if (product != null) {
          System.out.println(product.getNameProduct() + " cost " + product.getCostProduct());
          summ += product.getCostProduct();
        }
      }
      System.out.println("________________________");
      System.out.println("Сумма корзины: " + summ);
    }
  }

  public void specialProduct() {
    int namber = 0;
    System.out.println("Spec tovar : ");
    for (Product product : productBasket.values()) {
      if (product != null && product.isSpecial()) {
        namber++;
        System.out.println(product);
      }
    }
    System.out.println(" Всего спец. товаров: " + namber + " шт");
  }

  public void printBasket() {
    System.out.println("printBasket");
    if (productBasket.isEmpty()) {
      System.out.println("Корзина пуста");
    } else {
      System.out.println("Состав корзины:");
      for (Entry<String, Product> product : productBasket.entrySet()) {
        System.out.println(product);
      }
    }
  }

  // нужен для другого метода
  public Collection<Product> getProductBasket() {
    return productBasket.values();
  }

  public List<Product> dellProductByName(String name) {
    List<Product> dellBasket = new ArrayList<>();
    if (productBasket.containsKey(name)) {
      dellBasket.add(productBasket.get(name));
      productBasket.remove(name);
    }
    return dellBasket;
  }



  //поиск по имени обьекта внутри значения
//  public List<Product> dellProductByName(String name) {
//    System.out.println("dellProductByName");
//    List<Product> dellBasket = new ArrayList<>();
//    Iterator<Product> iterator = productBasket.values().iterator();
//    String answer = name + " Не найдено";
//    while (iterator.hasNext()) {
//      Product product = iterator.next();
//      if (product.searchTerm().equals(name)) {
//        dellBasket.add(product);
//        iterator.remove();
//        answer = "Найден и удалён: " + product.searchTerm();
//      }
//    }
//    System.out.println(answer);
//    System.out.println(dellBasket);
//    return dellBasket;
//  }

}// main
