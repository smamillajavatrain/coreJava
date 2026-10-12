package com.fortress.java.preparation.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

import com.fortress.java.preparation.collection.util.CollectionUtil;


/**
 * smamilla
 */
public class GenericCollection {
	
	@SuppressWarnings("unchecked")
	public static <T> Collection<T> cloneCollection(
	        Collection<T> collection) {

	    if (collection instanceof ArrayList<?>) {
	        return (Collection<T>) ((ArrayList<?>) collection).clone();

	    } else if (collection instanceof LinkedList<?>) {
	        return new LinkedList<>(collection);

	    } else if (collection instanceof Stack<?>) {
	        return (Collection<T>) ((Stack<?>) collection).clone();

	    } else if (collection instanceof Vector<?>) {
	        return (Collection<T>) ((Vector<?>) collection).clone();

	    } else if (collection instanceof LinkedHashSet<?>) {
	        return (Collection<T>) ((LinkedHashSet<?>) collection).clone();

	    } else if (collection instanceof HashSet<?>) {
	        return (Collection<T>) ((HashSet<?>) collection).clone();

	    } else if (collection instanceof TreeSet<?>) {
	        return new TreeSet<>((TreeSet<T>) collection);

	    } else if (collection instanceof PriorityQueue<?>) {
	        return new PriorityQueue<>((PriorityQueue<T>) collection);
	    }

	    return new ArrayList<>(collection);
	}
	
	// commonOperations clone subList Shuffle Frequency indexOf and lastIndexOf Maximum and minimum 
	// Sorting the temporary list and Clear operation on the temporary list
	public static <T extends Comparable<? super T>>
	void commonOperations(Collection<T> collection, T searchElement) {

	    if (collection == null) {
	        throw new IllegalArgumentException(
	                "Collection must not be null");
	    }

	    System.out.println("\nOriginal collection: " + collection);
	    System.out.println("Collection type: "
	            + collection.getClass().getSimpleName());

	    // 1. Clone operation: demonstrate clone() where supported
	    Collection<T> clonedCollection = cloneCollection(collection);

	    System.out.println("Cloned collection: " + clonedCollection);
	    System.out.println("Original identity hash: "
	            + System.identityHashCode(collection));
	    System.out.println("Cloned identity hash: "
	            + System.identityHashCode(clonedCollection));

	    // 2. Create a List copy for List-specific operations
	    List<T> list = new ArrayList<>(collection);

	    // 3. SubList operation: fromIndex inclusive, toIndex exclusive
	    if (list.size() >= 3) {
	        System.out.println("SubList: " + list.subList(1, 3));
	    } else {
	        System.out.println("SubList skipped: insufficient elements");
	    }

	    // 4. Shuffle operation
	    Collections.shuffle(list);
	    System.out.println("After shuffle: " + list);

	    // 5. Frequency operation
	    System.out.println("Frequency of " + searchElement + ": "
	            + Collections.frequency(collection, searchElement));

	    // 6. indexOf and lastIndexOf
	    System.out.println("First occurrence index: "
	            + list.indexOf(searchElement));
	    System.out.println("Last occurrence index: "
	            + list.lastIndexOf(searchElement));

	    // 7. Maximum and minimum
	    if (!collection.isEmpty()) {
	        System.out.println("Maximum: " + Collections.max(collection));
	        System.out.println("Minimum: " + Collections.min(collection));
	    }

	    // 8. Sorting the temporary list
	    Collections.sort(list);
	    System.out.println("Ascending order: " + list);

	    Collections.sort(list, Collections.reverseOrder());
	    System.out.println("Descending order: " + list);

	    // 9. Clear operation on the temporary list
	    list.clear();
	    System.out.println("Temporary list after clear: " + list);

	    // Original collection is unchanged
	    System.out.println("Original collection remains: " + collection);
	}
	
	
//	retainAll -> keep common elements
	public static void retainAllDemo(Collection<String> collection) {
		Collection<String> collection1 = CollectionUtil.getCollectionObject(collection);
		Collection<String> collection2 = CollectionUtil.getCollectionObject(collection);
		
		collection1.add("Sree");
		collection1.add("Vihas");
		collection1.add("Ravi");
		collection1.add("Kiran");

		collection2.add("Sree");
		collection2.add("Vihas");
		collection2.add("Praveen");
		
		collection1.retainAll(collection2);  
		
		System.out.println(collection1);
		
	}
	
//	removeAll -> remove common elements
	public static void removeAllDemo(Collection<String> collection) {
		Collection<String> collection1 = CollectionUtil.getCollectionObject(collection);
		Collection<String> collection2 = CollectionUtil.getCollectionObject(collection);
		
		collection1.add("Sree");
		collection1.add("Vihas");
		collection1.add("Ravi");
		collection1.add("Kiran");
		
		if(collection1.contains("Ravi")) {
			System.out.println("Element Existng in the ArrayList");
		}

		collection2.add("Sree");
		collection2.add("Vihas");
		collection2.add("Ravi");
		collection2.add("Kiran");
		
		if(collection1.containsAll(collection2)){
			System.out.println("Both collection have same elements");
		}else {
			System.out.println("Both collection have not same elements");
		}
		collection1.removeAll(collection2);  //  REMOVE Common elements 
		
		System.out.println(collection1);
		
	}
	
	// Sorting collection elements
	public static void sortCollectionElements(Collection<String> collection) {

	    if (collection == null) {
	        throw new IllegalArgumentException(
	                "Collection must not be null");
	    }

	    List<String> sortedList = new ArrayList<>(collection);

	    System.out.println("Original collection: " + collection);

	    // Ascending order
	    Collections.sort(sortedList);

	    System.out.println("Ascending order: " + sortedList);

	    // Descending order
	    Collections.sort(sortedList, Collections.reverseOrder());

	    System.out.println("Descending order: " + sortedList);
	}
	
	//displayArrayListUsingTraditional
	public static void displayCollectionObjectUsingTraditional(Collection<String> collection) {
		List<String> list = new ArrayList<>(collection);
		// ArrayList elements index starts from 0
		if (list != null && !list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}else {
			System.out.println("list is empty or null");
		}
	}
	
	//displayEnhancedForLoop
	public static void displayEnhancedForLoop(Collection<String> collection) {
		List<String> list = new ArrayList<>(collection);
		if (list != null && !list.isEmpty()) {
			for(Object obj:list) {
				System.out.println(obj);
			}
		}else {
			System.out.println("list is empty or null");
		}
		
	}
	
	//dispayUsingIterator
	public static void dispayUsingIterator(Collection<String> collection) {
		List<String> list = new ArrayList<>(collection);
		Iterator<String> iterElem = list.iterator();
		System.out.println("\n The iterator values" + " of list are: ");
		while (iterElem.hasNext()) {
			System.out.println(iterElem.next() + " ");
		}
	}
	
	//displayUsingListIterator
	public static void displayUsingListIterator(Collection<String> collection) {
		List<String> list = new ArrayList<>(collection);
		ListIterator<String> listIterString = list.listIterator();
		System.out.println("\n The list iterator values" + " of list are: ");
		while (listIterString.hasNext()) {
			System.out.println(listIterString.next() + " ");
		}
		
		//Backward:
		ListIterator<String> iterator = list.listIterator(list.size());

		while (iterator.hasPrevious()) {
		    System.out.println(iterator.previous());
		}
	}
	
	//displayUsingArray
	public static void displayUsingArray(Collection<String> collection) {
		List<String> list = new ArrayList<>(collection);
		Object[] array = list.toArray();

		for (Object obj : array) {
		    System.out.println(obj);
		}
	}
}