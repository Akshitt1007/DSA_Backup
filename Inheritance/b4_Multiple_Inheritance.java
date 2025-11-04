package h_OOPS.Inheritance;

/*
    Multiple Inheritance:
        -> A sub-call which have the properties of two top classes

                  Parent (Human)
                    /       \
        Child1 (Student)  Child2 (Teacher)
               |
        FinalChild (Scholar)

        Parent (interface):
        - String name
        - int age

        Child1 (class):
        - int rollNumber

        Child2 (interface):
        - String subject

 */
public class b4_Multiple_Inheritance {
    public static void main(String[] args) {

        /*
            A    B
            \   /
              c

              here,
                A and B are top classes
                from which the c class is inheriting

                what if A have variable n = 10;
                and B also have same variable n = 100;
                if we do "c.n" what value do we get ??

                -> it will create confusion which one to pick
                -> that's why Java does not support this Multiple Inheritance
                -> but there are use cases for this multiple inheritance: that's why there is "INTERFACES" in java by which we can do this
         */

    }
}
