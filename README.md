# JavaBasics
 Java classes for Meir class.
 
 Rights for the libs belong to Meir Licht.


## Repository Structure
View the Meir libraries at `lib/`

You can view the files at `src/MONTH/DATE`.  
For example: `src/feb/f19/...`

## The `helper.Helper` Class
The class has some useful methods for arrays and other features. Examples include: 

* 2D array `toString`
* Cloning arrays
* Generating random arrays

And more.

To use the Helper class:
1. Copy the file from `helper` folder to a folder called `helper` on your project.
2. Type on the top of your line:
    ```java
    import helper.Helper;
    ```
3. Type in your classes:
    ```java
    int[] arr = Helper.genArr(10, 0, 9);
    int[][] mat = Helper.genMat(10, 10, 0, 1);
    ```