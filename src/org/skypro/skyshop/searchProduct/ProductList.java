package org.skypro.skyshop.searchProduct;

import java.util.List;
import org.skypro.skyshop.product.Product;

public class ProductList implements Searchable {

  private final List<Product> products;

  public ProductList(List<Product> products) {
    this.products = products;
  }

  @Override
  public String toString() {
    return "ProductList{" +
        "products=" + products +
        '}';
  }

  public List<Product> getProducts() {
    return products;
  }

  @Override
  public String searchTerm() {
    return "";
  }

  @Override
  public String searchTipContent() {
    return "";
  }
}
