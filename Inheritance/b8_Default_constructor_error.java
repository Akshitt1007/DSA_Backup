package h_OOPS.Inheritance;
//  -> If a parent class has only a parameterized constructor, Java will not provide a default constructor for you.
//  -> So when a child class extends that parent, you MUST explicitly call the parent's constructor using super(...).

/*
    class A{
        int num;

        A(int num){
            this.num=num;
        }

        num = 10;   // we can't modify here
                    // since A is blue-print
                    // we can not update when we are declare like in line 5 or in a method
    }
    class B extends A{
        int a;
    }

    1. This things will give error since "Class B" also have num as its instance variable since it's inheriting from class A
    2. in class A we have made a constructor for this num
    3. that's why in B we have to make for that num so that it gets initialised
    ---------------------------------------------------------------------------

    class A{
        int num;
        A(){
            this.num=num;
        }
    }

    class B extends A{
        int a;
    }

    1. Here this would not give error since in class "A" default constructor is called
    2. So in class B java will automatically create such constructor in class B for num
       -> Java inserts super() automatically.
    3. But in upper case we have made our own constructor therefore we have to create one in class B as well
 */
public class b8_Default_constructor_error {
    public static void main(String[] args) {

    }
}

class A{
    int num;

    A(int num){
        this.num=num;
    }
}

class B extends A{
    int a;

    B (int a ){
        super(a);
    }
}

/*
    🔑 Key Takeaways:
    - If parent class has ONLY a parameterized constructor → child MUST call it using super(...)
    - If parent class has a no-arg constructor → child can rely on compiler to insert super()
    - Fields like `num = 10;` must be initialized inside a constructor or block, not directly as a statement in class body
*/
