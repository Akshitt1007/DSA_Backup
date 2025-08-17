package h_OOPS.Inheritance;

// Hierarchical Inheritance Example with Human -> Student & Teacher

public class b6_example {
    public static void main(String[] args) {

        Student student = new Student("Akshit", 20, 101);
        student.displayStudentInfo();
        System.out.println();

        Teacher teacher = new Teacher("Mr. Rao", 45, "Physics");
        teacher.displayTeacherInfo();
    }
}

// Base Class
class Human {
    String name;
    int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayBasicInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Child Class 1
class Student extends Human {
    int rollNumber;

    public Student(String name, int age, int rollNumber) {
        super(name, age); // Call constructor of Human
        this.rollNumber = rollNumber;
    }

    public void displayStudentInfo() {
        System.out.println("👨‍🎓 Student Info:");
        displayBasicInfo();
        System.out.println("Roll Number: " + rollNumber);
    }
}

// Child Class 2
class Teacher extends Human {
    String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age); // Call constructor of Human
        this.subject = subject;
    }

    public void displayTeacherInfo() {
        System.out.println("👨‍🏫 Teacher Info:");
        displayBasicInfo();
        System.out.println("Subject: " + subject);
    }
}
