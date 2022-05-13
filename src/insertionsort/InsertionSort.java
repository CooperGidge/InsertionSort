/*
 * InsertionSort.java
 * ICS4U
 */
package insertionsort;

// Being used to get user input without a Scanner
import javax.swing.*;

/**
 *
 * @author cogid4775
 */
public class InsertionSort {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Allow the user to input the array size. Hold their answer in `int arraySize`
        int arraySize = Integer.parseInt(JOptionPane.showInputDialog("How many random numbers do you want to generate?"));
        
        // Create array with size `int arraySize`
        int arr[] = new int[arraySize];
        
        // Fill the array with random values
        arr = fillArrayRandomly(arr);
        
        // Display the unsorted array
        System.out.println("Unsorted array:");
        printArr(arr);
        
        // Tell the user the array is going to be sorted
        // This is done before the current time is logged to increase accuracy
        System.out.println("\nSorting the array using insertion sort...");
        
        // Store current time
        // To calculate the time it took to sort later
        // This is done right before the array is sorted to increase accuracy
        long time = System.currentTimeMillis();
        
        // Sort the array
        arr = insertionSort(arr);
                
        // Calculate the time it took to sort
        // This is done right after the array is sorted to increase accuracy
        time = System.currentTimeMillis() - time;
        
        // Display the sorted array
        System.out.println("\nSorted array:");
        printArr(arr);
        
        // Display how long it took to sort the array
        System.out.println("\nIt took " + time + " milliseconds (" + ((double) time/1000) + " seconds) to sort the array using insertion sort.");
    }
    
    /**
     * Sort an array
     * @param array the array to sort
     */
    public static int[] insertionSort(int[] array) {
        // Run insertion sort algorithm
        // Loop through each element
        for (int j = 1; j < array.length; j++) {
            int temp = array[j];
            int possibleIndex = j;
            while (possibleIndex > 0 && temp < array[possibleIndex - 1]) {
                array[possibleIndex] = array[possibleIndex - 1];
                possibleIndex--;
            }
            array[possibleIndex] = temp;
        }
        // Return sorted array
        return array;
    }
    
    /**
     * Fill an array with random numbers
     * @param array the array to fill with random numbers between 0 and 999
     */
    public static int[] fillArrayRandomly(int[] array) {
        // Loop through each element
        for (int i = 0; i < array.length; i++) {
            // Assign each element a random value between 0 and 999
            array[i] = (int) (Math.random() * 1000);
        }
        // Return randomly filled array
        return array;
    }
    
    /**
     * Print an array
     * @param array the array to print
     */
    public static void printArr(int[] array) {
        // Loop through each element in the array
        for (int i = 0; i < array.length; i++) {
            // Print the value of the element
            System.out.println(array[i]);
        }
    }
    
}