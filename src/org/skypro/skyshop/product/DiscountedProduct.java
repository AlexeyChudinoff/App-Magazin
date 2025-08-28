package org.skypro.skyshop.product;

import org.skypro.skyshop.util.SimpleLogger;
import org.skypro.skyshop.util.ConsoleColors;

public class DiscountedProduct extends Product {
  private final int baseCost;
  private final int discountPercent;
  private final int costAfterDiscount;

  public DiscountedProduct(String nameProduct, int baseCost, int discountPercent) {
    super(nameProduct);

    if (baseCost <= 0) {
      String errorMsg = "Базовая цена должна быть больше нуля!";
      SimpleLogger.error(errorMsg);
      throw new IllegalArgumentException(errorMsg);
    }

    if (discountPercent < 0 || discountPercent > 100) {
      String errorMsg = "Скидка должна быть от 0 до 100%!";
      SimpleLogger.error(errorMsg);
      throw new IllegalArgumentException(errorMsg);
    }

    this.baseCost = baseCost;
    this.discountPercent = discountPercent;
    this.costAfterDiscount = baseCost - (baseCost * discountPercent / 100);

    SimpleLogger.debug("Создан продукт со скидкой: " + nameProduct +
        " - базовая цена: " + baseCost +
        ", скидка: " + discountPercent + "%");
  }

  @Override
  public int getCostProduct() {
    return costAfterDiscount;
  }

  @Override
  public boolean isSpecial() {
    return true;
  }

  @Override
  public String toString() {
    return "(Discounted) " + getNameProduct() +
        " - базовая цена: " + baseCost + " руб." +
        ", скидка: " + discountPercent + "%" +
        ", итого: " + costAfterDiscount + " руб.";
  }
}