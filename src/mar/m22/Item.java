package mar.m22;

// This class is a item in a shop
public class Item {
  private final int code; // Product code - cannot be changed.
  private int cost; // Cost for one item
  private int stock; // Stock in store
  
  public Item(int code, int cost, int stock) {
    this.code = code;
    this.cost = cost;
    this.stock = stock;
  }
  
  public Item(Item i) {
    this.code = i.code;
    this.cost = i.cost;
    this.stock = i.stock;
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
  
  /**
   * Removes desired amount from stock (if there is enough stock), and returns the total price for
   * all items.
   *
   * @param amount The amount of items to buy
   * @return this.price * amount, or -1 if the transaction failed.
   */
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
  
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    Item item = (Item) o;
    
    return (code == item.code) && (cost == item.cost) && (stock == item.stock);
  }
  
  public String toString() {
    return "Item[code=" + code + ", cost=" + cost + ", stock=" + stock + "]";
  }
}
