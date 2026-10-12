package com.fortress.java.preparation.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * smamilla
 */
public class QueueOperations {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("        JAVA QUEUE OPERATIONS DEMO");
        System.out.println("==========================================");

        // 1. Creating a Queue
        System.out.println("\n1. Creating a Queue");
        System.out.println("Purpose: Queue represents FIFO processing "
                + "when using a FIFO queue implementation.");

        Queue<String> queue = new LinkedList<>();

        System.out.println("Initial Queue: " + queue);
        System.out.println("Is Queue empty? " + queue.isEmpty());

        // 2. add() operation
        System.out.println("\n2. add() Operation");
        System.out.println("Purpose: Inserts an element into the Queue. "
                + "Throws an exception if insertion fails.");

        queue.add("Java");
        queue.add("Spring");
        queue.add("Microservices");
        queue.add("Kafka");

        System.out.println("Queue after add(): " + queue);

        // 3. offer() operation
        System.out.println("\n3. offer() Operation");
        System.out.println("Purpose: Inserts an element and returns "
                + "true if successful.");

        boolean offered = queue.offer("Docker");

        System.out.println("Was Docker inserted? " + offered);
        System.out.println("Queue after offer(): " + queue);

        // 4. peek() operation
        System.out.println("\n4. peek() Operation");
        System.out.println("Purpose: Retrieves the head without removing it.");

        System.out.println("Head element: " + queue.peek());
        System.out.println("Queue after peek(): " + queue);

        // 5. element() operation
        System.out.println("\n5. element() Operation");
        System.out.println("Purpose: Retrieves the head, "
                + "throwing an exception if the Queue is empty.");

        System.out.println("Head using element(): " + queue.element());

        // 6. poll() operation
        System.out.println("\n6. poll() Operation");
        System.out.println("Purpose: Retrieves and removes the head. "
                + "Returns null when the Queue is empty.");

        String polledElement = queue.poll();

        System.out.println("Polled element: " + polledElement);
        System.out.println("Queue after poll(): " + queue);

        // 7. remove() operation
        System.out.println("\n7. remove() Operation");
        System.out.println("Purpose: Removes and returns the head. "
                + "Throws an exception if the Queue is empty.");

        String removedElement = queue.remove();

        System.out.println("Removed element: " + removedElement);
        System.out.println("Queue after remove(): " + queue);

        // 8. size() operation
        System.out.println("\n8. size() Operation");
        System.out.println("Purpose: Returns the number of elements.");

        System.out.println("Queue size: " + queue.size());

        // 9. contains() operation
        System.out.println("\n9. contains() Operation");
        System.out.println("Purpose: Checks whether an element exists.");

        System.out.println("Contains Kafka? " + queue.contains("Kafka"));
        System.out.println("Contains Python? " + queue.contains("Python"));

        // 10. Adding duplicate elements
        System.out.println("\n10. Duplicate Elements");
        System.out.println("Purpose: LinkedList permits duplicate elements.");

        queue.offer("Java");
        queue.offer("Java");

        System.out.println("Queue with duplicates: " + queue);

        // 11. Iterator
        System.out.println("\n11. Iterator Operation");
        System.out.println("Purpose: Traverses Queue elements using Iterator.");

        Iterator<String> iterator = queue.iterator();

        while (iterator.hasNext()) {
            System.out.println("Element: " + iterator.next());
        }

        // 12. Enhanced for loop
        System.out.println("\n12. Enhanced for Loop");
        System.out.println("Purpose: Iterates through all Queue elements.");

        for (String element : queue) {
            System.out.println(element);
        }

        // 13. Convert Queue to List
        System.out.println("\n13. Queue to List Conversion");
        System.out.println("Purpose: Creates a separate List for "
                + "index-based operations.");

        List<String> list = new ArrayList<>(queue);

        System.out.println("Converted List: " + list);
        System.out.println("Element at index 0: " + list.get(0));

        // 14. indexOf() and lastIndexOf()
        System.out.println("\n14. indexOf() and lastIndexOf()");
        System.out.println("Purpose: Finds the first and last occurrence "
                + "in the converted List.");

        System.out.println("First Java index: " + list.indexOf("Java"));
        System.out.println("Last Java index: " + list.lastIndexOf("Java"));

        // 15. subList()
        System.out.println("\n15. subList() Operation");
        System.out.println("Purpose: Returns a List view between "
                + "fromIndex inclusive and toIndex exclusive.");

        if (list.size() >= 2) {
            System.out.println("SubList: " + list.subList(0, 2));
        }

        // 16. Collections.frequency()
        System.out.println("\n16. frequency() Operation");
        System.out.println("Purpose: Counts occurrences of an element.");

        System.out.println("Frequency of Java: "
                + Collections.frequency(queue, "Java"));

        // 17. Maximum and minimum
        System.out.println("\n17. Maximum and Minimum");
        System.out.println("Purpose: Finds alphabetically greatest "
                + "and smallest elements.");

        if (!queue.isEmpty()) {
            System.out.println("Maximum: " + Collections.max(queue));
            System.out.println("Minimum: " + Collections.min(queue));
        }

        // 18. Sorting a copied List
        System.out.println("\n18. Sorting Operation");
        System.out.println("Purpose: Sorts a List copy without modifying "
                + "the original Queue.");

        Collections.sort(list);
        System.out.println("Ascending order: " + list);

        Collections.sort(list, Collections.reverseOrder());
        System.out.println("Descending order: " + list);

        // 19. Shuffle a copied List
        System.out.println("\n19. shuffle() Operation");
        System.out.println("Purpose: Randomly rearranges the List copy.");

        Collections.shuffle(list);
        System.out.println("Shuffled List: " + list);

        // 20. addAll()
        System.out.println("\n20. addAll() Operation");
        System.out.println("Purpose: Adds all elements from another collection.");

        List<String> additionalElements = new ArrayList<>();
        additionalElements.add("SQL");
        additionalElements.add("JDBC");

        queue.addAll(additionalElements);

        System.out.println("Queue after addAll(): " + queue);

        // 21. remove(Object)
        System.out.println("\n21. remove(Object) Operation");
        System.out.println("Purpose: Removes the first matching occurrence "
                + "of an element.");

        boolean removed = queue.remove("Spring");

        System.out.println("Was Spring removed? " + removed);
        System.out.println("Queue after remove(Object): " + queue);

        // 22. removeAll()
        System.out.println("\n22. removeAll() Operation");
        System.out.println("Purpose: Removes elements contained "
                + "in another collection.");

        List<String> removeElements = new ArrayList<>();
        removeElements.add("SQL");
        removeElements.add("JDBC");

        queue.removeAll(removeElements);

        System.out.println("Queue after removeAll(): " + queue);

        // 23. retainAll()
        System.out.println("\n23. retainAll() Operation");
        System.out.println("Purpose: Retains only elements that occur "
                + "in another collection.");

        List<String> retainElements = new ArrayList<>();
        retainElements.add("Java");
        retainElements.add("Kafka");

        queue.retainAll(retainElements);

        System.out.println("Queue after retainAll(): " + queue);

        // 24. Clone/copy demonstration
        System.out.println("\n24. Queue Copy Operation");
        System.out.println("Purpose: Creates a separate LinkedList "
                + "containing the same elements.");

        Queue<String> copiedQueue = new LinkedList<>(queue);

        System.out.println("Original Queue: " + queue);
        System.out.println("Copied Queue: " + copiedQueue);
        System.out.println("Same object? " + (queue == copiedQueue));

        // 25. equals() and hashCode()
        System.out.println("\n25. equals() and hashCode()");
        System.out.println("Purpose: Compares Queue contents and "
                + "calculates a content-based hash code.");

        System.out.println("Queues equal? " + queue.equals(copiedQueue));
        System.out.println("Original hashCode: " + queue.hashCode());
        System.out.println("Copied hashCode: " + copiedQueue.hashCode());

        // 26. Clear operation
        System.out.println("\n26. clear() Operation");
        System.out.println("Purpose: Removes all elements from the Queue.");

        queue.clear();

        System.out.println("Queue after clear(): " + queue);
        System.out.println("Is Queue empty? " + queue.isEmpty());

        // 27. Empty Queue exception handling
        System.out.println("\n27. Empty Queue Handling");
        System.out.println("Purpose: Demonstrates the difference between "
                + "exception-based and special-value methods.");

        System.out.println("poll() on empty Queue: " + queue.poll());
        System.out.println("peek() on empty Queue: " + queue.peek());

        try {
            queue.remove();
        } catch (java.util.NoSuchElementException e) {
            System.out.println("remove(): Queue is empty.");
        }

        try {
            queue.element();
        } catch (java.util.NoSuchElementException e) {
            System.out.println("element(): Queue is empty.");
        }

        // 28. PriorityQueue demonstration
        System.out.println("\n28. PriorityQueue Demonstration");
        System.out.println("Purpose: Demonstrates priority-based retrieval. "
                + "Natural order is used for Strings.");

        Queue<String> priorityQueue = new PriorityQueue<>();

        priorityQueue.offer("Spring");
        priorityQueue.offer("Java");
        priorityQueue.offer("Microservices");
        priorityQueue.offer("Kafka");

        System.out.println("PriorityQueue: " + priorityQueue);
        System.out.println("Head by priority: " + priorityQueue.peek());

        System.out.println("Removing elements in priority order:");

        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }

        System.out.println("\n==========================================");
        System.out.println("       QUEUE OPERATIONS COMPLETED");
        System.out.println("==========================================");
    }
}
/*
		Queue method differences
		Operation	  If operation fails / queue is empty
		add(e)		  Throws an exception if insertion fails
		offer(e)	  Returns false if insertion fails
		remove()	  Throws NoSuchElementException
		poll()	      Returns null
		element()	  Throws NoSuchElementException
		peek()	      Returns null
		
		Queue itself is an interface and does not guarantee FIFO for every implementation.
		 LinkedList used as a queue follows FIFO when elements are inserted with offer() 
		 and removed with poll(). PriorityQueue follows priority ordering, and its iterator 
		 does not guarantee sorted traversal.
		 Also, Queue does not expose clone().
		 The example uses new LinkedList<>(queue) 
		 to demonstrate copying without relying on an implementation-specific clone() method.
		 
		 Main Queue implementation classes
		 
		 1. LinkedList
			General-purpose
			Implements Queue, Deque, and List. Supports FIFO processing, insertion and removal at both ends, 
			and indexed access.
			Use when: You need a general-purpose queue or deque and also need list operations.
			
		2. PriorityQueue
		Priority-based
		Retrieves the highest-priority element first.
		 By default, natural ordering is used; for numbers, this means the smallest number is retrieved first.
		Use when: You need task scheduling by priority, shortest-job selection, 
		or algorithms such as Dijkstra's shortest path.

		3. ArrayDeque
		Efficient deque
		Array-backed double-ended queue. 
		Supports insertion and removal at both ends and is commonly preferred over Stack for stack operations.
		Use when: You need an efficient, non-thread-safe FIFO queue, deque, or stack.
		
		4. ArrayBlockingQueue
		Bounded and thread-safe
		Array-backed blocking queue with a fixed capacity.
		Use when: Producers and consumers share a buffer with a strict maximum size, such as a controlled worker pool.

		5. LinkedBlockingQueue
		Blocking and thread-safe
		Linked-node queue that can be bounded or effectively unbounded 
		(the default constructor uses a very large maximum capacity).
		Use when: Background workers consume tasks submitted by producer threads.
		
		6. PriorityBlockingQueue
		Thread-safe priority queue that supports blocking retrieval. It is logically unbounded, 
		so producers are not blocked by a configured capacity limit.
		Use when: Multiple threads submit tasks that workers must process according to priority.
		
		7. SynchronousQueue
		Has no internal storage capacity. Each insertion must rendezvous with a corresponding removal.
		Use when: Tasks should be handed directly between threads without being buffered, 
		such as in certain executor configurations.

		8. DelayQueue
		An unbounded blocking queue whose elements become available for retrieval only 
		after their delay expires. Elements must implement Delayed.
		Use when: You need delayed jobs, expiring tasks, or time-based scheduling.

		9. ConcurrentLinkedQueue
		A non-blocking, thread-safe FIFO queue. 
		It does not wait for an element to become available and is unbounded.
		Use when: Multiple threads need concurrent FIFO access without blocking queue operations.
		
		Other important Queue and Deque implementations
		
		Implementation					Main purpose													When to use
		LinkedBlockingDeque	            Thread-safe, optionally bounded double-ended blocking queue	    Producer-consumer workflows where insertion/removal at both ends is required
		ConcurrentLinkedDeque	        Non-blocking, thread-safe double-ended queue					Concurrent access from multiple threads, without blocking waits
		LinkedTransferQueue	            Thread-safe transfer queue										Producer threads may hand tasks directly to waiting consumers or enqueue them
		PriorityQueue                   with a custom comparator	Custom priority ordering	 		Process urgent tasks before less urgent tasks
		
		A distinction worth emphasizing: BlockingQueue is an interface, not a concrete class. 
		Classes such as ArrayBlockingQueue and LinkedBlockingQueue implement it. 
		Similarly, Deque is an interface implemented by classes such as ArrayDeque and LinkedList.
		
		Queue does not guarantee FIFO for every implementation.

		PriorityQueue does not guarantee sorted iteration; repeatedly calling poll() retrieves elements in priority order.
		
		ArrayDeque generally offers an efficient alternative to Stack and LinkedList for ordinary queue/deque usage.
		
		BlockingQueue provides waiting operations such as put() and take().
		
		ConcurrentLinkedQueue is thread-safe but does not provide blocking retrieval.
		
		ArrayBlockingQueue has fixed capacity; LinkedBlockingQueue can be bounded or effectively unbounded.

		Standard Java queues generally do not permit null elements.

*/