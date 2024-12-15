package org.skypro.skyshop.product;

public class SimpleProduct extends Product {

  int costSimpleProduct;

  public SimpleProduct(String nameProduct, int costSimpleProduct)
      throws IllegalArgumentException {
    super(nameProduct);

    if (costSimpleProduct <= 0) {
      throw new IllegalArgumentException(ANSI_GREEN + "ВНИМАНИЕ !" + ANSI_RESET
          + " цена SimpleProduct  не может быть меньше нуля");
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

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  //ANSI_GREEN + "ВНИМАНИЕ !" + ANSI_RESET +
}
