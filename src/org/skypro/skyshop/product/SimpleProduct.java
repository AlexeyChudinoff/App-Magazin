package org.skypro.skyshop.product;

import java.util.Collection;
import java.util.Iterator;
import org.skypro.skyshop.searchProduct.Searchable;

public class SimpleProduct extends Product {

  int costSimpleProduct;

  public SimpleProduct(String nameProduct, int costSimpleProduct)
      throws IllegalArgumentException {
    super(nameProduct);

    if (costSimpleProduct <= 0) {
      throw new IllegalArgumentException(
          ANSI_GREEN + "ВНИМАНИЕ ! Цена меньше нуля !" + ANSI_RESET);
    }
    this.costSimpleProduct = costSimpleProduct;
  }

  @Override
  public int getCostProduct() {
    return costSimpleProduct;
  }

  @Override
  public String toString() {
    return "Simpl._" + getNameProduct() +
        "  = цена =  " + costSimpleProduct;
  }

  public boolean isSpecial() {
    return false;
  }

  @Override
  public String searchTerm() {
    return super.searchTerm();
  }

  @Override
  public String searchTipContent() {
    return super.searchTipContent();
  }

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";

  //ANSI_GREEN + "ВНИМАНИЕ !" + ANSI_RESET +


}