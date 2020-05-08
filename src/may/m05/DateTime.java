package may.m05;

import mar.m30.Date;
import mar.m30.Time;

public class DateTime {
  private Date date;
  private Time time;
  
  public DateTime(Date date, Time time) {
    this.date = new Date(date);
    this.time = new Time(time);
  }
  
  /**
   * Constructs a DateTime object from date and time values (dd/MM/yyyy HH:mm:ss)
   */
  public DateTime(int dd, int MM, int yyyy, int HH, int mm, int ss) {
    this(new Date(dd, MM, yyyy), new Time(HH, mm, ss));
  }
  
  public DateTime(DateTime dt) {
    this.date = new Date(dt.date);
    this.time = new Time(dt.time);
  }
  
  public Date getDate() {
    return new Date(date);
  }
  
  public void setDate(Date date) {
    this.date = new Date(date);
  }
  
  public Time getTime() {
    return new Time(time);
  }
  
  public void setTime(Time time) {
    this.time = new Time(time);
  }
  
  @Override
  public String toString() {
    return "DateTime{" + "date=" + date.format() + ", time=" + time.format() + '}';
    // Date::format -> dd/MM/yyyy
    // Time::format -> HH:mm:ss
  }
  
  public boolean isBefore(DateTime dt) {
    if (date.equals(dt.date)) {
      return time.isBefore(dt.time);
    }
    return date.isBefore(dt.date);
  }
  
  public boolean isAfter(DateTime dt) {
    return !(isBefore(dt) || equals(dt));
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
  
    DateTime d = (DateTime) o;
  
    return (date == d.date && time == d.time) || (d.date.equals(date) && d.time.equals(time));
  }
}
