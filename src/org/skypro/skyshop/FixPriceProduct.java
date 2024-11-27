package org.skypro.skyshop;

public class FixPriceProduct extends Product {

  static final int FIX_PRICE_PRODUCT = 500;

  public FixPriceProduct(String nameProduct) {
    super(nameProduct);
  }

  public int getCostProduct() {
    return FIX_PRICE_PRODUCT;
  }

  @Override
  public String toString() {
    return "имя продукта c фиксированной ценой = "
        + getNameProduct() + " =  Фиксированная цена = " + FIX_PRICE_PRODUCT;
  }

  public boolean isSpecial() {
    return true;
  }

}
