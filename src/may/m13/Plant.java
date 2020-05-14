package may.m13;

public class Plant {
  private boolean succulent;
  private int size;
  private int price;
  
  public Plant(boolean succulent, int size, int price) {
    this.succulent = succulent;
    this.size = size;
    this.price = price;
  }
  
  public Plant(Plant p) {
    this(p.succulent, p.size, p.price);
  }
  
  public boolean isSucculent() {
    return succulent;
  }
  
  public void setSucculent(boolean succulent) {
    this.succulent = succulent;
  }
  
  public int getSize() {
    return size;
  }
  
  public void setSize(int size) {
    this.size = size;
  }
  
  public int getPrice() {
    return price;
  }
  
  public void setPrice(int price) {
    this.price = price;
  }
  
  @Override
  public String toString() {
    return "Plant{" +
        "succulent=" + succulent +
        ", size=" + size +
        ", price=" + price +
        '}';
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    Plant p = (Plant) o;
    return succulent == p.isSucculent() && size == p.getSize() && price == p.getPrice();
  }
}
