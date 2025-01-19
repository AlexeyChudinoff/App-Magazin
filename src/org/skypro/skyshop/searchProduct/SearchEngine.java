package org.skypro.skyshop.searchProduct;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.ProductBasket;
import org.skypro.skyshop.product.Product;

public class SearchEngine {

  private final Set<Searchable> searchList = new HashSet<>();

  public void addBasketInSearchList(ProductBasket basket) {
    System.out.println("addBasketInSearchList");
    if (basket == null) {
      throw new IllegalArgumentException("ВНИМАНИЕ ! Корзина не может быть null !");
    }
    Map<String, List<Product>> copiedList = basket.getProductBasket();
    for (List<Product> products : copiedList.values()) {
      if (products != null) {
        for (Product product : products) {
          if (product != null) {
            searchList.add(product);
          }
        }
      }
    }
    System.out.println(searchList);
    System.out.println("size bascet " + searchList.size());
  }

  public void addArticle(Article article) {
    searchList.add(article);
    System.out.println("Add  article: " + article);
  }

  public void printGetStringRepresentation() {
    System.out.println("printGetStringRepresentation");
    if (searchList == null || searchList.isEmpty()) {
      System.out.println("ВНИМАНИЕ ! Список поиска пуст или равен null !");
      return;
    }
    for (Searchable product : searchList) {
      if (product == null) {
        System.out.println(ANSI_GREEN + "ВНИМАНИЕ ! product is null" + ANSI_RESET);
        continue;
      }
      product.getStringRepresentation();
    }
  }

  public Set<Searchable> searchProduct(String findName) {
    System.out.println("searchProduct");
    if (findName == null || findName.isBlank()) {
      throw new IllegalArgumentException("ВНИМАНИЕ ! Имя для поиска не может быть пустым !");
    }
    Set<Searchable> searchProdList = searchList.stream()
        .filter(product -> product != null && findName.equalsIgnoreCase(product.searchTerm()))
        .collect(Collectors.toCollection(() -> new TreeSet<>(new StringLengthComparator())));

    if (searchProdList.isEmpty()) {
      System.out.println("Не найден продукт: " + findName);
    } else {
      System.out.println("Найдены продукты: " + searchProdList);
    }

    return searchProdList;
  }

//  public Set<Searchable> searchProduct(String findName) {
//    System.out.println("searchProduct");
//    Set<Searchable> searchProductList = new HashSet<>();
//    if (findName == null || findName.isBlank()) {
//      throw new IllegalArgumentException("ВНИМАНИЕ ! Имя для поиска не может быть пустым !");
//    }
//    boolean productFound = false;
//    for (Searchable product : searchList) {
//      if (product != null && findName.equals(product.searchTerm())) {
//        searchProductList.add(product);
//        productFound = true;
//      }
//    }
//    if (!productFound) {
//      System.out.println("Не найден продукт: " + findName);
//    } else {
//      System.out.println("Найдены продукты: " + searchProductList);
//    }
//    Set<Searchable> searchProductTreeSet = new TreeSet<>(searchProductList);
//    return searchProductTreeSet;
//  }

  public List<Searchable> searchForMostSuitable(String substring) {
    System.out.println("searchForMostSuitable");
    if (substring == null || substring.isBlank()) {
      throw new IllegalArgumentException("ВНИМАНИЕ ! Подстрока для поиска не может быть пустой !");
    }
    List<Searchable> mostSuitableProduct = new ArrayList<>();
    for (Searchable object : searchList) {
      int count = 0;
      int i = 0;
      while ((i = object.searchTerm().indexOf(substring, i)) >= 0) {
        count++;
        i += substring.length();
      }
      if (count > 0) {
        mostSuitableProduct.add(object);
        System.out.println(
            "в объекте: " + object.searchTerm() + " =  Нашлось " + count + " раз(а)");
      }
    }
    System.out.println("Search Basket: " + mostSuitableProduct);
    return mostSuitableProduct;
  }

  public void printSerchList() {
    System.out.println("printSerchList");
    List<Searchable> allProducts = new ArrayList<>();
    for (Searchable products : searchList) {
      allProducts.add(products);
    }
    // Сортировка по длине имени, а затем в натуральном порядке
    allProducts.sort((s1, s2) -> {
      if (s1 == null || s2 == null) {
        throw new IllegalArgumentException(
            "ВНИМАНИЕ ! Объекты для сравнения не могут быть null !");
      }//метод compareTo надо прописать в тех классах, объекты которых будут сравниваться
      int lengthCompare = Integer.compare(s2.searchTerm().length(), s1.searchTerm().length());
      if (lengthCompare != 0) {
        return lengthCompare;
      } else {
        return s2.searchTerm().compareTo(s1.searchTerm());
      }
    });

    for (Searchable product : allProducts) {
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