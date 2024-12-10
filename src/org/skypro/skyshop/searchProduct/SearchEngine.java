package org.skypro.skyshop.searchProduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.Basket;

public class SearchEngine {

  private final Searchable[] searchList;

  public SearchEngine(int size) {
    searchList = new Searchable[size];
    System.out.println("создан массив searchList[" + size + "]");
  }

  public void addArticle(String nameArticle, String textArticle) {
    // System.out.println("addArticle");
    String answer = "Невозможно добавить: " + nameArticle + textArticle;
    for (int i = 0; i < searchList.length; i++) {
      if (searchList[i] == null) {
        answer = "add: " + nameArticle + " , " + textArticle;
        searchList[i] = new Article(nameArticle, textArticle);
        break;
      }
    }
    System.out.println(answer);
  }

  public void search(String find) {
    System.out.println("search");
    List<Object> findeProduct = new ArrayList<>();
    for (Searchable searchable : searchList) {
      if (searchable.searchTerm().contains(find)) {
        findeProduct.add(searchable.searchTerm());
        System.out.println(searchable.searchTerm());
        if (findeProduct.size() == 5) {
          break;
        }
      }
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

  @Override
  public String toString() {
    return Arrays.toString(searchList);
  }

  public void addBasket() {
    System.out.println("addBasket");
    String answer = "Нет места";
    if (searchList.length >= Basket.getProductBasket().length) {
      for (int i = 0; i < Basket.getProductBasket().length; i++) {
        if (searchList[i] == null) {
          searchList[i] = Basket.getProductBasket()[i];
          answer = "add: " + Basket.getProductBasket()[i];
          System.out.println(answer);
          if (i == Basket.getProductBasket().length) {
            break;
          }

        }
      }
    } else {
      for (int i = 0; i < searchList.length; i++) {
        if (searchList[i] == null) {
          searchList[i] = Basket.getProductBasket()[i];
          answer = "add: " + Basket.getProductBasket()[i];
          System.out.println(answer);
          if (Basket.getProductBasket().length == searchList.length) {
            break;
          }

        }
      }
    }


  }


}//class