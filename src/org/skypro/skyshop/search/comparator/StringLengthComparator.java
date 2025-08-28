package org.skypro.skyshop.search.comparator;

import org.skypro.skyshop.search.Searchable;
import java.util.Comparator;

public class StringLengthComparator implements Comparator<Searchable> {
  @Override
  public int compare(Searchable s1, Searchable s2) {
    return Integer.compare(s1.searchTerm().length(), s2.searchTerm().length());
  }
}