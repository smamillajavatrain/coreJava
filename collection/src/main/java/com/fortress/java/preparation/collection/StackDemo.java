package com.fortress.java.preparation.collection;

import java.util.Stack;

import com.fortress.java.preparation.collection.util.CollectionUtil;

/**
 * smamilla
 */
public class StackDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	    System.out.println("==================================================");
	    System.out.println("       Stack COLLECTION OPERATIONS");
	    System.out.println("==================================================");

	    // 1. Common Collection Operations
	    System.out.println("\n>>> START: commonOperations()");
	    System.out.println("Purpose: Demonstrates clone, subList, shuffle, frequency, "
	            + "indexOf, lastIndexOf, min, max, sorting and clear operations.");

	    GenericCollection.commonOperations(
	            CollectionUtil.populateGenericCollection(Stack::new), "Sree");

	    System.out.println("<<< END: commonOperations()");
	    System.out.println("Result: Common collection operations demonstrated.");


	    // 2. retainAll() Operation
	    System.out.println("\n>>> START: retainAllDemo()");
	    System.out.println("Purpose: Retains only the elements that are common "
	            + "to both collections.");

	    GenericCollection.retainAllDemo(
	    		CollectionUtil.populateGenericCollection(Stack::new));

	    System.out.println("<<< END: retainAllDemo()");
	    System.out.println("Result: Only common elements are retained.");


	    // 3. removeAll() Operation
	    System.out.println("\n>>> START: removeAllDemo()");
	    System.out.println("Purpose: Removes all elements from the first "
	            + "collection that are present in the second collection.");

	    GenericCollection.removeAllDemo(
	    		CollectionUtil.populateGenericCollection(Stack::new));

	    System.out.println("<<< END: removeAllDemo()");
	    System.out.println("Result: Common elements are removed.");


	    // 4. Sorting Collection Elements
	    System.out.println("\n>>> START: sortCollectionElements()");
	    System.out.println("Purpose: Sorts collection elements in ascending "
	            + "and descending order using a temporary List.");

	    GenericCollection.sortCollectionElements(
	    		CollectionUtil.populateGenericCollection(Stack::new));

	    System.out.println("<<< END: sortCollectionElements()");
	    System.out.println("Result: Ascending and descending orders displayed.");


	    // 5. Traditional for Loop
	    System.out.println("\n>>> START: displayStackUsingTraditional()");
	    System.out.println("Purpose: Iterates through collection elements "
	            + "using a traditional for loop and index positions.");

	    GenericCollection.displayCollectionObjectUsingTraditional(
	    		CollectionUtil.populateGenericCollection(Stack::new));

	    System.out.println("<<< END: displayStackUsingTraditional()");
	    System.out.println("Result: Elements displayed using a traditional for loop.");


	    // 6. Enhanced for Loop
	    System.out.println("\n>>> START: displayEnhancedForLoop()");
	    System.out.println("Purpose: Iterates through collection elements "
	            + "using the enhanced for loop.");

	    GenericCollection.displayEnhancedForLoop(
	    		CollectionUtil.populateGenericCollection(Stack::new));

	    System.out.println("<<< END: displayEnhancedForLoop()");
	    System.out.println("Result: Elements displayed using an enhanced for loop.");


	    // 7. Iterator
	    System.out.println("\n>>> START: dispayUsingIterator()");
	    System.out.println("Purpose: Traverses collection elements using Iterator "
	            + "and its hasNext() and next() methods.");

	    GenericCollection.dispayUsingIterator(
	    		CollectionUtil.populateGenericCollection(Stack::new));

	    System.out.println("<<< END: dispayUsingIterator()");
	    System.out.println("Result: Elements displayed using Iterator.");


	    // 8. ListIterator
	    System.out.println("\n>>> START: displayUsingListIterator()");
	    System.out.println("Purpose: Traverses list elements in forward "
	            + "and backward directions using ListIterator.");

	    GenericCollection.displayUsingListIterator(
	    		CollectionUtil.populateGenericCollection(Stack::new));

	    System.out.println("<<< END: displayUsingListIterator()");
	    System.out.println("Result: Elements displayed in both directions.");


	    // 9. Convert Collection to Array
	    System.out.println("\n>>> START: displayUsingArray()");
	    System.out.println("Purpose: Converts collection elements into an array "
	            + "using toArray() and displays them.");

	    GenericCollection.displayUsingArray(
	    		CollectionUtil.populateGenericCollection(Stack::new));

	    System.out.println("<<< END: displayUsingArray()");
	    System.out.println("Result: Elements displayed using an array.");


	    // 10. Clone Collection
	    System.out.println("\n>>> START: cloneCollection()");
	    System.out.println("Purpose: Creates a shallow copy of the collection "
	            + "and demonstrates that the copy is a separate object.");

	    System.out.println("Cloned collection: "
	            + GenericCollection.cloneCollection(
	            		CollectionUtil.populateGenericCollection(Stack::new)));

	    System.out.println("<<< END: cloneCollection()");
	    System.out.println("Result: A copied collection is returned.");


	    System.out.println("\n==================================================");
	    System.out.println("       Stack COLLECTION OPERATIONS COMPLETED");
	    System.out.println("==================================================");
	}
}