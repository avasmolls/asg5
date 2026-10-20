# LISP Lists | Java

**HCDD 311: Object-Oriented Programming & Design — Assignment 5**

## Overview

This project implements a custom immutable linked list in Java, inspired by the list structures used in the LISP programming language. The goal was to gain a deeper understanding of recursively defined data types, functional programming concepts, and pattern matching by building a linked list from scratch.

Unlike Java's built-in list implementations, this project uses a sealed interface and records to represent lists recursively, without relying on traditional loops or built-in list-processing methods.

## Technologies Used

- **Java** — Object-oriented and functional programming
- **Maven** — Project management and build automation
- **JUnit** — Unit testing
- **Recursion** — List traversal and manipulation
- **Sealed Interfaces & Records** — Algebraic data type implementation
- **Pattern Matching** — Exhaustive switch expressions

## Features

The `LispList` interface represents two possible list structures:

- `Empty()` — Represents an empty list.
- `Cons(int head, LispList tail)` — Represents a nonempty list containing an integer and the remainder of the list.

The implementation includes the following operations:

| Method | Description |
|---|---|
| `empty()` | Creates an empty list. |
| `cons(head, tail)` | Constructs a new list node. |
| `of(...)` | Creates a list from a sequence of integers. |
| `length()` | Recursively calculates the number of elements. |
| `toString()` | Displays list elements in a readable format. |
| `removeAll(target)` | Removes all occurrences of a specified integer while preserving the order of remaining elements. |
| `merge(other)` | Alternates elements between two lists, appending any remaining elements from the longer list. |

## Example Usage

### Creating a List

```java
LispList numbers = LispList.of(3, 4, 5);

System.out.println(numbers);
// Output: [3, 4, 5]
```

### Finding List Length

```java
LispList numbers = LispList.of(10, 20, 30);

System.out.println(numbers.length());
// Output: 3
```

### Removing Elements

```java
LispList numbers = LispList.of(3, 4, 3, 5);

LispList filtered = numbers.removeAll(3);

System.out.println(filtered);
// Output: [4, 5]
```

### Merging Lists

```java
LispList list1 = LispList.of(1, 2, 3, 4);
LispList list2 = LispList.of(5, 6);

LispList merged = list1.merge(list2);

System.out.println(merged);
// Output: [1, 5, 2, 6, 3, 4]
```

## Project Structure

```text
asg5/
├── pom.xml
├── src/
│   └── LispList.java
└── test/
    └── LispListTest.java
```

- **LispList.java** — Defines the recursive list structure and its operations.
- **LispListTest.java** — Contains JUnit tests to validate functionality.
- **pom.xml** — Configures Maven dependencies and project settings.

## Testing

JUnit tests are used to verify the correctness of all four operations: `length()`, `toString()`, `removeAll()`, and `merge()`.

Test cases cover:

- Empty, singleton, and multi-element lists
- Positive, negative, and zero values
- Removing elements with no matches, partial matches, or all matches
- Merging lists of equal and unequal lengths
- Preserving original lists after operations
- Correct string formatting and element ordering

To execute the tests, run:

```bash
mvn test
```

## Key Learning Outcomes

Through this project, I developed a stronger understanding of:

- **Recursive Data Structures:** Modeling linked lists through self-referential types.
- **Java Sealed Interfaces & Records:** Representing a data structure using distinct, well-defined cases.
- **Pattern Matching:** Using exhaustive switch expressions to handle recursive cases.
- **Immutability:** Creating new lists without modifying existing data.
- **Recursive Algorithms:** Implementing list operations without loops or built-in collection utilities.
- **Unit Testing:** Validating functionality and edge cases through JUnit.

## Project Context

Developed as part of **HCDD 311 at Pennsylvania State University**, this assignment focused on implementing foundational data structures and strengthening Java programming skills through recursion, immutability, and algebraic data types.

