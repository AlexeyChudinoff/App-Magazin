package org.skypro.skyshop.product;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
    return "Fix._"
        + getNameProduct() + " = цена = " + FIX_PRICE_PRODUCT;
  }

  public boolean isSpecial() {
    return true;
  }

}
