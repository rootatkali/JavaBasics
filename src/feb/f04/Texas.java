package feb.f04;

import java.util.Arrays;
import java.util.Scanner;

public class Texas {
  public static Scanner reader = new Scanner(System.in);

  public static String holdEm(int[] cards) {
    int[] amt = new int[13]; // Array for amt of every card
    Arrays.fill(amt, 0); // Init because Meir

    int pairs = 0; // Pairs counter
    int triple = 0; // Triplet Counter

    // Get amounts of every value.
    for (int i = 0; i < cards.length; i++) {
      amt[cards[i] - 1 /* Account for index starting from 0 */]++;
    }

    // Check for pairs, triplets and carets
    for (int i = 0; i < amt.length; i++) {
      if (amt[i] == 2) {
        pairs++;
      } else if (amt[i] == 3) {
        triple++;
      } else if (amt[i] == 4) {
        return "Caret!"; // קארה
      } else if (amt[i] == 5) {
        return "CHEATER!"; // A deck of cards has 4 cards of each value
      }
    }
    // Calculate
    if (pairs == 2) {
      return "Two pairs!"; // זוגיים
    } else if (pairs == 1) {
      if (triple == 1) {
        return "Full house!"; // פול
      } else {
        return "Pair!"; // זוג
      }
    } else if (triple == 1) {
        return "Triplet!"; // שלישייה
    }

    // Check for sequence
    for (int i = 0; i < amt.length - cards.length; i++) {
      if (amt[i] + amt[i + 1] + amt[i + 2] + amt[i + 3] + amt[i + 4] == 5) {
        return "Sequence!"; // רצף
      }
    }

    return "No rank.";
  }

  public static int[] genArr(int size, int lo, int hi) {
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = (int) (Math.random() * (hi - lo + 1) + lo);
    }
    return arr;
  }

  public static void main(String[] args) {
    int[] cards;
    for (int i = 0; i < 100; i++) {
      cards = genArr(5, 1, 13);
      System.out.println(Arrays.toString(cards) + " " + holdEm(cards));
    }
  }
}
