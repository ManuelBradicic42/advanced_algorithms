package org.com2031.lab4;

import java.util.Arrays;
import java.util.Comparator;

public class IntervalScheduling {

	static class Interval {
		final int start;
		final int finish;
		final String name;
		
		Interval(String name, int start, int finish){
			this.start = start;
			this.finish = finish;
			this.name = name;
		}
		
		@Override
		public String toString() {
			return name + ":[" + start + "," + finish + "]";
		}
	}
	
	static Interval[] schedule(Interval[] intervals) {
		
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval first, Interval second) {
				return first.finish - second.finish;
			}
		});
		
		Interval[] schedule = new Interval[intervals.length];
		int nextStart = 0;
		int counter = 0;
		for(Interval i : intervals) {
			if(i.start >= nextStart) {
				schedule[counter] = i;
				nextStart = i.finish;
				counter++;
			}
		}
		
		Interval[] ans = new Interval[counter];
		for (int i = 0; i < counter; i++) {
			ans[i] = schedule[i];
		}
		
		return ans;		
	}
//  Utilities for testing	
	
	
	public static void printArray(Interval[] a) {
		System.out.print("{");
		for(int i = 0; i< a.length-1; i++) {
			System.out.print(a[i] + ", ");			
		}
			if(a.length>0) {
				System.out.print(a[a.length - 1]);
		
			}
		System.out.print("}");
	}
	
	public static void testIntervalScheduling(String name, Interval[] test, Interval[] expected){
	    Interval[] output;
	    output = schedule(test);
	    if (Arrays.equals(output, expected)){
	    	System.out.println("  Pass:   "+name);
	    }
	    else {
	    	System.out.println("*********************");	    	
	    	System.out.println("  Fail:   "+name);
	    	System.out.print("  Input:    ");
	    	printArray(test);
	    	System.out.println();
	    	System.out.print("  Expected Result: ");
	    	printArray(expected);
	    	System.out.println();
	    	System.out.print("  Actual Result:   ");
	    	printArray(output);
	    	System.out.println();	    	
	    	System.out.println("*********************");
	    }
//	    System.out.print("\n");
	}
	
	
	
	/**
	 * Test the scheduling algorithms on a sample data set.
	 * 
	 * @param args
	 *            unused
	 */
	public static void main(String[] args) {

// Some intervals to build tests
		
		Interval a = new Interval("a", 0, 6);
		Interval b = new Interval("b", 1, 4);
		Interval c = new Interval("c", 3, 5);
		Interval d = new Interval("d", 3, 8);
		Interval e = new Interval("e", 4, 7);
		Interval f = new Interval("f", 5, 9);
		Interval g = new Interval("g", 6, 10);
		Interval h = new Interval("h", 8, 11);
		Interval j = new Interval("j", 8, 14);
		Interval k = new Interval("k", 13, 18);
		Interval l = new Interval("l", 15, 22);	
		
// Test cases
		Interval[] intervals1 = {a,b,c,d,e,f,g,h};
		Interval[] expected1 = {b,e,h};
		testIntervalScheduling("test1",intervals1,expected1);
		Interval[] i2 = {c,d,e,f,g,h,j,k};
		Interval[] e2 = {c,f,k};
		testIntervalScheduling("test2",i2,e2);
		Interval[] i3 = {c,e,f,g,k,a};
		Interval[] e3 = {c,f,k};
		testIntervalScheduling("test3",i3,e3);
		Interval[] i4 = {a,b,c,d};
		Interval[] e4 = {b};
		testIntervalScheduling("test4",i4,e4);
		Interval[] i5 = {a,b,c,d,e,f,g,h,j,k,l};
		Interval[] e5 = {b,e,h,k};
		testIntervalScheduling("test5",i5,e5);
		Interval[] i6 = {l,k,j,h,g};
		Interval[] e6 = {g,k};
		testIntervalScheduling("test6",i6,e6);
		Interval[] i7 = {e};
		Interval[] e7 = {e};
		testIntervalScheduling("test7",i7,e7);
		Interval[] i8 = {};
		Interval[] e8 = {};
		testIntervalScheduling("test8",i8,e8);
		
	}
	
}

