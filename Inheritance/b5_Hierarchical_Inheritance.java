package h_OOPS.Inheritance;

/*
    Hierarchical Inheritance
        -> Hierarchical inheritance is when more than one class inherits from a single parent class.

              +-------------+
              |   Human     |
              |-------------|
              | String name |
              | int age     |
              +-------------+
                 /       \
                /         \
      +----------------+   +------------------+
      |   Student      |   |   Teacher        |
      |----------------|   |------------------|
      | int rollNumber |   | String subject   |
      +----------------+   +------------------+

      Student:
        1. rollNumber
        2. Name
        3. Age

      Teacher:
        1. Subject
        2. Name
        3. Age

    Difference between Hierarchical and Multiple
        -> In Multiple there are many parent and one child
        -> In Hierarchical there are many child and one parent (like classic inheritance)

 */
public class b5_Hierarchical_Inheritance {
    public static void main(String[] args) {

        Dog dog = new Dog("Chop");
        dog.Bark();
        dog.Eat();
        dog.name();
        System.out.println();

        Cat cat = new Cat("Ellie");
        cat.Meow();
        cat.Eat();
        cat.name();
    }
}

class Animal{

    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void Eat(){
        System.out.println( "I am eating ");
    }
    public void name(){
        System.out.println( "His/her name is " + this.name );
    }
}

class Dog extends Animal{

    public Dog( String name ){
        super( name );
    }
    public void Bark(){
        System.out.println( "Woof" );
    }
}

class Cat extends Animal{

    public Cat( String name ){
        super( name );
    }
    public void Meow(){
        System.out.println( "Meow" );
    }
}
