package jun.j01;

import helper.Helper;

import java.util.Arrays;

public class MrtnRace {
  private String country;
  private int year;
  private Runner[] runners;
  
  private Runner[] copy(Runner[] arr) {
    Runner[] ret = new Runner[arr.length];
    for (int i = 0; i < arr.length; i++) {
      ret[i] = new Runner(arr[i]);
    }
    return ret;
  }
  
  public MrtnRace(String country, int year, int maxR) {
    this.country = country;
    this.year = year;
    runners = new Runner[maxR];
  }
  
  public String getCountry() {
    return country;
  }
  
  public void setCountry(String country) {
    this.country = country;
  }
  
  public int getYear() {
    return year;
  }
  
  public void setYear(int year) {
    this.year = year;
  }
  
  public Runner[] getRunners() {
    return copy(runners);
  }
  
  // Complexity O(n)
  public void addRunner(Runner r) {
    int index = Helper.firstNull(runners);
    if (index == -1) return;
    runners[index] = new Runner(r);
  }
  
  // Complexity O(n)
  public void addScoreToRunner(String id, int score) {
    Runner r = null;
    for (Runner rr : runners) {
      if (rr == null) continue;
      if (rr.getId().equals(id)) {
        r = rr;
        break;
      }
    }
    if (r == null) return;
    
    Item[] items = r.getLstItems();
    
    Item item = new Item(this.year, score);
    int index = Helper.firstNull(items); // If the array is already sorted, newest will go in the first empty spot.
    if (index == -1) return;
    items[index] = item;
    r.setLstItems(items);
  }
  
  @Override
  public String toString() {
    return "MrtnRace{" +
        "country='" + country + '\'' +
        ", year=" + year +
        ", runners=" + Arrays.toString(runners) +
        '}';
  }
}
