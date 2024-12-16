package org.skypro.skyshop.searchProduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import org.skypro.skyshop.Exeption.BestResultNotFound;
import org.skypro.skyshop.product.Article;
import org.skypro.skyshop.product.Basket;
import org.skypro.skyshop.product.Product;


public class SearchEngine {

  private Searchable[] searchList;

  public SearchEngine(int size) {
    // searchList = new ArrayList<>(size).toArray(new Searchable[size]);
    searchList = new Searchable[size];
    System.out.println("создан массив searchList[" + size + "]");
  }

  public void addBasket() {
    System.out.println("addBasket");
    ArrayList<ArrayList> addProduct = new ArrayList<>();
      addProduct.add(new Basket().getProductBasket());
      System.out.println(addProduct);

  }


  public void addArticle(String nameArticle, String textArticle) {
    for (int i = 0; i < searchList.length; i++) {
      if (searchList[i] == null) {
        searchList[i] = new Article(nameArticle, textArticle);
        System.out.println("Add: " + nameArticle + " , " + textArticle);
        break;
      }
    }
  }

  public void search(String find) {
    System.out.println("search");
    List<Object> findeProduct = new ArrayList<>();
    for (Searchable searchable : searchList) {
      if (searchable == null) {
        return;
      }
      if (searchable.searchTerm().contains(find)) {
        findeProduct.add(searchable.searchTerm());
        System.out.println(searchable.searchTerm());
//        if (findeProduct.size() == 5) {
//          break;
//        }
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

  public void searchForMostSuitable(String substring) {
    System.out.println("searchForMostSuitable");
    for (Searchable object : searchList) {
      if (object == null) {
        System.out.println(ANSI_BLUE + "Дальше нет объектов для поиска, список пуст " + ANSI_RESET);
        return;
      }
      int i = 0;//   System.out.println("начинаем проверку объекта "
      // + object.searchTerm() + " с индекса = " + i);
      int idxVhod = object.searchTerm().indexOf(substring, i);
      //System.out.println(" Взяли объект " + object.searchTerm()
      // + " поискали и получили idxVhod  = " + idxVhod);

      if (idxVhod < 0) {
        try {
          throw new BestResultNotFound("Не найдено :" + substring);
        } catch (BestResultNotFound e) {
          System.out.println(e.getMessage());
        }
      }

      int count = 0;
      while (idxVhod >= 0) {
        // System.out.println("пошли в цикл wille");
        count++;
        //System.out.println("count = " + count);
        //System.out.println("в итоге пока нашли " +  substring +" " + count + " раз ");
        i = idxVhod
            + substring.length();//System.out.println(" сделали i + поисковое слово = " + i);
        idxVhod = object.searchTerm().indexOf(substring, i);
        //System.out.println(" поискали с нового инднекса " + i +
        //    " и получили idxVhod = " + idxVhod);
      }
      if (count > 0) {
        System.out.println(
            "в объекте: " + object.searchTerm() + " =  Нашлось " + count + " раз(а)");
      }
    }
  }

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  //ANSI_GREEN + "ВНИМАНИЕ !" + ANSI_RESET +

}//class