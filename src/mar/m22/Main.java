package mar.m22;

public class Main {
  /**
   * This is a helper method.
   * Formats the balance of two accounts
   * @param b1 A BankAccount.
   * @param b2 A BankAccount.
   * @return b1.owner: b1.bal, b2.owner: b2.bal
   */
  public static String balString(BankAccount b1, BankAccount b2) {
    return b1.getOwner() + ": $" + b1.getBalance() + ", " +
        b2.getOwner() + ": $" + b2.getBalance();
  }
  
  public static void main(String[] args) {
    Date date = new Date(24, 3, 2020);
    
    Item butter = new Item(1, 4, 15);
    Item milk = new Item(2, 5, 20);
    
    BankAccount shop = new BankAccount("Shop", "000-0001/23", 0);
    BankAccount rotem = new BankAccount("Rotem", "000-0002/46", 100);
    
    System.out.println("Transaction log for date: " + date.format());
    
    // Rotem buys 3 milk
    rotem.transferTo(shop, milk.buy(3));
    System.out.println(rotem.getOwner() + " bought 3 milk for $" + (milk.getCost() * 3) + "!");
    System.out.println("New milk stock: " + milk.getStock());
    System.out.println(balString(rotem, shop));
    
    // Rotem buys 10 butter
    rotem.transferTo(shop, butter.buy(10));
    System.out.println(rotem.getOwner() + " bought 10 butter for $" + (butter.getCost()*10) + "!");
    System.out.println("New butter stock: " + butter.getStock());
    System.out.println(balString(rotem, shop));
    
    // Shop restocks 5 butter, each butter costs the shop $2.
    butter.restock(5);
    shop.withdraw(5 * 2); // 5 butters times $2 each.
    System.out.println("Butter restocked.\nNew butter stock: " + butter.getStock());
    System.out.println(shop);
  }
}
