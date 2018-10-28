package com.udaantech.chainmemorygame;

import com.udaantech.chainmemorygame.core.Game;
import java.util.Scanner;

public class GameTest {

  public static void main(String[] args) {
    startTest();
  }

  private static void startTest() {
    Game game = new Game();
    String input;
    while (true) {
      Scanner scanner = new Scanner(System.in);
      input = scanner.nextLine();
      if (input.equals("stop")) {
        break;
      }
      System.out.println(game.getSpeechText(input));
    }
  }

}
