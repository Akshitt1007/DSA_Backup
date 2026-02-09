package a_Basics;

public class a0_architecture_workingOFjavaFILE {
    public static void main(String[] args) {

    /*
    so a java compiler first converts the file into byte code which is a class file that has the extension .class then the
interpreter converts it into binary code or machine code LINE BY LINE , we need JVM(java virtual machine) to run this

 **PLATFORM INDEPENDENCE
"In Java, a bytecode file is generated as part of the process of compiling Java source code. The reason for creating a
 bytecode file is to make Java programs platform-independent, allowing them to run on any device or operating system that
 has a Java Virtual Machine (JVM).
* a byte code can run on any system as it needs a virtual machine to run like java
* in c or c++ we get an .exe(executable file) that is machine code which is platform dependent as different system has different arch...
* JVM is platform dependent as they would have different way to convert it into different machine code
 JDK = JRE(JAVA RUNTIME ENVIRONMENT) + DEVELOPMENT TOOLS
 JRE = JVM + LIBRARY CLASSES
 JVM = JIT ( JUST IN TIME COMPILING TYPE) , if a code is used again it provides the machine code for that code to make running a bit faster
 JDK is just a package we can download from the internet which contains the compiler(javac) tools for development interpreter/loader
 JRE is and installation package that provides environment ot only run the program
 JVM(JAVA VIRTUAL MACHINE) - first the clas loader loads all classes needed to execute the program and then its sends the code for check the format
 JVM also contains the stack and heap memory which contains the function calls , reference variable etc and the objects respectively
 */
    }

/** 🎯 THE BIG PICTURE FIRST:

 You write Java code → it gets compiled → then interpreted or compiled again (JIT!) → finally executed.

 Now let’s zoom in.

 🛠️ 1. javac – The Java Compiler

 What it is:
 javac stands for Java Compiler. It translates your .java source files into .class files.

 Input: .java (human-readable Java code)
 Output: .class (bytecode – an intermediate, platform-independent form)

 Stage: Compile-time

 What it does:

 Checks syntax and rules (e.g., type safety)
 Translates into bytecode, not machine code
 No execution happens here. Just translation.
 💡 Think of it like turning your handwritten notes into a PDF that can be shared.

 ☕ 2. JVM – Java Virtual Machine

 What it is:
 The engine that runs your Java bytecode.

 Input: .class files (bytecode)
 Output: Actually executes the program

 Stage: Runtime

 What it does:

 Loads class files
 Verifies them for security
 Executes them line-by-line OR uses JIT to optimize them
 Manages memory via the Heap and Stack
 Handles Garbage Collection, Multithreading, and Security Sandboxing
 💡 Think of JVM like your coffee machine — you can put any coffee pod (bytecode), and it’ll brew it on any platform. Write once, run anywhere™.

 ⚙️ 3. JIT – Just-In-Time Compiler

 What it is:
 A runtime performance beast that lives inside the JVM.

 What it does:

 Takes frequently used bytecode and compiles it into native machine code (hotspot optimization).
 Caches it, so repeated calls are blazing fast.
 Removes the overhead of interpretation.
 💡 Analogy: You're reading a foreign book with a translator (JVM). But if you read the same sentence 100 times, you memorize it (JIT), and now you don’t need the translator — you just know.

 🧠 4. Other Key Players You Should Know

 ✅ Bytecode
 Intermediate code between Java source and machine code. It's platform-independent and runs on the JVM.

 ✅ JRE – Java Runtime Environment
 JVM + Core Libraries + other stuff to run Java apps.
 If JVM is the engine, JRE is the whole car.

 ✅ JDK – Java Development Kit
 Includes javac, JRE, JVM, and tools like javadoc, javap, etc.
 It’s the whole factory. If you're developing, you need this.

 ✅ Classloader
 Part of the JVM. It loads your class files into memory at runtime.
 Also helps with dynamic loading and separating classes via namespaces.

 ✅ Garbage Collector
 Manages memory by deleting unreferenced objects in the heap.
 Java devs don’t manually free() memory like C++. JVM handles it.*/
}

