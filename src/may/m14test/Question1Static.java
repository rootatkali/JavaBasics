package may.m14test;

public class Question1Static {
  // Question 1.E
  public static int topVolunteer(VolunteerWork[] arr) {
    // Count top volunteers
    
    int ret = 0; // Counting
  
    // Loop for array
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].isFinish(30).equals("מצטיין")) { // Required hours is 30.
        ret++;
      }
    }
    
    return ret;
  }
  
  // Question 1.F
  public static int inPlace(VolunteerWork[] arr, String place) {
    // Count volunteers in place
    
    int count = 0;
  
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].getPlace().equals(place)) {
        count++;
      }
    }
    
    return count;
  }
  
  // Question 1.G
  public static void weHaveProblem(VolunteerWork[] arr) {
    // Print volunteer(s) with least hours
    
    int min = arr[0].getHours();
    
    // First loop - Find minimum hours
    for (int i = 1; i < arr.length; i++) { // Start from one to not check arr[0].getHours() < arr[0].getHours()
      if (arr[i].getHours() < min) {
        min = arr[i].getHours();
      }
    }
    
    // Second loop - Print
    for (int i = 0; i < arr.length; i++) {
      if (arr[i].getHours() == min) {
        System.out.println(arr[i]);
      }
    }
  }
}
