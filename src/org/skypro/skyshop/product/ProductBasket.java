package org.skypro.skyshop.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class ProductBasket {

  private final List<Product> productBasket = new ArrayList<>();

  public void addProduct(Product product) {
    productBasket.add(product);
    System.out.println("Add: " + product);
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
