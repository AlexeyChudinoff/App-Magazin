package org.skypro.skyshop.product;

import java.util.Arrays;

public class Article implements Searchable {

  private String nameArticle;
  private String textArticle;

  public Article(String nameArticle, String textArticle) {
    this.nameArticle = nameArticle;
    this.textArticle = textArticle;
  }

  int size = 6;
  Article[] articles = new Article[size];

  public void printArticles() {
    System.out.println("printArticles");
    for (Article article : articles) {
      System.out.println(article);
    }
  }

  public void addArticle(String nameArticle, String textArticle) {
    String answer;
    boolean articleAdded = false;

    for (int i = 0; i < articles.length; i++) {
      if (articles[i] == null) {
        articles[i] = new Article(nameArticle, textArticle);
        answer = nameArticle + " : " + textArticle;
        System.out.println("addArticle- " + answer);
        articleAdded = true;
        break;
      }
    }
    if (!articleAdded) {
      answer = "Массив статей полон. Невозможно добавить " + nameArticle;
      System.out.println(answer);
    }
  }

  public String getNameArticle() {
    return nameArticle;
  }

  public String getTextArticle() {
    return textArticle;
  }

  @Override
  public String toString() {
    return "Article- " +
        "Название статьи = " + getNameArticle() +
        " , Текст статьи = " + getTextArticle();
  }

  @Override
  public String searchTerm() {
    return getNameArticle();
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
