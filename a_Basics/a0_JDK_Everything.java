package a_Basics;

public class a0_JDK_Everything {
}
/*
==============================
JAVA ARCHITECTURE COMPLETE NOTES
==============================

1) JDK (Java Development Kit)
--------------------------------
- Used for DEVELOPING Java applications.
- Contains everything needed to write, compile, and run Java programs.

Includes:
    - JRE
    - javac (compiler)
    - Debugger (jdb)
    - Documentation tool (javadoc)
    - Other development tools

Important:
    javac exists ONLY inside JDK.
    Without JDK, you cannot compile .java files.

--------------------------------------------------

2) JRE (Java Runtime Environment)
-----------------------------------
- Used for RUNNING Java applications.
- Does NOT contain compiler.

Includes:
    - JVM
    - Core Java libraries
    - Supporting runtime files

Important:
    JRE cannot compile code.
    It can only run already compiled .class files.

--------------------------------------------------

3) javac (Java Compiler)
--------------------------
- Converts source code into bytecode.

Process:
    MyProgram.java  --->  MyProgram.class

- The .class file contains BYTECODE.
- Bytecode is platform independent.

--------------------------------------------------

4) JVM (Java Virtual Machine)
-------------------------------
- Responsible for executing bytecode.
- Platform dependent (different JVM for Windows, Linux, Mac).
- Makes Java platform independent overall.

JVM Main Components:

    1) ClassLoader Subsystem
       - Loads .class files into memory.

    2) Runtime Data Areas (Memory)
       - Heap (objects, shared)
       - Stack (method calls, local variables)
       - Method Area (class metadata, static variables)
       - PC Register
       - Native Method Stack

    3) Execution Engine
       - Interpreter
       - JIT Compiler
       - Garbage Collector

--------------------------------------------------

5) Execution Engine
----------------------

Interpreter:
    - Reads bytecode line by line.
    - Slower but starts quickly.

JIT (Just-In-Time Compiler):
    - Converts frequently used bytecode into native machine code.
    - Stores optimized code in cache.
    - Improves runtime performance.
    - Works during execution (NOT during compilation).

Garbage Collector:
    - Automatically removes unused objects from heap.
    - Prevents memory leaks.
    - Runs inside JVM.

--------------------------------------------------

6) Complete Flow of Java Program
-----------------------------------

Step 1: Write code -> MyProgram.java
Step 2: Compile using javac (inside JDK)
Step 3: Generates bytecode -> MyProgram.class
Step 4: JVM loads class file
Step 5: Execution Engine runs bytecode
Step 6: JIT optimizes frequently used code
Step 7: Output is produced

--------------------------------------------------

7) Key Concepts Summary
--------------------------

JDK = Development Kit (JRE + tools)
JRE = Runtime Environment (JVM + libraries)
JVM = Executes bytecode
javac = Converts .java to .class
Bytecode = Platform independent
JIT = Optimizes runtime performance
GC = Manages memory automatically

--------------------------------------------------

Why Java is Platform Independent?

- Source code compiles into bytecode.
- Bytecode runs on JVM.
- JVM is available for multiple platforms.
- Same .class file runs everywhere.

Write Once, Run Anywhere.

==============================
END OF NOTES
==============================
*/
/*
JDK (Java Development Kit) is used to develop Java applications.
It contains everything required to write, compile, and run Java programs.

Inside JDK, there is:

JRE (Java Runtime Environment)

Development tools like javac (compiler)

JRE (Java Runtime Environment) is used to run Java programs.
It does not contain the compiler.
It contains:

JVM (Java Virtual Machine)

Core Java libraries

The javac compiler (which is inside JDK, not JRE) converts the .java source file into a .class file.
The .class file contains bytecode, which is platform independent.

Now comes JVM.

JVM is responsible for executing the bytecode.
JVM is platform dependent (different JVM for Windows, Linux, etc.), but because every platform has its own JVM implementation, the same bytecode can run everywhere.
This is why Java is platform independent overall.

Inside the JVM, there is an Execution Engine.

The Execution Engine contains:

Interpreter

JIT (Just-In-Time) Compiler

Garbage Collector

The Interpreter reads bytecode line by line and executes it.

The JIT compiler improves performance.
When a method or block of code is executed multiple times, JIT converts that bytecode into native machine code and stores it in memory.
Next time it runs directly as machine code instead of interpreting again.
This makes execution faster.

The Execution Engine ultimately converts bytecode into machine code, which is executed by the CPU to produce output.
 */
