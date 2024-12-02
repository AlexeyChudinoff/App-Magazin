package org.skypro.skyshop.product;

public class Article implements Searchable{

  String nameArticle;
  String textArticle;

 public Article(String nameArticle, String textArticle) {
    this.nameArticle = nameArticle;
    this.textArticle = textArticle;
  }

  public String getNameArticle() {
    return nameArticle;
  }

  public String getTextArticle() {
    return textArticle;
  }

  @Override
  public String toString() {
    return
        nameArticle + "+" + textArticle ;
  }


  @Override
  public String SearchTerm() {
    System.out.println("SearchTerm_Article");
    return toString();
  }

  @Override
  public String getTipContent() {
    System.out.println("getTipContent_Article");
    return "ARTICLE";
  }


}
