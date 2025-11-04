package h_OOPS.Comparing_Objects;


//  - Comparable is a generic interface, so you have to tell it what type your object will be compared to.
//  - Without that, the compiler warns (or errors, depending on settings) that you’re using a raw type.

class Student implements Comparable<Student> {

//public class Student implements Comparable {

    String name ;
    int marks;

    public Student(String name, int marks){
        this.name = name;
        this.marks = marks;
    }

    @Override
    public int compareTo( Student o ){
//        return 0;

        int diff = (int)(this.marks - o.marks);

        /*
             0 → akshit has more marks than aryan.
             < 0 → aryan has more marks.
             == 0 → they have equal marks.
         */
        return diff;
    }
}

public class a1_Compare  {
    public static void main(String[] args) {
//
        Student akshit = new Student( "Akshit", 88);
        Student aryan = new Student( "Aryan", 45);


        // Objects cannot be compared using > or < directly.
        // To define a natural ordering, implement Comparable in the Student class
        // or use a Comparator when comparing.


//        if ( akshit > aryan ){
//            System.out.println("Aryan is dumb");
//        }
//        else{
//            System.out.println("Akshit is dumb");
//        }


        if ( akshit.compareTo( aryan ) > 0 ){
            // This will always return false
            // Since we are return 0 in the "compareTo"

            System.out.println( "Akshit is good");
        }
        else{
            System.out.println( "Aryan is good");
        }
        /*
            How it works:
                - akshit.compareTo(aryan) > 0 → akshit has more marks than aryan.
                - < 0 → aryan has more marks.
                - == 0 → they have equal marks.
         */

    }
}
