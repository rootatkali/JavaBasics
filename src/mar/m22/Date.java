package mar.m22;

public class Date {
  private int day;
  private int month;
  private int year;
  
  public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }
  
  public Date(Date d) {
    this.day = d.day; // Because I'm accessing from the Date class, I can use d.day
    this.month = d.month;
    this.year = d.year;
  }
  
  public int getDay() {
    return day;
  }
  
  public void setDay(int day) {
    this.day = day;
  }
  
  public int getMonth() {
    return month;
  }
  
  public void setMonth(int month) {
    this.month = month;
  }
  
  public int getYear() {
    return year;
  }
  
  public void setYear(int year) {
    this.year = year;
  }
  
  public boolean isBefore(Date d) {
    if (d.year > year) return true;
    else if (d.month > month) return true;
    else return d.day > day;
  }
  
  public boolean isAfter(Date d) {
    return !(this.isBefore(d) || this.equals(d)); // If not before or same, then is after
  }
  
  public String toString() {
    return "Date[day=" + day + ", month=" + month + ", year=" + year + "]"; // Proper toString()
  }
  
  public boolean equals(Object o) {
    // Checks for memory pointer, null pointer and type
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    // Standard comparison
    Date date = (Date) o;
    return (day == date.day) && (month == date.month) && (year == date.year);
  }
}
