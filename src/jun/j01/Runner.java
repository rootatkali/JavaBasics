package jun.j01;

import java.util.Arrays;

public class Runner {
  private String id;
  private int yearB;
  private Item[] lstItems;
  
  public Runner(String id, int yearB, int maxM) {
    this.id = id;
    this.yearB = yearB;
    lstItems = new Item[maxM];
  }
  
  // copy constructor
  public Runner(Runner r) {
    id = r.id;
    yearB = r.yearB;
    lstItems = r.lstItems;
  }
  
  public String getId() {
    return id;
  }
  
  public int getYearB() {
    return yearB;
  }
  
  public Item[] getLstItems() {
    return lstItems;
  }
  
  public void setLstItems(Item[] lstItems) {
    this.lstItems = lstItems;
  }
  
  @Override
  public String toString() {
    return "Runner{" +
        "id='" + id + '\'' +
        ", yearB=" + yearB +
        ", lstItems=" + Arrays.toString(lstItems) +
        '}';
  }
}
