package may.m20;

public class Book {
  private String name;
  private int shelf;
  private boolean interesting;
  
  public Book(String name, int shelf, boolean interesting) {
    this.name = name;
    this.shelf = shelf;
    this.interesting = interesting;
  }
  
  public Book(Book b) {
    this(b.name, b.shelf, b.interesting);
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int getShelf() {
    return shelf;
  }
  
  public void setShelf(int shelf) {
    this.shelf = shelf;
  }
  
  public boolean isInteresting() {
    return interesting;
  }
  
  public void setInteresting(boolean interesting) {
    this.interesting = interesting;
  }
  
  @Override
  public String toString() {
    return "Book{" +
        "name='" + name + '\'' +
        ", shelf=" + shelf +
        ", interesting=" + interesting +
        '}';
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    Book book = (Book) o;
    
    if (getShelf() != book.getShelf()) return false;
    if (isInteresting() != book.isInteresting()) return false;
    return getName().equals(book.getName());
  }
}
