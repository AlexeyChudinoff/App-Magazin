package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

  int costSimpleProduct;

  public SimpleProduct(String nameProduct, int costSimpleProduct) {
    super(nameProduct);
    if (costSimpleProduct <= 0) {
      throw new IllegalArgumentException(" цена меньше нуля");
    }
    this.costSimpleProduct = costSimpleProduct;
  }

  @Override
  public int getCostProduct() {
    return costSimpleProduct;
  }

  @Override
  public String toString() {
    return "Simpl. продукт = " + getNameProduct() +
        " стоимость= " + costSimpleProduct;
  }

  public boolean isSpecial() {
    return false;
  }


}
