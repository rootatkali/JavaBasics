package may.m13;

import helper.Helper;

import java.util.Arrays;
import java.util.Objects;

public class Garden {
  private String name;
  private String owner;
  private Plant[] plants;
  
  private Plant[] copy(Plant[] arr) {
    Plant[] ret = new Plant[arr.length];
    for (int i = 0; i < arr.length; i++) {
      ret[i] = new Plant(arr[i]);
    }
    return ret;
  }
  
  public Garden(String name, String owner, int size) {
    this.name = name;
    this.owner = owner;
    this.plants = new Plant[size];
  }
  
  public Garden(Garden g) {
    name = g.getName();
    owner = g.getOwner();
    plants = copy(g.getPlants());
  }
  
  public void addPlant(Plant p) {
    int index = Helper.firstNull(plants);
    if (index < 0) return;
    plants[index] = new Plant(p);
  }
  
  public void addPlants(Plant... plants) {
    for (Plant p : plants) {
      addPlant(p);
    }
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getOwner() {
    return owner;
  }
  
  public void setOwner(String owner) {
    this.owner = owner;
  }
  
  public Plant[] getPlants() {
    return copy(plants);
  }
  
  @Override
  public String toString() {
    return "Garden{" +
        "name='" + name + '\'' +
        ", owner='" + owner + '\'' +
        ", plants=" + Arrays.toString(plants) +
        '}';
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    Garden g = (Garden) o;
    return name.equals(g.getName()) && owner.equals(g.getOwner()) && Arrays.equals(plants, g.getPlants());
  }
}
