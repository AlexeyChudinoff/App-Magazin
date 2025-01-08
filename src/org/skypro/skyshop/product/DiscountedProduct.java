package org.skypro.skyshop.product;

import java.util.Collection;
import java.util.Iterator;
import org.skypro.skyshop.searchProduct.Searchable;

public class DiscountedProduct extends Product {

  private final int baseCost;
  private final int discountBaseCost;//целое число от 0 до 100
  private final int costAfterDiscount;

  public DiscountedProduct(String nameProduct, int baseCost, int discountBaseCost)
      throws RuntimeException {
    super(nameProduct);
    if (baseCost <= 0) {
      throw new IllegalArgumentException(
          ANSI_GREEN + "ВНИМАНИЕ ! Цена продукта меньше нуля !" + ANSI_RESET);
    }
    if (discountBaseCost < 0) {
      throw new IllegalArgumentException(
          ANSI_GREEN + "ВНИМАНИЕ ! Размер скидки меньше нуля !" + ANSI_RESET);
    }
    if (discountBaseCost > 100) {
      throw new IllegalArgumentException(
          ANSI_GREEN + "ВНИМАНИЕ ! Размер скидки больше ста процентов !" + ANSI_RESET);
    }
    this.baseCost = baseCost;
    this.discountBaseCost = discountBaseCost;
    costAfterDiscount = (this.baseCost * this.discountBaseCost) / 100;
  }

  public int getBaseCost() {
    return baseCost;
  }

  public int getDiscountBaseCost() {
    return discountBaseCost;
  }

  @Override
  public int getCostProduct() {
    return costAfterDiscount;
  }

  @Override
  public String toString() {
    return "Disc._" + getNameProduct() + " = цена без скидки = " + baseCost +
        " , скидка = " + discountBaseCost + "%" +
        " = цена со скидкой = " + costAfterDiscount;
  }

  @Override
  public String searchTerm() {
    return super.searchTerm();
  }

  @Override
  public String searchTipContent() {
    return super.searchTipContent();
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
