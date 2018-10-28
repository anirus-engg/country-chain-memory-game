package com.udaantech.chainmemorygame.data;

public class GameControl {

  private static GameControl instance;
  private int playerUtteranceCount = 0;
  private boolean alexaTurn = false;

  private GameControl() {}

  public static GameControl getInstance() {
    if (instance == null) {
      instance = new GameControl();
    }
    return instance;
  }

  public void resetPlayerUtteranceCount() {
    playerUtteranceCount = 0;
  }

  public void increasePlayerUtteranceByOne() {
    playerUtteranceCount++;
  }

  public void clear() {
    instance = null;
  }

  // Getters and Setters

  public int getPlayerUtteranceCount() {
    return playerUtteranceCount;
  }

  public void setPlayerUtteranceCount(int playerUtteranceCount) {
    this.playerUtteranceCount = playerUtteranceCount;
  }

  public boolean isAlexaTurn() {
    return alexaTurn;
  }

  public void setAlexaTurn(boolean alexaTurn) {
    this.alexaTurn = alexaTurn;
  }
}
