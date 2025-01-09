package org.skypro.skyshop.product;

import org.skypro.skyshop.searchProduct.Searchable;

public class Article implements Searchable {

  private final String nameArticle;
  private final String textArticle;

  public Article(String nameArticle, String textArticle) {
    this.nameArticle = nameArticle;
    this.textArticle = textArticle;
  }

  @Override
  public String toString() {
    return "Название статьи = " + (nameArticle != null ? nameArticle : "null") +
        " , Текст статьи = " + (textArticle != null ? textArticle : "null");
  }
  @Override
  public String searchTerm() {
    return nameArticle ;
  }
  @Override
  public String searchTipContent() {
    return "ARTICLE";
  }

}
