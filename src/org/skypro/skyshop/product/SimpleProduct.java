package org.skypro.skyshop.product;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SimpleProduct extends Product {

  int costSimpleProduct;

  public SimpleProduct(String nameProduct, int costSimpleProduct)
      throws IllegalArgumentException {
    super(nameProduct);

    if (costSimpleProduct <= 0) {
      throw new IllegalArgumentException(
          ANSI_GREEN + "ВНИМАНИЕ ! Цена меньше нуля !" + ANSI_RESET);
    }
    this.costSimpleProduct = costSimpleProduct;
  }

  @Override
  public int getCostProduct() {
    return costSimpleProduct;
  }

  @Override
  public String toString() {
    return "Simpl._" + getNameProduct() +
        "  = цена =  " + costSimpleProduct;
  }

  public boolean isSpecial() {
    return false;
  }

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001B[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  //ANSI_GREEN + "ВНИМАНИЕ !" + ANSI_RESET +
  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public boolean contains(Object o) {
    return false;
  }

  @Override
  public Iterator<Product> iterator() {
    return null;
  }

  @Override
  public Object[] toArray() {
    return new Object[0];
  }

  @Override
  public <T> T[] toArray(T[] a) {
    return null;
  }

  @Override
  public boolean add(Product product) {
    return false;
  }

  @Override
  public boolean remove(Object o) {
    return false;
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean addAll(Collection<? extends Product> c) {
    return false;
  }

  @Override
  public boolean addAll(int index, Collection<? extends Product> c) {
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return false;
  }

  @Override
  public void clear() {

  }

  @Override
  public Product get(int index) {
    return null;
  }

  @Override
  public Product set(int index, Product element) {
    return null;
  }

  @Override
  public void add(int index, Product element) {

  }

  @Override
  public Product remove(int index) {
    return null;
  }

  @Override
  public int indexOf(Object o) {
    return 0;
  }

  @Override
  public int lastIndexOf(Object o) {
    return 0;
  }

  @Override
  public ListIterator<Product> listIterator() {
    return null;
  }

  @Override
  public ListIterator<Product> listIterator(int index) {
    return null;
  }

  @Override
  public List<Product> subList(int fromIndex, int toIndex) {
    return List.of();
  }
}