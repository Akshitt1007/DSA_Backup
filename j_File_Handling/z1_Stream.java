package j_File_Handling;

/*
    Stream:
        -> In its most basic form a stream simply represents a sequence of data (bytes or Unicode characters) in some sort of sequential queue.
        -> Java programs perform I/O through streams. A stream is an abstraction that either produces or consumes information.
        -> A stream is linked to a physical device by the Java I/O system.
        -> Java implements streams within class hierarchies defined in the java.io package.
        -> The same I/O classes and methods can be applied to different types of devices.
            i) byte -> like storing an image
            ii) character(Unicode) -> unicode value of "a" ie 97f

        -> eg : "print.out" is byte stream that carries data from code to console
            here;
                i) System -> a final class in java.lang
                ii) out -> a public static final field of type PrintStream
                iii) println(...) -> a method of PrintStream that writes data as characters, then converts it into bytes using
                                       the platform’s default charset, and finally flushes it to the console.

        -> Behind the scene:
                1) You give println() a string.
                2) That string is internally turned into characters.
                3) Those characters are encoded into bytes (usually UTF-8 or your OS default).
                4) The bytes are then sent to the console using System.out, a stream of bytes connected to the standard output (aka your terminal).

        -> Working:
                1) When you use System.out.println("Hello, world!");, the string is:
                2) Encoded into bytes ➜ [72, 101, 108, 108, 111, 44, 32, 119, 111, 114, 108, 100, 33]
                3) Streamed to the terminal via System.out (a PrintStream)
                4) Terminal renders those bytes back into readable characters.

        -> The Predefined Streams :
                1) System.out refers to the standard output stream. By default, this is the console.
                2) System.in refers to standard input, which is the keyboard by default.
                3) System.err refers to the standard error stream, which also is the console by default.

                System.in is an object of type InputStream; System.out and System.err are objects of type PrintStream.
                These are byte streams.

 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class z1_Stream{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }
}

/*
           -> Byte streams are defined by using two class hierarchies.
           -> At the top are two abstract classes: InputStream and OutputStream.
           -> Each of these abstract classes has several concrete subclasses that handle the differences among various devices,
              such as disk files, network connections, and even memory buffers.
           -> The abstract classes InputStream and OutputStream define several key methods that the other stream classes implement.
           -> Two of the most important methods are read( ) and write( )

           -> Character streams are defined by using two class hierarchies.
           -> At the top are two abstract classes: Reader and Writer.
           -> Two of the most important methods are read( ) and write( ).


                                                                   File System
                                                                    /      \
                                                           Byte Stream     Character Stream
                                                              / \                   /\
                                                 Input stream    output stream     /  \
                                                                              reader  writer


         1. Reading Byte Data → InputStream
            -> When you want to read raw byte data (like from a file, network, or keyboard),
            -> Java uses the InputStream abstract class.
            -> It has several concrete subclasses depending on where the bytes come from.

            Source	- Subclass Used

            File	- FileInputStream
            Memory	- ByteArrayInputStream
            Console	- System.in (which is a BufferedInputStream)
            Network	- Socket.getInputStream()

            -> InputStream is the parent class, and the JVM (or you) chooses the subclass based on the source of input.
               Each subclass has its own implementation of the .read() methods.

            -> working of how class are called in case of (System.in):

                           Byte Stream
                               ↓
                           InputStream
                               ↓
                         FileInputStream
                               ↓
                        BufferedInputStream
                               ↓
                           System.in




        2. Writing Byte Data → OutputStream
            -> When you want to write raw bytes, Java uses the OutputStream abstract class.
            -> Again, different concrete subclasses are used depending on where you’re sending the bytes to.

            Destination - Subclass Used

            File	    - FileOutputStream
            Memory	    - ByteArrayOutputStream
            Console	    - System.out, System.err (PrintStream is actually wrapping an OutputStream)
            Network	    - Socket.getOutputStream()

            -> So yes, OutputStream is the base class, and again the JVM or your code chooses the proper subclass for the destination.

            -> working of how class are called in case of (System.out):

                     Byte Stream (Output)
                             ↓
                       OutputStream (abstract)
                             ↓
                       FilterOutputStream
                             ↓
                         PrintStream
                             ↓
                          System.out


    -> When we want to take byte input, the InputStream class (an abstract class) comes into play. Based on the source of the
    input (keyboard, file, network, etc.), the JVM or the programmer uses an appropriate subclass
    like FileInputStream, BufferedInputStream, or ByteArrayInputStream, each providing its own implementation for reading bytes.

    -> Similarly, when we want to write byte data (output), the OutputStream abstract class is used. Depending on the
    destination (console, file, network), a specific subclass like FileOutputStream, BufferedOutputStream, or ByteArrayOutputStream is used.
    Each subclass knows how to handle byte output for its respective destination.

    🎯 NOTE : Names of character streams typically end with Reader/Writer & names of byte streams end with InputStream/OutputStream.

 */



