package com.fortress.java.preparation.collection;

import java.util.TreeSet;

import com.fortress.java.preparation.collection.util.CollectionUtil;

/**
 * smamilla
 */
public class TreeSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	    System.out.println("==================================================");
	    System.out.println("       TREESET COLLECTION OPERATIONS");
	    System.out.println("==================================================");

	    // 1. Common Collection Operations
	    System.out.println("\n>>> START: commonOperations()");
	    System.out.println("Purpose: Demonstrates clone, subList, shuffle, frequency, "
	            + "indexOf, lastIndexOf, min, max, sorting and clear operations.");

	    GenericCollection.commonOperations(
	            CollectionUtil.populateGenericCollection(TreeSet::new), "Sree");

	    System.out.println("<<< END: commonOperations()");
	    System.out.println("Result: Common collection operations demonstrated.");


	    // 2. retainAll() Operation
	    System.out.println("\n>>> START: retainAllDemo()");
	    System.out.println("Purpose: Retains only the elements that are common "
	            + "to both collections.");

	    GenericCollection.retainAllDemo(
	    		CollectionUtil.populateGenericCollection(TreeSet::new));

	    System.out.println("<<< END: retainAllDemo()");
	    System.out.println("Result: Only common elements are retained.");


	    // 3. removeAll() Operation
	    System.out.println("\n>>> START: removeAllDemo()");
	    System.out.println("Purpose: Removes all elements from the first "
	            + "collection that are present in the second collection.");

	    GenericCollection.removeAllDemo(
	    		CollectionUtil.populateGenericCollection(TreeSet::new));

	    System.out.println("<<< END: removeAllDemo()");
	    System.out.println("Result: Common elements are removed.");


	    // 4. Sorting Collection Elements
	    System.out.println("\n>>> START: sortCollectionElements()");
	    System.out.println("Purpose: Sorts collection elements in ascending "
	            + "and descending order using a temporary List.");

	    GenericCollection.sortCollectionElements(
	    		CollectionUtil.populateGenericCollection(TreeSet::new));

	    System.out.println("<<< END: sortCollectionElements()");
	    System.out.println("Result: Ascending and descending orders displayed.");


	    // 5. Traditional for Loop
	    System.out.println("\n>>> START: displayTreeSetUsingTraditional()");
	    System.out.println("Purpose: Iterates through collection elements "
	            + "using a traditional for loop and index positions.");

	    GenericCollection.displayCollectionObjectUsingTraditional(
	    		CollectionUtil.populateGenericCollection(TreeSet::new));

	    System.out.println("<<< END: displayTreeSetUsingTraditional()");
	    System.out.println("Result: Elements displayed using a traditional for loop.");


	    // 6. Enhanced for Loop
	    System.out.println("\n>>> START: displayEnhancedForLoop()");
	    System.out.println("Purpose: Iterates through collection elements "
	            + "using the enhanced for loop.");

	    GenericCollection.displayEnhancedForLoop(
	    		CollectionUtil.populateGenericCollection(TreeSet::new));

	    System.out.println("<<< END: displayEnhancedForLoop()");
	    System.out.println("Result: Elements displayed using an enhanced for loop.");


	    // 7. Iterator
	    System.out.println("\n>>> START: dispayUsingIterator()");
	    System.out.println("Purpose: Traverses collection elements using Iterator "
	            + "and its hasNext() and next() methods.");

	    GenericCollection.dispayUsingIterator(
	    		CollectionUtil.populateGenericCollection(TreeSet::new));

	    System.out.println("<<< END: dispayUsingIterator()");
	    System.out.println("Result: Elements displayed using Iterator.");


	    // 8. ListIterator
	    System.out.println("\n>>> START: displayUsingListIterator()");
	    System.out.println("Purpose: Traverses list elements in forward "
	            + "and backward directions using ListIterator.");

	    GenericCollection.displayUsingListIterator(
	    		CollectionUtil.populateGenericCollection(TreeSet::new));

	    System.out.println("<<< END: displayUsingListIterator()");
	    System.out.println("Result: Elements displayed in both directions.");


	    // 9. Convert Collection to Array
	    System.out.println("\n>>> START: displayUsingArray()");
	    System.out.println("Purpose: Converts collection elements into an array "
	            + "using toArray() and displays them.");

	    GenericCollection.displayUsingArray(
	    		CollectionUtil.populateGenericCollection(TreeSet::new));

	    System.out.println("<<< END: displayUsingArray()");
	    System.out.println("Result: Elements displayed using an array.");


	    // 10. Clone Collection
	    System.out.println("\n>>> START: cloneCollection()");
	    System.out.println("Purpose: Creates a shallow copy of the collection "
	            + "and demonstrates that the copy is a separate object.");

	    System.out.println("Cloned collection: "
	            + GenericCollection.cloneCollection(
	            		CollectionUtil.populateGenericCollection(TreeSet::new)));

	    System.out.println("<<< END: cloneCollection()");
	    System.out.println("Result: A copied collection is returned.");


	    System.out.println("\n==================================================");
	    System.out.println("       TREESET COLLECTION OPERATIONS COMPLETED");
	    System.out.println("==================================================");
	}
}
/*

			import java.util.*;

			public class TreeSetMethodsDemo {
			
			    public static void main(String[] args) {
			
			        TreeSet<Integer> numbers =
			                new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));
			
			        System.out.println("Original TreeSet: " + numbers);
			
			        System.out.println("First element: " + numbers.first());
			        System.out.println("Last element: " + numbers.last());
			
			        System.out.println("Lower than 30: " + numbers.lower(30));
			        System.out.println("Floor of 30: " + numbers.floor(30));
			        System.out.println("Ceiling of 30: " + numbers.ceiling(30));
			        System.out.println("Higher than 30: " + numbers.higher(30));

			        System.out.println("HeadSet before 30: " + numbers.headSet(30));
			        System.out.println("TailSet from 30: " + numbers.tailSet(30));
			        System.out.println("SubSet from 20 to 40: " + numbers.subSet(20, 40));
			
			        System.out.println("Descending order: " + numbers.descendingSet());
			
			        System.out.println("Before pollFirst: " + numbers);
			        System.out.println("Removed first: " + numbers.pollFirst());
			        System.out.println("After pollFirst: " + numbers);
			
			        System.out.println("Before pollLast: " + numbers);
			        System.out.println("Removed last: " + numbers.pollLast());
			        System.out.println("After pollLast: " + numbers);
			    }
			}
			
			Focus especially on first(), last(), lower(), floor(), ceiling(), higher(), pollFirst(), pollLast(), 
			headSet(), tailSet() and subSet(). 
			These distinguish TreeSet from a basic HashSet and are frequently useful in coding problems.
			
			
			1. Basic TreeSet methods
			Method							Description												Example
			add(E e)						Adds an element if it is not already present.			numbers.add(10);
			addAll(Collection c)	        Adds all elements from another collection.				numbers.addAll(list);
			size()							Returns the number of elements.							numbers.size();
			isEmpty()						Checks whether the set is empty.						numbers.isEmpty();
			contains(Object o)				Checks whether an element exists.						numbers.contains(20);
			remove(Object o)				Removes a specified element.							numbers.remove(10);
			clear()							Removes all elements.									numbers.clear();
			iterator()						Iterates in ascending order.							numbers.iterator();
			descendingIterator()			Iterates in descending order.							numbers.descendingIterator();
			toArray()						Converts the set into an Object[].						numbers.toArray();
			toArray(T[] a)					Converts the set into a typed array.					numbers.toArray(new Integer[0]);
			first()							Returns the smallest element.							numbers.first();
			last()							Returns the largest element.							numbers.last();
			
			2. Important NavigableSet methods
			These methods are especially important for interviews because 
			they allow you to search for elements relative to a given value.
			Consider this set: TreeSet<Integer> numbers =
			        				new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));

			Method			Description														Example				Result
			lower(E e)	Greatest element strictly less than the given element.				numbers.lower(30)	20
			floor(E e)	Greatest element less than or equal to the given element.			numbers.floor(30)	30
			ceiling(E e)	Smallest element greater than or equal to the given element.	numbers.ceiling(30)	30
			higher(E e)	Smallest element strictly greater than the given element.			numbers.higher(30)	40
			pollFirst()	Retrieves and removes the smallest element.							numbers.pollFirst()	10
			pollLast()	Retrieves and removes the largest element.							numbers.pollLast()	50
			descendingSet()	Returns a reverse-order view of the set.						numbers.descendingSet()	[50, 40, 30, 20, 10]
			
				Easy way to remember:
				- lower() → strictly lower
				- floor() → lower or equal
				- ceiling() → equal or higher
				- higher() → strictly higher
				
			3. Range-view methods
			Method					Description															
			headSet(E toElement)	Elements strictly less than the endpoint.									
			numbers.headSet(30)			[10, 20]
			
			tailSet(E fromElement)	Elements greater than or equal to the starting point.						
			numbers.tailSet(30)	[30, 40, 50]
			
			subSet(E from, E to)	Elements from the starting point inclusive to the endpoint exclusive.	
				numbers.subSet(20, 40)	[20, 30]
				
			headSet(E to, boolean inclusive)	
			Controls whether the endpoint is included.						
			numbers.headSet(30, true)	[10, 20, 30]
			
			tailSet(E from, boolean inclusive)	
			Controls whether the starting point is included.				
			numbers.tailSet(30, false)	[40, 50]
			
			subSet(E from, boolean fromInclusive, E to, boolean toInclusive)								
				numbers.subSet(20, true, 40, true)	[20, 30, 40]
				Controls inclusion of both endpoints
				
			Note: Range methods return views backed by the original set. Changes to a returned view can affect the original set.
			
			4. Comparator and sorting methods
			Method						Description															Example
			comparator()				Returns the custom comparator, or null for natural ordering.	numbers.comparator()
			Collections.reverseOrder()	Creates a comparator for reverse ordering.						new TreeSet<>(Collections.reverseOrder())
			add(E e)					Inserts an element in its correct sorted position.				numbers.add(25);

*/