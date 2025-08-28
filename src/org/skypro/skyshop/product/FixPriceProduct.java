package org.skypro.skyshop.product;

import org.skypro.skyshop.util.SimpleLogger;

public class FixPriceProduct extends Product {
  static final int FIX_PRICE_PRODUCT = 500;

  public FixPriceProduct(String nameProduct) {
    super(nameProduct);
    SimpleLogger.debug("Создан фиксированный продукт: " + nameProduct);
  }

  @Override
  public int getCostProduct() {
    return FIX_PRICE_PRODUCT;
  }

  @Override
  public boolean isSpecial() {
    return true;
  }

  @Override
  public String toString() {
    return "(FixPrice) " + getNameProduct() + " - цена: " + FIX_PRICE_PRODUCT + " руб.";
  }
}