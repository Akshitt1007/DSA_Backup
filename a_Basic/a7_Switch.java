package a_Basics;

import java.util.Scanner;

public class a7_Switch {
    public static void main(String[] args){

        /*
            switch (expression) {

            case value1:
                // Code to be executed if expression == value1
                break; // Exit the switch block
            case value2:
                // Code to be executed if expression == value2
                break;
            // Add more cases as needed
            default:
                // Code to be executed if no cases match

            }
         */

        System.out.println("Enter the fruits: ");
        Scanner scanner = new Scanner(System.in);
        String fruits_name = scanner.next();

        /*
            switch (fruits_name) {
            case "Mango" : System.out.println("King of fruits");
                break;
            case "Apple" : System.out.println("A sweet red fruit");
                break;
            case "Orange" : System.out.println("Round fruit");
                break;
            case "Grapes" : System.out.println("Small fruit");
                break;
            default : System.out.println("please enter a valid fruit");
             */
        // if there is no break all the cases will run out and the help of break if one case run it will break out of switch case

        switch (fruits_name) {
            case "Mango" -> System.out.println("King of fruits");
            case "Apple" -> System.out.println("A sweet red fruit");
            case "Orange" -> System.out.println("Round fruit");
            case "Grapes" -> System.out.println("Small fruit");
            default -> System.out.println("please enter a valid fruit");

            // this is more efficient way to write the switch case and there is no more need to write break statement as it is automatically working internally
        }

        System.out.println("Enter the date: ");
        int date = scanner.nextInt();

//        switch(date){
//            case 1 -> System.out.println("Monday");
//            case 2 -> System.out.println("Tuesday");
//            case 3 -> System.out.println("Wednesday");
//            case 4 -> System.out.println("Thursday");
//            case 5 -> System.out.println("Friday");
//            case 6 -> System.out.println("Saturday");
//            case 7 -> System.out.println("Sunday");
//            default -> System.out.println("No day");
//        }

//        switch (date) {
//            case 1:
//            case 2:
//            case 3:
//            case 4:
//            case 5:
//                System.out.println("Weekday");
//                break;
//            case 6:
//            case 7:
//                System.out.println("Weekend");
//                break;
//        }

        switch (date){
            case 1,2,3,4,5 -> System.out.println("Weekday");
            case 6,7 -> System.out.println("Weekend");
        }




        // Nested switch case:

        System.out.println("Enter the employee ID: ");
        int id = scanner.nextInt();
        String name = scanner.next();

        switch (name){
            case "Akshit" -> {
                System.out.println("Your name is Akshit Choudhary");
                {
                    switch (id){
                        case 101 -> System.out.println("IT department ");
                        case 201 -> System.out.println("MKT");
                    }
                }
            }
            case "Abhinav" -> {
                System.out.println("Your name is Abhinav Choudhary");
                {
                    switch (id){
                        case 101 -> System.out.println("IT department ");
                        case 201 -> System.out.println("MKT");
                    }
                }
            }
            default -> System.out.println("No records ");
        }

//
//        switch (id) {
//            case 1:
//                System.out.println("Akshit Choudhary");
//                break;
//            case 2:
//                System.out.println("Abhinav Choudhary");
//                break;
//            case 3:
//                System.out.println("Emp name 3");
//                switch (name) {
//                    case "IT":
//                        System.out.println("IT Department");
//                        break;
//                    case "Management":
//                        System.out.println("Management Department");
//                        break;
//                    default:
//                        System.out.println("No department entered");
//                }
//                break;
//            default:
//                System.out.println("Enter correct EmpID");
//        }
//
//        // better way to write
//        switch (id) {
//            case 1 -> System.out.println("Akshit Choudhary");
//            case 2 -> System.out.println("Abhinav Choudhary");
//            case 3 -> {
//                System.out.println("Emp Number 3");
//                switch (name) {
//                    case "IT" -> System.out.println("IT Department");
//                    case "Management" -> System.out.println("Management Department");
//                    default -> System.out.println("No department entered");
//                }
//            }
//            default -> System.out.println("Enter correct EmpID");
//        }

    }
}
