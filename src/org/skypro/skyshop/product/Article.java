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
    return "Название статьи = " + nameArticle +
        " , Текст статьи = " + textArticle;
  }

  @Override
  public String searchTerm() {
    return nameArticle + " , " + textArticle;
  }

  @Override
  public String searchTipContent() {
    return "ARTICLE";
  }

  @Override
  public void getStringRepresentation() {
    Searchable.super.getStringRepresentation();
  }

}
