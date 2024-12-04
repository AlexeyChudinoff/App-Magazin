package org.skypro.skyshop.product;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchEngine {

  private Searchable[] searchable;
  private int id;

  public void GenerateSearchable(int size) {
    System.out.println("GenerateSearchable SearchEngine");
    searchable = new Searchable[size];
    id = 0;
    System.out.println("создан массив searchable[" + size + "]");
  }

  public void add(Searchable searchTerm) {
    if (id == searchable.length) {
      System.out.println("невозможно добавить " + searchTerm);
      return;
    }
    searchable[id] = searchTerm;
    System.out.println("add :" + searchTerm);
    id++;
  }


  public void search(String find) {
    ArrayList<String> findeProduct = new ArrayList<>();
    for (int i = 0; i < searchable.length; i++) {
      if (searchable[i].searchTerm().contains(find)) {
        findeProduct.add(searchable[i].searchTerm());
            if (findeProduct.size() == 5) {
          break;
        }
      }
    }
    for (int i = 0; i < findeProduct.size(); i++) {
      System.out.println(findeProduct.get(i));
    }

  }


  public void printGetStringRepresentation() {
    System.out.println("printGetStringRepresentation");
    for (Searchable object : searchable) {
      if (object == null) {
        return;
      }
      object.getStringRepresentation();
    }
  }

  public void printSearchEngine() {
    System.out.println("printSearchEngine");
    for (Searchable object : searchable) {
      System.out.println(object);
    }
  }

  @Override
  public String toString() {
    return Arrays.toString(searchable);
  }


}//class