package com.fortress.java.preparation.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

/**
 * smamilla
 */
public class StackOperations {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("       JAVA STACK OPERATIONS DEMO");
        System.out.println("==========================================");

        // 1. Creating a Stack
        System.out.println("\n1. Creating a Stack");
        System.out.println("Purpose: Stack follows LIFO - Last In, First Out.");

        Stack<String> stack = new Stack<>();

        System.out.println("Empty Stack: " + stack);
        System.out.println("Is Stack empty? " + stack.empty());

        // 2. push() operation
        System.out.println("\n2. push() Operation");
        System.out.println("Purpose: Adds an element to the top of the Stack.");

        stack.push("Java");
        System.out.println("After pushing Java: " + stack);

        stack.push("Spring");
        System.out.println("After pushing Spring: " + stack);

        stack.push("Microservices");
        System.out.println("After pushing Microservices: " + stack);

        stack.push("Kafka");
        System.out.println("After pushing Kafka: " + stack);

        System.out.println("Current Stack: " + stack);

        // 3. peek() operation
        System.out.println("\n3. peek() Operation");
        System.out.println("Purpose: Retrieves the top element without removing it.");

        System.out.println("Top element: " + stack.peek());
        System.out.println("Stack after peek(): " + stack);

        // 4. search() operation
        System.out.println("\n4. search() Operation");
        System.out.println("Purpose: Searches from the top; position starts at 1.");

        System.out.println("Position of Kafka: " + stack.search("Kafka"));
        System.out.println("Position of Java: " + stack.search("Java"));
        System.out.println("Position of Python: " + stack.search("Python"));

        // 5. pop() operation
        System.out.println("\n5. pop() Operation");
        System.out.println("Purpose: Removes and returns the top element.");

        String removedElement = stack.pop();
        System.out.println("Popped element: " + removedElement);
        System.out.println("Stack after pop(): " + stack);

        // 6. push() duplicate elements
        System.out.println("\n6. Pushing Duplicate Elements");
        System.out.println("Purpose: Stack permits duplicate elements.");

        stack.push("Java");
        System.out.println("After pushing Java again: " + stack);

        // 7. size() operation
        System.out.println("\n7. size() Operation");
        System.out.println("Purpose: Returns the number of elements.");

        System.out.println("Stack size: " + stack.size());

        // 8. contains() operation
        System.out.println("\n8. contains() Operation");
        System.out.println("Purpose: Checks whether an element exists.");

        System.out.println("Contains Spring? " + stack.contains("Spring"));
        System.out.println("Contains Python? " + stack.contains("Python"));

        // 9. indexOf() and lastIndexOf()
        System.out.println("\n9. indexOf() and lastIndexOf()");
        System.out.println("Purpose: Finds the first and last matching index; indexes start at 0.");

        System.out.println("First Java index: " + stack.indexOf("Java"));
        System.out.println("Last Java index: " + stack.lastIndexOf("Java"));

        // 10. get() operation
        System.out.println("\n10. get() Operation");
        System.out.println("Purpose: Retrieves an element using its zero-based index.");

        System.out.println("Element at index 0: " + stack.get(0));
        System.out.println("Element at index 1: " + stack.get(1));

        // 11. set() operation
        System.out.println("\n11. set() Operation");
        System.out.println("Purpose: Replaces an element at a specified index.");

        stack.set(0, "Core Java");
        System.out.println("Stack after set(): " + stack);

        // 12. Iterator
        System.out.println("\n12. Iterator Operation");
        System.out.println("Purpose: Traverses Stack from bottom to top.");

        Iterator<String> iterator = stack.iterator();

        while (iterator.hasNext()) {
            System.out.println("Element: " + iterator.next());
        }

        // 13. ListIterator
        System.out.println("\n13. ListIterator Operation");
        System.out.println("Purpose: Traverses forward and backward.");

        ListIterator<String> listIterator = stack.listIterator();

        System.out.println("Forward traversal:");
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        System.out.println("Backward traversal:");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

        // 14. Enhanced for loop
        System.out.println("\n14. Enhanced for Loop");
        System.out.println("Purpose: Traverses all elements without explicit indexes.");

        for (String element : stack) {
            System.out.println(element);
        }

        // 15. Search with contains() and indexOf()
        System.out.println("\n15. Searching for an Element");
        System.out.println("Purpose: Demonstrates membership and index-based searching.");

        String searchElement = "Spring";

        if (stack.contains(searchElement)) {
            System.out.println(searchElement + " exists at index "
                    + stack.indexOf(searchElement));
        } else {
            System.out.println(searchElement + " does not exist.");
        }

        // 16. remove(Object)
        System.out.println("\n16. remove(Object) Operation");
        System.out.println("Purpose: Removes the first matching element.");

        boolean removed = stack.remove("Spring");
        System.out.println("Was Spring removed? " + removed);
        System.out.println("Stack after remove(): " + stack);

        // 17. remove(index)
        System.out.println("\n17. remove(index) Operation");
        System.out.println("Purpose: Removes the element at the specified index.");

        String removedByIndex = stack.remove(0);
        System.out.println("Removed element: " + removedByIndex);
        System.out.println("Stack after removing index 0: " + stack);

        // 18. add() operation
        System.out.println("\n18. add() Operation");
        System.out.println("Purpose: Stack inherits add() from List.");

        stack.add("Hibernate");
        System.out.println("Stack after add(): " + stack);

        // 19. add(index, element)
        System.out.println("\n19. add(index, element) Operation");
        System.out.println("Purpose: Inserts an element at a specified index.");

        stack.add(0, "Advanced Java");
        System.out.println("Stack after indexed insertion: " + stack);

        // 20. addAll() operation
        System.out.println("\n20. addAll() Operation");
        System.out.println("Purpose: Adds all elements from another collection.");

        ArrayList<String> additionalElements = new ArrayList<>();
        additionalElements.add("SQL");
        additionalElements.add("JDBC");

        stack.addAll(additionalElements);
        System.out.println("Stack after addAll(): " + stack);

        // 21. subList() operation
        System.out.println("\n21. subList() Operation");
        System.out.println("Purpose: Returns a view from fromIndex inclusive to toIndex exclusive.");

        if (stack.size() >= 2) {
            System.out.println("SubList: " + stack.subList(0, 2));
        }

        // 22. Collections.frequency()
        System.out.println("\n22. frequency() Operation");
        System.out.println("Purpose: Counts occurrences of an element.");

        System.out.println("Frequency of Java: "
                + Collections.frequency(stack, "Java"));

        // 23. Collections.max() and min()
        System.out.println("\n23. Maximum and Minimum");
        System.out.println("Purpose: Finds alphabetically greatest and smallest elements.");

        System.out.println("Maximum: " + Collections.max(stack));
        System.out.println("Minimum: " + Collections.min(stack));

        // 24. Sorting
        System.out.println("\n24. Sorting Operation");
        System.out.println("Purpose: Sorts the Stack as a List; this changes its element order.");

        Collections.sort(stack);
        System.out.println("Ascending order: " + stack);

        Collections.sort(stack, Collections.reverseOrder());
        System.out.println("Descending order: " + stack);

        // 25. Shuffle
        System.out.println("\n25. shuffle() Operation");
        System.out.println("Purpose: Randomly rearranges elements.");

        Collections.shuffle(stack);
        System.out.println("Stack after shuffle: " + stack);

        // 26. Clone
        System.out.println("\n26. clone() Operation");
        System.out.println("Purpose: Creates a shallow copy of the Stack.");

        @SuppressWarnings("unchecked")
        Stack<String> clonedStack = (Stack<String>) stack.clone();

        System.out.println("Original Stack: " + stack);
        System.out.println("Cloned Stack: " + clonedStack);
        System.out.println("Same object? " + (stack == clonedStack));

        // 27. equals() and hashCode()
        System.out.println("\n27. equals() and hashCode()");
        System.out.println("Purpose: Compares contents and calculates a content-based hash code.");

        System.out.println("Stacks equal? " + stack.equals(clonedStack));
        System.out.println("Original hashCode: " + stack.hashCode());
        System.out.println("Cloned hashCode: " + clonedStack.hashCode());

        // 28. removeAll()
        System.out.println("\n28. removeAll() Operation");
        System.out.println("Purpose: Removes all elements contained in another collection.");

        ArrayList<String> removeElements = new ArrayList<>();
        removeElements.add("SQL");
        removeElements.add("JDBC");

        stack.removeAll(removeElements);
        System.out.println("Stack after removeAll(): " + stack);

        // 29. retainAll()
        System.out.println("\n29. retainAll() Operation");
        System.out.println("Purpose: Retains only elements present in another collection.");

        ArrayList<String> retainElements = new ArrayList<>();
        retainElements.add("Java");
        retainElements.add("Spring");

        stack.retainAll(retainElements);
        System.out.println("Stack after retainAll(): " + stack);

        // 30. clear()
        System.out.println("\n30. clear() Operation");
        System.out.println("Purpose: Removes all elements from the Stack.");

        stack.clear();
        System.out.println("Stack after clear(): " + stack);
        System.out.println("Is Stack empty? " + stack.empty());

        // 31. Exception handling for empty Stack
        System.out.println("\n31. Empty Stack Handling");
        System.out.println("Purpose: pop() and peek() throw EmptyStackException when empty.");

        try {
            stack.pop();
        } catch (java.util.EmptyStackException e) {
            System.out.println("Cannot pop: Stack is empty.");
        }

        try {
            stack.peek();
        } catch (java.util.EmptyStackException e) {
            System.out.println("Cannot peek: Stack is empty.");
        }

        System.out.println("\n==========================================");
        System.out.println("       STACK OPERATIONS COMPLETED");
        System.out.println("==========================================");
    }
}
/*
 	1. Stack follows LIFO
	   Last In, First Out. The last element pushed onto the stack is the first one popped off.

	2. push(), pop() and peek()
	   push() adds an element, 
	   pop() removes and returns the top element, 
	   and peek() reads the top without removing it.

	3. search() vs. indexOf()
	   search() counts positions from the top starting at 1. 
	   indexOf() counts indexes from the bottom starting at 0.

	4. Empty stack exceptions
	   Calling pop() or peek() on an empty stack throws EmptyStackException.
	   Check empty() or isEmpty() before performing these operations when necessary.

Production note: Stack is a legacy, synchronized collection that extends Vector. 
For new stack-oriented code, Java generally recommends Deque with ArrayDeque, using push(), pop(), and peek(). 
The example above uses Stack specifically to teach its API and inherited collection methods.
 
 */
