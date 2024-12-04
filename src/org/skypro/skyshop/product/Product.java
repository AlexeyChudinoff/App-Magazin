package org.skypro.skyshop.product;

public abstract class Product implements Searchable {

  private final String nameProduct;

  public Product(String nameProduct) {
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

  @Override
  public void getStringRepresentation() {
    Searchable.super.getStringRepresentation();
  }
}