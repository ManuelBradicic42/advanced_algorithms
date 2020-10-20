package org.com2031.lab3;

import java.util.Arrays;

public class MergeSort {

	/**
	 * 
	 * @param arr an array of integers
	 * @return  array of the integers n arr in sorted order
	 */
	
	public static int[] mergeSort(int[] arr) {
		
		if(arr.length == 0)  {
			return arr;
		}else {
			return dac_mergeSort(arr, 0, arr.length);
		}
	}
	
	/**
	 * 
	 * @param arr    array of integers
	 * @param start  an index of arr
	 * @param end    index such that end-1 is an index of arr greater than or equal to start, 
	 * @return       array of the integers in arr where the elements are sorted between start (inclusive) and end (exclusive)
	 */
	public static int[] dac_mergeSort(int[] arr, int start, int end) {
	// BASE CASE
	if(start == end - 1) {
		int[] ans =  {arr[start]};
		return ans;
	}
	else { // DIVIDE
		int mid = (start + end)/2;
		return merge(dac_mergeSort(arr, start, mid), dac_mergeSort(arr, mid, end));
	}
	}
	
	/**
	 * 
	 * @param arr1  sorted list of integers
	 * @param arr2  sorted list of integers
	 * @return      sorted list of all the integers in arr1 and arr2
	 */
	
	public static int[] merge(int[] arr1, int[] arr2) {
		// COMBINE
		int length;
		length = arr1.length + arr2.length;
		int[] arr = new int[length];
		int l = 0;
		int r = 0;
		while(l < arr1.length && r < arr2.length) {
			if(arr1[l] < arr2[r]) {
				arr[l+r] = arr1[l];
				l+=1;
			}
			else {
				arr[l+r] = arr2[r];
				r+=1;
			}
		}
		while(l < arr1.length) {
			arr[l+r] = arr1[l];
			l++;
		}
		while(r < arr2.length) {
			arr[l+r] = arr2[r];
			r++;
		}
		return arr;
	
	}
	
/**********************
 * 
 * Utilities for testing
 * 
 */
	
	public static void printArray(int[] a) {
		System.out.print("{");
		for(int i = 0; i< a.length-1; i++) {
			System.out.print(a[i] + ", ");			
		}
			if(a.length>0) {
				System.out.print(a[a.length - 1]);
		
			}
		System.out.print("}");
	}
		

	
	public static void testMergeSort(String name, int[] test, int[] expected){
	    int[] test2;
	    test2 = mergeSort(test);
	    if (Arrays.equals(test2, expected)){
	    	System.out.println("  Pass:   "+name);
	    }
	    else {
	    	System.out.println("*********************");	    	
	    	System.out.println("  Fail:   "+name);
	    	System.out.print("  Input:    ");
	    	printArray(test);
	    	System.out.println();
	    	System.out.print("  Expected: ");
	    	printArray(expected);
	    	System.out.println();
	    	System.out.print("  Actual:   ");
	    	printArray(test2);
	    	System.out.println();	    	
	    	System.out.println("*********************");
	    }
//		    System.out.print("\n");
	}
	
	
	public static void main(String[] args) {

		// allocate two arrays
		int[] s1 = {2, 1, 4, 3, 6, 5};
		int[] t1 = {1, 2, 3, 4, 5, 6};
		testMergeSort("test1", s1, t1);
		int[] s2 = {8,6,8,6,4,4,2};
		int[] t2 = {2,4,4,6,6,8,8};
		testMergeSort("test2", s2, t2);
		int[] s3 = {1};
		int[] t3 = {1};
		testMergeSort("test3", s3, t3);
		int[] s4 = {3,3,4,3,3,3};
		int[] t4 = {3,3,3,3,3,4};
		testMergeSort("test4", s4, t4);
		int[] s5 = {9,7,5,3,1};
		int[] t5 = {1,3,5,7,9};
		testMergeSort("test5", s5, t5);
		int[] s6 = {};
		int[] t6 = {};
		testMergeSort("test6", s6, t6);
	}


}
