package h_OOPS.Inheritance;

/*
    Multilevel Inheritance:
        -> A chain of inheritance.

         Parent (Human)
               ↓
        Child1 (Student)
               ↓
        Child2 (GraduateStudent)

        Parent:
        - String name
        - int age

        Child1:
        - int rollNumber

        Child2:
        - String thesisTopic

 */

public class b3_Multilevel_Inheritance {
    public static void main(String[] args) {

        classIII box = new classIII( );
        System.out.println( box.a + " " + box.b + " " + box.c );
    }
}

class classI{

    int a;

    classI(){
        a = -1;
    }
    classI( int a ){
        this.a = a;
    }
}

class classII extends classI{

    int b;

    classII(){
        super();
        b = -1;
    }
    classII( int a, int b ){
        super(a);
        this.b = b;
    }
}

class classIII extends classII{

    int c;

    classIII(){
        super();
        c = -1;
    }
    classIII( int a, int b, int c ){
        super(a, b);
        this.c = c;
    }
}

