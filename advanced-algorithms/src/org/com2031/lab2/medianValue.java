package org.com2031.lab2;

import java.util.ArrayList;
import java.util.Arrays;

public class medianValue {

	public static Integer findMedian(ArrayList<Integer> arr) {
		ArrayList<Integer> sortedArray = new ArrayList<Integer>();
		sortedArray = quickSort(arr);
		
		int size = sortedArray.size();
		int n = (int) size/2;

		if(size%2 == 1) {
			return dac_kthSmallest(n+1, sortedArray);
		}
		else{
			int value1 = dac_kthSmallest(n, sortedArray);
			int value2 = dac_kthSmallest(n+1, sortedArray);
			return (value1 + value2)/2;
		}
		

	}
	/**
	 * 
	 * ------------ QUICK SORT ------------
	 *
	 */
	public static ArrayList<Integer> quickSort(ArrayList<Integer> arr){
		return dac_quickSort(arr);
	}
	
	public static ArrayList<Integer> dac_quickSort(ArrayList<Integer> arr){
		if(arr.size() <= 1) {
			return arr;
		}
		else {
			int pivot = arr.get(0);
			ArrayList<Integer> leftarr = new ArrayList<Integer>();
			ArrayList<Integer> rightarr = new ArrayList<Integer>();
			for(int i=1; i<arr.size(); i++) {
				if(arr.get(i) < pivot) {
					leftarr.add(arr.get(i));
				}
				else if(arr.get(i) >= pivot) {
					rightarr.add(arr.get(i));
				}
			}
			ArrayList<Integer> sortedLeft = dac_quickSort(leftarr);
			ArrayList<Integer> sortedRight = dac_quickSort(rightarr);
			
			ArrayList<Integer> sortedCombine = new ArrayList<>();
			
			sortedCombine.addAll(sortedLeft);
			sortedCombine.add(pivot);
			sortedCombine.addAll(sortedRight);
			return sortedCombine;
		}
	}
	
	/**
	 * 
	 * ------------ KthSmallest ------------
	 *
	 */
	
	public static Integer kthSmallest(int k, ArrayList<Integer> arr) {
		return dac_kthSmallest(k, arr);
	}
	
	public static Integer dac_kthSmallest(int k, ArrayList<Integer> arr) {
		if(arr.size() == 0) {
			return null;
		}
		else if(arr.size() == 1) {
			return arr.get(0);
		}
		else {
			int pivot = arr.get(0);
			ArrayList<Integer> leftarr = new ArrayList<Integer>();
			ArrayList<Integer> rightarr = new ArrayList<Integer>();
			
			for(int i=1; i<arr.size(); i++) {
				if(arr.get(i) <= pivot) {
					leftarr.add(arr.get(i));
				}
				else if(arr.get(i) > pivot) {
					rightarr.add(arr.get(i));
				}
			}
			
			if(leftarr.size() >= k) {
				return dac_kthSmallest(k, leftarr);
			}
			else if(leftarr.size() + 1 == k) {
				ArrayList<Integer> pivotList = new ArrayList<Integer>(Arrays.asList(pivot));
				return dac_kthSmallest(k, pivotList);
			}
			else {
				k -= (leftarr.size() + 1 );
				return dac_kthSmallest(k, rightarr);
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		ArrayList<Integer> s = new ArrayList<>(Arrays.asList(0, 2, 4, 6, 8, 10, 12, 14));
		System.out.println(findMedian(s));
		
	}

}
