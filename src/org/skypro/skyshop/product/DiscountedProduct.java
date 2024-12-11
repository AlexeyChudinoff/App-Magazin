package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

  private int baseCost;
  private int discountBaseCost;//целое число от 0 до 100
  private int costAfterDiscount;

  public DiscountedProduct(String nameProduct, int baseCost, int discountBaseCost)
      throws RuntimeException {
    super(nameProduct);
    if (baseCost <= 0) {
      throw new IllegalArgumentException("цена продукта с дисконтом меньше нуля");
    }
    if (discountBaseCost < 0) {
      throw new IllegalArgumentException(" размер скидки меньше нуля");
    }
    if (discountBaseCost > 100) {
      throw new IllegalArgumentException(" размер скидки больше ста процентов");
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

}
