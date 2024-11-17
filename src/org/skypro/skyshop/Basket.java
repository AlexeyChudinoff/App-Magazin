package org.skypro.skyshop;

import java.util.Arrays;

public class Basket {

  private static final Product[] productBasket = new Product[5];

  public static void greateBasket() {
    System.out.println("Vvod rukami");
    for (int i = 0; i < productBasket.length; i++) {
      productBasket[0] = new Product("Rubashka", 700);
      productBasket[1] = new Product("Shtani", 900);
      productBasket[2] = new Product("Trusi", 400);

      System.out.println(productBasket[i]);
    }
    System.out.println("---------------");
  }

  public static void addProduct(String nameProduct, int costProduct) {
    System.out.println("  addProduct");
    String answer = "Невозможно добавить продукт";
  for (int i = 0; i < productBasket.length; i++) {
        if (productBasket[i] == null) {
        answer = "Add " + nameProduct + " " + costProduct;
        productBasket[i] = new Product(nameProduct, costProduct);
               break;
      }
    } System.out.println(answer);
        System.out.println("-------------");
  }

  public static void printBasket() {
    System.out.println("  printBasket");
    for (int i = 0; i < productBasket.length; i++) {
      System.out.println(productBasket[i]);
    }
    System.out.println("-------------");
  }

  public static int summCostBasket() {
    System.out.println("summCostBasket");
    int summ = 0;
    for (int i = 0; i < productBasket.length; i++) {
      if (productBasket[i] == null) {
        continue;
      }
      summ += productBasket[i].getCostProduct();
      //System.out.println(summ); последовательное суммирование
    }
    return summ;
  }

  public static void printBasketCost() {
    System.out.println("printBasketCost");
    int summ = 0;
    for (int j = 0; j < productBasket.length; j++) {
      if (productBasket[j] == null) {
        continue;
      }
      summ += productBasket[j].getCostProduct();
      System.out.println(productBasket[j]);
    }
    System.out.println("Итого : общая стоимость корзины " + summ);
    if (summ == 0) {
      System.out.println(" В корзине пусто");
    }
    System.out.println("-------------");
  }

  public static void searchNameProduct(String searchName) {
    System.out.println("searchNameProduct");
    for (int i = 0; i < productBasket.length; i++) {
      if (productBasket[i] == null) {
        continue;
      }
      if ((productBasket[i].getNameProduct()).equals(searchName)) {
        System.out.println("true");
      } else {
        System.out.println("false");
      }
    }
    System.out.println("------------");
  }

  public static void deliteAllBasket() {
    System.out.println("deliteAllBasket");
    for (int i = 0; i < productBasket.length; i++) {
      if (productBasket[i] == null) {
        continue;
      }
      if (productBasket[i] != null) {
        productBasket[i] = null;
      }
    }
    System.out.println("------------");
  }

}