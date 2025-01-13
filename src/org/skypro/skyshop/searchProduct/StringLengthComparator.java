package org.skypro.skyshop.searchProduct;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {

  @Override
  public int compare(String s2, String s1) {
    return Integer.compare(s2.length(), s1.length());
  }

}
