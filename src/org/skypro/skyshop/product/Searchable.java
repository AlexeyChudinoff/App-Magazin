package org.skypro.skyshop.product;

public interface Searchable {

  String searchTerm();

  String searchTipContent();
  // String searchAble();

  // вместо toString
  default void getStringRepresentation() {
    System.out.println("Имя объекта: " + searchTerm() + " ;  " +
        " тип объекта: " + searchTipContent());
  }


}


