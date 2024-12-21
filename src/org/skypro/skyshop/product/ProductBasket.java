package org.skypro.skyshop.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ProductBasket {

  private final List<Product> productBasket = new ArrayList<>();

//  public void addProduct(String nameSimpleProduct, int costSimpleProduct) {
//    Product product = null;
//    try {
//      product = new SimpleProduct(nameSimpleProduct, costSimpleProduct);
//    } catch (IllegalArgumentException e) {
//      System.out.println(e.getMessage() + ", Не удалось добавить: " + nameSimpleProduct);
//    }
//    if (product != null) {
//      productBasket.add(product);
//      System.out.println("Add: " + product);
//    }
//  }

//  public void addProduct(String nameFixPriceProduct) throws IllegalArgumentException {
//    Product product = null;
//    try {
//      product = new FixPriceProduct(nameFixPriceProduct);
//    } catch (Exception e) {
//      System.out.println(e.getMessage() + ", Не удалось добавить: " + nameFixPriceProduct);
//    }
//    if (product != null) {
//      productBasket.add(product);
//      System.out.println("Add: " + product);
//    }
//  }

//  public void addProduct(String nameDiscountedProduct, int baseCost,
//      int discountBaseCost) throws IllegalArgumentException {
//    Product product = null;
//    try {
//      product = new DiscountedProduct(nameDiscountedProduct, baseCost, discountBaseCost);
//    } catch (RuntimeException e) {
//      System.out.println(e.getMessage() + ", Не удалось добавить: " + nameDiscountedProduct);
//    }
//    if (product != null) {
//      productBasket.add(product);
//      System.out.println("Add: " + product);
//    }
//  }

  public void addProduct(String name, int cost, int discount) {
    Product product = null;


    if (name != null || cost == 0 || discount == 0) {
      product = new FixPriceProduct(name);
      productBasket.add(product);
      System.out.println("Add: " + product);
      return;
    }

    if (name != null || cost != 0 || discount == 0) {
      product = new SimpleProduct(name, cost);
      productBasket.add(product);
      System.out.println("Add: " + product);
      return;
    }

    if (name != null || cost != 0 || discount != 0) {
      product = new DiscountedProduct(name, cost, discount);
      productBasket.add(product);
      System.out.println("Add: " + product);
      return;
    }

    if (product != null) {
      productBasket.add(product);
    }

  }


  public void printBasketCost() {
    System.out.println("printBasketCost");
    if (productBasket.isEmpty()) {
      System.out.println("Корзина пуста.");
    } else {
      int summ = 0;
      for (Product product : productBasket) {

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
    for (int i = 0; i < productBasket.size(); i++) {
      if (productBasket.get(i) != null && productBasket.get(i).isSpecial()) {
        namber++;
        System.out.println(productBasket.get(i));
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
      for (Product product : productBasket) {
        System.out.println(product);
      }
    }
  }

  // нужен для другого метода
  public List<Product> getProductBasket() {
    return productBasket;
  }

  public List<Product> dellProductByName(String name) {
    System.out.println("dellProductByName");
    List<Product> dellBasket = new ArrayList<>();
    Iterator<Product> iterator = productBasket.iterator();
    String answer = name + " Не найдено";
    while (iterator.hasNext()) {
      Product product = iterator.next();
      if (product.searchTerm().equals(name)) {
        dellBasket.add(product);
        iterator.remove();
        answer = "Найден и удалён: " + product.searchTerm();
      }
    }
    System.out.println(answer);
    System.out.println(dellBasket);
    return dellBasket;
  }


}// main
