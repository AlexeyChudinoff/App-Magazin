package org.skypro.skyshop.product;

public class Basket {

  private  Product[] productBasket = new Product[5];

  public void addProduct(String nameSimpleProduct, int costSimpleProduct) {
    String answer = "Невозможно добавить продукт";
    for (int i = 0; i < productBasket.length; i++) {
      if (productBasket[i] == null) {
        answer = "Name: " + nameSimpleProduct + ". Cost: " + costSimpleProduct;
        productBasket[i] = new SimpleProduct(nameSimpleProduct, costSimpleProduct);
        break;
      }
    }
    System.out.println("addProduct- " + answer);
  }

  public void addProduct(String nameFixPriceProduct) {
    String answer = "Нет места Невозможно добавить продукт" + nameFixPriceProduct;
    for (int i = 0; i < productBasket.length; i++) {
      if (productBasket[i] == null) {
        answer = "Name: " + nameFixPriceProduct + ". Cost: " + FixPriceProduct.FIX_PRICE_PRODUCT;
        productBasket[i] = new FixPriceProduct(nameFixPriceProduct);
        break;
      }
    }
    System.out.println("addProduct- " + answer);
  }

  public void addProduct(String nameDiscountedProduct, int baseCost,
      int discountBaseCost) {
    String answer = "Невозможно добавить продукт";
    for (int i = 0; i < productBasket.length; i++) {
      if (productBasket[i] == null) {
        answer = "Name: " + nameDiscountedProduct + ". Cos:  " + baseCost +
            " скидка = " + discountBaseCost + "%";
        productBasket[i] = new DiscountedProduct(nameDiscountedProduct, baseCost, discountBaseCost);
        break;
      }
    }
    System.out.println("addProduct- " + answer);
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
    System.out.println("Итого : общая стоимость корзины = " + summ);
    if (summ == 0) {
      System.out.println(" В корзине пусто");
    }
    System.out.println("-------------");
  }

  public void SpecialProduct() {
    int namber = 0;
    System.out.println("Spec tovar : ");
    for (int i = 0; i < productBasket.length; i++) {
      if (productBasket[i] != null && productBasket[i].isSpecial()) {
        namber++;
        System.out.println(productBasket[i]);
      }
    }
    System.out.println(" Всего специальных товаров: " + namber + " шт");
  }

  public static Product[] getProductBasket() {
    return productBasket;
  }
}