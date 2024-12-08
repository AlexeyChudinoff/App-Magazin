package org.skypro.skyshop.searchProduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.Basket;
import org.skypro.skyshop.product.Product;

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
        answer = "add: " + nameArticle + textArticle;
        searchList[i] = new Article(nameArticle, textArticle);
        break;
      }
    }
    System.out.println(answer);
  }
 /* public void add(Product getNameProduct) {
    String answer = "Невозможно добавить: " + getNameProduct;
    for (int i = 0; i < searchList.length; i++) {
      if (searchList[i] == null) {
        answer = "add: " + getNameProduct;
        searchList[i] = getNameProduct;
        break;
      }
    }
    System.out.println(answer);
  }*/

  public void search(String find) {
    System.out.println("search");
    List findeProduct = new ArrayList<>();
    for (int i = 0; i < searchList.length; i++) {
      if (searchList[i].searchTerm().contains(find)) {
        findeProduct.add(searchList[i].searchTerm());
        System.out.println(searchList[i].searchTerm());
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

  Searchable[] copyBasket = new Searchable[Basket.getProductBasket().length];

  public void setCopyBasket() {
    System.out.println("setCopyBasket");
    for (int i = 0; i < copyBasket.length; i++) {
      copyBasket[i] = Basket.getProductBasket()[i];
    }
    for (Searchable object : copyBasket) {
      System.out.println(object);
    }
  }
  /*public void addBasket() {
    System.out.println("addBasket");
    String answer = "Нет места";
    for (int i = 0; i < searchList.length; i++) {
      if (searchList[i] == null || i < copyBasket.length) {
          searchList[i] = copyBasket[i].searchTerm();
          answer = "add: " + copyBasket[i].searchTerm();
          break; // Выходим из цикла после успешного добавления
        } else {
        }
      }
      System.out.println(answer);

      for (Searchable object : searchList) {
        System.out.println(object);
      }
    }*/
  /*
  public void addBasket() {
    System.out.println("addBasket");
    String answer = "Нет места";
    for (int i = 0; i < copyBasket.length; i++) {
      if (searchList[i] == null) {
        answer = "add: " + copyBasket[i].searchTerm();
        searchList[i] = copyBasket[i];
      }
      System.out.println(answer);
      for (Searchable object : searchList) {
        System.out.println(object);
      }
    }
  }*/


}//class