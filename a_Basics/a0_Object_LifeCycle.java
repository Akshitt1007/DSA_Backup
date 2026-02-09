package a_Basics;



/*
================================================================================
                        OBJECT LIFECYCLE IN JAVA
================================================================================

1. WHAT IS OBJECT LIFECYCLE?
   - The complete journey of an object from creation to destruction
   - Managed automatically by JVM (Java Virtual Machine)
   - Involves memory allocation, usage, and garbage collection
   - Understanding lifecycle helps optimize memory and performance

================================================================================

2. STAGES OF OBJECT LIFECYCLE

   Stage 1: OBJECT CREATION (Birth)
            ↓
   Stage 2: OBJECT IN USE (Life)
            ↓
   Stage 3: OBJECT INVISIBLE (Aging)
            ↓
   Stage 4: OBJECT UNREACHABLE (Death)
            ↓
   Stage 5: OBJECT COLLECTED (Funeral)
            ↓
   Stage 6: OBJECT FINALIZED (After-life)
            ↓
   Stage 7: OBJECT DEALLOCATED (Gone Forever)

================================================================================

3. DETAILED EXPLANATION OF EACH STAGE

   ┌─────────────────────────────────────────────────────────────────────┐
   │ STAGE 1: OBJECT CREATION (INSTANTIATION)                            │
   └─────────────────────────────────────────────────────────────────────┘

   WHAT HAPPENS:
   - Memory allocated in HEAP memory
   - Constructor is invoked
   - Instance variables initialized
   - Object reference created

   WAYS TO CREATE OBJECTS:
   a) Using 'new' keyword (most common)
      Employee emp = new Employee();

   b) Using newInstance() method (Reflection)
      Class cls = Class.forName("Employee");
      Employee emp = (Employee) cls.newInstance();

   c) Using clone() method
      Employee emp1 = new Employee();
      Employee emp2 = (Employee) emp1.clone();

   d) Using deserialization
      ObjectInputStream ois = new ObjectInputStream(fis);
      Employee emp = (Employee) ois.readObject();

   e) Using factory methods
      String str = String.valueOf(123);

   MEMORY ALLOCATION:
   - Object stored in HEAP memory
   - Reference variable stored in STACK memory
   - Instance variables stored within object in HEAP

   EXAMPLE:
   class Student {
       int id;              // Instance variable
       String name;         // Instance variable

       Student(int id, String name) {  // Constructor
           this.id = id;
           this.name = name;
           System.out.println("Object created");
       }
   }

   // Creating object
   Student s1 = new Student(101, "John");
   // HEAP: Student object with id=101, name="John"
   // STACK: s1 reference pointing to HEAP object

   ┌─────────────────────────────────────────────────────────────────────┐
   │ STAGE 2: OBJECT IN USE (LIVING/REACHABLE STATE)                     │
   └─────────────────────────────────────────────────────────────────────┘

   WHAT HAPPENS:
   - Object is actively referenced
   - Methods can be called on object
   - Object data can be accessed/modified
   - Object is reachable from active thread

   REACHABLE OBJECTS:
   - Referenced by local variables
   - Referenced by static variables
   - Referenced by instance variables of reachable objects
   - Referenced by method parameters
   - Referenced by active threads

   EXAMPLE:
   Student s1 = new Student(101, "John");  // Reachable via s1
   s1.display();                            // Using the object
   System.out.println(s1.name);             // Accessing data

   Student s2 = s1;  // Now reachable via both s1 and s2

   ┌─────────────────────────────────────────────────────────────────────┐
   │ STAGE 3: OBJECT INVISIBLE (OUT OF SCOPE)                            │
   └─────────────────────────────────────────────────────────────────────┘

   WHAT HAPPENS:
   - Object exists in memory
   - But no longer accessible from current scope
   - Still reachable from other references

   EXAMPLE:
   public void method() {
       Student s1 = new Student(101, "John");
       {
           Student s2 = new Student(102, "Alice");
           // Both s1 and s2 are visible here
       }
       // s2 is now invisible (out of scope)
       // But s1 is still visible
   }

   ┌─────────────────────────────────────────────────────────────────────┐
   │ STAGE 4: OBJECT UNREACHABLE (ELIGIBLE FOR GC)                       │
   └─────────────────────────────────────────────────────────────────────┘

   WHAT HAPPENS:
   - No active references point to the object
   - Object cannot be accessed anymore
   - Eligible for Garbage Collection
   - Still occupies memory

   WAYS OBJECTS BECOME UNREACHABLE:

   a) Nullifying reference
      Student s1 = new Student(101, "John");
      s1 = null;  // Object becomes unreachable

   b) Reassigning reference
      Student s1 = new Student(101, "John");
      s1 = new Student(102, "Alice");  // First object unreachable

   c) Object created inside method (local scope)
      public void createStudent() {
          Student s1 = new Student(101, "John");
      }  // s1 goes out of scope, object becomes unreachable

   d) Island of Isolation
      class Demo {
          Demo ref;
      }
      Demo d1 = new Demo();
      Demo d2 = new Demo();
      d1.ref = d2;  // d1 references d2
      d2.ref = d1;  // d2 references d1
      d1 = null;
      d2 = null;
      // Both objects reference each other but unreachable from outside

   ┌─────────────────────────────────────────────────────────────────────┐
   │ STAGE 5: OBJECT COLLECTED (GARBAGE COLLECTION)                      │
   └─────────────────────────────────────────────────────────────────────┘

   WHAT HAPPENS:
   - Garbage Collector identifies unreachable objects
   - Objects marked for collection
   - GC runs automatically (non-deterministic)
   - Can request GC but not force it

   REQUESTING GARBAGE COLLECTION:
   a) System.gc();              // Requests GC
   b) Runtime.getRuntime().gc(); // Requests GC

   NOTE: These only REQUEST GC, JVM may or may not run it immediately

   GARBAGE COLLECTION ALGORITHMS:
   - Mark and Sweep
   - Generational Collection (Young Gen, Old Gen)
   - G1 Garbage Collector
   - ZGC, Shenandoah (Low latency)

   ┌─────────────────────────────────────────────────────────────────────┐
   │ STAGE 6: OBJECT FINALIZED (FINALIZATION)                            │
   └─────────────────────────────────────────────────────────────────────┘

   WHAT HAPPENS:
   - Just before GC destroys object, finalize() method is called
   - Gives object last chance to clean up resources
   - Called only ONCE per object
   - Not guaranteed to be called

   finalize() METHOD:
   protected void finalize() throws Throwable {
       // Cleanup code
       System.out.println("Object is being garbage collected");
       // Close files, release resources, etc.
   }

   EXAMPLE:
   class Demo {
       int id;

       Demo(int id) {
           this.id = id;
       }

       @Override
       protected void finalize() throws Throwable {
           System.out.println("Object " + id + " is finalized");
       }
   }

   public class Test {
       public static void main(String[] args) {
           Demo d1 = new Demo(1);
           Demo d2 = new Demo(2);

           d1 = null;
           d2 = null;

           System.gc();  // Request GC

           // Output (not guaranteed order):
           // Object 1 is finalized
           // Object 2 is finalized
       }
   }

   IMPORTANT NOTES:
   - finalize() is DEPRECATED in Java 9+
   - Use try-with-resources or explicit close() instead
   - finalize() can make object reachable again (resurrection)
   - Performance overhead

   ┌─────────────────────────────────────────────────────────────────────┐
   │ STAGE 7: OBJECT DEALLOCATED (MEMORY FREED)                          │
   └─────────────────────────────────────────────────────────────────────┘

   WHAT HAPPENS:
   - After finalization, GC actually removes object
   - Memory is reclaimed and returned to heap
   - Object is permanently destroyed
   - No longer exists in memory

================================================================================
7. OBJECT RESURRECTION (BRINGING DEAD BACK TO LIFE)

   WHAT IS IT?
   - Making unreachable object reachable again in finalize()
   - Object escapes garbage collection
   - finalize() called only ONCE, so can't be resurrected again

   EXAMPLE:
   class Student {
       static Student saved;  // Static reference to save object
       String name;

       Student(String name) {
           this.name = name;
       }

       @Override
       protected void finalize() throws Throwable {
           System.out.println("Finalize called for " + name);
           saved = this;  // Resurrection! Object becomes reachable again
       }
   }

   public class ResurrectionDemo {
       public static void main(String[] args) throws Exception {
           Student s = new Student("John");
           s = null;  // Object unreachable

           System.gc();  // GC called
           Thread.sleep(1000);

           // Object resurrected!
           if (Student.saved != null) {
               System.out.println("Resurrected: " + Student.saved.name);
           }

           // Making unreachable again
           Student.saved = null;
           System.gc();
           Thread.sleep(1000);

           // finalize() won't be called again, direct deallocation
       }
   }

================================================================================

8. GARBAGE COLLECTION BASICS

   WHEN GC RUNS:
   - When heap memory is low
   - When explicitly requested (not guaranteed)
   - JVM decides automatically

   TYPES OF GC:
   a) Minor GC - Cleans Young Generation
   b) Major GC - Cleans Old Generation
   c) Full GC - Cleans entire heap

   GC ALGORITHMS:
   - Serial GC (-XX:+UseSerialGC)
   - Parallel GC (-XX:+UseParallelGC)
   - CMS GC (-XX:+UseConcMarkSweepGC) [Deprecated]
   - G1 GC (-XX:+UseG1GC) [Default in Java 9+]
   - ZGC (-XX:+UseZGC) [Java 11+]
   - Shenandoah GC (-XX:+UseShenandoahGC)

   REQUESTING GC:
   System.gc();                    // Request GC
   Runtime.getRuntime().gc();      // Request GC

   MONITORING GC:
   -verbose:gc                     // Print GC details
   -XX:+PrintGCDetails            // Detailed GC logs
   -XX:+PrintGCTimeStamps         // GC timestamps

================================================================================

10. COMMON INTERVIEW QUESTIONS & ANSWERS

   Q1: What are the stages of object lifecycle in Java?
   A: Creation → In Use → Invisible → Unreachable → Collected →
      Finalized → Deallocated

   Q2: Where are objects stored in memory?
   A: Objects are stored in HEAP memory. Reference variables are
      stored in STACK memory.

   Q3: When is an object eligible for garbage collection?
   A: When there are no reachable references pointing to it.

   Q4: Can we force garbage collection in Java?
   A: No, we can only REQUEST it using System.gc() or Runtime.gc().
      JVM decides when to actually run GC.

   Q5: What is the purpose of finalize() method?
   A: To perform cleanup operations before object is garbage collected.
      However, it's deprecated and not recommended.

   Q6: How many times can finalize() be called on an object?
   A: Only ONCE. Even if object is resurrected, finalize() won't be
      called again.

   Q7: What is object resurrection?
   A: Making an unreachable object reachable again inside finalize()
      method by assigning it to a static or instance variable.

   Q8: What are the different types of references in Java?
   A: Strong, Soft, Weak, and Phantom references.

   Q9: What is Island of Isolation?
   A: When objects reference each other but have no external references,
      making all of them eligible for GC.

   Q10: What's the difference between finalize() and close()?
   A: finalize() is called by GC automatically (deprecated).
      close() must be called explicitly and is recommended for
      resource cleanup.

   Q11: Can we create objects without using 'new' keyword?
   A: Yes - using clone(), deserialization, reflection, factory methods.

   Q12: What happens if finalize() throws an exception?
   A: Exception is ignored and finalization terminates for that object.

   Q13: What is the alternative to finalize() in modern Java?
   A: Use try-with-resources with AutoCloseable interface or
      Cleaner API (Java 9+).

   Q14: Difference between System.gc() and Runtime.gc()?
   A: No difference. System.gc() internally calls Runtime.gc().
      Both only request GC, don't guarantee it.

   Q15: How to check if object is eligible for GC?
   A: No direct way. Check if all strong references are removed.
      Use profiling tools like VisualVM or JConsole.

================================================================================
*/


public class a0_Object_LifeCycle {

    static class Student {  // Make Student static
        static Student saved;  // Static reference to save object
        String name;

        Student(String name) {
            this.name = name;
        }
        @SuppressWarnings("deprecation")
        @Override
        protected void finalize() throws Throwable {
            System.out.println("Finalize called for " + name);
            saved = this;
        }
    }  // Close Student class here

    public static void main(String[] args) throws InterruptedException {
        /* STEP-BY-STEP EXECUTION FLOW */

        /* STEP 1: Object Creation
         * - New Student object created in heap memory
         * - name = "John"
         * - Reference variable 's' points to this object
         */
        Student s = new Student("John");

        /* STEP 2: Remove Reference
         * - 's' is set to null
         * - Student object now has zero references
         * - Object becomes eligible for garbage collection
         */
        s = null;

        /* STEP 3: First Garbage Collection Request
         * - System.gc() requests JVM to run garbage collector
         * - Thread.sleep(1000) waits for GC to complete
         */
        System.gc();
        Thread.sleep(1000);

        /* STEP 4: finalize() Method Executes (FIRST TIME)
         * - GC detects unreachable Student object
         * - Calls finalize() method before destroying
         * - Inside finalize(): Student.saved = this
         * - Object saves its own reference to static variable
         * - OBJECT RESURRECTED - now reachable via Student.saved
         */

        /* STEP 5: Verify Resurrection
         * - Check if Student.saved != null (it is!)
         * - Access resurrected object: Student.saved.name
         * - Prints: "Resurrected: John"
         */
        if (Student.saved != null) {
            System.out.println("Resurrected: " + Student.saved.name);
        }

        /* STEP 6: Remove Reference Again
         * - Student.saved set to null
         * - Object becomes unreachable SECOND TIME
         * - No references pointing to object
         */
        Student.saved = null;

        /* STEP 7: Second Garbage Collection Request
         * - System.gc() called again
         * - Thread.sleep(1000) waits for GC
         */
        System.gc();
        Thread.sleep(1000);

        /* STEP 8: Permanent Deletion
         * - GC detects unreachable object again
         * - finalize() NOT CALLED (only executes once per object)
         * - Object permanently deleted from memory
         * - No resurrection this time
         */
    }
}

