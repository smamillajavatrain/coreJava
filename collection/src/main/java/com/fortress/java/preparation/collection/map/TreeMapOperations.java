package com.fortress.java.preparation.collection.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeMap;

/**
 * smamilla
 */
public class TreeMapOperations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        // 1. Create an empty TreeMap
        TreeMap<Integer, String> employees = new TreeMap<>();

        System.out.println("1. Empty TreeMap: " + employees);

        // 2. Insert entries in a deliberately unsorted order
        System.out.println("\n2. Before insertion: " + employees);

        employees.put(103, "Divya");
        employees.put(101, "Sree");
        employees.put(105, "Kalyani");
        employees.put(102, "Vihas");
        employees.put(104, "Bhargav");

        System.out.println("After insertion: " + employees);
        // Entries are ordered by key.

        // 3. Duplicate key updates the existing value
        System.out.println("\n3. Before duplicate-key insertion: "
                + employees);

        employees.put(102, "Vihas Updated");

        System.out.println("After updating key 102: " + employees);

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
            System.out.println(entry.getKey() + " -> " + entry.getValue());
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

        // 12. Update using replace()
        System.out.println("\n12. Before replace(): "
                + employees.get(103));

        employees.replace(103, "Divya Updated");

        System.out.println("After replace(): " + employees.get(103));

        // 13. Conditional replace()
        System.out.println("\n13. Before conditional replace(): "
                + employees.get(101));

        boolean replaced =
                employees.replace(101, "Sree", "Sree Mamilla");

        System.out.println("Replacement successful? " + replaced);
        System.out.println("After replacement: " + employees.get(101));

        // 14. Remove by key
        System.out.println("\n14. Before remove(): " + employees);

        employees.remove(105);

        System.out.println("After removing key 105: " + employees);

        // 15. Conditional removal
        System.out.println("\n15. Before conditional removal: " + employees);

        boolean removed = employees.remove(104, "Wrong Name");

        System.out.println("Removed with incorrect value? " + removed);

        removed = employees.remove(104, "Bhargav");

        System.out.println("Removed with correct value? " + removed);
        System.out.println("After removal: " + employees);

        // 16. Add entries from another map
        Map<Integer, String> additional = new HashMap<>();
        additional.put(107, "Aditya");
        additional.put(108, "Krishna");

        System.out.println("\n16. Before putAll(): " + employees);

        employees.putAll(additional);

        System.out.println("After putAll(): " + employees);
        // TreeMap still orders entries by key.

        // 17. Get first and last keys
        System.out.println("\n17. Smallest key: " + employees.firstKey());
        System.out.println("Largest key: " + employees.lastKey());

        System.out.println("First entry: " + employees.firstEntry());
        System.out.println("Last entry: " + employees.lastEntry());

        // 18. Navigate relative to a key
        System.out.println("\n18. Current map: " + employees);

        System.out.println("lowerKey(103): " + employees.lowerKey(103));
        System.out.println("floorKey(103): " + employees.floorKey(103));
        System.out.println("ceilingKey(103): " + employees.ceilingKey(103));
        System.out.println("higherKey(103): " + employees.higherKey(103));

        System.out.println("lowerEntry(103): " + employees.lowerEntry(103));
        System.out.println("floorEntry(103): " + employees.floorEntry(103));
        System.out.println("ceilingEntry(103): " + employees.ceilingEntry(103));
        System.out.println("higherEntry(103): " + employees.higherEntry(103));

        // 19. headMap()
        System.out.println("\n19. Entries before key 104: "
                + employees.headMap(104));

        // 20. tailMap()
        System.out.println("\n20. Entries from key 104: "
                + employees.tailMap(104));

        // 21. subMap()
        System.out.println("\n21. Entries from 102 inclusive to 106 exclusive: "
                + employees.subMap(102, 106));

        // 22. Inclusive/exclusive range options
        System.out.println("\n22. Inclusive range 102 to 104: "
                + employees.subMap(102, true, 104, true));

        System.out.println("Head map including 103: "
                + employees.headMap(103, true));

        System.out.println("Tail map excluding 103: "
                + employees.tailMap(103, false));

        // 23. Descending map and keys
        System.out.println("\n23. Descending map: "
                + employees.descendingMap());

        NavigableSet<Integer> descendingKeys =
                employees.descendingKeySet();

        System.out.println("Descending keys: " + descendingKeys);

        // 24. pollFirstEntry()
        System.out.println("\n24. Before pollFirstEntry(): " + employees);

        Map.Entry<Integer, String> firstRemoved =
                employees.pollFirstEntry();

        System.out.println("Removed first entry: " + firstRemoved);
        System.out.println("After pollFirstEntry(): " + employees);

        // 25. pollLastEntry()
        System.out.println("\n25. Before pollLastEntry(): " + employees);

        Map.Entry<Integer, String> lastRemoved =
                employees.pollLastEntry();

        System.out.println("Removed last entry: " + lastRemoved);
        System.out.println("After pollLastEntry(): " + employees);

        // 26. Java 8 computeIfAbsent()
        System.out.println("\n26. Before computeIfAbsent(): " + employees);

        employees.computeIfAbsent(110, id -> "Employee-" + id);

        System.out.println("After computeIfAbsent(): " + employees);

        // 27. Java 8 computeIfPresent()
        System.out.println("\n27. Before computeIfPresent(): "
                + employees.get(102));

        employees.computeIfPresent(102,
                (id, name) -> name + " Updated");

        System.out.println("After computeIfPresent(): "
                + employees.get(102));

        // 28. Java 8 compute()
        System.out.println("\n28. Before compute(): "
                + employees.get(103));

        employees.compute(103,
                (id, name) -> name == null ? "New Employee" : name + " X");

        System.out.println("After compute(): " + employees.get(103));

        // 29. Java 8 merge()
        Map<String, Integer> counts = new TreeMap<>();

        System.out.println("\n29. Before merge(): " + counts);

        counts.merge("Java", 1, Integer::sum);
        counts.merge("Spring", 1, Integer::sum);
        counts.merge("Java", 1, Integer::sum);

        System.out.println("After merge(): " + counts);
        // Keys appear alphabetically: {Java=2, Spring=1}

        // 30. Custom reverse-order TreeMap
        TreeMap<Integer, String> reverseOrder =
                new TreeMap<>(Collections.reverseOrder());

        reverseOrder.put(103, "Divya");
        reverseOrder.put(101, "Sree");
        reverseOrder.put(102, "Vihas");

        System.out.println("\n30. Reverse-order TreeMap: " + reverseOrder);

        // 31. Copy into a new TreeMap
        System.out.println("\n31. Original map: " + employees);

        TreeMap<Integer, String> copied = new TreeMap<>(employees);

        System.out.println("Copied TreeMap: " + copied);

        copied.put(111, "Pawan");

        System.out.println("Modified copy: " + copied);
        System.out.println("Original remains unchanged: " + employees);

        // 32. Convert keys and values into lists
        List<Integer> ids = new ArrayList<>(employees.keySet());
        List<String> names = new ArrayList<>(employees.values());

        System.out.println("\n32. IDs as List: " + ids);
        System.out.println("Names as List: " + names);

        // 33. Remove entries conditionally
        System.out.println("\n33. Before removeIf(): " + employees);

        employees.entrySet().removeIf(
                entry -> entry.getKey() > 108);

        System.out.println("After removing keys greater than 108: "
                + employees);

        // 34. Compare maps
        TreeMap<Integer, String> anotherCopy = new TreeMap<>(employees);

        System.out.println("\n34. Maps are equal? "
                + employees.equals(anotherCopy));

        System.out.println("TreeMap hashCode: " + employees.hashCode());

        // 35. Clear the map
        System.out.println("\n35. Before clear(): " + employees);

        employees.clear();

        System.out.println("After clear(): " + employees);
        System.out.println("Is empty now? " + employees.isEmpty());
    }

}
/*
	TreeMap
		Maintains keys in sorted order, either by natural ordering or by a custom Comparator. It is useful for sorted reports, range queries and retrieving the nearest keys.
		Package: java.util.TreeMap
		
		Both support common Map operations such as put(), get(), remove(),
		putIfAbsent(), compute(), merge(), keySet(), values() and entrySet().
		
		Important methods
		TreeMap implements NavigableMap, which provides additional methods for sorted-key navigation and range queries
		
		Method					Purpose
		put(K, V)				Adds or updates a mapping in key-sorted order.
		get(K)					Retrieves a value by key.
		putIfAbsent(K, V)		Adds a mapping if the key is absent or mapped to null.
		containsKey(K)			Checks whether a key exists.
		containsValue(V)		Checks whether a value exists.
		firstKey()				Returns the smallest key.
		lastKey()				Returns the largest key.
		firstEntry()			Returns the first key-value entry, or null if empty.
		lastEntry()				Returns the last key-value entry, or null if empty.
		lowerKey(K)				Returns the greatest key strictly less than the specified key.
		floorKey(K)				Returns the greatest key less than or equal to the specified key.
		ceilingKey(K)			Returns the smallest key greater than or equal to the specified key.
		higherKey(K)			Returns the smallest key strictly greater than the specified key.
		lowerEntry(K)			Returns the entry with the greatest key strictly below the specified key.
		floorEntry(K)			Returns the entry with the greatest key less than or equal to the specified key.
		ceilingEntry(K)			Returns the entry with the smallest key greater than or equal to the specified key.
		higherEntry(K)			Returns the entry with the smallest key strictly above the specified key.
		pollFirstEntry()		Retrieves and removes the entry with the smallest key.
		pollLastEntry()			Retrieves and removes the entry with the largest key.
		descendingMap()			Returns a reverse-order view of the map.
		navigableKeySet()		Returns a navigable view of the keys.
		descendingKeySet()		Returns keys in descending order.
		headMap(K)				Returns a view of entries with keys strictly less than the endpoint.
		tailMap(K)				Returns a view of entries with keys greater than or equal to the starting point.
		subMap(K, K)			Returns a view from the starting key inclusive to the ending key exclusive.
		comparator()			Returns the custom comparator, or null for natural ordering.
		
		Natural order vs custom order
		
				TreeMap<Integer, String> ascending = new TreeMap<>();
				ascending.put(30, "C");
				ascending.put(10, "A");
				ascending.put(20, "B");
				
				System.out.println("Ascending: " + ascending);
				// {10=A, 20=B, 30=C}
				
				TreeMap<Integer, String> descending =
				        new TreeMap<>(Collections.reverseOrder());
				
				descending.putAll(ascending);
				
				System.out.println("Descending: " + descending);
				// {30=C, 20=B, 10=A}
				
				
		Range queries are backed views
		Methods such as headMap(), tailMap(), subMap() and descendingMap() return views, not independent copies.
		Changes through those views can affect the original map.
		
		TreeMap<Integer, String> map = new TreeMap<>();

		map.put(10, "A");
		map.put(20, "B");
		map.put(30, "C");
		
		System.out.println("Original map: " + map);
		
		Map<Integer, String> range = map.subMap(10, true, 30, false);
		
		System.out.println("Range view: " + range);
		
		range.put(15, "New");
		
		System.out.println("Original after modifying range: " + map);
		// {10=A, 15=New, 20=B, 30=C}
		
		 HashMap vs LinkedHashMap vs TreeMap
		 
		 Feature					HashMap					LinkedHashMap						TreeMap
		Ordering					No guaranteed order		Insertion order by default			Sorted by key
		Internal structure			Hash table				Hash table plus linked ordering		Red-black tree
		Typical get() / put()		\(O(1)\) average		\(O(1)\) average					\(O(\log n)\)
		Duplicate keys				Not allowed				Not allowed							Not allowed
		Duplicate values			Allowed					Allowed								Allowed
		Null key					One allowed				One allowed							Generally not allowed with natural ordering
		Null values					Allowed					Allowed								Allowed
		Custom ordering				No iteration-order guarantee	Insertion or access order	Custom Comparator
		Range queries				Not supported directly	Not supported directly				Supported
		Best use case				Fast key-value lookup	Predictable iteration order			Sorted keys and range searches
		
		Important notes for interviews and real projects
		
		- All three are implementations of Map. They store key-value pairs, not individual elements like a Set.

		- Keys must be unique. Inserting the same key again replaces its value. For TreeMap, keys are considered equivalent according to its ordering comparator.
		
		- HashMap does not guarantee order. Never rely on its iteration order, even if it appears consistent in a test.
		
		- LinkedHashMap preserves insertion order by default. Use access-order mode when an LRU-style ordering is needed.
		
		- TreeMap sorts by key, not by value. To sort by value, sort the entries and collect them into a LinkedHashMap if the resulting order must be retained.
		
		- Null keys differ. HashMap and LinkedHashMap allow one null key. A TreeMap using natural ordering does not generally support null keys. A custom comparator may change null-key handling, but it must define a valid ordering.
		
		- Be careful with range views. If you need an independent map, create a copy, for example new TreeMap<>(map).
		
		- Thread safety: These classes are not synchronized by default. Consider ConcurrentHashMap for concurrent key-value operations, noting that it does not permit null keys or values.
		
		- Use entrySet() for key-value traversal. It avoids performing a separate map lookup for every key.
		
		- Do not modify key fields that affect equality or ordering after insertion. Doing so can make map entries difficult to locate or violate the expected ordering.
		
		
		Which should you use?
		- Use HashMap when fast lookup is the priority and ordering is irrelevant.
		- Use LinkedHashMap when insertion order matters, or when implementing a simple access-order cache.
		- Use TreeMap when you need sorted keys, first/last entries, nearest-key searches or range-based reports.
*/