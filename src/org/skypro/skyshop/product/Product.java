package org.skypro.skyshop.product;

public abstract class Product implements Searchable {

  private String nameProduct;

  public Product(String nameProduct) {
    this.nameProduct = nameProduct;
     }

  public abstract boolean isSpecial();

  public abstract int getCostProduct();

  public String getNameProduct() {
    return nameProduct;
  }

  public void setNameProduct(String nameProduct) {
    this.nameProduct = nameProduct;
  }

  @Override
  public String toString() {
    return " имя продукта : " + nameProduct + " ; стоимость  = "
        + getCostProduct();
  }

  @Override
  public String SearchTerm(){
    return nameProduct;
  }

  @Override
  public  String getTipContent(){
    return "PRODUCT";
  }



}

