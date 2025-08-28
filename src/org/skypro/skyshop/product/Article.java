package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.search.Printable;
import org.skypro.skyshop.util.SimpleLogger;

import java.util.Objects;

public class Article implements Searchable, Printable, Comparable<Article> {
  private final String nameArticle;
  private final String textArticle;

  public Article(String nameArticle, String textArticle) {
    if (nameArticle == null || nameArticle.isBlank()) {
      String errorMsg = "Имя статьи не может быть пустым!";
      SimpleLogger.error(errorMsg);
      throw new IllegalArgumentException(errorMsg);
    }

    this.nameArticle = nameArticle;
    this.textArticle = textArticle != null ? textArticle : "";
    SimpleLogger.debug("Создана статья: " + nameArticle);
  }

  @Override
  public String toString() {
    return "Статья: " + nameArticle + " - " +
        (textArticle.length() > 20 ? textArticle.substring(0, 20) + "..." : textArticle);
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
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Article article = (Article) o;
    return Objects.equals(nameArticle, article.nameArticle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nameArticle);
  }

  @Override
  public int compareTo(Article other) {
    if (other == null) {
      throw new IllegalArgumentException("Объект для сравнения не может быть null!");
    }
    return this.nameArticle.compareTo(other.nameArticle);
  }

  @Override
  public void print() {
    SimpleLogger.info(toString());
  }

  public String getTextArticle() {
    return textArticle;
  }
}