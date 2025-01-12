package org.skypro.skyshop.searchProduct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import org.skypro.skyshop.Exeption.BestResultNotFound;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.ProductBasket;
import org.skypro.skyshop.product.Product;

public class SearchEngine {

  private final Set<List<Searchable>> searchList = new HashSet<>();

  public void addBasketInSearchList(ProductBasket basket) {
    System.out.println("addBasketInSearchList");
    Map<String, List<Product>> copiedList = basket.getProductBasket();
    if (copiedList == null) {
      throw new IllegalArgumentException("Basket cannot be null");
    }
    Set<Searchable> setSeachable = new HashSet<>();

    for (List<Product> products : copiedList.values()) {
      if (products != null) {
        for (Product product : products) {
          if (product != null) {
            setSeachable.add(product);
          }
        }
      }
    }
    for (Searchable product : setSeachable) {
      List<Searchable> prodList = new ArrayList<>();
      prodList.add(product);
      searchList.add(prodList);
    }
    System.out.println(searchList);
    System.out.println(searchList.size());
  }

  public void addArticle(Article article) {
    List<Searchable> articles = new ArrayList<>();
    articles.add(article);
    searchList.add(articles);

    System.out.println("Add  article: " + article);
    //System.out.println("Current List: " + searchList);
  }

  public void printGetStringRepresentation() {
    System.out.println("printGetStringRepresentation");
    for (List<Searchable> products : searchList) {
      if (products == null) {
        System.out.println(ANSI_GREEN + "ВНИМАНИЕ ! List is null" + ANSI_RESET);
        continue;
      }
      for (Searchable product : products) {
        if (product == null) {
          System.out.println(ANSI_GREEN + "ВНИМАНИЕ ! product is null" + ANSI_RESET);
          continue;
        }
        product.getStringRepresentation();
      }
    }
  }


  public Set<Searchable> searchProduct(String findName) {
    System.out.println("searchProduct");
    Set<Searchable> searchProductList = new HashSet<>(); // Используем HashSet вместо TreeSet, чтобы избежать необходимости в Comparable
    if (findName == null || searchList == null) {
      System.out.println("findName or searchList is null");
      return searchProductList;
    }

    boolean productFound = false;
    for (List<Searchable> products : searchList) {
      for (Searchable product : products) {
        if (product != null && findName.equals(product.searchTerm())) {
          searchProductList.add(product);
          productFound = true;
        }
      }
    }
    if (!productFound) {
      System.out.println("Не найден продукт: " + findName);
    } else {
      System.out.println("Найдены продукты: " + searchProductList);
    }
    Set<Searchable> searchProductTreeSet = new TreeSet<>(searchProductList);
    return searchProductTreeSet;
  }

  public List<Searchable> searchForMostSuitable(String substring) {
    System.out.println("searchForMostSuitable");
    List<Searchable> mostSuitableProduct = new ArrayList<>();
    for (List<Searchable> entry : searchList) {
      for (Searchable object : entry) {
        int i = 0;
        int indexVhoda = object.searchTerm().indexOf(substring, i);
        if (indexVhoda < 0) {
          System.out.println("Не найдено :" + substring + " в " + object.searchTerm());
        }
        int count = 0;
        while (indexVhoda >= 0) {
          count++;
          mostSuitableProduct.add(object);
          i = indexVhoda + substring.length();
          indexVhoda = object.searchTerm().indexOf(substring, i);
        }
        if (count > 0) {
          System.out.println(
              "в объекте: " + object.searchTerm() + " =  Нашлось " + count + " раз(а)");
        }
      }
    }
    System.out.println("Search Basket: " + mostSuitableProduct);
    return mostSuitableProduct;
  }

  public void printSerchList() {
    System.out.println("printSerchList");
    for (List<Searchable> product : searchList) {
      System.out.println(product);
    }
  }

//  public void printSerchList() {
//    System.out.println("printSerchList");
//    List<Searchable> allProducts = new ArrayList<>();
//    for (List<Searchable> products : searchList) {
//      allProducts.addAll(products);
//    }
//
//    // Сортировка по длине имени, а затем в натуральном порядке
//    allProducts.sort((s1, s2) -> {
//      int lengthCompare = Integer.compare(s1.searchTerm().length(), s2.searchTerm().length());
//      if (lengthCompare != 0) {
//        return lengthCompare;
//      } else {
//        return s1.searchTerm().compareTo(s2.searchTerm());
//      }
//    });
//
//    for (Searchable product : allProducts) {
//      System.out.println(product);
//    }
//  }

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
//ANSI_GREEN + "ВНИМАНИЕ !" + ANSI_RESET +

}//class