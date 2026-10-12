package com.fortress.java.preparation.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * smamilla
 */
public class LinkedListOperations {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("      JAVA LINKEDLIST OPERATIONS DEMO");
        System.out.println("==========================================");

        // 1. Creating a LinkedList
        System.out.println("\n1. Creating a LinkedList");
        System.out.println("Purpose: LinkedList implements List, Deque "
                + "and Queue interfaces.");

        LinkedList<String> list = new LinkedList<>();

        System.out.println("Initial LinkedList: " + list);
        System.out.println("Is LinkedList empty? " + list.isEmpty());

        // 2. add() operation
        System.out.println("\n2. add() Operation");
        System.out.println("Purpose: Adds elements at the end of the list.");

        list.add("Java");
        list.add("Spring");
        list.add("Microservices");
        list.add("Kafka");

        System.out.println("LinkedList after add(): " + list);

        // 3. addFirst() operation
        System.out.println("\n3. addFirst() Operation");
        System.out.println("Purpose: Inserts an element at the beginning.");

        list.addFirst("Core Java");
        System.out.println("After addFirst(): " + list);

        // 4. addLast() operation
        System.out.println("\n4. addLast() Operation");
        System.out.println("Purpose: Inserts an element at the end.");

        list.addLast("Docker");
        System.out.println("After addLast(): " + list);

        // 5. getFirst() and getLast()
        System.out.println("\n5. getFirst() and getLast()");
        System.out.println("Purpose: Retrieves the first and last elements "
                + "without removing them.");

        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());
        System.out.println("LinkedList remains: " + list);

        // 6. peekFirst() and peekLast()
        System.out.println("\n6. peekFirst() and peekLast()");
        System.out.println("Purpose: Retrieves the first or last element; "
                + "returns null when the list is empty.");

        System.out.println("First element: " + list.peekFirst());
        System.out.println("Last element: " + list.peekLast());

        // 7. offerFirst() and offerLast()
        System.out.println("\n7. offerFirst() and offerLast()");
        System.out.println("Purpose: Inserts elements at the beginning "
                + "or end through the Deque interface.");

        System.out.println("offerFirst result: "
                + list.offerFirst("Hibernate"));

        System.out.println("offerLast result: "
                + list.offerLast("JDBC"));

        System.out.println("LinkedList: " + list);

        // 8. get(index)
        System.out.println("\n8. get(index) Operation");
        System.out.println("Purpose: Retrieves an element at a zero-based index.");

        System.out.println("Element at index 0: " + list.get(0));
        System.out.println("Element at index 2: " + list.get(2));

        // 9. set(index, element)
        System.out.println("\n9. set() Operation");
        System.out.println("Purpose: Replaces the element at a specified index.");

        String oldElement = list.set(1, "Advanced Java");

        System.out.println("Replaced element: " + oldElement);
        System.out.println("After set(): " + list);

        // 10. add(index, element)
        System.out.println("\n10. add(index, element)");
        System.out.println("Purpose: Inserts an element at a specified index.");

        list.add(2, "Hibernate ORM");
        System.out.println("After indexed insertion: " + list);

        // 11. Duplicate elements
        System.out.println("\n11. Duplicate Elements");
        System.out.println("Purpose: LinkedList allows duplicate values.");

        list.add("Java");
        list.add("Java");

        System.out.println("After adding duplicates: " + list);

        // 12. indexOf() and lastIndexOf()
        System.out.println("\n12. indexOf() and lastIndexOf()");
        System.out.println("Purpose: Finds the first and last occurrence "
                + "of an element.");

        System.out.println("First Java index: " + list.indexOf("Java"));
        System.out.println("Last Java index: " + list.lastIndexOf("Java"));

        // 13. contains() and containsAll()
        System.out.println("\n13. contains() and containsAll()");
        System.out.println("Purpose: Checks whether individual elements "
                + "or all specified elements exist.");

        System.out.println("Contains Java? " + list.contains("Java"));

        List<String> requiredElements = new ArrayList<>();
        requiredElements.add("Java");
        requiredElements.add("Kafka");

        System.out.println("Contains all required elements? "
                + list.containsAll(requiredElements));

        // 14. removeFirst() and removeLast()
        System.out.println("\n14. removeFirst() and removeLast()");
        System.out.println("Purpose: Removes and returns the first "
                + "or last element.");

        System.out.println("Removed first: " + list.removeFirst());
        System.out.println("After removeFirst(): " + list);

        System.out.println("Removed last: " + list.removeLast());
        System.out.println("After removeLast(): " + list);

        // 15. pollFirst() and pollLast()
        System.out.println("\n15. pollFirst() and pollLast()");
        System.out.println("Purpose: Removes the first or last element; "
                + "returns null when empty.");

        System.out.println("Polled first: " + list.pollFirst());
        System.out.println("After pollFirst(): " + list);

        System.out.println("Polled last: " + list.pollLast());
        System.out.println("After pollLast(): " + list);

        // 16. remove(index) and remove(Object)
        System.out.println("\n16. remove(index) and remove(Object)");
        System.out.println("Purpose: Removes by index or by matching value.");

        if (!list.isEmpty()) {
            System.out.println("Removed at index 0: " + list.remove(0));
        }

        boolean removed = list.remove("Java");

        System.out.println("Was Java removed? " + removed);
        System.out.println("After remove operations: " + list);

        // 17. Queue operations: offer(), peek(), poll()
        System.out.println("\n17. Queue Operations");
        System.out.println("Purpose: Demonstrates LinkedList as a FIFO Queue.");

        list.offer("Python");
        list.offer("JavaScript");
        list.offer("TypeScript");

        System.out.println("Queue elements: " + list);
        System.out.println("Queue head using peek(): " + list.peek());
        System.out.println("Removed queue head using poll(): " + list.poll());
        System.out.println("After poll(): " + list);

        // 18. Stack operations: push(), pop()
        System.out.println("\n18. Stack Operations");
        System.out.println("Purpose: Demonstrates LinkedList as a Deque "
                + "with LIFO operations.");

        list.push("First");
        list.push("Second");

        System.out.println("After push(): " + list);
        System.out.println("Popped element: " + list.pop());
        System.out.println("After pop(): " + list);

        // 19. Iterator
        System.out.println("\n19. Iterator Operation");
        System.out.println("Purpose: Traverses elements from beginning to end.");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            System.out.println("Element: " + iterator.next());
        }

        // 20. Descending Iterator
        System.out.println("\n20. Descending Iterator");
        System.out.println("Purpose: Traverses elements from end to beginning.");

        Iterator<String> descendingIterator = list.descendingIterator();

        while (descendingIterator.hasNext()) {
            System.out.println("Element: " + descendingIterator.next());
        }

        // 21. ListIterator
        System.out.println("\n21. ListIterator Operation");
        System.out.println("Purpose: Supports bidirectional traversal.");

        ListIterator<String> listIterator = list.listIterator();

        System.out.println("Forward traversal:");
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        System.out.println("Backward traversal:");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        // 22. Enhanced for loop
        System.out.println("\n22. Enhanced for Loop");
        System.out.println("Purpose: Traverses each element without an explicit index.");

        for (String element : list) {
            System.out.println(element);
        }

        // 23. subList()
        System.out.println("\n23. subList() Operation");
        System.out.println("Purpose: Returns a view from fromIndex inclusive "
                + "to toIndex exclusive.");

        if (list.size() >= 2) {
            System.out.println("SubList: " + list.subList(0, 2));
        }

        // 24. Collections.frequency()
        System.out.println("\n24. frequency() Operation");
        System.out.println("Purpose: Counts occurrences of an element.");

        System.out.println("Frequency of Java: "
                + Collections.frequency(list, "Java"));

        // 25. Maximum and Minimum
        System.out.println("\n25. Maximum and Minimum");
        System.out.println("Purpose: Finds alphabetically greatest "
                + "and smallest elements.");

        if (!list.isEmpty()) {
            System.out.println("Maximum: " + Collections.max(list));
            System.out.println("Minimum: " + Collections.min(list));
        }

        // 26. Sorting
        System.out.println("\n26. Sorting Operation");
        System.out.println("Purpose: Sorts LinkedList in ascending "
                + "and descending order.");

        Collections.sort(list);
        System.out.println("Ascending order: " + list);

        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Descending order: " + list);

        // 27. Shuffle
        System.out.println("\n27. shuffle() Operation");
        System.out.println("Purpose: Randomly rearranges list elements.");

        Collections.shuffle(list);
        System.out.println("After shuffle: " + list);

        // 28. Clone / Copy
        System.out.println("\n28. Clone / Copy Operation");
        System.out.println("Purpose: Creates an independent LinkedList "
                + "with the same element references.");

        LinkedList<String> clonedList = (LinkedList<String>) list.clone();

        System.out.println("Original: " + list);
        System.out.println("Cloned: " + clonedList);
        System.out.println("Same object? " + (list == clonedList));

        // 29. addAll()
        System.out.println("\n29. addAll() Operation");
        System.out.println("Purpose: Adds all elements from another collection.");

        List<String> extraElements = new ArrayList<>();
        extraElements.add("SQL");
        extraElements.add("JDBC");

        list.addAll(extraElements);
        System.out.println("After addAll(): " + list);

        // 30. removeAll()
        System.out.println("\n30. removeAll() Operation");
        System.out.println("Purpose: Removes elements contained in another collection.");

        List<String> removeElements = new ArrayList<>();
        removeElements.add("SQL");
        removeElements.add("JDBC");

        list.removeAll(removeElements);
        System.out.println("After removeAll(): " + list);

        // 31. retainAll()
        System.out.println("\n31. retainAll() Operation");
        System.out.println("Purpose: Retains only elements present "
                + "in the specified collection.");

        List<String> retainElements = new ArrayList<>();
        retainElements.add("Java");
        retainElements.add("Python");

        list.retainAll(retainElements);
        System.out.println("After retainAll(): " + list);

        // 32. toArray()
        System.out.println("\n32. toArray() Operation");
        System.out.println("Purpose: Converts the LinkedList into an array.");

        Object[] array = list.toArray();

        for (Object element : array) {
            System.out.println(element);
        }

        // 33. equals() and hashCode()
        System.out.println("\n33. equals() and hashCode()");
        System.out.println("Purpose: Compares list contents and calculates "
                + "a content-based hash code.");

        LinkedList<String> copy = new LinkedList<>(list);

        System.out.println("Lists equal? " + list.equals(copy));
        System.out.println("Original hashCode: " + list.hashCode());
        System.out.println("Copy hashCode: " + copy.hashCode());

        // 34. Clear
        System.out.println("\n34. clear() Operation");
        System.out.println("Purpose: Removes all elements.");

        list.clear();

        System.out.println("After clear(): " + list);
        System.out.println("Is LinkedList empty? " + list.isEmpty());

        // 35. Empty LinkedList handling
        System.out.println("\n35. Empty LinkedList Handling");
        System.out.println("Purpose: Demonstrates safe and exception-based "
                + "retrieval methods.");

        System.out.println("pollFirst(): " + list.pollFirst());
        System.out.println("peekFirst(): " + list.peekFirst());

        try {
            list.getFirst();
        } catch (java.util.NoSuchElementException e) {
            System.out.println("getFirst(): LinkedList is empty.");
        }

        try {
            list.removeFirst();
        } catch (java.util.NoSuchElementException e) {
            System.out.println("removeFirst(): LinkedList is empty.");
        }

        System.out.println("\n==========================================");
        System.out.println("    LINKEDLIST OPERATIONS COMPLETED");
        System.out.println("==========================================");
    }
}
/*

		LinkedList-specific methods
		Method							Purpose
		addFirst(e)						Adds an element at the beginning.
		addLast(e)						Adds an element at the end.
		getFirst() / getLast()			Retrieves an endpoint; throws an exception if empty.
		peekFirst() / peekLast()		Retrieves an endpoint or returns null if empty.
		removeFirst() / removeLast()	Removes an endpoint; throws an exception if empty.
		pollFirst() / pollLast()		Removes an endpoint or returns null if empty.
		descendingIterator()			Traverses from the tail toward the head.
		offer() / poll() / peek()		Queue operations: insert, retrieve-and-remove, and inspect the head.
		push() / pop()					Deque-based stack operations.
		
		
		Key differences: ArrayList vs. LinkedList
		Feature						ArrayList								LinkedList
		Internal structure			Resizable array							Doubly linked list
		Access by index				Usually \(O(1)\)						\(O(n)\)
		Insert/remove at ends		End append is amortized \(O(1)\);       beginning operations require shifting	\(O(1)\)
		Queue and deque methods	    Not implemented							Implemented
		Extra memory				Generally lower							Higher due to node references
		clone()						Supported publicly						No public clone() method
		
		Emphasize that LinkedList implements List, Queue, and Deque. 
		This is why the same object supports indexed operations, FIFO queue methods, and LIFO stack-style methods.
		Note that subList() returns a backed view rather than an independent list, 
		and clone() produces a shallow copy. For new stack-oriented code, 
		Java generally recommends Deque with ArrayDeque; 
		for queue-oriented code, select the implementation based on the required ordering semantics.

*/