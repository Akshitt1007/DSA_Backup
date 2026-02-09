package a_Basics;

public class a0_Memory_Management {
    public static void main(String[] args) {
            /*
            types of languages / languages can follow many principles but some lean towards some principle more
             ** procedural - specifies a series of well-structured steps to compose a program almost each language is procedural language
             ** functional - making functions ,so we don't have to modify they variables just simply change the function

            -> In procedural programming, we usually change data step by step using loops and variables.
            -> In functional programming, we try to avoid changing data and instead use functions that return new results without modifying the original data

             * .also we don't have to repeat the code for different programs like a calculator
             * .used in situation where we have to perform lots of different operations on the same set of data like ML(it's not modifying
             * the original data but using a copy of data and making a separate output
             * *.first class functions -- reassigning function variable names to other
             ** oops - revolves around object(code + data = object) class has attributes and objects we access the attribute of class using object
             * .made it easier to debug and reuse code as we are making template for different type of data ,so we can find bugs easily

             ** static vs dynamic
             * static -- type checking is done at the time of compiling, errors will show at compile time , declare data type before you use it
             * dynamic -- type checking at runtime , error might not show till program is run , no need to declare data type

             ** how memory management work ,
             * two types of memory stack and heap stack - if a = 10 a is reference variable and 10 is the object
             * how are they stored a is stored in stack(even function and variables calls) and object is stored in head and ref points to heap(object)
             * a is variable in stack memory and its pointing towards an object in heap memory ,,, ref var is just like a variable that points to the
             * actual value in the heap memory ---- more than one reference variable can point to object but if one of the ref var changes the object
             * all the var will see the change , if the object is changed via one ref var it will be changed for all other ref var pointing to it
             * objects have type that are defined by the template(class)

             ** garbage collection - object with no reference variable will be removed from the memory when garbage collection hits , it hits automatically
             * when the memory needs to be cleared like in dynamic languages like python we don't need to declare data type before thus a = 10 and a = "akshit"
             * so at time of garbage collection object 10 in heap memory doesn't have any ref variable pointing to it thus it is removed from the memory

             ** flowchart is just a basic map of how the program should be start/ stop parabola input/output parallelogram processing - rhombus
             *  and for condition rhombus arrow for the flow of the program
             * pseudocode- a rough code just to explain don't have to follow the syntax correctly same as flowchart just without the shapes
             * NOTE - int a so a is the reference to memory location where the value is stored  */
        }
    }
