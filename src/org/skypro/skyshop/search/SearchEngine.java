package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.ProductBasket;
import org.skypro.skyshop.util.SimpleLogger;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {

  private final Set<Searchable> searchList = new HashSet<>();


  public void addBasketInSearchList(ProductBasket basket) {
    SimpleLogger.info("Добавление корзины в поисковый список");

    if (basket == null) {
      SimpleLogger.error("Корзина не может быть null!");
      throw new IllegalArgumentException("Корзина не может быть null!");
    }

    int addedCount = 0;
    for (List<Product> products : basket.getProductBasket().values()) {
      for (Product product : products) {
        if (product != null) {
          searchList.add(product);
          addedCount++;
        }
      }
    }

    SimpleLogger.info("Добавлено продуктов: " + addedCount);
    SimpleLogger.info("Общий размер поискового списка: " + searchList.size());
  }

  public void addArticle(Article article) {
    if (article == null) {
      SimpleLogger.warn("Попытка добавить null статью");
      return;
    }

    searchList.add(article);
    SimpleLogger.info("Добавлена статья: " + article.searchTerm());
  }

  public void printAllStringRepresentations() {
    SimpleLogger.info("=== СТРОКОВЫЕ ПРЕДСТАВЛЕНИЯ ОБЪЕКТОВ ===");

    if (searchList.isEmpty()) {
      SimpleLogger.warn("Поисковый список пуст");
      return;
    }

    for (Searchable item : searchList) {
      if (item instanceof Printable) {
        SimpleLogger.info(((Printable) item).getStringRepresentation());
      }
    }
  }

  public Set<Searchable> searchExactMatch(String findName) {
    SimpleLogger.info("Поиск точного совпадения: '" + findName + "'");

    if (findName == null || findName.isBlank()) {
      SimpleLogger.error("Имя для поиска не может быть пустым!");
      throw new IllegalArgumentException("Имя для поиска не может быть пустым!");
    }

    Set<Searchable> results = searchList.stream()
        .filter(Objects::nonNull)
        .filter(item -> findName.equalsIgnoreCase(item.searchTerm()))
        .collect(Collectors.toSet());

    if (results.isEmpty()) {
      SimpleLogger.info("Точных совпадений не найдено: '" + findName + "'");
    } else {
      SimpleLogger.info("Найдено точных совпадений: " + results.size());
      for (Searchable result : results) {
        SimpleLogger.info("  - " + result.searchTerm() + " (" + result.searchTipContent() + ")");
      }
    }

    return results;
  }

  public List<Searchable> searchContains(String substring) {
    SimpleLogger.info("Поиск по подстроке: '" + substring + "'");

    if (substring == null || substring.isBlank()) {
      SimpleLogger.error("Подстрока для поиска не может быть пустой!");
      throw new IllegalArgumentException("Подстрока для поиска не может быть пустой!");
    }

    String lowerSubstring = substring.toLowerCase();
    List<Searchable> results = searchList.stream()
        .filter(Objects::nonNull)
        .filter(item -> item.searchTerm().toLowerCase().contains(lowerSubstring))
        .collect(Collectors.toList());

    if (results.isEmpty()) {
      SimpleLogger.info("Совпадений по подстроке не найдено: '" + substring + "'");
    } else {
      SimpleLogger.info("Найдено совпадений по подстроке: " + results.size());
      for (Searchable result : results) {
        SimpleLogger.info("  - " + result.searchTerm() + " (" + result.searchTipContent() + ")");
      }
    }

    return results;
  }

  public void printSearchListSorted() {
    SimpleLogger.info("=== ОТСОРТИРОВАННЫЙ СПИСОК ===");

    if (searchList.isEmpty()) {
      SimpleLogger.warn("Поисковый список пуст");
      return;
    }

    List<Searchable> sortedList = new ArrayList<>(searchList);
    sortedList.sort(Comparator.comparing(Searchable::searchTerm));

    for (Searchable item : sortedList) {
      SimpleLogger.info(item.searchTerm() + " (" + item.searchTipContent() + ")");
    }
  }

  public int getSearchListSize() {
    return searchList.size();
  }

  public void clearSearchList() {
    searchList.clear();
    SimpleLogger.info("Поисковый список очищен");
  }

  public boolean contains(Searchable item) {
    return searchList.contains(item);
  }


}