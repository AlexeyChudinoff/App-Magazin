package org.skypro.skyshop.searchProduct;

public interface Searchable {

  String searchTerm();

  String searchTipContent();

  // вместо toString
  default void getStringRepresentation() {
    System.out.println("Имя объекта: " + searchTerm() + " ;  " +
        " тип объекта: " + searchTipContent());
  }
}


