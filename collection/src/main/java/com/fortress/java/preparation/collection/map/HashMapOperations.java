package com.fortress.java.preparation.collection.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * smamilla
 */
public class HashMapOperations {

	public static void main(String[] args) {

        // 1. Create a HashMap
        Map<Integer, String> employees = new HashMap<>();

        System.out.println("1. Empty HashMap: " + employees);

        // 2. Add elements using put()
        System.out.println("\n2. Before adding employees: " + employees);

        employees.put(101, "Sree");
        employees.put(102, "Vihas");
        employees.put(103, "Divya");
        employees.put(104, "Bhargav");
        employees.put(105, "Kalyani");

        System.out.println("After adding employees: " + employees);

        // 3. Duplicate key: the existing value is replaced
        System.out.println("\n3. Before duplicate-key insertion: "
                + employees);

        employees.put(102, "Vihas Updated");

        System.out.println("After updating key 102: " + employees);

        // 4. Add a new mapping only if the key is absent
        System.out.println("\n4. Before putIfAbsent(): " + employees);

        employees.putIfAbsent(106, "Bhavana");
        employees.putIfAbsent(101, "New Sree");

        System.out.println("After putIfAbsent(): " + employees);

        // 5. Retrieve a value using get()
        System.out.println("\n5. Value for key 101: "
                + employees.get(101));

        // 6. Retrieve a default value for a missing key
        System.out.println("\n6. Missing key 999: "
                + employees.get(999));

        System.out.println("Default value for key 999: "
                + employees.getOrDefault(999, "Employee Not Found"));

        // 7. Check keys and values
        System.out.println("\n7. Contains key 103: "
                + employees.containsKey(103));

        System.out.println("Contains value 'Sree': "
                + employees.containsValue("Sree"));

        System.out.println("Contains key 999: "
                + employees.containsKey(999));

        // 8. Get map size and check whether empty
        System.out.println("\n8. Number of employees: "
                + employees.size());

        System.out.println("Is map empty? " + employees.isEmpty());

        // 9. Iterate through key-value pairs using entrySet()
        System.out.println("\n9. Iterating using entrySet():");

        for (Map.Entry<Integer, String> entry : employees.entrySet()) {
            System.out.println("Employee ID: " + entry.getKey()
                    + ", Name: " + entry.getValue());
        }

        // 10. Iterate using keySet()
        System.out.println("\n10. Iterating using keySet():");

        for (Integer id : employees.keySet()) {
            System.out.println("ID: " + id
                    + ", Name: " + employees.get(id));
        }

        // 11. Iterate through values only
        System.out.println("\n11. Employee names:");

        for (String name : employees.values()) {
            System.out.println(name);
        }

        // 12. Iterate using forEach()
        System.out.println("\n12. Iterating using forEach():");

        employees.forEach((id, name) ->
                System.out.println(id + " -> " + name));

        // 13. Update a value using put()
        System.out.println("\n13. Before updating employee 103: "
                + employees.get(103));

        employees.put(103, "Divya Updated");

        System.out.println("After updating employee 103: "
                + employees.get(103));

        // 14. Update a value using replace()
        System.out.println("\n14. Before replace(): " + employees);

        employees.replace(104, "Bhargav Updated");

        System.out.println("After replace(): " + employees);

        // 15. Conditional replace()
        System.out.println("\n15. Before conditional replace(): "
                + employees.get(101));

        boolean replaced =
                employees.replace(101, "Sree", "Sree Mamilla");

        System.out.println("Was replacement successful? " + replaced);
        System.out.println("After conditional replace(): "
                + employees.get(101));

        // 16. Remove using key
        System.out.println("\n16. Before removing key 105: " + employees);

        employees.remove(105);

        System.out.println("After removing key 105: " + employees);

        // 17. Remove only when key and value both match
        System.out.println("\n17. Before conditional removal: "
                + employees);

        boolean removed = employees.remove(104, "Wrong Name");

        System.out.println("Removed with incorrect value? " + removed);

        removed = employees.remove(104, "Bhargav Updated");

        System.out.println("Removed with correct value? " + removed);
        System.out.println("After conditional removal: " + employees);

        // 18. Copy mappings using putAll()
        Map<Integer, String> additionalEmployees = new HashMap<>();

        additionalEmployees.put(107, "Aditya");
        additionalEmployees.put(108, "Krishna");

        System.out.println("\n18. Original map: " + employees);
        System.out.println("Additional map: " + additionalEmployees);

        employees.putAll(additionalEmployees);

        System.out.println("After putAll(): " + employees);

        // 19. Obtain keySet(), values() and entrySet()
        System.out.println("\n19. All keys: " + employees.keySet());
        System.out.println("All values: " + employees.values());
        System.out.println("All entries: " + employees.entrySet());

        // 20. Clone the HashMap
        System.out.println("\n20. Original before clone: " + employees);

        HashMap<Integer, String> clonedEmployees =
                new HashMap<>((HashMap<Integer, String>) employees);

        System.out.println("Cloned map: " + clonedEmployees);

        clonedEmployees.put(109, "Pawan");

        System.out.println("After modifying cloned map: "
                + clonedEmployees);
        System.out.println("Original remains unchanged: " + employees);

        // 21. Create a copy using the Map constructor
        Map<Integer, String> copiedEmployees =
                new HashMap<>(employees);

        System.out.println("\n21. Copied map: " + copiedEmployees);

        // 22. Java 8 computeIfAbsent()
        System.out.println("\n22. Before computeIfAbsent(): " + employees);

        employees.computeIfAbsent(110, id -> "Employee-" + id);

        System.out.println("After computeIfAbsent(): " + employees);

        // 23. Java 8 computeIfPresent()
        System.out.println("\n23. Before computeIfPresent(): "
                + employees.get(101));

        employees.computeIfPresent(101,
                (id, name) -> name + " Updated");

        System.out.println("After computeIfPresent(): "
                + employees.get(101));

        // 24. Java 8 compute()
        System.out.println("\n24. Before compute(): "
                + employees.get(102));

        employees.compute(102,
                (id, name) -> name == null ? "New Employee" : name + " X");

        System.out.println("After compute(): " + employees.get(102));

        // 25. Java 8 merge()
        Map<String, Integer> wordCounts = new HashMap<>();

        System.out.println("\n25. Before merge(): " + wordCounts);

        wordCounts.merge("Java", 1, Integer::sum);
        wordCounts.merge("Java", 1, Integer::sum);
        wordCounts.merge("Spring", 1, Integer::sum);

        System.out.println("After merge(): " + wordCounts);

        // 26. Sorting keys using TreeMap
        System.out.println("\n26. Original HashMap: " + employees);

        Map<Integer, String> sortedByKey = new TreeMap<>(employees);

        System.out.println("Sorted by key: " + sortedByKey);

        // 27. Sort entries by value into a LinkedHashMap
        System.out.println("\n27. Before sorting by value: " + employees);

        Map<Integer, String> sortedByValue = new LinkedHashMap<>();

        employees.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry ->
                        sortedByValue.put(entry.getKey(), entry.getValue()));

        System.out.println("Sorted by value: " + sortedByValue);

        // 28. Convert keys to a List
        List<Integer> employeeIds =
                new ArrayList<>(employees.keySet());

        System.out.println("\n28. Employee IDs as List: " + employeeIds);

        // 29. Convert values to a List
        List<String> employeeNames =
                new ArrayList<>(employees.values());

        System.out.println("Employee names as List: " + employeeNames);

        // 30. Remove mappings using removeIf() on entrySet()
        System.out.println("\n30. Before removeIf(): " + employees);

        employees.entrySet().removeIf(
                entry -> entry.getKey() > 108);

        System.out.println("After removing IDs greater than 108: "
                + employees);

        // 31. Compare maps
        Map<Integer, String> comparisonMap =
                new HashMap<>(employees);

        System.out.println("\n31. Maps are equal? "
                + employees.equals(comparisonMap));

        System.out.println("Hash code of employees: "
                + employees.hashCode());

        System.out.println("Hash code of comparison map: "
                + comparisonMap.hashCode());

        // 32. Clear all mappings
        System.out.println("\n32. Before clear(): " + employees);

        employees.clear();

        System.out.println("After clear(): " + employees);
        System.out.println("Is map empty now? " + employees.isEmpty());
    }
}

/*
   		Concept									Key point
		Duplicate keys							A new value replaces the previous value for the same key.
		Duplicate values	Allowed; 			multiple keys can map to the same value.
		Ordering								HashMap does not guarantee iteration order.
		Null handling							Allows one null key and multiple null values.
		Thread safety							Not synchronized by default.
		Performance								get() and put() are typically \(O(1)\) on average, assuming good hash distribution.
		Key equality							Uses hashCode() and equals() to identify keys.
		Mutable keys							Avoid modifying fields that affect equals() or hashCode() after inserting a key.
		Sorting by key							Use TreeMap.
		Sorting by value						Sort the entries and collect into a LinkedHashMap to preserve the resulting order.
		Counting frequencies					Use merge() or getOrDefault().
		Concurrent access						Consider ConcurrentHashMap for concurrent updates.
		
		Count the frequency of each word
		
		List<String> words = Arrays.asList(
        "Java", "Spring", "Java", "Microservices", "Spring", "Java");

		Map<String, Integer> frequency = new HashMap<>();
		
		System.out.println("Before counting: " + frequency);
		
		for (String word : words) {
		    frequency.merge(word, 1, Integer::sum);
		}
		
		System.out.println("Word frequencies: " + frequency);
		
		// Example result:
		// {Java=3, Spring=2, Microservices=1}
 		
 		Find duplicate elements in a list
 		
 		List<Integer> numbers =
        Arrays.asList(10, 20, 10, 30, 20, 40, 10);

		Map<Integer, Integer> frequency = new HashMap<>();
		
		for (Integer number : numbers) {
		    frequency.merge(number, 1, Integer::sum);
		}
		
		System.out.println("Frequencies: " + frequency);
		
		System.out.println("Duplicate elements:");
		
		frequency.forEach((number, count) -> {
		    if (count > 1) {
		        System.out.println(number + " occurs " + count + " times");
		    }
		});
		
		Find the first non-repeating character
		
		String input = "swiss";

		Map<Character, Integer> frequency = new LinkedHashMap<>();
		
		for (char ch : input.toCharArray()) {
		    frequency.merge(ch, 1, Integer::sum);
		}
		
		System.out.println("Character frequencies: " + frequency);
		
		for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
		    if (entry.getValue() == 1) {
		        System.out.println("First non-repeating character: "
		                + entry.getKey());
		        break;
		    }
		}
		
		LinkedHashMap is used here because it preserves insertion order. A plain HashMap does not guarantee that order.
		
		Note: In the complete example, you can simplify the clone operation to new HashMap<>(employees), 
		which is the usual approach for creating a shallow copy.
		 
		A shallow copy duplicates the map structure but does not clone mutable objects stored as keys or values.
 
 */
