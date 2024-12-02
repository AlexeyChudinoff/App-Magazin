package org.skypro.skyshop.product;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class SearchEngine {


 // public String strSearch;
  private final String nameProduct;
  private final String nameArticle;
  private final String textArticle;

  public SearchEngine(String nameProduct, String nameArticle, String textArticle) {
    this.nameProduct = nameProduct;
    this.nameArticle = nameArticle;
    this.textArticle = textArticle;
  }
  public SearchEngine[] searchable = new SearchEngine[0];

  public void GenerateSearchable(int size) {
    System.out.println("GenerateSearchable SearchEngine");
    SearchEngine[] searchable = new SearchEngine[size];
    System.out.println("создан массив searchable[" + size +"]");
    for (int i = 0; i < size; i++) {
      searchable[i] = null;
      System.out.println(searchable[i]);
    }
  }

  public void add (String nameProduct, String nameArticle, String textArticle) {
    System.out.println("  add SearchEngine");
    String answer = "Невозможно добавить продукт";
    for (int i = 0; i < searchable.length; i++) {
      if (searchable[i] == null) {
        answer = "Add " + nameProduct + " " + nameArticle + " " +textArticle;
        searchable[i] = new SearchEngine(nameProduct, nameArticle,textArticle);
        break;
      }
    }
    System.out.println(answer);
    System.out.println("-------------");
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchEngine that = (SearchEngine) o;
    return Objects.deepEquals(searchable, that.searchable) && Objects.equals(
        nameProduct, that.nameProduct) && Objects.equals(nameArticle, that.nameArticle)
        && Objects.equals(textArticle, that.textArticle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(Arrays.hashCode(searchable), nameProduct, nameArticle, textArticle);
  }

  @Override
  public String toString() {
    return "SearchEngine{" +
        "nameArticle='" + nameArticle + '\'' +
        ", searchable=" + Arrays.toString(searchable) +
        ", nameProduct='" + nameProduct + '\'' +
        ", textArticle='" + textArticle + '\'' +
        '}';
  }
/*public SearchEngine[] GenerateSearchable() {
    System.out.println("GenerateSearchable");
    Scanner sc = new Scanner(System.in);
    System.out.println("Введите размер массива"
        + " поиска (Searchable): ");
    int size = sc.nextInt();
    SearchEngine searchable[] = new SearchEngine[size];
    System.out.println("создан массив searchable[]");
    for (int i = 0; i < size; i++) {
      searchable[i] = null;
      System.out.println(searchable[i]);
    }
    return searchable;
  }*/


}//class