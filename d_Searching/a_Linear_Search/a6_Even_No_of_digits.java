package d_Searching.Linear_Search;

public class a6_Even_No_of_digits {
    public static void main(String[] args) {

        int[] array = { -12 , 345 , 2 , 6 , 7895 , 22 , 44 , 88 , 1234 };

        System.out.println("Number of even digits are: " + even_digits(array));
    }

    static int even_digits( int [] array ){
        int even = 0 ;

        if( array.length == 0){
            return even;
        }

        for( int i=0 ; i< array.length ; i++ ){

            int count = 0;

            while( array[i] !=0 ){
                array[i] = array[i]/10;
                count++;
            }

            if( count % 2 == 0 ){
                even++;
            }
        }
        return even;
    }
}
