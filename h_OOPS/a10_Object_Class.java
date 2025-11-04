package h_OOPS;

public class a10_Object_Class {

    int num ;
    String name;

    a10_Object_Class( int num, String name ){
        this.num = num;
        this.name = name;
    }

    @Override
    public String toString(){
        return super.toString();
    }

    @Override
    public int hashCode(){
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        return super.equals(obj);
    }

    public static void main(String[] args) {

        a10_Object_Class obj = new a10_Object_Class( 10, "Akshit" );
        a10_Object_Class obj2 = new a10_Object_Class( 11, "Abhinav");

        System.out.println( obj.hashCode() );
        System.out.println( obj2.hashCode() );
    }
}
