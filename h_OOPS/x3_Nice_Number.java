package h_OOPS;
import java.util.Scanner;


class NiceNumber{
    NiceNumber(){}

    public int findType( int num ){
        int count =0 ;

        for ( int i= 1 ; i<=num ; i++ ){
            if(num %i ==0){
                count++;
            }
            if( count > 4 ){
                return 0;
            }
        }
        if( count == 4 ){
            return 1;
        }
        else{
            return 0;
        }
    }
}
public class x3_Nice_Number {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the Ticket: ");
        int ticket = in.nextInt();

        NiceNumber obj = new NiceNumber();

        if ( obj.findType(ticket) == 1 ){
            System.out.println("Nice number");
        }
        else{
            System.out.println("Not Nice number");
        }
    }
}
