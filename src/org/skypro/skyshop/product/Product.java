package org.skypro.skyshop.product;

import org.skypro.skyshop.searchProduct.Searchable;

public abstract class Product implements Searchable {

  private final String nameProduct;

  public Product(String nameProduct) {
    if (nameProduct.isBlank()) {
     throw new IllegalArgumentException(" нет имени продукта");
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
    return "Product- имя продукта : " + nameProduct + " ; стоимость  = "
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

}