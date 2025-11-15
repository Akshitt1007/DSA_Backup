package q_Additional.q1_StringBuffer;

/*
              FILE HANDLING WITH STRING BUFFER

    💡 Concept:

    In many technical rounds or coding tests, we aren’t given
    console inputs (Scanner / System.in). Instead:
        → Inputs come from a file (like input.txt)
        → We must process them
        → And write all outputs back to a file (like output.txt)

    This mimics real-world programming where data is file-based,
    not entered manually.


    💡 Why Use StringBuffer:

    - StringBuffer is mutable (can be changed without creating new objects).
    - Normal String is immutable — every "+" creates a new String (slow).
    - StringBuffer helps efficiently build and store output before writing.
    - It is thread-safe (synchronized) — good for multi-threaded programs.


    💡 WHY WE USE STRINGBUFFER INSTEAD OF STRING

    1. Problem with Normal String:

        - In Java, Strings are **immutable** (cannot be changed once created).
        - Every time you modify a String using '+' or 'concat()',
          Java internally creates a **new String object** in memory.
        - Example:
              String s = "Hello";
              s = s + " World";
          ➤ Creates TWO different objects in memory:
              "Hello" and "Hello World".

        - If we build large output in a loop:
              String output = "";
              for(int i = 0; i < 1000; i++)
                  output = output + i + "\n";
          ➤ Creates 1000+ new String objects → memory waste.

    2. Solution → Use StringBuffer (Mutable String)

        - StringBuffer is **mutable**, meaning it can be changed
          without creating new objects each time.
        - It uses a single object where we can keep appending text.
        - Example:
              StringBuffer sb = new StringBuffer();
              for(int i = 0; i < 1000; i++)
                  sb.append(i).append("\n");
          ➤ Only one object is created and reused.

    3. Why It’s Important in File Handling:

        - When writing multiple outputs to a file:
            • Using normal String creates a new object every time
              (inefficient).
            • Using StringBuffer collects all output in one object.
        - Then we write the final result once using:
              bw.write(sb.toString());
        - This reduces CPU load, improves performance,
          and avoids unnecessary memory allocation.

 */
public class a1_why {
}
