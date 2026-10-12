/**
 * smamilla
 */

/**
 * 
 */
package com.fortress.java.preparation.collection.bk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;

import com.fortress.java.preparation.collection.util.CollectionUtil;

/**
 * smamilla
 */
public class ArrayListCompleteExamples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * first element if you add into the list then capacity = 10
		 * ArrayList list = new ArrayList();
		 * System.out.println(list.size()); // Size = 0 list is empty
		 * if(list!=null && list.isEmpty()) {
		 * System.out.println("ArrayList is empty!!");
		 * }
		 * // first element into the AL then capacity = 10;
		 */
		
		sortListElements(CollectionUtil.populateArrayList());
		displayArrayListUsingTraditional(CollectionUtil.populateArrayList());
		displayEnhancedForLoop(CollectionUtil.populateArrayList());
		displayUsingArray(CollectionUtil.populateArrayList());
		dispayUsingIterator(CollectionUtil.populateArrayList());
		displayUsingListIterator(CollectionUtil.populateArrayList());
		retainAllDemo();
		removeAllDemo();
		commonOperations(CollectionUtil.populateArrayList());
	}
	
	public static void commonOperations(ArrayList list) {
		
		ArrayList clonedList = (ArrayList) list.clone();
		
		System.out.println("Capacity --> "+list);
		System.out.println(System.identityHashCode(list));
		System.out.println(list.hashCode());
		System.out.println("Original: " + list);
		System.out.println("Clone: " + clonedList);
		System.out.println(list.subList(1, 4)); // create a new list with the mentioned index
		
//		subList()  subList(fromIndex, toIndex)

//		fromIndex → inclusive
//		toIndex   → exclusive
		
		Collections.shuffle(list);
		System.out.println(list);
		
		Collections.shuffle(list);
		System.out.println(list);
		
//		Collections.frequency()
		int count = Collections.frequency(list, "Sree");
		System.out.println("Sree occurred " + count + " times");
		
		System.out.println("First Sree index: " + list.indexOf("Sree"));

		System.out.println("Last Sree index: " + list.lastIndexOf("Sree"));
		
		ArrayList numbers = new ArrayList();

		numbers.add(10);
		numbers.add(50);
		numbers.add(20);
		numbers.add(80);
		numbers.add(30);

		System.out.println("Maximum: " + Collections.max(numbers));
		System.out.println("Minimum: " + Collections.min(numbers));
		
		list.clear();
		System.out.println(list);
	}
	
	public static void retainAllDemo() {
		ArrayList list1 = new ArrayList();

		list1.add("Sree");
		list1.add("Vihas");
		list1.add("Ravi");
		list1.add("Kiran");

		ArrayList list2 = new ArrayList();

		list2.add("Sree");
		list2.add("Vihas");
		list2.add("Praveen");
		
		list1.retainAll(list2);  // keep common elements
		
		System.out.println(list1);
		
	}
	
	public static void removeAllDemo() {
		ArrayList list1 = new ArrayList();

		list1.add("Sree");
		list1.add("Vihas");
		list1.add("Ravi");
		list1.add("Kiran");
		
		if(list1.contains("Ravi")) {
			System.out.println("Element Existng in the ArrayList");
		}
		
		ArrayList list2 = new ArrayList();

		list2.add("Sree");
		list2.add("Vihas");
		list2.add("Ravi");
		list2.add("Kiran");
		
		if(list1.containsAll(list2)){
			System.out.println("Both list have same elements");
		}else {
			System.out.println("Both list have not same elements");
		}
		list1.removeAll(list2);  //  REMOVE Common elements 
		
		System.out.println(list1);
		
	}

	public static void sortListElements(ArrayList list) {
		System.out.println(list.size());
		System.out.println("Before sorting the ArrayList elements---");
		System.out.println(list);

		Collections.sort(list);
		System.out.println("After sorting the ArrayList elements in Ascending order ---");
		System.out.println(list);

		Collections.sort(list, Collections.reverseOrder());
		System.out.println("After sorting the ArrayList elements in Descending order ---");
		System.out.println(list);
	}

	public static void displayArrayListUsingTraditional(ArrayList list) {
		// Arraylist elements index starts from 0
		if (list != null && !list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}else {
			System.out.println("list is empty or null");
		}
	}
	
	public static void displayEnhancedForLoop(ArrayList list) {
		if (list != null && !list.isEmpty()) {
			for(Object obj:list) {
				System.out.println(obj);
			}
		}else {
			System.out.println("list is empty or null");
		}
		
	}
	
	public static void dispayUsingIterator(ArrayList list) {
		Iterator iterElem = list.iterator();
		System.out.println("\n The iterator values" + " of list are: ");
		while (iterElem.hasNext()) {
			System.out.println(iterElem.next() + " ");
		}
	}
	
	public static void displayUsingListIterator(ArrayList list) {
		ListIterator<Object> listIterString = list.listIterator();
		System.out.println("\n The list iterator values" + " of list are: ");
		while (listIterString.hasNext()) {
			System.out.println(listIterString.next() + " ");
		}
		
		//Backward:
		ListIterator<Object> iterator = list.listIterator(list.size());

		while (iterator.hasPrevious()) {
		    System.out.println(iterator.previous());
		}
	}
	
	public static void displayUsingArray(ArrayList list) {
		Object[] array = list.toArray();

		for (Object obj : array) {
		    System.out.println(obj);
		}
	}
}