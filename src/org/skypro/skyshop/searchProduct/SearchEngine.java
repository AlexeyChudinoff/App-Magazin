package org.skypro.skyshop.searchProduct;

import java.util.ArrayList;
import java.util.Arrays;
import org.skypro.skyshop.product.Basket;
import org.skypro.skyshop.product.Product;

public class SearchEngine {

  private Searchable[] searchList;

  public void GenerateSearchable(int size) {
    System.out.println("GenerateSearchable SearchEngine");
    searchList = new Searchable[size];
    System.out.println("создан массив searchable[" + size + "]");
  }

  public void add(Searchable searchTerm) {
    String answer = "Невозможно добавить: " + searchTerm;
    for (int i = 0; i < searchList.length; i++) {
      if (searchList[i] == null) {
        answer = "add: " + searchTerm;
        searchList[i] = searchTerm;
        break;
      }
    }
    System.out.println(answer);
  }

  public void add1(Product getNameProduct) {
    String answer = "Невозможно добавить: " + getNameProduct;
    for (int i = 0; i < searchList.length; i++) {
      if (searchList[i] == null) {
        answer = "add: " + getNameProduct;
        searchList[i] = getNameProduct;
        break;
      }
    }
    System.out.println(answer);
  }

  public void search(String find) {
    System.out.println("search");
    ArrayList<String> findeProduct = new ArrayList<>();
    for (int i = 0; i < searchList.length; i++) {
      if (searchList[i].searchTerm().contains(find)) {
        findeProduct.add(searchList[i].searchTerm());
      }
      if (findeProduct.size() == 5) {
          break;
      }
    }
    for (int i = 0; i < findeProduct.size(); i++) {
      System.out.println(findeProduct.get(i));
    }

  }


  public void printGetStringRepresentation() {
    System.out.println("printGetStringRepresentation");
    for (Searchable object : searchList) {
      if (object == null) {
        return;
      }
      object.getStringRepresentation();
    }
  }

  //для проверки
  public void printSearchEngine() {
    System.out.println("printSearchEngine");
    for (Searchable object : searchList) {
      System.out.println(object/*.searchTerm()*/);
    }
  }

  @Override
  public String toString() {
    return Arrays.toString(searchList);
  }

  Searchable[] copyBasket = new Product[Basket.getProductBasket().length];

  public void setCopyBasket() {
    System.out.println("setCopyBasket");
    for (int i = 0; i < copyBasket.length; i++) {
      copyBasket[i] = Basket.getProductBasket()[i];
    }
    for (Searchable object : copyBasket) {
      System.out.println(object);
    }
  }

  //                       copyBasket
  public void addBasket(Product getNameProduct) {
    String answer = "Невозможно добавить: " + getNameProduct;
    for (int i = 0; i < searchList.length; i++) {
      if (searchList[i] == null) {
        answer = "add: " + getNameProduct;
        searchList[i] = getNameProduct;
      }
    }
    System.out.println(answer);
    for (Searchable object : searchList) {
      System.out.println(object);
    }
  }


}//class