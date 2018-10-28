package com.udaantech.chainmemorygame.core;

import com.udaantech.chainmemorygame.data.AllCountries;
import com.udaantech.chainmemorygame.data.CountryLink;
import com.udaantech.chainmemorygame.data.GameControl;

public class Game {

  public static final String TITLE = "ChainMemoryGame";
  public static final String GAMEOVER = "score";
  public static final String COUNTRY_SLOT = "Country";

  public String getSpeechText(String countryUtterance) {
    StringBuilder speechText = new StringBuilder();

    speechText.append(validatePlayerTurn(countryUtterance));

    GameControl gameControl = GameControl.getInstance();
    if (gameControl.isAlexaTurn()) {
      speechText.append(alexaTurn());
    }

    return speechText.toString();
  }

  private String validatePlayerTurn(String country) {

    CountryLink countryLink = CountryLink.getInstance();
    AllCountries allCountries = AllCountries.getInstance();
    GameControl gameControl = GameControl.getInstance();
    country = country.toLowerCase();

    gameControl.setAlexaTurn(false);
    int utteranceCount = gameControl.getPlayerUtteranceCount();

    if (utteranceCount >= countryLink.size()) {
      if (countryLink.contains(country)) {
        gameControl.increasePlayerUtteranceByOne();
        return "Country already exists in the link. It was nice playing with you. Your score is " +
            countryLink.size(); // Game Over
      }

      if (!allCountries.exists(country)) {
        return "It is an invalid country name.  Please try again."; // Try again
      }

      countryLink.add(country);
      gameControl.resetPlayerUtteranceCount();
      gameControl.setAlexaTurn(true);
      return "";
    }

    // check the chain
    if (!countryLink.getElement(utteranceCount).equals(country)) {
      gameControl.increasePlayerUtteranceByOne();
      return "Incorrect country name.  The correct country is " +
          countryLink.getElement(utteranceCount) + ". Your score is " + countryLink.size(); // Game OVer
    }

    gameControl.increasePlayerUtteranceByOne();
    return "";
  }

  private String alexaTurn() {
    AllCountries allCountries = AllCountries.getInstance();
    CountryLink countryLink = CountryLink.getInstance();
    String myCountry = allCountries.getRandom();

    String speechTest = countryLink.toString() + ". I say " + myCountry;
    countryLink.add(myCountry);
    return speechTest;
  }

  private void gameOver() {
    CountryLink.getInstance().clear();
    GameControl.getInstance().clear();
  }
}
