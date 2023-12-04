/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.util.Arrays;
import java.util.Random;

public class SortComparison {
    public static void main(String[] args) {
        int[] arr1 = generateRandomArray(100000);
        int[] arr2 = arr1.clone();
        
        long start = System.currentTimeMillis();
        bubbleSort(arr1);
        long end = System.currentTimeMillis();
        System.out.println("Bubble Sort Time: " + (end - start) + " ms");
        System.out.println("Bubble Sort Swaps: " + bubbleSortSwaps);
        System.out.println("bubble Sort comparisons: " + bubbleSortComparisons);
        bubbleSortSwaps = 0;
        
        start = System.currentTimeMillis();
        mergeSort(arr2);
        end = System.currentTimeMillis();
        System.out.println("Merge Sort Time: " + (end - start) + " ms");
        System.out.println("Merge Sort Swaps: " + mergeSortSwaps);
    System.out.println("merge Sort comparisons: " + mergeSortComparisons);
    }
    
    private static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt();
        }
        return arr;
    }
    
    private static int bubbleSortSwaps = 0;
    static long bubbleSortComparisons = 0;
    
    
    
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
           
            for (int j = 0; j < arr.length - i - 1; j++) {
                bubbleSortComparisons++;
                if (arr[j] > arr[j+1]) {
                    bubbleSortComparisons++;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    bubbleSortSwaps++;
                }
            }
        }
    }
    
    private static int mergeSortSwaps = 0;
    
    static long mergeSortComparisons = 0;
    
    
    private static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = Arrays.copyOfRange(arr, 0, mid);
            int[] right = Arrays.copyOfRange(arr, mid, arr.length);
            
            mergeSort(left);
            mergeSort(right);
            
            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    arr[k++] = left[i++];
                    mergeSortComparisons++;
                } else {
                    arr[k++] = right[j++];
                    mergeSortSwaps += mid - i;
                }
            }
            while (i < left.length) {
                arr[k++] = left[i++];
                 mergeSortComparisons++;
            }
            while (j < right.length) {
                arr[k++] = right[j++];
                 mergeSortComparisons++;
            }
        }
    }
}