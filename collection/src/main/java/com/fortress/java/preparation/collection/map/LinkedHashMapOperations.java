package com.fortress.java.preparation.collection.map;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * smamilla
 */
public class LinkedHashMapOperations {

	/**
	 * @param args
	 */
	 public static void main(String[] args) {

	        // 1. Create a LinkedHashMap
	        Map<Integer, String> employees = new LinkedHashMap<>();

	        System.out.println("1. Empty map: " + employees);

	        // 2. Insert entries
	        System.out.println("\n2. Before insertion: " + employees);

	        employees.put(103, "Divya");
	        employees.put(101, "Sree");
	        employees.put(105, "Kalyani");
	        employees.put(102, "Vihas");
	        employees.put(104, "Bhargav");

	        System.out.println("After insertion: " + employees);
	        // Insertion order is preserved.

	        // 3. Insert a duplicate key
	        System.out.println("\n3. Before duplicate-key insertion: "
	                + employees);

	        employees.put(102, "Vihas Updated");

	        System.out.println("After updating key 102: " + employees);
	        // The value changes, but the key's insertion position remains.

	        // 4. putIfAbsent()
	        System.out.println("\n4. Before putIfAbsent(): " + employees);

	        employees.putIfAbsent(106, "Bhavana");
	        employees.putIfAbsent(101, "New Sree");

	        System.out.println("After putIfAbsent(): " + employees);

	        // 5. Retrieve values
	        System.out.println("\n5. Value for key 103: "
	                + employees.get(103));

	        System.out.println("Missing key with default: "
	                + employees.getOrDefault(999, "Not Found"));

	        // 6. Check keys and values
	        System.out.println("\n6. Contains key 101: "
	                + employees.containsKey(101));

	        System.out.println("Contains value Sree: "
	                + employees.containsValue("Sree"));

	        // 7. Size and empty check
	        System.out.println("\n7. Map size: " + employees.size());
	        System.out.println("Is empty? " + employees.isEmpty());

	        // 8. Traverse using entrySet()
	        System.out.println("\n8. Traversing using entrySet():");

	        for (Map.Entry<Integer, String> entry : employees.entrySet()) {
	            System.out.println("ID = " + entry.getKey()
	                    + ", Name = " + entry.getValue());
	        }

	        // 9. Traverse using keySet()
	        System.out.println("\n9. Traversing using keySet():");

	        for (Integer id : employees.keySet()) {
	            System.out.println(id + " -> " + employees.get(id));
	        }

	        // 10. Traverse values
	        System.out.println("\n10. Employee names:");

	        for (String name : employees.values()) {
	            System.out.println(name);
	        }

	        // 11. Java 8 forEach()
	        System.out.println("\n11. Traversing using forEach():");

	        employees.forEach((id, name) ->
	                System.out.println(id + " -> " + name));

	        // 12. Replace an existing value
	        System.out.println("\n12. Before replace(): "
	                + employees.get(103));

	        employees.replace(103, "Divya Updated");

	        System.out.println("After replace(): " + employees.get(103));

	        // 13. Conditional replace
	        System.out.println("\n13. Before conditional replace(): "
	                + employees.get(101));

	        boolean replaced =
	                employees.replace(101, "Sree", "Sree Mamilla");

	        System.out.println("Replacement successful? " + replaced);
	        System.out.println("After conditional replace(): "
	                + employees.get(101));

	        // 14. Remove by key
	        System.out.println("\n14. Before remove(): " + employees);

	        employees.remove(105);

	        System.out.println("After removing key 105: " + employees);

	        // 15. Remove only when key and value match
	        System.out.println("\n15. Before conditional removal: "
	                + employees);

	        boolean removed = employees.remove(104, "Wrong Name");

	        System.out.println("Removed using incorrect value? " + removed);

	        removed = employees.remove(104, "Bhargav");

	        System.out.println("Removed using correct value? " + removed);
	        System.out.println("After removal: " + employees);

	        // 16. Add all entries from another map
	        Map<Integer, String> additional = new LinkedHashMap<>();
	        additional.put(107, "Aditya");
	        additional.put(108, "Krishna");

	        System.out.println("\n16. Before putAll(): " + employees);

	        employees.putAll(additional);

	        System.out.println("After putAll(): " + employees);

	        // 17. Java 8 computeIfAbsent()
	        System.out.println("\n17. Before computeIfAbsent(): " + employees);

	        employees.computeIfAbsent(109, id -> "Employee-" + id);

	        System.out.println("After computeIfAbsent(): " + employees);

	        // 18. Java 8 computeIfPresent()
	        System.out.println("\n18. Before computeIfPresent(): "
	                + employees.get(102));

	        employees.computeIfPresent(102,
	                (id, name) -> name + " Updated");

	        System.out.println("After computeIfPresent(): "
	                + employees.get(102));

	        // 19. Java 8 compute()
	        System.out.println("\n19. Before compute(): "
	                + employees.get(103));

	        employees.compute(103,
	                (id, name) -> name == null ? "New Employee" : name + " X");

	        System.out.println("After compute(): " + employees.get(103));

	        // 20. Java 8 merge() for counting
	        Map<String, Integer> wordCount = new LinkedHashMap<>();

	        System.out.println("\n20. Before merge(): " + wordCount);

	        wordCount.merge("Java", 1, Integer::sum);
	        wordCount.merge("Spring", 1, Integer::sum);
	        wordCount.merge("Java", 1, Integer::sum);
	        wordCount.merge("Java", 1, Integer::sum);

	        System.out.println("After merge(): " + wordCount);
	        // {Java=3, Spring=1}

	        // 21. Copy the map
	        System.out.println("\n21. Original map: " + employees);

	        Map<Integer, String> copied = new LinkedHashMap<>(employees);

	        System.out.println("Copied map: " + copied);

	        copied.put(110, "Pawan");

	        System.out.println("Modified copy: " + copied);
	        System.out.println("Original remains unchanged: " + employees);

	        // 22. Convert keys and values into lists
	        List<Integer> ids = new ArrayList<>(employees.keySet());
	        List<String> names = new ArrayList<>(employees.values());

	        System.out.println("\n22. IDs as List: " + ids);
	        System.out.println("Names as List: " + names);

	        // 23. Sort entries by value and retain sorted iteration order
	        System.out.println("\n23. Before sorting by value: " + employees);

	        Map<Integer, String> sortedByValue = new LinkedHashMap<>();

	        employees.entrySet().stream()
	                .sorted(Map.Entry.comparingByValue())
	                .forEach(entry ->
	                        sortedByValue.put(entry.getKey(), entry.getValue()));

	        System.out.println("Sorted by value: " + sortedByValue);

	        // 24. Access-order LinkedHashMap
	        Map<Integer, String> accessOrderMap =
	                new LinkedHashMap<>(16, 0.75f, true);

	        accessOrderMap.put(1, "One");
	        accessOrderMap.put(2, "Two");
	        accessOrderMap.put(3, "Three");

	        System.out.println("\n24. Before accessing key 1: " + accessOrderMap);

	        accessOrderMap.get(1);

	        System.out.println("After accessing key 1: " + accessOrderMap);
	        // Key 1 moves to the end because access order is enabled.

	        // 25. Compare two maps
	        Map<Integer, String> anotherCopy = new LinkedHashMap<>(employees);

	        System.out.println("\n25. Maps are equal? "
	                + employees.equals(anotherCopy));

	        System.out.println("Map hashCode: " + employees.hashCode());

	        // 26. Remove entries conditionally
	        System.out.println("\n26. Before removeIf(): " + employees);

	        employees.entrySet().removeIf(
	                entry -> entry.getKey() > 108);

	        System.out.println("After removing keys greater than 108: "
	                + employees);

	        // 27. Clear the map
	        System.out.println("\n27. Before clear(): " + employees);

	        employees.clear();

	        System.out.println("After clear(): " + employees);
	        System.out.println("Is empty now? " + employees.isEmpty());
	    }

}

/*
 	LinkedHashMap
	Maintains insertion order by default. 
	It is useful when you want to preserve the order in which entries were added, 
	such as displaying records in entry order.
	Package: java.util.LinkedHashMap
	
	1. Important methods
		Method				Purpose
		put(K, V)			Adds a new mapping or updates an existing key.
		putIfAbsent(K, V)	Adds a mapping if the key is absent or currently mapped to null.
		get(K)				Retrieves the value associated with a key.
		getOrDefault(K, V)	Returns a default value when the key has no mapping.
		containsKey(K)		Checks whether a key exists.
		containsValue(V)	Checks whether a value exists.
		replace(K, V)		Replaces the value for an existing key.
		remove(K)			Removes a mapping by key.
		remove(K, V)		Removes a mapping only if its value matches.
		putAll(Map)			Adds mappings from another map.
		keySet()			Returns a view of keys in encounter order.
		values()			Returns a view of values in encounter order.
		entrySet()			Returns a view of key-value entries in encounter order.
		forEach()			Processes every key-value pair.
		computeIfAbsent()	Calculates a value if a mapping is absent or null.
		computeIfPresent()	Recalculates a value if the key has a non-null mapping.
		compute()			Calculates a new value for a key.
		merge()				Adds a mapping or combines its current value with a new one.
		clear()				Removes all mappings.
		
		Special LinkedHashMap concepts
		
		Insertion order vs access order
		By default, LinkedHashMap preserves insertion order. 
		It also supports access order, which can be useful when implementing an LRU (Least Recently Used) cache.
		
		Configuration										Behavior
		new LinkedHashMap<>()								Preserves insertion order
		new LinkedHashMap<>(16, 0.75f, true)				Maintains access order
		get(key) in access-order mode						
		
		Moves the accessed entry to the end
		Updating an existing key in insertion-order mode	Does not move the entry to the end
		
		Example of a simple LRU-style cache:
		
		import java.util.LinkedHashMap;
		import java.util.Map;
		
		public class LruCacheDemo {
		
		    public static void main(String[] args) {
		
		        Map<Integer, String> cache =
		                new LinkedHashMap<Integer, String>(16, 0.75f, true) {
		                    @Override
		                    protected boolean removeEldestEntry(
		                            Map.Entry<Integer, String> eldest) {
		                        return size() > 3;
		                    }
		                };
		
		        cache.put(1, "One");
		        cache.put(2, "Two");
		        cache.put(3, "Three");
		
		        System.out.println("Before access: " + cache);
		
		        cache.get(1);
		
		        System.out.println("After accessing key 1: " + cache);
		
		        cache.put(4, "Four");
		
		        System.out.println("After inserting key 4: " + cache);
		        // Key 2 is evicted because it is now the least recently used.
		    }
		}
		 
 */
