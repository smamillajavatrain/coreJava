package com.fortress.java.preparation.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/** Run this class to study Generics step by step. */
public class GenericsDemoApplication {
	public static void main(String[] args) {
		section("1. WHY GENERICS: TYPE SAFETY");
		List raw = new ArrayList(); // legacy/raw style; avoid in new code
		raw.add("Java");
		raw.add(100);
		String rawFirst = (String) raw.get(0); // cast required
		System.out.println("Raw first item: " + rawFirst);
		// String crash = (String) raw.get(1); // uncomment to see ClassCastException
		List<String> languages = new ArrayList<>();
		languages.add("Java");
		languages.add("Spring");
		// languages.add(100); // compile-time error
		String firstLanguage = languages.get(0); // no cast
		System.out.println(languages + "; first=" + firstLanguage);

		section("2. GENERIC CLASS: Box<T>");
		Box<String> stringBox = new Box<>("Hello");
		Box<Integer> integerBox = new Box<>(42);
		System.out.println(stringBox.get());
		System.out.println(integerBox.get());
		// Box<int> invalid = new Box<>(10); // primitives are not allowed as type
		// arguments

		section("3. MULTIPLE TYPE PARAMETERS: Pair<K,V>");
		System.out.println(new Pair<>(101, "Anita"));
		System.out.println(new Pair<>("PRICE", 12.50));

		section("4. GENERIC INTERFACE");
		ValueStore<String> store = new InMemoryValueStore<>();
		store.save("Saved through generic interface");
		System.out.println(store.find());

		section("5. GENERIC METHODS");
		List<String> names = Arrays.asList("Anita", "Ravi", "John");
		List<Integer> ids = Arrays.asList(11, 22, 33);
		System.out.println("First name=" + GenericsUtil.first(names));
		System.out.println("First id=" + GenericsUtil.first(ids));
		System.out.println("Contains Ravi? " + GenericsUtil.contains(names, "Ravi"));

		section("6. BOUNDED TYPES: T EXTENDS NUMBER");
		System.out.println(new NumberBox<>(25).doubleValue());
		System.out.println(new NumberBox<>(12.75).doubleValue());
		// new NumberBox<String>("25"); // compile-time error

		section("7. MULTIPLE BOUNDS");
		NumericComparableBox<Integer> bounded = new NumericComparableBox<>(7);
		System.out.println("Compare 7 with 10: " + bounded.compareToValue(10));

		section("8. UPPER-BOUNDED WILDCARD: ? EXTENDS");
		System.out.println("Integer sum=" + GenericsUtil.sumNumbers(Arrays.asList(10, 20, 30)));
		System.out.println("Double sum=" + GenericsUtil.sumNumbers(Arrays.asList(1.5, 2.5)));
		// List<? extends Number> can be read as Number; arbitrary additions are unsafe.

		section("9. LOWER-BOUNDED WILDCARD: ? SUPER");
		List<Integer> integerSink = new ArrayList<>();
		List<Number> numberSink = new ArrayList<>();
		List<Object> objectSink = new ArrayList<>();
		GenericsUtil.addIntegers(integerSink);
		GenericsUtil.addIntegers(numberSink);
		GenericsUtil.addIntegers(objectSink);
		System.out.println(integerSink);
		System.out.println(numberSink);
		System.out.println(objectSink);

		section("10. UNBOUNDED WILDCARD: ?");
		GenericsUtil.printAll(names);
		GenericsUtil.printAll(ids);
		// List<?> is useful when element type is unknown; only null can be added
		// safely.

		section("11. PECS: PRODUCER EXTENDS, CONSUMER SUPER");
		List<Integer> source = Arrays.asList(1, 2, 3);
		List<Number> destination = new ArrayList<>();
		GenericsUtil.copy(source, destination);
		System.out.println("Copied values=" + destination);

		section("12. GENERIC VARARGS HELPER");
		System.out.println(GenericsUtil.listOf("Java", "SQL", "Spring"));

		section("13. GENERIC INVARIANCE");
		List<Integer> integers = Arrays.asList(1, 2, 3);
		// List<Number> numbers = integers; // compile-time error: invariant
		List<? extends Number> readable = integers;
		System.out.println("Read as Number=" + readable.get(0));
		List<Number> separateNumbers = new ArrayList<>();
		separateNumbers.add(4.5);
		separateNumbers.add(10);
		System.out.println(separateNumbers);

		section("14. TYPE ERASURE AND OVERLOAD NAME CLASH");
		System.out.println("List<String> and List<Integer> erase to List at runtime.");
		System.out.println("Cannot overload process(List<String>) and process(List<Integer>) only by type argument.");

		section("15. RAW TYPES AND LEGACY INTEROPERABILITY");
		List<String> safeNames = new ArrayList<>();
		safeNames.add("Sita");
		addLegacyValue(safeNames); // intentionally unsafe demonstration
		System.out.println("Polluted list=" + safeNames);
		try {
			for (String name : safeNames)
				System.out.println(name.length());
		} catch (ClassCastException ex) {
			System.out.println("Expected: raw type can cause ClassCastException.");
		}

		section("16. PRACTICAL REPOSITORY");
		StudentRepository repo = new StudentRepository();
		repo.save(new Student(1, "Anita", 91.5));
		repo.save(new Student(2, "Ravi", 84.0));
		repo.save(new Student(3, "Meera", 96.0));
		System.out.println("Find id 2: " + repo.findById(2).orElse(null));
		repo.findAllSorted().forEach(System.out::println);

		section("17. EXERCISES");
		System.out.println("1) Create Box<Double> and Box<Student>.");
		System.out.println("2) Write a generic list-swap method.");
		System.out.println("3) Find max using T extends Comparable<T>.");
		System.out.println("4) Create Pair<String, Student>.");
		System.out.println("5) Explain List<Integer> vs List<Number>.");

		List<Integer> sortExample = new ArrayList<>(Arrays.asList(5, 1, 4));
		Collections.sort(sortExample);
		System.out.println("Sorted list=" + sortExample);
	}

	private static void section(String title) {
		System.out.println("\n==================================================");
		System.out.println(title);
		System.out.println("==================================================");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void addLegacyValue(List values) {
		values.add(123);
	}
}

/** Class bound first, then interface bound. */
class NumericComparableBox<T extends Number & Comparable<T>> {
	private final T value;

	NumericComparableBox(T value) {
		this.value = value;
	}

	int compareToValue(T other) {
		return value.compareTo(other);
	}
}
