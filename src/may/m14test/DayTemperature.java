package may.m14test;

import mar.m30.Date;

import java.util.Arrays;

public class DayTemperature {
  private Date day;
  private int[] temperature;
  
  // Not part of test
  private int[] copy(int[] arr) {
    int[] ret = new int[arr.length];
    System.arraycopy(arr, 0, ret, 0, arr.length);
    return ret;
  }
  
  // Not part of test
  public DayTemperature(Date day, int[] temperature) {
    this.day = new Date(day);
    this.temperature = copy(temperature);
  }
  
  // Question 2
  public DayTemperature(DayTemperature dt) {
    /*
     * Copy Constructor. We assume that DayTemperature.getDay() returns a new instance of Date, and that
     * DayTemperature.getTemperature() returns a new array.
     */
    this.day = dt.getDay();
    this.temperature = dt.getTemperature();
  }
  
  // vvv Not part of test vvv
  
  public Date getDay() {
    return new Date(day);
  }
  
  public void setDay(Date day) {
    this.day = new Date(day);
  }
  
  public int[] getTemperature() {
    return copy(temperature);
  }
  
  public void setTemperature(int[] temperature) {
    this.temperature = copy(temperature);
  }
  
  @Override
  public String toString() {
    return "DayTemperature{" +
        "day=" + day +
        ", temperature=" + Arrays.toString(temperature) +
        '}';
  }
}
