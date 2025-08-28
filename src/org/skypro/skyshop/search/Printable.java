package org.skypro.skyshop.search;

public interface Printable {
  default String getStringRepresentation() {
    return "Имя объекта: " + ((Searchable) this).searchTerm() +
        " ; тип объекта: " + ((Searchable) this).searchTipContent();
  }

  void print();
}