package mar.m30;

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
    this(d.day, d.month, d.year); // Better way to use this constructor
    /*
    this.day = d.day; // Because I'm accessing from the Date class, I can use d.day
    this.month = d.month;
    this.year = d.year;
     */
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
    if (d.year < year) return false;
    if (d.month < month) return false;
    if (d.month > month) return true;
    return d.day > day;
  }
  
  public boolean isAfter(Date d) {
    return !(this.isBefore(d) || this.equals(d)); // If not before or same, then is after
  }
  
  public void add(int days) {
    int absDays = this.year * 360 + this.month * 30 + this.day + days;
    this.year = absDays / 360;
    this.month = (absDays % 360 + 1) / 30;
    this.day = absDays % 30;
  }
  
  public int days(Date d) {
    int days = 0;
    days += (d.year - this.year) * 360;
    days += (d.month - this.month) * 30;
    days += d.day - this.day;
    return days;
  }
  
  public void copy(Date d) {
    this.day = d.day;
    this.month = d.month;
    this.year = d.year;
  }
  
  /**
   * Returns a string representation of the Date.
   *
   * @param delimiter The separator between the date, the month and the year, e.g "/" or "."
   * @return The date in dd MM yyyy format.
   */
  public String format(String delimiter) {
    return (day > 9 ? day : "0" + day) // if (day > 9) day else "0" + day
        + delimiter
        + (month > 9 ? month : "0" + month) // if (month > 9) month else "0" + month
        + delimiter
        + year;
  }
  
  /**
   * Formats the date using the default delimiter, "/".
   *
   * @return The date in dd/MM/yyyy format.
   */
  public String format() {
    return format("/");
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
