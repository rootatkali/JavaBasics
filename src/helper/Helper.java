package helper;

/**
 * Helper class for array and matrix functions.
 *
 * @author Rotem
 */
public class Helper {
  /* # PRIMITIVES TOOLS */
  
  /**
   * Compares two boolean values to test if they're equal up to the required precision.
   * @param d1 First number
   * @param d2 Second number
   * @param digits Required digits of precision
   * @return <code>true</code> if the values are equal, <code>false</code> otherwise.
   */
  public static boolean sameValue(double d1, double d2, int digits) {
    return Math.abs(d1 - d2) < Math.pow(10, -digits);
  }
  
  /**
   * Returns a pseudo-random int
   * @param lo The lowest value for the int
   * @param hi The highest value for the int
   * @return
   */
  public static int rand(int lo, int hi) {
    return (int) (Math.random() * (hi - lo + 1) + lo);
  }
  
  /* # 1D ARRAY TOOLS */
  
  /**
   * Generates new <code>int[]</code> with random values. See {@link Math#random()}.
   *
   * @param size The size of the new array.
   * @param lo   Minimum value of the random values.
   * @param hi   Maximum value of the random values.
   * @return A randomized array.
   */
  public static int[] genArr(int size, int lo, int hi) {
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = (int) (Math.random() * (hi - lo + 1) + lo);
    }
    return arr;
  }
  
  /**
   * Finds the first index of a specific integer in an array.
   *
   * @param arr The array to look in.
   * @param val The requested value.
   * @return The index of <code>val</code>'s first occurrence in the array. If not found, returns
   * <code>-1</code>.
   */
  public static int index(int[] arr, int val) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == val)
        return i;
    }
    return -1;
  }
  
  /**
   * Sees if the value <code>val</code> is found in an integer array.
   * See {@link #index(int[], int)}
   *
   * @param arr The array to look in.
   * @param val The requested value.
   * @return <code>true</code> if found, <code>else</code> otherwise.
   */
  public static boolean exist(int[] arr, int val) {
    return index(arr, val) != -1;
  }
  
  /**
   * Swaps the values with the two indexes requested in an array.
   *
   * @param arr  The requested array.
   * @param idx1 The first index.
   * @param idx2 The second index.
   */
  public static void swap(int[] arr, int idx1, int idx2) {
    int tmp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = tmp;
  }
  
  /**
   * Copies elements of array from {@code src} to {@code dst} from index {@code fromIndexSrc}
   * (inclusive) to index {@code toIndexSrc} (exclusive). Clones starting from index
   * {@code startDst}
   *
   * @param src          The source array for copying elements
   * @param dst          The destination array
   * @param fromIndexSrc Index to start copying from. Inclusive.
   * @param toIndexSrc   Index to end copying from. Exclusive.
   * @param startDst     Index to start copying to. Inclusive.
   */
  public static void copyTo(int[] src, int[] dst, int fromIndexSrc, int toIndexSrc, int startDst) {
    if (src == null) throw new NullPointerException();
    if (dst == null) throw new NullPointerException();
    if (fromIndexSrc == toIndexSrc) return;
    if (fromIndexSrc < 0) throw new ArrayIndexOutOfBoundsException("Negative index");
    if (startDst < 0) throw new ArrayIndexOutOfBoundsException("Negative index");
    if (toIndexSrc < fromIndexSrc) throw new IllegalArgumentException("Negative index range");
    if (toIndexSrc > src.length) throw new ArrayIndexOutOfBoundsException
        ("Index " + toIndexSrc + " out of bounds for length " + src.length);
    if (startDst >= dst.length) throw new ArrayIndexOutOfBoundsException("Out of bounds for dst.");
    if (toIndexSrc - fromIndexSrc - startDst > dst.length) throw new ArrayIndexOutOfBoundsException
        ("No space in array");
    
    for (int i = fromIndexSrc; i < toIndexSrc; i++) {
      dst[startDst++] = src[i];
    }
  }
  
  /**
   * Uses {@link #copyTo(int[], int[], int, int, int)} from {@code src} to {@code dst}.
   * Copies all of <code>src</code> to index {@code 0} at <code>dst</code>.
   *
   * @param src Array to copy from.
   * @param dst Array to copy to.
   */
  public static void copyTo(int[] src, int[] dst) {
    copyTo(src, dst, 0, src.length, 0);
  }
  
  /**
   * Copies elements of array from {@code src} to {@code dst} from index {@code fromIndexSrc}
   * (inclusive) to index {@code toIndexSrc} (exclusive). Clones starting from index
   * {@code startDst}.
   *
   * @param src          The source array for copying elements
   * @param dst          The destination array
   * @param fromIndexSrc Index to start copying from. Inclusive.
   * @param toIndexSrc   Index to end copying from. Exclusive.
   * @param startDst     Index to start copying to. Inclusive.
   * @param <T>          Type of arrays
   */
  public static <T> void copyTo(T[] src, T[] dst, int fromIndexSrc, int toIndexSrc, int startDst) {
    if (src == null) throw new NullPointerException();
    if (dst == null) throw new NullPointerException();
    if (fromIndexSrc == toIndexSrc) return;
    if (fromIndexSrc < 0) throw new ArrayIndexOutOfBoundsException("Negative index");
    if (startDst < 0) throw new ArrayIndexOutOfBoundsException("Negative index");
    if (toIndexSrc < fromIndexSrc) throw new IllegalArgumentException("Negative index range");
    if (toIndexSrc > src.length) throw new ArrayIndexOutOfBoundsException
        ("Index " + toIndexSrc + " out of bounds for length " + src.length);
    if (startDst >= dst.length) throw new ArrayIndexOutOfBoundsException("Out of bounds for dst.");
    if (toIndexSrc - fromIndexSrc - startDst > dst.length) throw new ArrayIndexOutOfBoundsException
        ("No space in array");
    
    for (int i = fromIndexSrc; i < toIndexSrc; i++) {
      dst[startDst++] = src[i];
    }
  }
  
  /**
   * Returns the first <code>null</code> value in an array.
   * @param arr The array to look in.
   * @param <T> The type of the array elements
   * @return the index of the first <code>null</code> value, or <code>-1</code> if not found.
   */
  public static <T> int firstNull(T[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == null) return i;
    }
    return -1;
  }
  
  /* # 2D ARRAY TOOLS */
  
  /**
   * Generates a new <code>int[][]</code> with random values in every cell. See
   * {@link #genArr(int, int, int)}
   *
   * @param r  Amount of rows in the array.
   * @param c  Amount of columns in the array.
   * @param lo Minimum value of the randomised values.
   * @param hi Maximum value of the randomised values.
   * @return A randomized matrix.
   */
  public static int[][] genMat(int r, int c, int lo, int hi) {
    int[][] mat = new int[r][];
    for (int i = 0; i < r; i++) {
      mat[i] = genArr(c, lo, hi);
    }
    return mat;
  }
  
  /**
   * Searches a matrix of ints for a value. See {@link #index(int[], int)}
   *
   * @param matrix An integer matrix
   * @param val    The requested value.
   * @return <code>true</code> if found, <code>else</code> if not.
   */
  public static boolean exist(int[][] matrix, int val) {
    for (int i = 0; i < matrix.length; i++) {
      if (exist(matrix[i], val)) return true;
    }
    return false;
  }
  
  /**
   * Converts integer matrix to String. Creates a new matrix of type Integer and uses
   * {@link #matToString(Object[][])} on it.
   *
   * @param matrix An int matrix.
   * @return A string representation of the matrix, with each item in a single row surrounded by a
   * comma and each row surrounded by a <code>NEWLINE</code>
   */
  public static String matToString(int[][] matrix) {
    Integer[][] mat = new Integer[matrix.length][matrix[0].length];
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        mat[i][j] = matrix[i][j];
      }
    }
    return matToString(mat);
  }
  
  /**
   * Converts character matrix to String. Creates a new matrix of type Character and uses
   * {@link #matToString(Object[][])} on it.
   *
   * @param matrix A char matrix.
   * @return A string representation of the matrix, with each item in a single row surrounded by a
   * comma and each row surrounded by a <code>NEWLINE</code>
   */
  public static String matToString(char[][] matrix) {
    Character[][] mat = new Character[matrix.length][matrix[0].length];
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        mat[i][j] = matrix[i][j];
      }
    }
    return matToString(mat);
  }
  
  /**
   * Converts double matrix to String. Creates a new matrix of type Double and uses
   * {@link #matToString(Object[][])} on it.
   *
   * @param matrix A double matrix.
   * @return A string representation of the matrix, with each item in a single row surrounded by a
   * comma and each row surrounded by a <code>NEWLINE</code>
   */
  public static String matToString(double[][] matrix) {
    Double[][] mat = new Double[matrix.length][matrix[0].length];
    for (int i = 0; i < mat.length; i++) {
      for (int j = 0; j < mat[i].length; j++) {
        mat[i][j] = matrix[i][j];
      }
    }
    return matToString(mat);
  }
  
  /**
   * Converts matrix to String.
   *
   * @param matrix The matrix, of a non-primitive type.
   * @param <T>    The type of the matrix.
   * @return A string representation of the matrix, with each item in a single row followed by a
   * comma and each row followed by a <code>NEWLINE</code>
   */
  public static <T> String matToString(T[][] matrix) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < matrix.length; i++) {
      sb.append("[");
      for (int j = 0; j < matrix[i].length; j++) {
        sb.append(matrix[i][j]);
        if (j < matrix[i].length - 1) {
          sb.append(", ");
        }
      }
      sb.append((i == (matrix.length - 1)) ? "]" : "],\n");
    }
    return sb.toString().strip();
  }
}
