package i_Exception_Handling;

/*
    Error vs Exception:

        1. Error ( Not recoverable )
            -> Definition: Serious problems that are not meant to be caught or handled by your program.
            -> Examples: OutOfMemoryError, StackOverflowError, VirtualMachineError
            -> Cause: Typically caused by the JVM or hardware, not your code.
            -> Handling: You should not try to catch or handle them. Just fix the root problem.

        2. Exception ( recoverable )
            -> Definition: Conditions your program can catch and handle.
            -> Types:
                1. Checked Exceptions: Compiler forces you to handle. (IOException, SQLException)
                2. Unchecked Exceptions: Runtime exceptions; your choice to handle. (NullPointerException, ArrayIndexOutOfBoundsException)
            -> Cause: Usually caused by bad code or unexpected user input.
            -> Handling: Use try-catch, throws, etc.


                                                Object
                                                   |
                                               Throwable
                                               /       \
                                           Error      Exception
                                                       /     \
                                                  Checked   Unchecked (Runtime)

            -> In Java, `Object` is the ultimate superclass. One of its key subclasses is `Throwable`, which represents things that can go wrong during program execution.

            -> Throwable` has two main children: `Error` and `Exception`.

                - `Error` is used for serious issues in the JVM or system (like `StackOverflowError`). These are not meant to be caught.
                - `Exception` is used for conditions your program can anticipate and handle.

            -> Inside `Exception`, we have:
                - Checked Exceptions (compiler forces you to handle them)
                - Unchecked Exceptions (runtime issues — optional to handle)

         1. Checked Exceptions:

            -> Exceptions that the compiler checks at compile time.
            -> If your code can cause one of these, Java will force you to either:
                - handle it with try-catch, or
                - declare it using throws.
            -> "IOException" is a checked exception. The compiler demands you deal with it.

            -> Use Case:
               Situations that are expected and recoverable:
                - File not found
                - Invalid user input (when handled politely)

        2. Unchecked Exception:

            -> You can write code that may throw these, and Java won’t complain — but you might crash at runtime.
            -> These all inherit from RuntimeException.
            -> Division by zero is an ArithmeticException, and it's unchecked.

            -> Use Case:
                - Usually caused by bugs in your code
                - Accessing null (NullPointerException)
                - Index out of bounds (ArrayIndexOutOfBoundsException)
                - Dividing by zero
                - Type casting issues (ClassCastException)


                java.lang.Object
                └── java.lang.Throwable                   ← Root of all exceptions and errors
                    ├── java.lang.Error                   ← Serious system-level problems (not meant to be caught)
                    │   ├── StackOverflowError
                    │   ├── OutOfMemoryError
                    │   └── ...
                    │
                    └── java.lang.Exception               ← Root of all exceptions (checked + unchecked)
                        ├── java.lang.RuntimeException    ← Root of all unchecked exceptions
                        │   ├── NullPointerException
                        │   ├── ArithmeticException
                        │   ├── ArrayIndexOutOfBoundsException
                        │   ├── ClassCastException
                        │   └── ...
                        │
                        ├── IOException                   ← Checked Exception
                        │   ├── FileNotFoundException
                        │   └── EOFException
                        │
                        ├── SQLException                  ← Checked Exception
                        ├── InterruptedException          ← Checked Exception
                        ├── ClassNotFoundException        ← Checked Exception
                        └── ParseException                ← Checked Exception

 */
public class a1_basic {
    public static void main(String[] args) {

        int a = 5;
        int b = 0;

        try {                       // Wrap code that might throw an exception
//            throw new Exception( "Just for Fun." );   // If we write this then below expression will never work
            int c = a/b;
        }

        catch ( ArithmeticException e ){      // Handle the exception (if it occurs inside the try block)
            System.out.println( e.getMessage() );
        }
        catch ( Exception e ){
            System.out.println( "Normal exception");
        }
        // Always add strict exception at top
        // if we top "Exception" at the top
        // then the below catch will not work
        // since Exception include all further exceptions

        // Why This Order Matters:
        // -> ArithmeticException is more specific (a child class).
        // -> Exception is more general (a parent class).

        finally {                   // finally block always runs — even if you don't catch the exception.
            System.out.println( "This 'finally' will always runs no matter what happens" );
        }

        throw new IllegalArgumentException("This is wrong!");
            // 	Manually throw an exception
    }

     public int random( int a, int b) throws ArithmeticException {          // Declare a method might throw an exception

        if ( b==0 ){        // Manually throw an exception
            throw new ArithmeticException();
        }
        return a/b ;
    }

}
/*
    Step-by-Step:
    1. Code enters the try block.
    2. If everything’s cool — skip catch, go to finally (if it exists).
    3. If something throws an exception:
    4. Java looks for a matching catch(ExceptionType) block.
    5. If a match is found, it executes that block.
    6. If no match is found, the program crashes (unless the exception bubbles up).
    7. The finally block runs no matter what — exception or no exception.
*/
