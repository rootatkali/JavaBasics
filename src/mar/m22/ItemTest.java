package mar.m22;

public class ItemTest {
  public static void main(String[] args) {
    Item milk = new Item(1, 5, 10);
    System.out.println(milk.buy(4)); // 20
    System.out.println(milk.buy(6)); // 30
    System.out.println(milk.buy(1)); // ERR, -1
    milk.restock(3);
    System.out.println(milk.buy(1)); // 5
  }
}
