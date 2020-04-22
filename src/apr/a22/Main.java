package apr.a22;

public class Main {
  public static void main(String[] args) {
    Basket maccabi = new Basket("Maccabi Tel Aviv", new int[]{5, 19, 4, 2, 6},
        5, 19, 4, 2, 6, 3, 7, 10, 12, 11, 99);
    System.out.println(maccabi);
    
    maccabi.exchange(2, 3);
    System.out.println(maccabi);
    
    maccabi.addPlayers(1, 20);
    System.out.println(maccabi);
    
    maccabi.setInGame();
    System.out.println(maccabi);
  }
}
