package com.udaantech.chainmemorygame.data;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class AllCountries {

  private static AllCountries instance;

  private final List<String> countryList;

  private AllCountries() {
    countryList = new ArrayList<>();
    ClassLoader classLoader = getClass().getClassLoader();
    List<String> lines = new ArrayList<>();
    try {
      lines = Files.readAllLines(Paths.get(classLoader.getResource("customSlots.csv").toURI()));
    } catch (IOException | URISyntaxException ex) {
      ex.printStackTrace();
    }

    for (String line : lines) {
      String[] customSLots = line.split(",");
      String country = customSLots[0];
      countryList.add(country);
    }
  }

  public static AllCountries getInstance() {
    if (instance == null) {
      instance = new AllCountries();
    }
    return instance;
  }

  public boolean exists(String country) {
    country = country.toLowerCase();
    System.out.println(country + " " + countryList.contains(country));
    return countryList.contains(country);
  }

  public String getRandom() {

    Random random = new Random();
    int randomIndex = random.nextInt(countryList.size());
    String randomCountry = countryList.get(randomIndex);
    if (CountryLink.getInstance().contains(randomCountry)) {
      randomCountry = getRandom();
    }
    return randomCountry;
  }
}
