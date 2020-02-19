package feb.f05;

import static helper.Helper.matToString;

public class Matrices {
  public static final char BLACK = 'B';
  public static final char WHITE = '-';
  public static void main(String[] args) {
    char[][] checker = new char[8][8];
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        if ((i + j) % 2 == 0)
          checker[i][j] = BLACK;
        else
          checker[i][j] = WHITE;
      }
    }
    int[][] test = new int[4][3];
    
    System.out.println(matToString(test));
    System.out.println(matToString(checker));
  }
  
}
