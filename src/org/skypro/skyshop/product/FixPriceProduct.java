package org.skypro.skyshop.product;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FixPriceProduct extends Product {

  static final int FIX_PRICE_PRODUCT = 500;

  public FixPriceProduct(String nameProduct) {
    super(nameProduct);
  }

  public int getCostProduct() {
    return FIX_PRICE_PRODUCT;
  }

  @Override
  public String toString() {
    return "Fix._"
        + getNameProduct() + " = цена = " + FIX_PRICE_PRODUCT;
  }

  public boolean isSpecial() {
    return true;
  }

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
