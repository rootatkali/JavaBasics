package may.m05;

import mar.m30.Date;

public class Passport {
  private String name;
  private String lastName;
  private String number;
  private Date issueDate;
  private Date expDate;
  private Date birth;
  private String id;
  
  public Passport(String name, String lastName, String number, Date issueDate, Date expDate, Date birth, String id) {
    this.name = name;
    this.lastName = lastName;
    this.number = number;
    this.issueDate = new Date(issueDate);
    this.expDate = new Date(expDate);
    this.birth = new Date(birth);
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getLastName() {
    return lastName;
  }
  
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  
  public String getNumber() {
    return number;
  }
  
  public void setNumber(String number) {
    this.number = number;
  }
  
  public Date getIssueDate() {
    return new Date(issueDate);
  }
  
  public void setIssueDate(Date issueDate) {
    this.issueDate = new Date(issueDate);
  }
  
  public Date getExpDate() {
    return new Date(expDate);
  }
  
  public void setExpDate(Date expDate) {
    this.expDate = new Date(expDate);
  }
  
  public Date getBirth() {
    return new Date(birth);
  }
  
  public void setBirth(Date birth) {
    this.birth = new Date(birth);
  }
  
  public String getId() {
    return id;
  }
  
  public void setId(String id) {
    this.id = id;
  }
  
  @Override
  public String toString() {
    return "Passport{" 
        + "name='" + name + "'" 
        + ", lastName='" + lastName + "'" 
        + ", number='" + number + "'" +
        ", issueDate=" + issueDate.format() 
        + ", expDate=" + expDate.format() 
        + ", birth=" + birth.format() +
        ", id='" + id + "'" 
        + '}';
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    Passport p = (Passport) o;
    
    return name.equals(p.name) && lastName.equals(p.lastName) && number.equals(p.number)
        && issueDate.equals(p.issueDate) && expDate.equals(p.expDate) && birth.equals(p.birth) && id.equals(p.id);
  }
}
