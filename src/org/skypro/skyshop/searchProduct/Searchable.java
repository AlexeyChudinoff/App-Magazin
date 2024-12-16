package org.skypro.skyshop.searchProduct;

import java.util.ArrayList;
import java.util.List;
import org.skypro.skyshop.product.Basket;
import org.skypro.skyshop.product.Product;

public interface Searchable {

  String searchTerm();

  String searchTipContent();

  // вместо toString
  default void getStringRepresentation() {
    System.out.println("Имя объекта: " + searchTerm() + " ;  " +
        " тип объекта: " + searchTipContent());
  }
}


