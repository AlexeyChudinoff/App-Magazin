package org.skypro.skyshop.searchProduct;

import java.util.ArrayList;
import java.util.List;
import org.skypro.skyshop.product.Product;

public class ProductList implements Searchable {

  private final List<Product> products;

  public ProductList(List<Product> products) {
    this.products = products;
  }

  @Override
  public String toString() {
    return products != null ? products.toString() : "null";
  }

  public List<Product> getProducts() {
    return products;
  }

//разобраться ещё раз
  @Override
  public String searchTerm() {
    StringBuilder searchTerm = new StringBuilder();
    for (Product product : products) {
      if (product != null) {
        searchTerm.append(product.searchTerm()).append(", ");
      }
    }
    return searchTerm.length() > 0 ? searchTerm.substring(0, searchTerm.length() - 2) : "";
  }

  @Override
  public String searchTipContent() {
    return "PRODUCT";
  }
}