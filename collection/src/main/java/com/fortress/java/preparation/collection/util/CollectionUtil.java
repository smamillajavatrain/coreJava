/**
 * smamilla
 */

/**
 * 
 */
package com.fortress.java.preparation.collection.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;
import java.util.function.Supplier;

/**
 * smamilla
 */
public class CollectionUtil {

	public static ArrayList populateArrayList() {
		ArrayList list = new ArrayList();
		list.add("Sree");  // 0
		list.add("Sree"); // 1
		list.add("Vihas");
		list.add("Divya");
		list.add("Bhargav");
		list.add("Kalyani");
		list.add("Bhavana");
		list.add("Aditya");
		list.add("Sree");  // 8
		list.add("Krishna");
		list.add("Pawan");
		list.add("Sree");  //11
		return list;
	}
	
	public static ArrayList<String> populateGenericArrayList() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Sree");  // 0
		list.add("Sree"); // 1
		list.add("Vihas");
		list.add("Divya");
		list.add("Bhargav");
		list.add("Kalyani");
		list.add("Bhavana");
		list.add("Aditya");
		list.add("Sree");  // 8
		list.add("Krishna");
		list.add("Pawan");
		list.add("Sree");  //11
		return list;
	}
	
	public static LinkedList<String> populateGenericLinkedList() {
		LinkedList<String> list = new LinkedList<String>();
		list.add("Sree");  // 0
		list.add("Sree"); // 1
		list.add("Vihas");
		list.add("Divya");
		list.add("Bhargav");
		list.add("Kalyani");
		list.add("Bhavana");
		list.add("Aditya");
		list.add("Sree");  // 8
		list.add("Krishna");
		list.add("Pawan");
		list.add("Sree");  //11
		return list;
	}
	
	public static <C extends Collection<String>> C populateGenericCollection(
	        Supplier<C> collectionFactory) {

	    C collection = collectionFactory.get();

	    collection.add("Sree");      // 0 for List
	    collection.add("Sree");      // 1 for List
	    collection.add("Vihas");
	    collection.add("Divya");
	    collection.add("Bhargav");
	    collection.add("Kalyani");
	    collection.add("Bhavana");
	    collection.add("Aditya");
	    collection.add("Sree");      // 8 for List
	    collection.add("Krishna");
	    collection.add("Pawan");
	    collection.add("Sree");      // 11 for List

	    return collection;
	}
	
	public static Vector populateVector() {
		Vector vector = new Vector();
		vector.add("Sree");  // 0
		vector.add("Sree"); // 1
		vector.add("Vihas");
		vector.add("Divya");
		vector.add("Bhargav");
		vector.add("Kalyani");
		vector.add("Bhavana");
		vector.add("Aditya");
		vector.add("Sree");  // 8
		vector.add("Krishna");
		vector.add("Pawan");
		vector.add("Sree");  //11
		return vector;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Collection<T> getCollectionObject(Collection<T> collection) {
	    if (collection == null) {
	        throw new IllegalArgumentException("Collection must not be null");
	    }
	    try {
	        return collection.getClass().getDeclaredConstructor().newInstance();
	    } catch (ReflectiveOperationException e) {
	        throw new IllegalArgumentException("Cannot create collection of type: "
	                        + collection.getClass().getName(), e);
	    }
	}
	
	public static <T> void getCollectionObject(
	        Collection<T> collection,
	        Supplier<Collection<T>> factory) {

	    Collection<T> collection1 = factory.get();
	    Collection<T> collection2 = factory.get();

	    collection1.addAll(collection);
	    collection2.addAll(collection);

	    System.out.println(collection1);
	    System.out.println(collection2);
	}
	
	public static Collection<String> getValidCollectionObject(Collection<String> collection) {
		Collection<String> collection1 = null;
		if(collection instanceof ArrayList) {
			collection1 = new ArrayList<String>();
		}else if(collection instanceof LinkedList) {
			collection1 = new LinkedList<String>();
		}else if(collection instanceof Vector) {
			collection1 = new Vector<String>();
		}else if(collection instanceof Stack) {
			collection1 = new Stack<String>();
		}else if(collection instanceof HashSet) {
			collection1 = new HashSet<String>();
		}else if(collection instanceof LinkedHashSet) {
			collection1 = new LinkedHashSet<String>();
		}else if(collection instanceof TreeSet) {
			collection1 = new TreeSet<String>();
		}else if(collection instanceof Queue) {
			collection1 = new PriorityQueue<String>();
		}
		return collection1;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> Collection<T> cloneCollection(
	        Collection<T> collection) {

	    if (collection instanceof ArrayList<?>) {
	        return (Collection<T>) ((ArrayList<?>) collection).clone();

	    } else if (collection instanceof Stack<?>) {
	        return (Collection<T>) ((Stack<?>) collection).clone();

	    } else if (collection instanceof Vector<?>) {
	        return (Collection<T>) ((Vector<?>) collection).clone();

	    } else if (collection instanceof LinkedHashSet<?>) {
	        return (Collection<T>) ((LinkedHashSet<?>) collection).clone();

	    } else if (collection instanceof HashSet<?>) {
	        return (Collection<T>) ((HashSet<?>) collection).clone();
	    }

	    // Fallback for LinkedList, TreeSet, Queue and other collections
	    if (collection instanceof SortedSet<?>) {
	        return new TreeSet<>((SortedSet<T>) collection);
	    }

	    if (collection instanceof PriorityQueue<?>) {
	        return new PriorityQueue<>((PriorityQueue<T>) collection);
	    }

	    if (collection instanceof LinkedList<?>) {
	        return new LinkedList<>(collection);
	    }

	    return new ArrayList<>(collection);
	}
}