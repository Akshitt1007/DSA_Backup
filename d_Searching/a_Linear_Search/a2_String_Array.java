package d_Searching;
import java.util.Scanner;

public class a2_String_Array {
    public static void main(String[] args) {

        Scanner s1 = new Scanner(System.in);

        System.out.println("Enter your name: ");
        String name1 = s1.nextLine();

        System.out.println("Enter the target letter: ");
        char target;
        target = s1.next().charAt(0);

        int index = find_index(name1, target);
        if(index == -1){
            System.out.println("Target not present.");
        }
        else{
            System.out.println("Target at "+ index);
        }
    }

    static int find_index(String name, char target){

        if(name.length() == 0){
            System.out.println("String is empty. ");
            return -1;
        }

        for(int i=0 ; i<name.length() ; i++){
            if(target == name.charAt(i)) {
//            if(target.equals(String.valueOf(name.charAt(i)))){
//                System.out.println("Target letter is at index: " + i);
                return i;
            }
        }
        return -1;

    }
}
