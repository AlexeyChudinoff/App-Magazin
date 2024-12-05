package org.skypro.skyshop.searchProduct;

import java.util.ArrayList;
import java.util.Arrays;
import org.skypro.skyshop.product.Basket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class SearchEngine {

  private Searchable[] searchable;

  public void GenerateSearchable(int size) {
    System.out.println("GenerateSearchable SearchEngine");
    searchable = new Searchable[size];
    System.out.println("создан массив searchable[" + size + "]");
  }

  public void add(Searchable searchTerm) {
    String answer = "Невозможно добавить: " + searchTerm;
    for (int i = 0; i < searchable.length; i++) {
      if (searchable[i] == null) {
        answer = "add: " + searchTerm;
        searchable[i] = searchTerm;
        break;
      }
    }
    System.out.println(answer);
  }

  public void add1(Product getNameProduct) {
    String answer = "Невозможно добавить: " + getNameProduct;
    for (int i = 0; i < searchable.length; i++) {
      if (searchable[i] == null) {
        answer = "add: " + getNameProduct;
        searchable[i] = getNameProduct;
        break;
      }
    }
    System.out.println(answer);
  }


  /*public void add(Searchable searchTerm) {
    if (id == searchable.length) {
      System.out.println("невозможно добавить " + searchTerm);
      return;
    }
    searchable[id] = searchTerm;
    System.out.println("add :" + searchTerm);
    id++;
  }*/


  public void search(String find) {
    System.out.println("search");
    ArrayList<String> findeProduct = new ArrayList<>();
    for (int i = 0; i < searchable.length; i++) {
      if (searchable[i].searchTerm().contains(find)) {
        findeProduct.add(searchable[i].searchTerm());
        if (findeProduct.size() == 5) {
          break;
        }
      }
    }
    for (int i = 0; i < findeProduct.size(); i++) {
      System.out.println(findeProduct.get(i));
    }

  }


  public void printGetStringRepresentation() {
    System.out.println("printGetStringRepresentation");
    for (Searchable object : searchable) {
      if (object == null) {
        return;
      }
      object.getStringRepresentation();
    }
  }

  //для проверки
  public void printSearchEngine() {
    System.out.println("printSearchEngine");
    for (Searchable object : searchable) {
      System.out.println(object/*.searchTerm()*/);
    }
  }

  @Override
  public String toString() {
    return Arrays.toString(searchable);
  }

  public void setCopyBasket() {
    System.out.println("setCopyBasket");
    Searchable[] copyBasket = new Product[Basket.getProductBasket().length];
    {
      for (int i = 0; i < copyBasket.length; i++) {
        copyBasket[i] = Basket.getProductBasket()[i];
        //System.out.println(copyBasket[i]);
      }
    }
    System.out.println(Arrays.toString(copyBasket));
  }




}//class