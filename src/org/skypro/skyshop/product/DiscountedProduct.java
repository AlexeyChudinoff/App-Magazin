package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

  private int baseCost;
  private int discountBaseCost;//целое число от 0 до 100
  private int costAfterDiscount;

  public DiscountedProduct(String nameProduct, int baseCost, int discountBaseCost)
      throws RuntimeException {
    super(nameProduct);
    if (baseCost <= 0) {
      throw new IllegalArgumentException(
          ANSI_GREEN + "ВНИМАНИЕ !" + ANSI_RESET + " цена продукта с дисконтом меньше нуля");
    }
    if (discountBaseCost < 0) {
      throw new IllegalArgumentException(
          ANSI_GREEN + "ВНИМАНИЕ !" + ANSI_RESET + " размер скидки меньше нуля");
    }
    if (discountBaseCost > 100) {
      throw new IllegalArgumentException(
          ANSI_GREEN + "ВНИМАНИЕ !" + ANSI_RESET + " размер скидки больше ста процентов");
    }
    this.baseCost = baseCost;
    this.discountBaseCost = discountBaseCost;
    costAfterDiscount = (this.baseCost * this.discountBaseCost) / 100;
  }

  public int getBaseCost() {
    return baseCost;
  }

  public int getDdiscountBaseCost() {
    return discountBaseCost;
  }

  @Override
  public int getCostProduct() {
    return costAfterDiscount;
  }

  @Override
  public String toString() {
    return "Disc. продукт= " + getNameProduct() + " = цена без скидки = " + baseCost +
        " , скидка = " + discountBaseCost + "%" +
        " = цена со скидкой = " + costAfterDiscount;
  }

  public boolean isSpecial() {
    return true;
  }

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  //ANSI_GREEN + "ВНИМАНИЕ !" + ANSI_RESET +

}
