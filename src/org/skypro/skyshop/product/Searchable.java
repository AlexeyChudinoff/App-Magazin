package org.skypro.skyshop.product;

public interface Searchable {

  String SearchTerm();
  String getTipContent();

  //String SearchAble();

  default  void getStringRepresentation() {
    System.out.println("getStringRepresentation");
    System.out.println("Имя объекта: " + SearchTerm() + "-" +
        " тип объекта: " + getTipContent());
  }



}


