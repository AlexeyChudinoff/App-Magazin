package org.skypro.skyshop.searchProduct;

import java.util.Comparator;
//это для сортировки по TreeMap
//import java.util.Set;
//import java.util.TreeSet;
//
//public class Main {
//  public static void main(String[] args) {
//    Set<String> set = new TreeSet<>(new StringLengthComparator());
//
//    set.add("Apple");
//    set.add("Banana");
//    set.add("Fig");
//    set.add("Cherry");
//
//    for (String fruit : set) {
//      System.out.println(fruit);
//    }
//  }
//}

public class StringLengthComparator implements Comparator<Searchable> {

  @Override
  public int compare(Searchable s2, Searchable s1) {
    return Integer.compare(s2.searchTerm().length(), s1.searchTerm().length());
  }
}
