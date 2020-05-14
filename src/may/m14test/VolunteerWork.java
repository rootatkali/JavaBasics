package may.m14test;

public class VolunteerWork {
  private String name;
  private String place;
  private int hours;
  
  
  public VolunteerWork(String name, String place, int hours) {
    this.name = name;
    this.place = place;
    this.hours = hours;
  }
  
  // Question 1.A
  public VolunteerWork(VolunteerWork v) {
    // Copy constructor
    name = v.getName();
    hours = v.getHours();
    place = v.getPlace();
  }
  
  // Question 1.B
  public boolean equals(VolunteerWork other) {
    // Lazy equals using toString()
    return toString().equals(other.toString());
  }
  
  // Question 1.C
  public void addHours(int n) {
    // Add hours to total
    hours += n;
  }
  
  // Question 1.D
  public String isFinish(int num) {
    // Return finish status
    if (hours > num) return "מצטיין";
    if (hours == num) return "סיים"; // Implicit "else"
    return "לא סיים"; // Implicit "else"
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getPlace() {
    return place;
  }
  
  public void setPlace(String place) {
    this.place = place;
  }
  
  public int getHours() {
    return hours;
  }
  
  public void setHours(int hours) {
    this.hours = hours;
  }
  
  @Override
  public String toString() {
    return "VolunteerWork{" +
        "name='" + name + '\'' +
        ", place='" + place + '\'' +
        ", hours=" + hours +
        '}';
  }
}
