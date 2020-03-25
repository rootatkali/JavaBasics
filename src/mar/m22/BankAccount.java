package mar.m22;

public class BankAccount {
  private final String id; // ID of account cannot be changed
  private String owner;
  private int balance;
  
  public BankAccount(String owner, String id, int balance) {
    this.owner = owner;
    this.id = id;
    this.balance = balance;
  }
  
  public String getOwner() {
    return owner;
  }
  
  public void setOwner(String owner) {
    this.owner = owner;
  }
  
  public String getId() {
    return id;
  }
  
  public int getBalance() {
    return balance;
  }
  
  // Instead of setBalance(), there is deposit() and withdraw()
  
  public void deposit(int bal) {
    if (bal <= 0) return; // Cannot deposit negative money
    this.balance += bal;
  }
  
  public void withdraw(int bal) {
    if (bal <= 0) return; // Cannot withdraw negative money
    this.balance -= bal;
  }
  
  public boolean isOverdraft() {
    return balance < 0;
  }
  
  public void transferTo(BankAccount ba, int amount) {
    if (amount <= 0) return; // Cannot transfer negative money
    this.withdraw(amount);
    ba.deposit(amount);
  }
  
  public String toString() {
    return "BankAccount[id='" + id + "', owner='" + owner + "', balance=" + balance + "]";
  }
  
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || this.getClass() != o.getClass()) return false;
    
    BankAccount ba = (BankAccount) o;
    
    return (this.balance == ba.balance) && (this.id.equals(ba.id)) && (this.owner.equals(ba.owner));
  }
}
