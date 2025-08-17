package h_OOPS.Access;

/*
    We have made the Instance Variable as public
    which is not a good convention
    since any stranger can access it through "obj.num" or modify it using "obj.default_num = 100"
    which we don't want.

    That's why we have special keyword to make them secure
    and only few member can have the access for them
    -> This is called Data Hiding

    4  Access Modifiers:

        1. Private Access Modifiers
            -> In order to access them we have getter/setter
                => Getter is used to access the value
                => Setter is used to modify the value
            -> Who can access? -- Only the class itself.
            -> Used for -- Sensitive data you don't want anyone touching directly.

        2. Public Access Modifiers
            -> can be accessed by anyone and modified by anyone
            -> Who can access? -- Anyone, anywhere.
            -> Used for: -- Methods and classes that need to be used universally, like APIs or public-facing services.

        3. Default Access Modifiers
            -> When we don't mention any Access Modifiers, Java makes it as Default Access Modifiers
            -> Who can access? -- All classes in the same package.
            -> Used for: -- when we don't want variable to use outside that particular package

        4. Protected Access Modifiers
            -> The protected access modifier allows access from a different package only when the accessing class is a
               subclass of the class in which the member was originally declared.
            -> Who can access? -- Inheriting classes and same-package classes.
            -> Used for: -- Inheritance purposes, like giving children access to the family heirlooms.
 */
public class Access_Modifiers {

    private int default_num;
    protected String name;
    int[] array;

    // Since we are accessing thr value the return type must not be void
    public int getDefault_num(){
        return default_num;
    }

    // Since we are only modifying/setting the value, we don't need anything in return so set the return type as "Void"
    // It will have arguments because we are passing new value to set for the private variable
    public void setDefault_num( int num ){
        this.default_num = num;
    }

    public Access_Modifiers(int default_num, String name) {
        this.default_num = default_num;
        this.name = name;
        this.array = new int[default_num];
    }
}
/*
        +----------------+---------+----------+---------------------+---------------------+--------------------------------+
        |   Modifier     | Class   | Package  | Subclass (same pkg) | Subclass (diff pkg) | World (diff pkg & not subclass)|
        +----------------+---------+----------+---------------------+---------------------+--------------------------------+
        | public         |    +    |    +     |          +          |          +          |              +                 |
        | protected      |    +    |    +     |          +          |          +          |              -                 |
        | no modifier    |    +    |    +     |          +          |          -          |              -                 |
        | private        |    +    |    -     |          -          |          -          |              -                 |
        +----------------+---------+----------+---------------------+---------------------+--------------------------------+
*/
