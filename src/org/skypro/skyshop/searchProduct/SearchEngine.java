package org.skypro.skyshop.searchProduct;

import java.util.ArrayList;
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

  private final Set<List<Searchable>> searchList = new TreeSet<>();

  public void addBasketInSearchList(ProductBasket basket) {
    System.out.println("addBasketInSearchList");
    Map<String, List<Product>> copiedList = basket.getProductBasket();
    if (copiedList == null) {
      throw new IllegalArgumentException("Basket cannot be null");
    }

    // Проходим по всем категориям и продуктам в корзине
    for (Map.Entry<String, List<Product>> entry : copiedList.entrySet()) {
      String category = entry.getKey();
      List<Product> products = entry.getValue();

      // Если список продуктов для категории не пустой
      if (products != null && !products.isEmpty()) {
        // Получаем или создаем список Searchable для данной категории
        List<Searchable> searchableList = searchList.computeIfAbsent(category,
            k -> new ArrayList<>());

        // Добавляем каждый продукт в список Searchable
        for (Product product : products) {
          if (product != null) {
            searchableList.add(product);
          }
        }
      }
    }
    for (Map.Entry<String, List<Searchable>> entry : searchList.entrySet()) {
      System.out.println("Add in category: " + entry.getKey() + ", Products: " + entry.getValue());
    }
  }

  public void sizeBasket() {
    System.out.println("SizeBasket: " + searchList.size());
  }

  public void addArticle(String category, Article article) {
    List<Searchable> articles = searchList.get(category);
    if (articles == null) {
      articles = new ArrayList<>();
      searchList.put(category, articles);
    }
    articles.add(article);
    System.out.println("Add in category: " + category + ", articles: " + articles);
    //System.out.println("Current List: " + searchList);
  }

  public void printGetStringRepresentation() {
    System.out.println("printGetStringRepresentation");
    for (List<Searchable> products : searchList.values()) {
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

  public List<Searchable> searchProduct(String findName) {
    System.out.println("searchProduct");
    List<Searchable> searchProductList = new ArrayList<>();
    if (findName == null) {
      System.out.println("findName is null ");
      return searchProductList;
    }
    boolean productFound = false;
    for (List<Searchable> products : searchList.values()) {
      for (Searchable product : products) {
        // Проверка на null и соответствие searchTerm
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
    return searchProductList;
  }

  public List<Searchable> searchForMostSuitable(String substring) {
    System.out.println("searchForMostSuitable");
    List<Searchable> mostSuitableProduct = new ArrayList<>();
    for (List<Searchable> entry : searchList.values()) {
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
    for (Entry<String, List<Searchable>> product : searchList.entrySet()) {
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