package may.m20;

import java.util.Arrays;

public class Library {
  private Book[] arrBooks;
  
  private Book[] copy(Book[] arr) {
    Book[] ret = new Book[arr.length];
    for (int i = 0; i < arr.length; i++) {
      ret[i] = new Book(arr[i]);
    }
    return ret;
  }
  
  public Library(Book[] arrBooks) {
    this.arrBooks = copy(arrBooks);
  }
  
  public Book[] getArrBooks() {
    return copy(arrBooks);
  }
  
  public void setArrBooks(Book[] arrBooks) {
    this.arrBooks = copy(arrBooks);
  }
  
  public boolean isInteresting(int shelf) {
    int ctr = 0;
    for (int i = 0; i < arrBooks.length; i++) {
      if (arrBooks[i] != null) {
        if (arrBooks[i].getShelf() == shelf) {
          ctr += (arrBooks[i].isInteresting() ? 1 : -1);
        }
      }
    }
    return ctr >= 0;
  }
  
  /**
   * @return The shelf with the most books on it.
   */
  public int maxShelf() {
    int[] shelves = new int[101]; // 1~100 + 0
    int max = 1;
    Arrays.fill(shelves, 0);
    
    // First scan - on booksArr
    for (int i = 0; i < arrBooks.length; i++) {
      if (arrBooks[i] != null) {
        shelves[arrBooks[i].getShelf()]++;
      }
    }
    
    // Second scan - for shelves. Loop from 1 because 0 does not count for the purposes of this method.
    for (int i = 1; i < shelves.length; i++) {
      if (shelves[i] >= shelves[max]) max = i;
    }
    
    return max;
  }
  
  @Override
  public String toString() {
    return "Library{" +
        "arrBooks=" + Arrays.toString(arrBooks) +
        '}';
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    Library library = (Library) o;
    return Arrays.equals(getArrBooks(), library.getArrBooks());
  }
}
