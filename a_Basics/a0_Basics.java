package a_Basics;


public class a0_Basics {
    public static void main(String[] args) {
/* # Stack and Heap Memory: In-Depth Explanation

Memory management is a fundamental concept in computer science. Understanding how stack and heap memory work is crucial for writing efficient code and avoiding memory-related bugs.

## Stack Memory

### Characteristics
- **Static allocation**: Memory is allocated at compile time
- **LIFO** (Last In First Out) data structure
- **Fast access**: Very efficient allocation and deallocation
- **Limited size**: Typically much smaller than heap memory
- **Automatic management**: Memory allocated/deallocated automatically when variables enter/leave scope
- **Thread-specific**: Each thread has its own stack

### What gets stored on the stack?
- **Primitive data types**: integers, floats, booleans, characters
- **Value types** (in languages that distinguish between value and reference types)
- **References/pointers** to heap objects (the reference itself, not the object)
- **Method/function call information**: Return addresses, parameters, local variables
- **Short-lived data** that has a predictable lifetime

### Memory Layout
The stack grows downward in memory (in most architectures). Each function call creates a "stack frame" containing:
1. Function parameters
2. Return address
3. Local variables
4. Register save area

## Heap Memory

### Characteristics
- **Dynamic allocation**: Memory is allocated at runtime
- **No particular order** of allocation/deallocation
- **Slower access**: Less efficient than stack
- **Larger size**: Much more memory available than on stack
- **Manual or automatic management**: Depends on language (manual in C/C++, automatic via garbage collection in Java/C#/JavaScript)
- **Shared resource**: All threads share the same heap

### What gets stored on the heap?
- **Dynamic size objects**: Objects whose size isn't known at compile time
- **Reference type objects**: Classes, arrays, strings (in most languages)
- **Large data structures**: collections, large arrays
- **Long-lived data**: Objects that persist beyond the function that created them

## Memory Usage by Data Type

| Data Type | Typically Stored In | Notes |
|-----------|---------------------|-------|
| Integer, Float, Boolean, Char | Stack | These primitive types have fixed, known sizes |
| Arrays (fixed size, in C/C++) | Stack | When declared as local variables with fixed size |
| Arrays (dynamic or large) | Heap | Dynamic arrays or very large arrays |
| Strings (in C) | Stack for pointer, Heap for content | `char*` on stack, actual characters on heap |
| Strings (Java, C#, etc.) | Heap | String objects are reference types |
| Classes/Objects | Heap | Objects are typically created with `new` |
| Pointers/References | Stack | The pointer/reference itself is on stack, what it points to may be on heap |

## Reference Variables vs Value Types

### Reference Variables
- **Storage**: The reference variable itself is stored on the stack
- **Content**: Points to data stored on the heap
- **Memory model**: Contains a memory address (pointer) to the actual data
- **Assignment**: Copying a reference copies the pointer, not the data
- **Example**:
  ```java
  // In Java
  String name = "John"; // 'name' is on stack, "John" string object is on heap
  Person person = new Person(); // 'person' on stack, Person object on heap
  ```

### Value Types
- **Storage**: Directly stored on the stack
- **Content**: Contains the actual data
- **Memory model**: Memory directly holds the value
- **Assignment**: Copying a value type creates a completely independent copy
- **Example**:
  ```c
  // In C
  int age = 30; // Both 'age' variable and value 30 are on stack
  float salary = 50000.0; // Both on stack
  ```

## Language-Specific Implementation Examples

### Java
- **Primitives** (int, boolean, char, etc.): Stack
- **Objects** (String, user-defined classes, arrays): Heap
- **References**: Stack
- All heap memory managed by garbage collector

### C#
- **Value types** (int, float, struct): Stack
- **Reference types** (class, interface, delegate, string): Heap
- Heap memory managed by garbage collector

### C/C++
- **Automatic variables**: Stack
- **Dynamic variables** (malloc/new): Heap
- Manual memory management required
- ```cpp
  int x = 10; // Stack
  int* y = new int(20); // Pointer on stack, int value on heap
  delete y; // Manual cleanup required
  ```

### JavaScript
- **Primitives** (number, boolean, etc.): Stack-like behavior
- **Objects and functions**: Heap
- Automatic garbage collection

## Memory Visualization

Here's how the stack and heap might look during program execution:

```
MEMORY
+------------------------+
| STACK                  |
| +------------------+   |
| | main() frame     |   |
| | int x = 5        |   |
| | Person* p        |---+----> HEAP
| +------------------+   |      +------------------+
| | foo() frame      |   |      | Person Object    |
| | int y = 10       |   |      | name: "John"     |
| | float z = 3.14   |   |      | age: 30          |
| +------------------+   |      +------------------+
|                        |      | String "John"    |
|                        |      +------------------+
|                        |      | int[] array      |
|                        |      | [10,20,30,40]    |
+------------------------+      +------------------+
```

Understanding stack and heap memory helps developers make better decisions about data structures, optimize performance, diagnose memory leaks, and understand the behavior of their code at a deeper level.*/
    }
}