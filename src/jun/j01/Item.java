package jun.j01;

public class Item {
  private int year;
  private int score;
  
  public Item(int year, int score) {
    this.year = year;
    this.score = score;
  }
  
  public Item(Item i) {
    this(i.year, i.score);
  }
  
  public int getYear() {
    return year;
  }
  
  public int getScore() {
    return score;
  }
  
  @Override
  public String toString() {
    return "Item{" +
        "year=" + year +
        ", score=" + score +
        '}';
  }
}
