package org.skypro.skyshop.product;

import java.util.Arrays;

public class SearchEngine {


  /*public String poleSearch;
  public void poleSearch (String poleSearch) {
    this.poleSearch = poleSearch;
  }*/

 public  SearchEngine[] searchable;

  public void GenerateSearchable(int size) {
    System.out.println("GenerateSearchable SearchEngine");
    searchable = new SearchEngine[size];
    System.out.println("создан массив searchable[" + size + "]");
  }

  public void add(String nameProduct) {
    String answer = "Нет места Невозможно добавить продукт " + nameProduct;
    for (int i = 0; i < searchable.length; i++) {
      if (searchable[i] == null) {
        answer = "add :  " + nameProduct ;
        searchable[i] = new SearchEngine();
        break;
      }
    }
    System.out.println(answer);
  }

  public void add(String nameArticle, String textArticle) {
    String answer = "Нет места Невозможно добавить продукт " + nameArticle;
    for (int i = 0; i < searchable.length; i++) {
      if (searchable[i] == null) {
        answer = "add :  " + nameArticle +  textArticle;
        searchable[i] = new SearchEngine();
        break;
      }
    }
    System.out.println(answer);
  }


  public void search(String strSearch) {
    System.out.println("'search SearchEngine'");
    SearchEngine[] searchArray = new SearchEngine[5];
    for (int i = 0; i < searchArray.length; i++) {
      if (searchable[i].equals(strSearch)) {
        searchArray[i] = searchable[i];
      } else {
        System.out.println("Совпадений не найдено");
      }
    }
  }

  public void printSearchEngine() {
    System.out.println("printSearchEngine");
    for (SearchEngine object : searchable) {
      System.out.println(object);
    }
  }

  @Override
  public String toString() {
    return "SearchEngine{" +
        "searchable=" + Arrays.toString(searchable) +
        '}';
  }


}//class