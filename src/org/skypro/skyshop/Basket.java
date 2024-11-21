package org.skypro.skyshop;

import java.util.Random;

public class Basket {

  private Product[] productBasket = new Product[5];
  private final String[] produktName = {" Трико ", " Кофта ",
      " Панамка ", " Майка ", " Галстук ", " Свитер ", " Рубашка ", " Брюки ", " Панамка ",
      " Лифчик 4 размера ", " Тапочки ", " Перчатки ", " Красное Ферари ", " АК-47 ",
      " Солёный шоколад ", " Лапти ", " Шлем богатырский "};
  private final Random random = new Random();

  public void greateBasket() {
    // заполням корзину не полностью, потом добавим с помощью метода
    for (int i = 0; i < productBasket.length - 1; i++) {
      productBasket[i] = new Product((produktName[random.nextInt(0, produktName.length)]),
          (random.nextInt(100, 1000)));
    }
    System.out.println("---------------");
  }

  public void addProduct(String nameProduct, int costProduct) {
    System.out.println("  addProduct");
    String answer = "Невозможно добавить продукт";
    for (int i = 0; i < productBasket.length; i++) {
      if (productBasket[i] == null) {
        answer = "Add " + nameProduct + " " + costProduct;
        productBasket[i] = new Product(nameProduct, costProduct);
        break;
      }
    }
    System.out.println(answer);
    System.out.println("-------------");
  }

  public void printBasket() {
    System.out.println("  printBasket");
    for (int i = 0; i < productBasket.length; i++) {
      System.out.println(productBasket[i]);
    }
    System.out.println("-------------");
  }

  public int summCostBasket() {
    System.out.println("summCostBasket");
    int summ = 0;
    for (int i = 0; i < productBasket.length; i++) {
      if (productBasket[i] == null) {
        continue;
      }
      summ += productBasket[i].getCostProduct();
      //вывод результатов последовательного суммирования(если надо)
      //System.out.println(summ);
    }
    return summ;
  }

  public void printBasketCost() {
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

  public void searchNameProduct(String searchName) {
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

  public void deliteAllBasket() {
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