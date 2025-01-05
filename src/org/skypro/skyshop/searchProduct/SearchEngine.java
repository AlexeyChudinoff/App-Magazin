package org.skypro.skyshop.searchProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.skypro.skyshop.Exeption.BestResultNotFound;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.ProductBasket;
import org.skypro.skyshop.product.Product;

public class SearchEngine {

  private final Map<String, Searchable> searchList = new TreeMap<>();

  public void addBasketInSearchList(ProductBasket basket) {
    System.out.println("addBasketInSearchList");
    Map<String, Product> copiedList = basket.getProductBasket();
    searchList.putAll(copiedList);
    System.out.println(searchList);
  }

  public void sizeBasket() {
    System.out.println("SizeBasket: " + searchList.size());
  }

  public void generateArticle(String nameArticle, String textArticle) {
    Article article = new Article(nameArticle, textArticle);
    searchList.put(nameArticle, article);
    System.out.println("add: " + nameArticle + "'" + article);
  }

  public Map<String, Searchable> searchProduct(String findName) {
    System.out.println("searchProduct");
    Map<String, Searchable> findProduct = new TreeMap<>();
    for (Map.Entry<String, Searchable> product : searchList.entrySet()) {
      if (product == null) {
        break;
      }
      if (searchList.containsKey(findName)) {
        findProduct.put(findName, searchList.get(findName));
      }
    }
    System.out.println("findProduct = " + findProduct);
    return findProduct;
  }

  public void printGetStringRepresentation() {
    System.out.println("printGetStringRepresentation");
    for (Map.Entry<String, Searchable> product : searchList.entrySet()) {
      if (product == null) {
        System.out.println("Нет объектов для поиска ");
        break;
      }
      product.getValue().getStringRepresentation();
    }
  }

  public Map<String, Searchable> searchForMostSuitable(String substring) {
    System.out.println("searchForMostSuitable");
    Map<String, Searchable> MostSuitableProduct = new TreeMap<>();
    for (Map.Entry<String, Searchable> object : searchList.entrySet()) {
      if (object == null) {
        System.out.println(ANSI_BLUE + "Дальше нет объектов для поиска, список пуст " + ANSI_RESET);
        break;
      }
      int i = 0;
      int idxVhod = object.getValue().searchTerm().indexOf(substring, i);
      if (idxVhod < 0) {
        try {
          throw new BestResultNotFound(
              "Не найдено :" + substring + " в " + object.getValue().searchTerm());
        } catch (BestResultNotFound e) {
          System.out.println(e.getMessage());
        }
      }
      int count = 0;
      while (idxVhod >= 0) {
        count++;
        MostSuitableProduct.put(object.getKey(), object.getValue());
        i = idxVhod + substring.length();
        idxVhod = object.getValue().searchTerm().indexOf(substring, i);
      }
      if (count > 0) {
        System.out.println(
            "в объекте: " + object.getValue().searchTerm() + " =  Нашлось " + count + " раз(а)");
      }
    }
    System.out.println(MostSuitableProduct);
    return MostSuitableProduct;
  }

  public void printSerchList() {
    System.out.println("printSerchList");
    for (Map.Entry<String, Searchable> object : searchList.entrySet()) {
      System.out.println(object);
    }
  }

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  //ANSI_GREEN + "ВНИМАНИЕ !" + ANSI_RESET +

}//class