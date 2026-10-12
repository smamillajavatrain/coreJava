package com.fortress.java.preparation.collection;

/**
 * smamilla
 */
public class JavaCollection {
	/*
	   Internal architecture at a glance
	   
	    HashMap
		Key-value storage
		Uses a hash table, bucket array, and linked nodes or tree bins when collisions become large. 
		It is not thread-safe.
		
		ConcurrentHashMap
		Concurrent key-value storage
		Uses a bucket array, 
		CAS operations and synchronized access to individual bins in Java 11, 
		allowing concurrent access without locking the entire map for every update.
		
		ArrayList
		Indexed list
		Stores elements in a resizable array. Index-based reads are fast;
		 inserting or removing elements in the middle requires shifting elements.
		
		HashSet
		Unique elements
		Internally uses a HashMap. Each set element is stored as a map key, 
		with a shared dummy object as its value.
		
		TreeSet
		Unique sorted elements
		Internally uses a TreeMap, which is based on a red-black tree.
		 Elements are kept sorted by natural ordering or a comparator.
	 
	 
	 Internal working of HashMap
	 . How data is stored
		Consider:
		Map<Integer, String> map = new HashMap<>();
		
		map.put(101, "Sree");
		map.put(102, "Vihas");
		map.put(103, "Divya");
		
		Conceptually, HashMap maintains an array of buckets. Each bucket can hold a node containing a hash, key, value and a reference to the next node.
		Simplified HashMap bucket array
		Bucket 0
		Empty
		Bucket 1
		Node: 101 → Sree
		Bucket 2
		Node: 102 → Vihas
		Bucket 3
		Empty
		Bucket 4
		Node: 103 → Divya
		Bucket 5
		Empty

This is a conceptual example, not the exact bucket positions produced by the JVM.
B. What happens during put(key, value)?
1. Calculate the hash. Java calls the key's hashCode() and applies a supplemental hash-spreading operation.
2. Calculate the bucket index. In Java 11, the index is calculated approximately as (capacity - 1) & hash, where capacity is a power of two.
3. Check the bucket. If it is empty, create a node. Otherwise, inspect the existing node or nodes.
4. Check for an existing key. HashMap checks the hash and key equality using reference identity or equals(). If the key exists, its value is updated.
5. Handle a collision. If different keys map to the same bucket, nodes are linked together. A sufficiently large collision bin can become a red-black tree.
6. Check resizing. When the number of mappings exceeds the applicable threshold, the table may resize and redistribute entries.
C. How collisions work

Two different keys may map to the same bucket. This is called a collision.
One bucket, multiple nodes
Bucket 4
Key A → Value A
Key B → Value B

Both keys occupy the same bucket but remain separate mappings if they are unequal.
In Java 11, the implementation can treeify a collision bin when it reaches the treeification threshold (8 nodes), provided the table capacity is at least 64. Otherwise, resizing may be attempted first. These are implementation details, not guarantees of the Map API.
D. Important Java 11 implementation values
Detail	Java 11 behavior
Default initial capacity	16 when the table is first allocated
Default load factor	0.75
Typical threshold at capacity 16	12 mappings
Bucket structure	Array of nodes
Collision handling	Linked nodes; red-black tree for sufficiently large bins
Average get() / put()	\(O(1)\) with good hash distribution
Worst-case lookup	Can be \(O(\log n)\) for tree bins under suitable conditions; ordinary collision chains can be \(O(n)\)

Interview takeaway: A good hashCode() distributes keys across buckets, 
while a correct equals() determines whether two keys represent the same logical key.
 Equal keys must have equal hash codes.
 
3. Internal working of ConcurrentHashMap
ConcurrentHashMap is designed for applications where multiple threads read and update a map concurrently,
 such as shared caches, counters, session metadata and request tracking.
A. How it differs from HashMap
Feature								HashMap										ConcurrentHashMap
Thread-safe for concurrent updates	No											Yes, for its supported operations
Locking strategy					No 											built-in synchronization	CAS and bin-level synchronization in Java 11
Entire map locked for every write?	No											No
Null keys							One allowed									Not allowed
Null values							Allowed										Not allowed
Iterators							Fail-fast on a best-effort basis			Weakly consistent
Atomic methods						No built-in concurrent atomicity			Supports methods such as putIfAbsent, compute, and merge
Typical use	Single-threaded or externally synchronized access					Shared maps accessed by multiple threads

B. Internal working in Java 11
Java 11's ConcurrentHashMap does not use the old Java 7 segmented-lock architecture. 
Its implementation works broadly as follows:
ConcurrentHashMap table
Bucket array

Empty bin
CAS may be used to install a new node atomically.

Occupied bin
Updates can synchronize on the bin's head node.

Collision bin
Traverses nodes or uses a tree bin when appropriate.

Resize
Threads can cooperate in transferring entries to a new table.

Conceptual overview of Java 11's concurrent implementation.
C. What happens during put(key, value)?
1. Calculate the key's hash and determine the target bucket.
2. If the bucket is empty, attempt to insert a node using CAS (compare-and-set).
3. If the bucket is occupied, coordinate updates using synchronization on the bin's head node.
4. Check whether the key already exists; update its value or add a new mapping.
5. Manage collision trees and resizing as necessary.
CAS is an atomic operation that attempts to change a value only if it still matches an expected value. 
It helps avoid locking in certain common cases.

D. Example — concurrent updates
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class ConcurrentHashMapExample {

    public static void main(String[] args) throws InterruptedException {

        Map<String, Integer> counts = new ConcurrentHashMap<>();

        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                counts.merge("Java", 1, Integer::sum);
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        System.out.println("Before execution: " + counts);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("After execution: " + counts);
        // Expected: {Java=2000}
    }
}

The merge() operation safely combines the updates to the same key. A plain counts.put("Java", counts.get("Java") + 1) would not provide the same atomic read-modify-write behavior.
Important: ConcurrentHashMap makes its supported map operations thread-safe, but it does not automatically make an arbitrary sequence of multiple operations atomic. Use appropriate atomic map methods or external synchronization when the whole sequence must be indivisible.
E. Important interview notes
- Reads generally do not require locking the entire map.
- Concurrent updates to unrelated bins can often proceed independently.
- Iterators are weakly consistent: they do not throw ConcurrentModificationException merely because another thread modifies the map, but they may reflect some concurrent changes and not others.
- Null keys and values are prohibited, avoiding ambiguity between an absent mapping and a mapping with a null value.
- Use ConcurrentHashMap rather than HashMap when a shared map needs concurrent updates without external synchronization.

4. Internal working of ArrayList
ArrayList stores its elements in an internal array. It grows the array when more capacity is required.
A. Internal structure
ArrayList
   |
   v
Internal Object[] array

Index:   0       1       2       3       4
       +-------+-------+-------+-------+-------+
Value: | Sree  |Vihas  |Divya  |Bhargav| null  |
       +-------+-------+-------+-------+-------+
       <--------- size = 4 --------->


The array capacity can be greater than the logical size. Unused slots are not elements of the list.

B. How common operations work
Operation			Internal behavior					Typical time
get(index)			Reads the array slot at the index	\(O(1)\)
set(index, value)	Replaces an existing slot			\(O(1)\)
add(value)			Writes at the next available slot	Amortized \(O(1)\)
add(index, value)	Shifts later elements to the right	\(O(n)\)
remove(index)		Shifts subsequent elements to the left	\(O(n)\)
contains(value)		Scans elements using equality checks	\(O(n)\)
indexOf(value)		Searches from the beginning	\(O(n)\)
ensureCapacity()	Can grow the backing array	Depends on resizing
clear()				Clears active element references	\(O(n)\)

C. How resizing works
In Java 11, a default-constructed ArrayList initially uses a shared empty array internally.
 When the first element is added, it normally allocates capacity 10. When capacity is exhausted, 
 the backing array is typically grown to around 1.5 times its previous capacity, subject to implementation limits.
Example:
import java.util.ArrayList;
import java.util.List;

public class ArrayListInternalDemo {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();

        System.out.println("Initial list: " + numbers);

        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        System.out.println("After adding: " + numbers);
        System.out.println("Element at index 1: " + numbers.get(1));

        numbers.add(1, 15);

        System.out.println("After inserting at index 1: " + numbers);
        // Elements from index 1 onward shift right.

        numbers.remove(2);

        System.out.println("After removing index 2: " + numbers);
        // Later elements shift left.
    }
}


Interview takeaway:
 ArrayList is excellent for frequent indexed access and append operations, 
 but it is less efficient for frequent insertions or removals near the beginning or middle.

5. Internal working of HashSet
The most important interview point is that HashSet internally uses a HashMap.

A. How elements are stored
Consider:
Set<String> names = new HashSet<>();

names.add("Sree");
names.add("Vihas");
names.add("Sree");

Conceptually, Java stores the elements as keys in an internal HashMap, with a shared dummy object as the value.
HashSet
Sree, Vihas, Sree

Internal HashMap
Key = Set element; Value = shared dummy object
Sree → PRESENT
Vihas → PRESENT

The second attempt to add Sree does not create a second entry because the key already exists.
B. How add(element) works
1. HashSet.add(element) delegates to the internal map's insertion logic.
2. The map calculates the element's hash and determines its bucket.
3. If the element is not already present, it is added as a key.
4. If an equal element already exists, the insertion is rejected.
5. The method returns true if the set changed and false if the element was already present.

C. Example
import java.util.HashSet;
import java.util.Set;

public class HashSetInternalDemo {

    public static void main(String[] args) {

        Set<String> names = new HashSet<>();

        System.out.println("Initial set: " + names);

        System.out.println("Add Sree: " + names.add("Sree"));
        System.out.println("After adding Sree: " + names);

        System.out.println("Add Vihas: " + names.add("Vihas"));
        System.out.println("After adding Vihas: " + names);

        System.out.println("Add duplicate Sree: "
                + names.add("Sree"));

        System.out.println("After duplicate insertion: " + names);

        System.out.println("Contains Vihas: " + names.contains("Vihas"));

        System.out.println("Remove Sree: " + names.remove("Sree"));
        System.out.println("After removal: " + names);
    }
}


D. Important HashSet notes

Feature						Internal behavior
Backing structure			HashMap
Duplicate elements			Not permitted
Ordering					No guaranteed iteration order
add()						Uses the backing map's key-insertion logic
contains()					Uses hash-based lookup
remove()					Removes the corresponding map key
Null elements				One null element is permitted
Average lookup/insertion	\(O(1)\), assuming good hash distribution
Thread safety				Not synchronized by default

Interview takeaway: If asked how HashSet prevents duplicates, explain hashCode(), bucket selection,
and equals() comparisons for candidate elements in the relevant bucket.

6. Internal working of TreeSet
TreeSet internally uses a TreeMap, which is based on a red-black tree.
 A red-black tree is a self-balancing binary search tree.
 
A. How elements are stored
Consider: TreeSet<Integer> numbers =
        new TreeSet<>(Arrays.asList(30, 10, 40, 20, 50));
Conceptually, the elements form a sorted search tree:
30
10
40
—
20
—
50

Simplified illustration of a search tree. The actual tree shape may differ 
because the tree balances itself as elements are inserted or removed.
The red-black tree maintains ordering and balancing rules so that operations remain efficient.

B. How add(element) works
	1. TreeSet.add(element) delegates to the internal TreeMap.
	2. The element is compared with existing elements using natural ordering or the configured Comparator.
	3. If the comparison identifies an existing equivalent element, no duplicate is added.
	4. Otherwise, a new tree node is inserted in the appropriate position.
	5. The tree performs recoloring and rotations when necessary to maintain red-black tree properties.
	
C. Example
import java.util.Arrays;
import java.util.TreeSet;

public class TreeSetInternalDemo {

    public static void main(String[] args) {

        TreeSet<Integer> numbers = new TreeSet<>();

        System.out.println("Initial set: " + numbers);

        numbers.add(30);
        System.out.println("After adding 30: " + numbers);

        numbers.add(10);
        System.out.println("After adding 10: " + numbers);

        numbers.add(40);
        System.out.println("After adding 40: " + numbers);

        numbers.add(20);
        System.out.println("After adding 20: " + numbers);

        numbers.add(50);
        System.out.println("After adding 50: " + numbers);

        System.out.println("Add duplicate 30: " + numbers.add(30));
        System.out.println("After duplicate insertion: " + numbers);

        System.out.println("Smallest element: " + numbers.first());
        System.out.println("Largest element: " + numbers.last());

        System.out.println("Lower than 30: " + numbers.lower(30));
        System.out.println("Higher than 30: " + numbers.higher(30));

        numbers.remove(30);
        System.out.println("After removing 30: " + numbers);
    }
}


D. Important TreeSet notes
Feature					Internal behavior
Backing structure		TreeMap
Data structure			Red-black tree
Ordering				Natural ordering or custom comparator
Duplicate elements		Not permitted under the set's ordering
Average and worst-case  add/search/remove	\(O(\log n)\)
Null elements			Generally not supported with natural ordering
Thread safety			Not synchronized by default
Special methods	first(), last(), lower(), floor(), ceiling(), higher()
Important: TreeSet uses comparison results to determine whether an element is already represented. 
If compare(a, b) == 0, the set treats those elements as equivalent for its ordering, even if a.equals(b) is false.

7. Final comparison — all five collections
Feature					HashMap				ConcurrentHashMap			ArrayList			HashSet					TreeSet
Stores					Key-value pairs		Key-value pairs	Elements	Duplicate eleemnts  Unique elements			Unique sorted elements
Internal structure		Hash table			Concurrent hash table		Resizable array		Backing HashMap			Backing TreeMap
Ordering				No guarantee		No guarantee				Insertion/index order	No guarantee		Sorted
Duplicates	Keys: 		no; values: yes		Keys: no; values: yes		Yes						No	No, by comparison
Null support			Null key and values	No null keys or values	Permitted	One null element	Generally no null with natural ordering
Thread-safe by default	No					Yes, for supported operations	No	No	No
Typical lookup	\(O(1)\) average	\(O(1)\) average	\(O(1)\) by index	\(O(1)\) average	\(O(\log n)\)
Best use case	Fast key-value lookup	Concurrent shared map	Indexed sequence	Fast uniqueness checks	Sorted uniqueness and range queries

8. What interviewers expect you to explain

1. How does HashMap resolve collisions? Hash spreading, bucket indexing, linked nodes, tree bins and resizing.
2. How is ConcurrentHashMap different from HashMap? CAS, bin-level synchronization, 
	safe concurrent operations and restrictions on nulls.
3. Why is ArrayList fast for get(index) but slower for middle insertions? 
	Direct array access versus shifting elements.
4. How does HashSet prevent duplicates? 
	It uses HashMap keys and hash/equality checks.
5. Why is TreeSet slower than HashSet for typical lookups? 
	It maintains sorted order using a balanced tree, with logarithmic operations rather than average constant-time hash lookup.
	
	Java Generics
	
	Java Generics were introduced in Java 5 to provide compile-time type safety, reusable code, and fewer explicit type casts. They are widely used in the Java Collections Framework, custom utility classes, repositories, APIs and enterprise applications.
	These notes cover all seven topics: Generics, Generic Classes, Bounded Types, Generic Methods, Wildcard Characters, Communication with Non-Generic Code, and Conclusions.
	1. Generics
	1.1 What are Generics?
	Generics allow classes, interfaces and methods to operate on different data types while preserving type safety.
	Without generics, we often use Object, which requires explicit type casting.
	
	Example 1 — Without Generics
	import java.util.ArrayList;
	import java.util.List;

	public class WithoutGenericsExample {

	    public static void main(String[] args) {

	        // A raw collection can store different object types.
	        List values = new ArrayList();

	        System.out.println("Before adding elements: " + values);

	        values.add("Java");
	        values.add(100);
	        values.add(25.5);

	        System.out.println("After adding elements: " + values);

	        // Explicit casting is required.
	        String language = (String) values.get(0);

	        System.out.println("Language: " + language);

	        // This causes ClassCastException at runtime.
	        // Uncomment to see the exception.
	        // String number = (String) values.get(1);
	    }
	}

	Problem: The compiler cannot ensure that every element is a String. Incorrect casts can cause runtime errors.
	Example 2 — With Generics
	import java.util.ArrayList;
	import java.util.List;

	public class GenericsExample {

	    public static void main(String[] args) {

	        // This list can store only String objects.
	        List<String> languages = new ArrayList<>();

	        System.out.println("Before adding elements: " + languages);

	        languages.add("Java");
	        languages.add("Spring Boot");
	        languages.add("Microservices");

	        System.out.println("After adding elements: " + languages);

	        // No explicit casting is needed.
	        String language = languages.get(0);

	        System.out.println("First language: " + language);

	        // Compile-time error:
	        // languages.add(100);
	    }
	}

	1.2 Advantages of Generics
	Advantage	Explanation
	Type safety	Detects incompatible types at compile time.
	Code reusability	One implementation can support multiple data types.
	No explicit casting	Retrieved values have the declared type.
	Fewer runtime errors	Prevents many invalid type conversions.
	Better readability	The intended data type is explicit.
	API design	Enables reusable utilities, repositories and service abstractions.
	
	1.3 Generic type parameter naming conventions
	These are conventions, not mandatory names.
	Symbol	Common meaning				Example
	T		Type						List<T>
	E		Element						Set<E>
	K		Key	Map						<K, V>
	V		Value						Map<K, V>
	N		Number						<N extends Number>
	R		Result or return type		<T, R>
	
	Remember: T, E, K, and V are placeholders for types, not actual Java classes.

	2. Generic Classes
	A generic class declares one or more type parameters at the class level. 
	Those parameters can then be used in instance variables, constructors, methods and return types.
	
	2.1 Syntax
	class ClassName<T> {
	    private T value;

	    public void setValue(T value) {
	        this.value = value;
	    }

	    public T getValue() {
	        return value;
	    }
	}


	Here, T is decided when the object is created.
	2.2 Best example — GenericBox

	class GenericBox<T> {

	    private T value;

	    public GenericBox(T value) {
	        this.value = value;
	    }

	    public void setValue(T value) {
	        System.out.println("Before updating value: " + this.value);

	        this.value = value;

	        System.out.println("After updating value: " + this.value);
	    }

	    public T getValue() {
	        return value;
	    }

	    public void display() {
	        System.out.println("Stored value: " + value);
	        System.out.println("Stored value type: "
	                + value.getClass().getSimpleName());
	    }
	}

	public class GenericClassExample {

	    public static void main(String[] args) {

	        // T is Integer for this object.
	        GenericBox<Integer> integerBox = new GenericBox<>(100);

	        System.out.println("Integer box:");
	        integerBox.display();

	        integerBox.setValue(200);

	        // T is String for this object.
	        GenericBox<String> stringBox = new GenericBox<>("Java");

	        System.out.println("\nString box:");
	        stringBox.display();

	        stringBox.setValue("Spring Boot");

	        // T is Double for this object.
	        GenericBox<Double> doubleBox = new GenericBox<>(25.5);

	        System.out.println("\nDouble box:");
	        doubleBox.display();
	    }
	}

	Expected behavior
	
	- GenericBox<Integer> accepts integer values.
	- GenericBox<String> accepts string values.
	- GenericBox<Double> accepts double values.
	- Passing an incompatible value produces a compile-time error.
	
	A generic class provides type safety while avoiding the need to write separate box classes for each data type.
	
	2.3 Generic class with multiple type parameters
	A class can declare more than one type parameter.
	class Pair<K, V> {

	    private K key;
	    private V value;

	    public Pair(K key, V value) {
	        this.key = key;
	        this.value = value;
	    }

	    public void display() {
	        System.out.println("Key: " + key);
	        System.out.println("Value: " + value);
	    }
	}

	public class GenericPairExample {

	    public static void main(String[] args) {

	        Pair<Integer, String> employee =
	                new Pair<>(101, "Sree");

	        System.out.println("Employee details:");
	        employee.display();

	        Pair<String, Double> product =
	                new Pair<>("Laptop", 65000.0);

	        System.out.println("\nProduct details:");
	        product.display();
	    }
	}


	This pattern is useful for representing key-value pairs, API responses, 
	request metadata and simple data-transfer structures.
	Important note: Java generics cannot use primitive types directly. 
	Use wrapper types such as Integer, Double, Boolean and Character instead of int, double, boolean and char.

	3. Bounded Types
	Bounded types restrict which types can be supplied to a generic type parameter. 
	They are useful when a generic method or class needs specific capabilities from its type.
	There are three important patterns to understand:
	- Upper-bounded type parameters: T extends SomeType
	- Multiple bounds: T extends ClassName & Interface1 & Interface2
	- Lower bounds are used with wildcards, such as ? super Integer (covered in Section 5).
	
	3.1 Upper-bounded generic class
	Suppose we want to calculate values only for numeric types. 
	Using an unrestricted T would not allow us to call numeric methods such as doubleValue().
	We can restrict the type using T extends Number.

	class NumericBox<T extends Number> {

	    private T value;

	    public NumericBox(T value) {
	        this.value = value;
	    }

	    public double getDoubleValue() {
	        return value.doubleValue();
	    }

	    public void display() {
	        System.out.println("Stored number: " + value);
	        System.out.println("As double: " + getDoubleValue());
	    }
	}

	public class BoundedTypeExample {

	    public static void main(String[] args) {

	        NumericBox<Integer> integerBox = new NumericBox<>(100);
	        System.out.println("Integer example:");
	        integerBox.display();

	        NumericBox<Double> doubleBox = new NumericBox<>(25.75);
	        System.out.println("\nDouble example:");
	        doubleBox.display();

	        NumericBox<Long> longBox = new NumericBox<>(5000L);
	        System.out.println("\nLong example:");
	        longBox.display();

	        // Compile-time error:
	        // NumericBox<String> stringBox = new NumericBox<>("Java");
	    }
	}



	Why does this work?
	Integer, Double and Long extend Number, so they satisfy the bound. String does not extend Number, so it is rejected by the compiler.
	
	3.2 Bounded generic method
	A generic method can also restrict its type parameter.
	public static <T extends Number> double sum(
	        T first, T second) {

	    return first.doubleValue() + second.doubleValue();
	}


	Complete example:
	public class BoundedGenericMethodExample {

	    public static <T extends Number> double sum(
	            T first, T second) {

	        System.out.println("First number: " + first);
	        System.out.println("Second number: " + second);

	        double result =
	                first.doubleValue() + second.doubleValue();

	        System.out.println("Sum: " + result);

	        return result;
	    }

	    public static void main(String[] args) {

	        System.out.println("Integer sum:");
	        sum(10, 20);

	        System.out.println("\nDouble sum:");
	        sum(12.5, 7.5);

	        // Compile-time error:
	        // sum("Java", "Spring");
	    }
	}


	Note that using double can lose precision for very large integers. 
	For exact integer arithmetic, use an appropriate numeric type and conversion strategy.
	
	3.3 Multiple bounds
	A type parameter can be required to extend one class and implement multiple interfaces.
	interface Printable {
	    void print();
	}

	interface Identifiable {
	    int getId();
	}

	class Report extends Object
	        implements Printable, Identifiable {

	    @Override
	    public void print() {
	        System.out.println("Printing report");
	    }

	    @Override
	    public int getId() {
	        return 101;
	    }
	}

	public class MultipleBoundsExample {

	    public static <T extends Object & Printable & Identifiable>
	    void process(T item) {

	        item.print();
	        System.out.println("ID: " + item.getId());
	    }

	    public static void main(String[] args) {

	        Report report = new Report();

	        System.out.println("Processing report:");
	        process(report);
	    }
	}


	In practice, Object is redundant in this particular example because every reference type already extends Object. 
	A simpler bound is:
	public static <T extends Printable & Identifiable>
	void process(T item) {
	    item.print();
	    System.out.println("ID: " + item.getId());
	}


	Syntax rule: If a class bound is specified, it must come first, followed by interface bounds. 
	A type parameter can have at most one class bound.

	4. Generic Methods
	A generic method declares its own type parameter, independently of whether it belongs to a generic class.
	
	4.1 Syntax
	public static <T> void display(T value) {
	    System.out.println(value);
	}


	The <T> declaration appears before the return type. The compiler can often infer the type from the arguments.
	4.2 Example — Generic method to display any array

	public class GenericMethodExample {

	    // T is declared by this method.
	    public static <T> void displayArray(T[] array) {

	        System.out.println("Array elements:");

	        for (T element : array) {
	            System.out.println(element);
	        }
	    }

	    public static void main(String[] args) {

	        Integer[] numbers = {10, 20, 30};

	        System.out.println("Integer array:");
	        displayArray(numbers);

	        String[] languages = {"Java", "Spring", "Microservices"};

	        System.out.println("\nString array:");
	        displayArray(languages);

	        Double[] prices = {10.5, 20.75, 30.25};

	        System.out.println("\nDouble array:");
	        displayArray(prices);
	    }
	}



	One method handles multiple array types while preserving their declared element types.
	
	4.3 Generic method to find the first element
	import java.util.List;

	public class FirstElementExample {

	    public static <T> T getFirst(List<T> list) {

	        if (list == null || list.isEmpty()) {
	            return null;
	        }

	        return list.get(0);
	    }

	    public static void main(String[] args) {

	        List<String> names = List.of("Sree", "Vihas", "Divya");
	        List<Integer> numbers = List.of(10, 20, 30);

	        System.out.println("First name: " + getFirst(names));
	        System.out.println("First number: " + getFirst(numbers));
	    }
	}


	List.of() is available in Java 9 and later, so it works in Java 11. This method returns null for an empty list; 
	in production APIs, consider whether an Optional<T> would express the result more clearly.
	
	4.4 Generic method vs generic class
	Generic class													Generic method
	Declares a type parameter at class level						Declares a type parameter at method level
	Type parameter can be shared across instance fields and methods	Type parameter belongs to that method
	Example: class Box<T>											Example: <T> T first(List<T> list)
	Type is usually determined when creating an object				Type is often inferred from method arguments
	
	A non-generic class can contain a generic method, and a generic class can also contain generic methods.

	5. Wildcard Character (?)
	The wildcard character ? represents an unknown type. 
	It is especially useful when writing methods that accept generic collections without requiring one exact generic type.
	
	There are three key forms:
	1. <?> — unbounded wildcard
	2. <? extends T> — upper-bounded wildcard
	3. <? super T> — lower-bounded wildcard
	5.1 Unbounded wildcard — <?>
	
	Use it when you need to accept a collection of any element type, without needing to know that type.
	import java.util.Arrays;
	import java.util.List;

	public class UnboundedWildcardExample {

	    public static void displayList(List<?> list) {

	        System.out.println("List contents:");

	        for (Object element : list) {
	            System.out.println(element);
	        }

	        // Not allowed:
	        // list.add("Java");
	        // list.add(100);
	    }

	    public static void main(String[] args) {

	        List<String> names = Arrays.asList("Sree", "Vihas");
	        List<Integer> numbers = Arrays.asList(10, 20, 30);

	        System.out.println("String list:");
	        displayList(names);

	        System.out.println("\nInteger list:");
	        displayList(numbers);
	    }
	}


	Why can we read elements as Object but not add arbitrary values? 
	The actual element type is unknown. Adding a String could violate the contract of a List<Integer>.
	
	5.2 Upper-bounded wildcard — <? extends T>
	Use this when you want to read values as type T or one of its subtypes.
	
	For example, List<Integer> and List<Double> can both be passed to a method that accepts List<? extends Number>.
	import java.util.Arrays;
	import java.util.List;

	public class UpperBoundWildcardExample {

	    public static double calculateTotal(
	            List<? extends Number> numbers) {

	        double total = 0;

	        System.out.println("Numbers:");

	        for (Number number : numbers) {
	            System.out.println(number);
	            total += number.doubleValue();
	        }

	        return total;
	    }

	    public static void main(String[] args) {

	        List<Integer> integers = Arrays.asList(10, 20, 30);
	        List<Double> decimals = Arrays.asList(1.5, 2.5, 3.5);

	        System.out.println("Integer total: "
	                + calculateTotal(integers));

	        System.out.println("\nDecimal total: "
	                + calculateTotal(decimals));
	    }
	}


	Important: A List<? extends Number> cannot safely accept an arbitrary Integer, Double 
	or other Number through add(), because the actual list could be a List<Integer>, a List<Double>, 
	or another subtype list. Reading as Number is safe.
	
	5.3 Lower-bounded wildcard — <? super T>
	
	Use this when a method needs to add values of type T to a collection that can hold T or a supertype of T.
	import java.util.ArrayList;
	import java.util.List;

	public class LowerBoundWildcardExample {

	    public static void addNumbers(
	            List<? super Integer> numbers) {

	        System.out.println("Before adding: " + numbers);

	        numbers.add(10);
	        numbers.add(20);
	        numbers.add(30);

	        System.out.println("After adding: " + numbers);
	    }

	    public static void main(String[] args) {

	        List<Integer> integers = new ArrayList<>();
	        List<Number> numbers = new ArrayList<>();
	        List<Object> objects = new ArrayList<>();

	        System.out.println("Integer list:");
	        addNumbers(integers);

	        System.out.println("\nNumber list:");
	        addNumbers(numbers);

	        System.out.println("\nObject list:");
	        addNumbers(objects);
	    }
	}


	You can add an Integer to all three lists because Integer, Number and Object satisfy the lower-bound relationship. When reading an element from List<? super Integer>, its safe general type is Object.
	
	5.4 PECS rule — a very important interview concept
	PECS stands for Producer Extends, Consumer Super.
	
	Wildcard				Use when											Typical example
	? extends T				A collection produces values you want to read as T	Reading numbers from List<? extends Number>
	? super T				A collection consumes values of type T				Adding integers to List<? super Integer>
	?						You only need to work with an unknown element type	Printing elements from List<?>
	
	5.5 Practical PECS example — copying one list to another
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.List;

	public class CopyListExample {

	    public static <T> void copy(
	            List<? extends T> source,
	            List<? super T> destination) {

	        System.out.println("Source: " + source);
	        System.out.println("Destination before copy: " + destination);

	        for (T item : source) {
	            destination.add(item);
	        }

	        System.out.println("Destination after copy: " + destination);
	    }

	    public static void main(String[] args) {

	        List<Integer> source = Arrays.asList(10, 20, 30);
	        List<Number> destination = new ArrayList<>();

	        copy(source, destination);
	    }
	}


	Here, the source produces Integer values, which can be read as T. The destination consumes T values, 
	so it can be a list of Number or Object.

	6. Communication with Non-Generic Code
	
	Java generics were introduced in Java 5 while maintaining compatibility with older Java code and libraries. This is achieved largely through type erasure.
	6.1 What is type erasure?
	At compile time, the compiler uses generic type information to check type safety.
	Much of that generic information is then erased from the generated bytecode.
	
	For example:
	List<String> names = new ArrayList<>();
	List<Integer> numbers = new ArrayList<>();

	At runtime, both are backed by the same raw runtime class: ArrayList. 
	The JVM does not normally retain the String versus Integer type argument as part of the object's runtime class.
	
	6.2 Raw types — legacy code
	A raw type is a generic class or interface used without specifying its type arguments.
	import java.util.ArrayList;
	import java.util.List;

	public class RawTypeExample {

	    public static void main(String[] args) {

	        // Legacy-style raw collection
	        List rawList = new ArrayList();

	        System.out.println("Before adding: " + rawList);

	        rawList.add("Java");
	        rawList.add(100);

	        System.out.println("After adding: " + rawList);

	        // Raw types allow unsafe mixing of data types.
	        // This cast succeeds for the first element.
	        String language = (String) rawList.get(0);

	        System.out.println("Language: " + language);

	        // This cast would fail at runtime:
	        // String number = (String) rawList.get(1);
	    }
	}


	Raw types are supported for backward compatibility, but they bypass many generic type checks 
	and can produce unchecked warnings or runtime ClassCastExceptions. Avoid them in new code.
	
	6.3 Passing generic data to legacy code
	Suppose an old API accepts a raw List:
	import java.util.List;

	public class LegacyApi {

	    // Simulates a pre-generics API.
	    public static void printItems(List items) {
	        for (Object item : items) {
	            System.out.println(item);
	        }
	    }
	}


	Modern code can call it:
	import java.util.Arrays;
	import java.util.List;

	public class LegacyIntegrationExample {

	    public static void main(String[] args) {

	        List<String> names = Arrays.asList("Sree", "Vihas", "Divya");

	        System.out.println("Passing generic list to legacy API:");

	        LegacyApi.printItems(names);
	    }
	}


	This works, but the raw legacy method cannot guarantee that 
	its operations preserve the caller's List<String> contract. 
	The legacy method should avoid inserting incompatible objects into the list.
	
	6.4 Important limitations of type erasure
	Rule															Example
	Cannot instantiate a type parameter directly					new T() is not allowed
	Cannot create a generic array directly							new T[10] is not allowed
	Cannot use primitive type arguments	List<int> is invalid; 		use List<Integer>
	
	Cannot overload methods based only on erased generic types	method(List<String>) 
	and method(List<Integer>) conflict after erasure
	
	Cannot use instanceof with most parameterized types	obj instanceof List<String> is not allowed
	
	Can test a reifiable type	obj instanceof List<?> is allowed in Java 11
	
	A generic type parameter can be instantiated indirectly by accepting a factory,
	 such as a Supplier<T>, or by passing a Class<T> where appropriate. 
	 Type erasure does not mean generics are useless at compile time: 
	 the compiler still enforces generic type safety and inserts necessary casts.

	7. Conclusions and interview revision
	7.1 Quick revision table
	Topic					Syntax						Main purpose
	Generics				List<String>				Type-safe reusable code
	Generic class			class Box<T>				Store or process different types through one class
	Bounded type			<T extends Number>			Restrict allowed types and access bound methods
	Generic method			<T> T process(T value)		Define a type parameter at method level
	Unbounded wildcard		<?>							Accept a collection of an unknown type
	Upper-bounded wildcard	<? extends Number>			Read values as Number
	Lower-bounded wildcard	<? super Integer>			Add Integer values safely
	
	Raw type	List list	Interoperate with legacy APIs, but sacrifices type safety
	Type erasure	Compile-time generic checks	Maintain runtime compatibility with Java's older type system
	
	7.2 Common interview questions
	
	Q1. What is the difference between T and ??
	T declares a named type parameter that can be reused consistently in declarations.
	 ? represents an unknown type, typically when accepting a generic object whose precise type does not matter.
	 
	Q2. What is the difference between List<Object> and List<?>?
	List<Object> can hold arbitrary objects. 
	List<?> can refer to a list of any specific element type, such as List<String> or List<Integer>, 
	but arbitrary values cannot safely be added to it.
	
	Q3. Is List<Integer> a subtype of List<Number>?
	No. Java generics are invariant. Although Integer extends Number, 
	List<Integer> is not a subtype of List<Number>. Use List<? extends Number> 
	when a method needs to accept lists of different Number subtypes.
	
	Q4. What is the difference between bounded types and bounded wildcards?
	- T extends Number constrains a declared type parameter.
	- ? extends Number accepts a parameterized type whose argument is an unknown subtype of Number.
	
	Q5. Can a generic class declare multiple type parameters?
	Yes. For example, class Pair<K, V> can represent a key and a value with different types.
	
	Q6. Why does Java use type erasure?
	It preserves compatibility with the existing Java runtime and
	 older bytecode while enforcing generic type rules during compilation.
	 
	Q7. What is PECS?
	Producer Extends, Consumer Super. 
	Use extends when reading values as a type and super when adding values of that type.
*/

}
