package org.skypro.skyshop.product;

import java.util.List;
import org.skypro.skyshop.searchProduct.Searchable;

public abstract class Product implements Searchable, List<Product> {

  private final String nameProduct;

  public Product(String nameProduct) throws IllegalArgumentException {
    if (nameProduct.isBlank()) {
      throw new IllegalArgumentException(
          ANSI_GREEN + "ВНИМАНИЕ ! Нет имени продукта !" + ANSI_RESET);
    }
    this.nameProduct = nameProduct;
  }

  public abstract boolean isSpecial();

  public abstract int getCostProduct();

  public String getNameProduct() {
    return nameProduct;
  }

  @Override
  public String toString() {
    return "Product- имя продукта : " + nameProduct + " ;  = цена =  "
        + getCostProduct();
  }

  @Override
  public String searchTerm() {
    return nameProduct;
  }

  @Override
  public String searchTipContent() {
    return "PRODUCT";
  }


  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  //ANSI_GREEN + "ВНИМАНИЕ !" + ANSI_RESET +

}