package feb.f18;

import java.util.Arrays;

public class Treasure {
  private static final int FOUND = -1;
  private static final int LOST = -2;
  
  // A
  public static int track(int[] rooms, int start) {
    // O(n)
    int cnt = 0;
    int goTo = rooms[start];
    int index = start;
    while ((goTo != FOUND) && (goTo != LOST)) {
      if (++cnt > rooms.length) return LOST;
      index = goTo;
      goTo = rooms[goTo];
    }
    if (goTo == LOST) return LOST;
    return index;
  }
  
  // B
  public static boolean[] findInf(int[] rooms) {
    // O(n²)
    boolean[] ret = new boolean[rooms.length];
    Arrays.fill(ret, true);
    int cntRooms = 0;
    int goTo = 0;
    for (int i = 0; i < ret.length; i++) {
      cntRooms = 0;
      goTo = rooms[i];
      while (cntRooms < rooms.length) {
        if (goTo == FOUND || goTo == LOST) {
          ret[i] = false;
        } else
          goTo = rooms[goTo];
        cntRooms++;
      }
    }
    return ret;
  }
  
  // C
  public static boolean[] goodSearch(int[] rooms) {
    // O(n²)
    boolean[] ret = new boolean[rooms.length];
    Arrays.fill(ret, false);
    boolean[] inf = findInf(rooms);
    
    for (int i = 0; i < inf.length; i++) {
      if (!inf[i]) {
        if (track(rooms, i) != LOST) {
          ret[i] = true;
        }
      }
    }
    
    return ret;
  }
  
  public static void main(String[] args) {
    //             0, 1, 2, 3, 4, 5,  6, 7,  8, 9, 10
    int[] rooms = {1, 0, 4, 1, 8, 9, 10, 3, -2, 2, -1};
    int[] tr = new int[rooms.length];
    
    System.out.println(track(rooms,6));
    System.out.println(Arrays.toString(goodSearch(rooms)));
  }
}
