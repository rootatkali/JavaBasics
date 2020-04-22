package apr.a22;

import java.util.Arrays;
import java.util.Objects;

public class Basket {
  private String name;
  private int[] inGame;
  private int[] allPlayers;
  
  // Copies the contents of an array into a new array - private method
  private int[] copy(int[] arr) {
    if (arr == null) return null;
    
    int[] copy = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      copy[i] = arr[i];
    }
    return copy;
  }
  
  // Performs a linear search
  private int index(int[] arr, int val) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == val) {
        return i;
      }
    }
    return -1;
  }
  
  public Basket(String name, int[] inGame, int... allPlayers) {
    this.name = name;
    
    // Input validation
    if (inGame == null) {
      this.inGame = null;
    } else {
      if (inGame.length != 5) throw new IllegalArgumentException("Illegal player number.");
      for (int i = 0; i < 5; i++) {
        if (index(allPlayers, inGame[i]) == -1) {
          throw new IllegalArgumentException("Player " + inGame[i] + " not in group.");
        }
      }
      this.inGame = copy(inGame);
    }
    
    this.allPlayers = copy(allPlayers);
  }
  
  public Basket(Basket b) {
    this(b.name, b.inGame, b.allPlayers);
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int[] getInGame() {
    return copy(inGame);
  }
  
  public void setInGame(int... inGame) {
    if (inGame == null || inGame.length == 0) {
      this.inGame = null;
      return;
    }
    // Input validation
    if (inGame.length != 5) throw new IllegalArgumentException("Illegal player number.");
    for (int i = 0; i < 5; i++) {
      if (index(allPlayers, inGame[i]) == -1) {
        throw new IllegalArgumentException("Player " + inGame[i] + " not in group.");
      }
    }
    this.inGame = copy(inGame);
  }
  
  public int[] getAllPlayers() {
    return copy(allPlayers);
  }
  
  public void setAllPlayers(int... allPlayers) {
    this.allPlayers = copy(allPlayers);
  }
  
  public void exchange(int out, int in) {
    int outIndex = index(inGame, out);
    int inIndex = index(allPlayers, in);
    
    if (outIndex == -1) throw new IllegalArgumentException("Player not playing.");
    if (inIndex == -1) throw new IllegalArgumentException("Player not in group");
    
    inGame[outIndex] = allPlayers[inIndex];
  }
  
  public void addPlayer(int shirt) {
    if (index(allPlayers, shirt) != -1) throw new IllegalArgumentException("Player already added.");
    
    int[] newGroup = new int[allPlayers.length + 1];
    
    for (int i = 0; i < allPlayers.length; i++) { // Copy contents
      newGroup[i] = allPlayers[i];
    }
    newGroup[allPlayers.length] = shirt;
    
    allPlayers = newGroup;
  }
  
  public void addPlayers(int... shirts) {
    for (int shirt : shirts) {
      addPlayer(shirt);
    }
  }
  
  @Override
  public String toString() {
    return "Basket{" + "name='" + name + '\'' + ", inGame=" + Arrays.toString(inGame) + ", " +
        "allPlayers=" + Arrays.toString(allPlayers) + '}';
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Basket b = (Basket) o;
    return name.equals(b.name) && Arrays.equals(inGame, b.inGame) && Arrays.equals(allPlayers,
        b.allPlayers);
  }
}
