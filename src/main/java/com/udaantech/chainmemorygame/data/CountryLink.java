package com.udaantech.chainmemorygame.data;

import java.util.LinkedList;
import java.util.List;

public class CountryLink {

  private static CountryLink instance;

  private List<String> countryLinkList = new LinkedList<>();

  private CountryLink(){}

  public static CountryLink getInstance() {
    if (instance == null) {
      instance = new CountryLink();
    }
    return instance;
  }

  public boolean contains(String country) {
    country = country.toLowerCase();
    return countryLinkList.contains(country);
  }

  public boolean add(String country) {
    country = country.toLowerCase();
    return countryLinkList.add(country);
  }

  public void clear() {
    instance = null;
  }

  public int size() {
    return countryLinkList.size();
  }

  public String getElement(int index) {
    return countryLinkList.get(index);
  }

  @Override
  public String toString() {
    return countryLinkList.toString();
  }
}
