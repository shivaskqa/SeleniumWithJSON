package com.jsonpractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;


/* 
 * Interviewer asked to write a logic on moving the input number to last in existing list
 Took one ArrayList for list of numbers as listofInts
 Took another list for getting the numbers and add them in to list though the given numbers are displayed multiple times/duplicated
 RemovedAll method is used to remove elements from listofInts.
 Once those are removed then added them with addAll method. So, list maintains insertion order so, newly added number will be added last.
*/

public class JavaListExamples {
	
	public static void main(String[] args) {
		
		int move=5;
		
		ArrayList<Integer> listofInts=new ArrayList<>();
		
		Collections.addAll(listofInts, 1,2,5,3,2,9,8,2,5);
		
		System.out.println(listofInts);
		
		ArrayList<Integer> list=(ArrayList<Integer>) listofInts
								.stream()
								.filter(e->e==move)
								.collect(Collectors.toList());
		
		System.out.println(list);
		listofInts.removeAll(list);
		
		listofInts.addAll(list);
		System.out.println(listofInts);
		
	}
}
