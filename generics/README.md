# Java Generics: Basic to Advanced (Java 11)

## Import into STS
1. Extract this ZIP.
2. In STS select **File → Import → Maven → Existing Maven Projects**.
3. Select the extracted folder containing `pom.xml`, then Finish.
4. Open `src/main/java/com/sma/generics/GenericsDemoApplication.java`.
5. Right-click → **Run As → Java Application**.

No external dependencies are required.

## Learning path
The main class demonstrates: raw vs typed collections; generic classes; multiple type parameters; generic interfaces; generic methods; bounded types; multiple bounds; `?`, `? extends`, `? super`; PECS; invariance; type erasure and overload clashes; raw types/heap pollution; a practical repository; and student exercises.

### Supporting classes
- `Box<T>` — generic container
- `Pair<K,V>` — two type parameters
- `ValueStore<T>` and `InMemoryValueStore<T>` — generic interface
- `NumberBox<T extends Number>` — bounded type
- `Student` and `StudentRepository` — practical example
- `GenericsUtil` — generic methods and wildcard helpers

### Teaching notes
- Generic type arguments must be reference types; use `Integer`, not `int`.
- Use `extends` for bounds even when the bound is an interface.
- For multiple bounds, a class bound must appear first: `T extends Number & Comparable<T>`.
- PECS = Producer Extends, Consumer Super.
- `List<Integer>` is not a subtype of `List<Number>`.
- Java checks generic types at compile time and uses type erasure.
