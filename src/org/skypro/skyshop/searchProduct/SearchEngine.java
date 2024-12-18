package org.skypro.skyshop.searchProduct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.skypro.skyshop.Exeption.BestResultNotFound;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.Basket;
import org.skypro.skyshop.product.Product;

public class SearchEngine {

  List<Searchable> searchList;

  public SearchEngine(int size) {
    searchList = new ArrayList<>(size);
    System.out.println("создан массив searchList [" + size + "]");
  }

  public void addBasketInSearchList(Basket basket) {
    System.out.println("addBasketInSearchList");
    List<Product> copiedList = basket.getProductBasket();
    for (Product product : copiedList) {
      searchList.add(product);
    }
    for (Object product : copiedList) {
      System.out.println(product);
    }
  }

  public void SizeBasket() {
    System.out.println("SizeBasket: " + searchList.size());
  }

  public void addArticle(String nameArticle, String textArticle) {
    searchList.add(new Article(nameArticle, textArticle));
    System.out.println("Add: " + nameArticle + "'" + textArticle);
  }

  public void searchProduct(String find) {
    System.out.println("search");
    List<Object> findeProduct = new ArrayList<>();
    for (Searchable searchable : searchList) {
      if (searchable == null) {
        return;
      }
      if (searchable.searchTerm().contains(find)) {
        findeProduct.add(searchable.searchTerm());
      }
    }
    for (Object product : findeProduct) {
      System.out.println(product);
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

  public void searchForMostSuitable(String substring) {
    System.out.println("searchForMostSuitable");
    for (Searchable object : searchList) {
      if (object == null) {
        System.out.println(ANSI_BLUE + "Дальше нет объектов для поиска, список пуст " + ANSI_RESET);
        return;
      }
      int i = 0;
      int idxVhod = object.searchTerm().indexOf(substring, i);
      if (idxVhod < 0) {
        try {
          throw new BestResultNotFound("Не найдено :" + substring);
        } catch (BestResultNotFound e) {
          System.out.println(e.getMessage());
        }
      }
      int count = 0;
      while (idxVhod >= 0) {
        count++;
        i = idxVhod + substring.length();
        idxVhod = object.searchTerm().indexOf(substring, i);
      }
      if (count > 0) {
        System.out.println(
            "в объекте: " + object.searchTerm() + " =  Нашлось " + count + " раз(а)");
      }
    }
  }

  public void printSerchList() {
    System.out.println("printSerchList");
    for (Searchable product : searchList) {
      System.out.println(product);
    }
  }

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  //ANSI_GREEN + "ВНИМАНИЕ !" + ANSI_RESET +

}//class

