package org.skypro.skyshop.product;

import java.util.Objects;
import org.skypro.skyshop.searchProduct.Searchable;

public class Article implements Searchable, Comparable {

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
    return nameArticle;
  }

  @Override
  public String searchTipContent() {
    return "ARTICLE";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Article article = (Article) o;
    // оставляем только имя, т.к искать и сравнивать будем только по имени
    return Objects.equals(nameArticle, article.nameArticle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nameArticle);
  }

  // когда стало public class Article implements Comparable
  @Override
  public int compareTo(Object o) {
    if (o == null) {
      throw new IllegalArgumentException(" Объект для сравнения не может быть null !");
    }
    if (o instanceof Article) {
      Article other = (Article) o;
      if (this.nameArticle == null || other.nameArticle == null) {
        throw new IllegalArgumentException(" Имя статьи не может быть null !");
      }
      return this.nameArticle.compareTo(other.nameArticle);
    }
    throw new IllegalArgumentException(" Объект не является Article");
  }

}
