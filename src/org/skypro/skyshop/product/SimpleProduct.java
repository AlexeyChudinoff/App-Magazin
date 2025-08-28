package org.skypro.skyshop.product;

import org.skypro.skyshop.util.SimpleLogger;
import org.skypro.skyshop.util.ConsoleColors;

public class SimpleProduct extends Product {
  private final int costSimpleProduct;

  public SimpleProduct(String nameProduct, int costSimpleProduct) {
    super(nameProduct);

    if (costSimpleProduct <= 0) {
      String errorMsg = "Цена должна быть больше нуля!";
      SimpleLogger.error(errorMsg);
      throw new IllegalArgumentException(errorMsg);
    }

    this.costSimpleProduct = costSimpleProduct;
    SimpleLogger.debug("Создан простой продукт: " + nameProduct + " за " + costSimpleProduct + " руб.");
  }

  @Override
  public int getCostProduct() {
    return costSimpleProduct;
  }

  @Override
  public boolean isSpecial() {
    return false;
  }

  @Override
  public String toString() {
    return "(Simple) " + super.toString();
  }
}