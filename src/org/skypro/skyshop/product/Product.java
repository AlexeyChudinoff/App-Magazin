package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.search.Printable;
import org.skypro.skyshop.util.SimpleLogger;
import org.skypro.skyshop.util.ConsoleColors;

import java.util.Objects;

public abstract class Product implements Searchable, Printable, Comparable<Product> {
  private final String nameProduct;

  protected Product(String nameProduct) {
    if (nameProduct == null || nameProduct.isBlank()) {
      String errorMsg = "Нет имени продукта!";
      SimpleLogger.error(errorMsg);
      throw new IllegalArgumentException(errorMsg);
    }
    this.nameProduct = nameProduct;
    SimpleLogger.debug("Создан продукт: " + nameProduct);
  }

  public abstract boolean isSpecial();
  public abstract int getCostProduct();

  public String getNameProduct() {
    return nameProduct;
  }

  @Override
  public String toString() {
    return nameProduct + " - цена: " + getCostProduct() + " руб.";
  }

  @Override
  public String searchTerm() {
    return nameProduct;
  }

  @Override
  public String searchTipContent() {
    return "PRODUCT";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return Objects.equals(nameProduct, product.nameProduct);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(nameProduct);
  }

  @Override
  public int compareTo(Product other) {
    if (other == null) {
      throw new IllegalArgumentException("Объект для сравнения не может быть null!");
    }
    return this.nameProduct.compareTo(other.nameProduct);
  }

  @Override
  public void print() {
    SimpleLogger.info(toString());
  }
}