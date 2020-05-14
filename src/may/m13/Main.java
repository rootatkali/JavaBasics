package may.m13;

import helper.Helper;

public class Main {
  public static void main(String[] args) {
    Plant[] plants = new Plant[10];
    for (int i = 0; i < plants.length; i++) {
      plants[i] = new Plant(
          Math.random() > 0.5,
          Helper.rand(1, 100),
          Helper.rand(25, 75)
      );
      System.out.println(plants[i]);
    }
    
    Garden garden = new Garden("Gan Miklat", "HaKfar HaYarok", 8);
    garden.addPlants(plants);
    System.out.println(garden);
  }
}
