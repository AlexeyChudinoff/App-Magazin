package org.skypro.skyshop.product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.TreeMap;

public class ProductBasket {

  private final Map<String, List<Product>> productBasket = new HashMap<>();

  public void addProduct(String category, Product product) {
    // Получаем список продуктов для данной категории
    List<Product> products = productBasket.get(category);
    // Если список для категории еще не существует, создаем его
    if (products == null) {
      products = new ArrayList<>();
      productBasket.put(category, products);
    }
    // Добавляем продукт в список
    products.add(product);

    System.out.println("Add in category: " + category + ", product: " + product);
    System.out.println("Current basket: " + productBasket);
  }

  public void printBasket() {
    System.out.println("printBasket");
    if (productBasket.isEmpty()) {
      System.out.println("Корзина пуста");
    } else {
      System.out.println("Состав корзины:");
      for (Entry<String, List<Product>> product : productBasket.entrySet()) {
        System.out.println(product);
      }
    }
  }


//  public void printBasketCost() {
//    System.out.println("printBasketCost");
//    if (productBasket.isEmpty()) {
//      System.out.println("Корзина пуста.");
//    } else {
//      int summ = 0;
//      for (Product product : productBasket.values()) {
//        if (product != null) {
//          System.out.println(product.getNameProduct() + " cost " + product.getCostProduct());
//          summ += product.getCostProduct();
//        }
//      }
//      System.out.println("________________________");
//      System.out.println("Сумма корзины: " + summ);
//    }
//  }
//
//  public void specialProduct() {
//    int namber = 0;
//    System.out.println("Spec tovar : ");
//    for (Product product : productBasket.values()) {
//      if (product != null && product.isSpecial()) {
//        namber++;
//        System.out.println(product);
//      }
//    }
//    System.out.println(" Всего спец. товаров: " + namber + " шт");
//  }
//

//  public Map<String, Product> getProductBasket() {
//    return productBasket;
//  }
//
//  public List<Product> dellProductByName(String name) {
//    System.out.println("dellProductByName");
//    List<Product> dellBasket = new ArrayList<>();
//    if (productBasket.containsKey(name)) {
//      dellBasket.add(productBasket.get(name));
//      System.out.println("Dell: " + productBasket.get(name));
//      productBasket.remove(name);
//    } else {
//      System.out.println("Not found product: " + name);
//    }
//    return dellBasket;
//  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductBasket that = (ProductBasket) o;
    return Objects.equals(productBasket, that.productBasket);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(productBasket);
  }
}// class