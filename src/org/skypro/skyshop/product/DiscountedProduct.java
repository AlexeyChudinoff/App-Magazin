package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

  private int baseCost;
  private int discountBaseCost;//целое число от 0 до 100
  private int costAfterDiscount;

  public DiscountedProduct(String nameProduct, int baseCost, int discountBaseCost) {
    super(nameProduct);
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
    return "имя продукта со скидкой = " + getNameProduct() + " = цена без скидки = " + baseCost +
        " , скидка = " + discountBaseCost + "%" +
        " = цена со скидкой = " + costAfterDiscount;
  }

  @Override
  public String searchTerm() {
    return "";
  }

  public boolean isSpecial() {
    return true;
  }

}
