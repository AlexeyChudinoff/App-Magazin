package org.skypro.skyshop.searchProduct;

import java.util.ArrayList;
import java.util.List;
import org.skypro.skyshop.Exeption.BestResultNotFound;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.ProductBasket;
import org.skypro.skyshop.product.Product;

public class SearchEngine {

  List<Searchable> searchList;

  public SearchEngine(int size) {
    searchList = new ArrayList<>(size);
    System.out.println("создан массив searchList [" + size + "]");
  }

  public void addBasketInSearchList(ProductBasket basket) {
    System.out.println("addBasketInSearchList");
    List<Product> copiedList = basket.getProductBasket();
    for (Product product : copiedList) {
      searchList.add(product);
    }
    for (Object product : copiedList) {
      System.out.println(product);
    }
  }

  public void sizeBasket() {
    System.out.println("SizeBasket: " + searchList.size());
  }

  public void generateArticle(String nameArticle, String textArticle) {
    Article article = new Article(nameArticle, textArticle);
    searchList.add(article);
    System.out.println("add: " + nameArticle + "'" + textArticle);
  }

  public List<Searchable> searchProduct(String find) {
    System.out.println("searchProduct");
    List<Searchable> findeProduct = new ArrayList<>();
    for (Searchable product : searchList) {
      if (product == null) {
        break;
      }
      if (product.searchTerm().contains(find)) {
        findeProduct.add(product);
      }
    }
    for (Object product : findeProduct) {
      System.out.println(product);
    }
    return findeProduct;
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

  public List<Searchable> searchForMostSuitable(String substring) {
    System.out.println("searchForMostSuitable");
    List<Searchable> listMostSuitable = new ArrayList<>();
    for (Searchable object : searchList) {
      if (object == null) {
        System.out.println(ANSI_BLUE + "Дальше нет объектов для поиска, список пуст " + ANSI_RESET);
        break;
      }
      int i = 0;
      int idxVhod = object.searchTerm().indexOf(substring, i);
      if (idxVhod < 0) {
        try {
          throw new BestResultNotFound("Не найдено :" + substring + " в " + object.searchTerm());
        } catch (BestResultNotFound e) {
          System.out.println(e.getMessage());
        }
      }
      int count = 0;
      while (idxVhod >= 0) {
        count++;
        listMostSuitable.add(object);
        i = idxVhod + substring.length();
        idxVhod = object.searchTerm().indexOf(substring, i);
      }
      if (count > 0) {
        System.out.println(
            "в объекте: " + object.searchTerm() + " =  Нашлось " + count + " раз(а)");
      }
    }
    System.out.println(listMostSuitable);
    return listMostSuitable;
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

