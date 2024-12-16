package org.skypro.skyshop.product;

import java.util.ArrayList;
import java.util.Arrays;

public class Basket {

  //private final Product[] productBasket = new Product[5];
  private final ArrayList<Product> productBasket = new ArrayList<>();

  public void addProduct(String nameSimpleProduct, int costSimpleProduct) {
    Product product = null;
    try {
      product = new SimpleProduct(nameSimpleProduct, costSimpleProduct);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage()+", Не удалось добавить: "+nameSimpleProduct);
    }

    if (product != null) {
      productBasket.add(product);
      System.out.println("Add: " + product);
    }
  }

  public void addProduct(String nameFixPriceProduct) throws IllegalArgumentException {
    Product product = null;
    try {
      product = new FixPriceProduct(nameFixPriceProduct);
    } catch (Exception e) {
      System.out.println(e.getMessage() + ", Не удалось добавить: " +nameFixPriceProduct);
    }
    if (product != null) {
      productBasket.add(product);
      System.out.println("Add: " + product);
    }
  }

  public void addProduct(String nameDiscountedProduct, int baseCost,
      int discountBaseCost) throws IllegalArgumentException {
 Product product = null ;
    try {
     product = new DiscountedProduct(nameDiscountedProduct, baseCost, discountBaseCost);
    } catch (RuntimeException e) {
      System.out.println(e.getMessage() + ", Не удалось добавить: " + nameDiscountedProduct);
    }
    if (product != null) {
      productBasket.add(product);
      System.out.println("Add: " + product);
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
          summ +=  product.getCostProduct();
        }
      }
      System.out.println("________________________");
      System.out.println("Сумма корзины: " + summ);
    }
  }

  public void SpecialProduct() {
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

    if (productBasket.isEmpty()) {
      System.out.println("Корзина пуста");
    } else {
      System.out.println("Состав корзины:");
      for (Product product : productBasket) {
        System.out.println(product);
      }
    }
  }

  public ArrayList getProductBasket() {
    ArrayList <Product> arrayBasket = new ArrayList<>();{
    for (Product product : productBasket) {
      arrayBasket = new ArrayList<Product>(productBasket);
      System.out.println(product.getNameProduct());
    }//product.getNameProduct()
    //System.out.println(Arrays.toString(new ArrayList[]{arrayBasket}));
    }
    return arrayBasket;
  }


//    for (int i = 0; i < productBasket.size(); i++) {
//      productLinkedList = productBasket;
//      System.out.println(productLinkedList.get(i));
//    }


    //  public Object getProductBasket() {
//    Iterable<Object> list = null;
//    // Получение итератора
//    Iterator<Object> iterator = list.iterator();
//
//    // Перебор элементов с использованием итератора
//    while (iterator.hasNext()) {
//      Object element = iterator.next();
//      System.out.println(element);
//      System.out.println(productBasket.iterator());
//    }return "";
//  }



  }// main
