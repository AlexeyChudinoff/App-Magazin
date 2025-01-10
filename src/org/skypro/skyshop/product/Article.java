package org.skypro.skyshop.product;

import java.util.Objects;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Article article = (Article) o;
    return Objects.equals(nameArticle, article.nameArticle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nameArticle);
  }
}
