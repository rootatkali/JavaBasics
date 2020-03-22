package mar.m22;

// This class is a item in a shop
public class Item {
  private final int code; // Product code
  private int cost; // Cost for one item
  private int stock; // Stock in store
  
  public Item(int code, int cost, int stock) {
    this.code = code;
    this.cost = cost;
    this.stock = stock;
  }
  
  public int getCode() {
    return code;
  }
  
  public int getCost() {
    return cost;
  }
  
  public void setCost(int cost) {
    this.cost = cost;
  }
  
  public int getStock() {
    return stock;
  }
  
  // There is no setStock, instead there are restock and buy
  public void restock(int stock) {
    if (stock <= 0) return;
    this.stock += stock;
  }
   
  public int buy(int amount) {
    if (amount <= 0) {
      System.err.println("Can't buy negative items!");
      return -1;
    }
    if (amount > stock) {
      System.err.println("Not enough stock!");
      return -1;
    }
    stock -= amount;
    return amount * cost;
  }
  
  @Override
  public String toString() {
    return "Item[code=" + code + ", cost=" + cost + ", stock=" + stock + "]";
  }
}
