import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * This is the package for BinarySearch.java
 *
 * The BinarySearch program makes an array
 * it shows the sorted array of 10 ints in numerical order,
 * and asks the user for a number to search for.
 * It then searches for the number in the array using binary search
 * and displays the index it is in
 *
 * <p>This class satisfies style checkers.</p>
 *
 * @version 1.0
 * @since 2025-03-28
 */

public final class BinarySearch {

    /**
     * The size of the array to be populated. */
    private static final int ARRAYSIZE = 10;

    /**
     * This is a private constructor to satisfy style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private BinarySearch() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args unused.
     */
    public static void main(final String[] args) {
        // create random number generator
        Random rand = new Random();
        // create array of ints
        int[] arrayOfInts = new int[ARRAYSIZE];
        // Creates scanner object
        Scanner scanner = new Scanner(System.in);
        // initialize search variable
        String search;
        do {
            // populate array with random numbers
            for (int i = 0; i < ARRAYSIZE; i++) {
                arrayOfInts[i] = rand.nextInt(100);
            }

            // sort array
            Arrays.sort(arrayOfInts);
            // prints sorted array
            System.out.print("Sorted array: ");
            System.out.println(Arrays.toString(arrayOfInts));
            System.out.print("Enter a number to search for, ");
            System.out.println("or q to quit: ");
            // get user input
            search = scanner.nextLine().toLowerCase();
            // check if user wants to quit
            if (search.equals("q")) {
                break;
            } else {
                // check if input is a number
                try {
                    int searchInt = Integer.parseInt(search);
                    // binary search
                    int low = 0;
                    int high = arrayOfInts.length - 1;
                    while (low <= high) {
                        int mid = (low + high) / 2;
                        if (arrayOfInts[mid] == searchInt) {
                            // print index of number
                            System.out.println("Number found at index: " + mid);
                            break;
                        } else if (arrayOfInts[mid] < searchInt) {
                            low = mid + 1;
                        } else {
                            high = mid - 1;
                        }
                    }
                    // if number not found
                    if (low > high) {
                        System.out.println("Number not found in the array.");
                    }
                } catch (NumberFormatException ex) {
                    // Catch exception if input is not a number
                    System.out.println("Invalid input. Enter a number.");
                }
            }

        // close scanner
        } while (!search.equals("q"));
        scanner.close();
        // print goodbye message
        System.out.println("Goodbye!");
    }
}
