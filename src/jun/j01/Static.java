package jun.j01;

public class Static {
  private static int sequence(Runner r) {
    Item[] items = r.getLstItems();
    int year = items[0].getYear();
    int cnt = 1;
    int cntMax = 1;
    for (int j = 0; j < items.length; j++) {
      Item i = items[j];
      if (i.getYear() == year + 1) {
        cnt++;
        year++;
        if (cntMax < cnt) {
          cntMax = cnt;
        }
      } else {
        year = items[j].getYear();
        cnt = 1;
      }
    }
    
    return cntMax;
  }
  
  // Complexity O(n^2)
  public static int consecutiveRunners(MrtnRace mr) {
    int ret = 0;
    for (Runner r : mr.getRunners()) {
      if (sequence(r) >= 3) ret++;
    }
    return ret;
  }
}
