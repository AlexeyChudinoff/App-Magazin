package org.skypro.skyshop.product;

public interface Searchable {

  String searchTerm();
  String searchTipContent();

   default  void getStringRepresentation() {
    System.out.println("getStringRepresentation");

    System.out.println("Имя объекта: " + searchTerm() + " ;  " +
        " тип объекта: " + searchTipContent());
  }



}


