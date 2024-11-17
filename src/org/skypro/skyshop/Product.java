package org.skypro.skyshop;

public class Product {

  private String nameProduct;
  private int costProduct;

  public Product(String nameProduct, int costProduct) {
    this.nameProduct = nameProduct;
    this.costProduct = costProduct;
  }

  public String getNameProduct() {
    return nameProduct;
  }

  public int getCostProduct() {
    return costProduct;
  }

  public void setNameProduct(String nameProduct) {
    this.nameProduct = nameProduct;
  }

  public void setCostProduct(int costProduct) {
    this.costProduct = costProduct;
  }

  @Override
  public String toString() {
    return " _Наименование продукта = " + nameProduct + " _Цена продукта = "
        + costProduct;
  }


}
