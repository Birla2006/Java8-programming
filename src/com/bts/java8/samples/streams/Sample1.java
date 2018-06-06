package com.bts.java8.samples.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * @author birla
 * 
 */
public class Sample1 {

	public static void main(String[] args) {

		String[] items = { "pen", "sofa", "books", "pencil", "hammer", "fan",
				"paper", "paint" };

		Sample1 sample = new Sample1();
		sample.findItemsAndSortingWithAsc(items, "p");
		sample.findItemsAndSortingWithDesc(items, "p");
		sample.findItemsAndApplyMapping(items, "p");
		sample.matchingExamples(items, "pen");
		
		int[] marks = {3,5,10,20,44,66,56,71,88};
		
		sample.getSummaryStatistics(marks); ////reduction - summary statistics

	}

	/**
	 * To Demonstrate the Stream from Array, sort in Descending, filter and
	 * print
	 * 
	 * @param items
	 * @param startsWith
	 */
	private void findItemsAndSortingWithDesc(String[] items,
			String startsWith) {
		System.out.println("Find Items with Descending Order :");
		Arrays.stream(items).filter(item -> item.startsWith("p"))
				.sorted(Comparator.reverseOrder()).forEach(System.out::println);
		System.out.println();

	}

	/**
	 * To Demonstrate the Stream from Array, sort in ascending, filter and print
	 * 
	 * @param items
	 * @param startsWith
	 */
	private void findItemsAndSortingWithAsc(String[] items, String startsWith) {

		System.out.println("Find Items with Ascending Order :");
		Arrays.stream(items).filter(item -> item.startsWith("p")).sorted()
				.forEach(System.out::println);
		System.out.println();

	}

	/**
	 * To Demonstrate the Stream from Array, mapping and print. map() function
	 * returns a stream of results by applying some operations on source of
	 * stream. map() function converts source stream into other form.
	 * 
	 * @param items
	 * @param startsWith
	 */
	private void findItemsAndApplyMapping(String[] items, String startsWith) {

		System.out.println("Find Items and converts into other by mapping:");
		Arrays.stream(items).filter(item -> item.startsWith("p"))
				.map(String::toUpperCase).forEach(System.out::println);
		System.out.println();

	}
	
	private void matchingExamples(String[] items , String conditionString){
		
		boolean isAnyMatches = Arrays.stream(items).anyMatch(item -> item.contains(conditionString));
		System.out.println("Is conditions matches on any one of the item :"+isAnyMatches);
		System.out.println();
		
		boolean isAllMatches = Arrays.stream(items).allMatch(item -> item.contains(conditionString));
		System.out.println("Is Conditions matches on all item :"+isAllMatches);
		System.out.println();
		
		boolean isNoneMatches = Arrays.stream(items).noneMatch(item -> item.contains(conditionString));
		System.out.println("Is Conditions matches on all item :"+isNoneMatches);
		System.out.println();
		
	}
	
	private void getSummaryStatistics(int[] marks) {
		 
		 System.out.println("Summary Statistics of int array : "+Arrays.stream(marks).summaryStatistics());
		
	}

}
